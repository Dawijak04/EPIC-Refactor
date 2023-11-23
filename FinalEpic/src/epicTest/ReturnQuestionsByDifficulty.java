package epicTest;
//imports
//external source
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

//java imports
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReturnQuestionsByDifficulty {


    public static String filePath = "src/epicTest/QuestionBank.csv"; //filepath for questions csv file

    public static List<Question> filterByDiff(Difficulty dif) { //filters questions
        List<Question> questionBank = readCSV(); //list of all the questions
        List<Question> filtered = new ArrayList<>();
        for (Question q : questionBank) {
            if (q.getDifficulty() == dif) { //if question q is the desired difficulty
                filtered.add(q); //q is added to the filtered list of questions
            }
            else if (dif == Difficulty.All) { //if user selects random mode, all questions are used. Hence list with all questions is assigned to filtered list
                filtered = questionBank;
                break;
            }
        }
        return filtered;
    }

    public static List<Question> readCSV() {
        List<Question> questionList = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> lines = csvReader.readAll();
            for (String[] line : lines) {
                String question;
                String option1;
                String option2;
                String option3;
                String option4;
                int correctOption;
                Difficulty difficulty = null;
                Question newQuestion = null;

                // Assuming the CSV format follows: Question,Option1,Option2,Option3,Option4,CorrectOption,Difficulty
                if (line.length == 7) {
                    question = line[0];
                    option1 = line[1];
                    option2 = line[2];
                    option3 = line[3];
                    option4 = line[4];
                    correctOption = Integer.parseInt(line[5]);
                    difficulty = Difficulty.valueOf(line[6]);
                    newQuestion = new Question(question, option1, option2, option3, option4, correctOption, difficulty); //question is created as an object

                //Assuming the CSV format follows: Question, CorrectOption, Difficulty
                } else if (line.length == 3) {
                    question = line[0];
                    correctOption = Integer.parseInt(line[1]);
                    difficulty = Difficulty.valueOf(line[2]);


                    newQuestion = new Question(question, correctOption, difficulty); //question is creates as an object
                }
                else {
                  System.out.println("Invalid CSV format for line: " + String.join(",", line)); //used for testing in case errors occure with csv file
                }
                    questionList.add(newQuestion); //question objet is added to the list
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return questionList;
    }
}

