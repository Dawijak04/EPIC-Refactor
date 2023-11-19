// Author: Dawid Jabuwoski

package epicTest;

import java.util.Arrays;

public class QuestionSorting {
	private String[] questions;

	public QuestionSorting(String[] questions) {
		this.questions = questions;
	}
	
	//Questions
	public String[] getQuestions(int diff) {
		if (diff == 1) {
			String[] easyQuestions = Arrays.copyOfRange(questions, 0, 6);
			return easyQuestions;
		}
		else if (diff == 2) {
			String[] mediumQuestions = Arrays.copyOfRange(questions, 6, 12);
			return mediumQuestions;
		}
		else if (diff == 3 ) {
			String[] hardQuestions = Arrays.copyOfRange(questions, 12, 18);
			return hardQuestions;
		}
		else {
			return questions;
		}
	}
	
	
}