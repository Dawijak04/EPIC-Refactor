// Author : Dawid Jabuwoski

package epicTest;

import java.util.Arrays;

public class answerSorting {
	private int[] answers;

	public answerSorting(int[] answers) {
		this.answers = answers;
	}
		
	//Correct answers
	public int[] getAnswers(int diff) {
		if (diff == 1) {
			int[] easyAnswers = Arrays.copyOfRange(answers, 0, 6);
			return easyAnswers;
		}
		if (diff == 2) {
			int[] mediumAnswers = Arrays.copyOfRange(answers, 6, 12);
			return mediumAnswers;
		}
		if (diff == 3) {
			int[] hardAnswers = Arrays.copyOfRange(answers, 12, 18);
			return hardAnswers;
		}
		else {
			return answers;
		}
	}
	

}