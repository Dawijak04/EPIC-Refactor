package epicTest;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReturnQuestionsByDifficulty {


    public static String filePath = "src/epicTest/QuestionBank.csv";

    public static List<Question> filterByDiff(Difficulty dif) {
        List<Question> questionBank = readCSV();
        List<Question> filtered = new ArrayList<>();
        for (Question q : questionBank) {
            if (q.getDifficulty() == dif) {
                filtered.add(q);
            }
            else if (dif == Difficulty.All) {
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
                // Assuming the CSV format follows: Question,Option1,Option2,Option3,Option4,CorrectOption,Difficulty
                String question;
                String option1;
                String option2;
                String option3;
                String option4;
                int correctOption;
                Difficulty difficulty = null;
                Question newQuestion = null;

                if (line.length == 7) {
                    question = line[0];
                    option1 = line[1];
                    option2 = line[2];
                    option3 = line[3];
                    option4 = line[4];
                    correctOption = Integer.parseInt(line[5]);
                    difficulty = Difficulty.valueOf(line[6]);
                    //System.out.print(difficulty + "!!!!");
                    newQuestion = new Question(question, option1, option2, option3, option4, correctOption, difficulty);

                } else if (line.length == 3) {
                    question = line[0];
                    //System.out.print("HELLO");
                    //System.out.print(question);
                    correctOption = Integer.parseInt(line[1]);
                    //System.out.print(correctOption);
                    //System.out.println(line[2] + "1");
                    difficulty = Difficulty.valueOf(line[2]);
                    //System.out.println(difficulty + "2");

                    newQuestion = new Question(question, correctOption, difficulty);


                }
                else {
                  System.out.println("Invalid CSV format for line: " + String.join(",", line));
                }
                //System.out.println("Dif" + line[2]);
                //if (newQuestion != null) {
                    //System.out.print("added to the list yay!!");
                    questionList.add(newQuestion);
                //}
                //System.out.println(difficulty + "3");
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return questionList;
    }
}

