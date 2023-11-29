package epicTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionReader {
	private static List<Question> questionBank = new ArrayList<>();
	public static void fileReading(String dif) {
		
		
		String path = "D:/FinalEpic/src/epicTest/QuestionBank.txt";
		String line = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			while((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				
				String question = values[0];
				String answer1 = values[1];
				String answer2 = values[2];
				String answer3 = values[3];
				String answer4 = values[4];
				int correctAnswer = Integer.parseInt(values[5]);
				String category = values[6];
				
				if ((dif.equals("Easy") || dif.equals("Medium") || dif.equals("Hard")) && category.equals(dif)) {
				questionBank.add(new Question(question, answer1, answer2, answer3, answer4, correctAnswer, category));
				}
				else if (dif.equals("Total")){
					questionBank.add(new Question(question, answer1, answer2, answer3, answer4, correctAnswer, category));
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public static List<Question> getQuestionBank() {
		return questionBank;
	}

	public static void setQuestionBank(List<Question> questionBank) {
		QuestionReader.questionBank = questionBank;
	}

	public static void main(String[] args) {
		fileReading("Easy");
		for (Question question : questionBank) {
		System.out.println("Question: " + question.getQuestion() + ". Category: " + question.getCategory());
		}
	}
}
