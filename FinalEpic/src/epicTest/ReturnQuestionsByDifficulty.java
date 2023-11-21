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
                if (line.length == 7) {
                    String question = line[0];
                    String option1 = line[1];
                    String option2 = line[2];
                    String option3 = line[3];
                    String option4 = line[4];
                    int correctOption = Integer.parseInt(line[5]);
                    Difficulty difficulty = Difficulty.valueOf(line[6]);

                    Question newQuestion = new Question(question, option1, option2, option3, option4, correctOption, difficulty);
                    questionList.add(newQuestion);
                } else {
                    System.out.println("Invalid CSV format for line: " + String.join(",", line));
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return questionList;
    }
}

