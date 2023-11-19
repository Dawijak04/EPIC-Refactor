// Author: Dawid Jabuwoski

package epicTest;

import java.util.Arrays;

public class potAnswerSorting {
	private String[][] potAnswers;

	public potAnswerSorting(String[][] potAnswers) {
		this.potAnswers = potAnswers;
	}
	
	
	//Potential Answers
	public String[][] getPotAnswers(int diff){
		if (diff == 1) {
			String[][] easyPotAnswers = Arrays.copyOfRange(potAnswers, 0, 6);
			return easyPotAnswers;
		}
		else if (diff == 2) {
			String[][] mediumPotAnswers = Arrays.copyOfRange(potAnswers,6, 12);
			return mediumPotAnswers;
		}
		else if (diff == 3) {
			String[][] hardPotAnswers = Arrays.copyOfRange(potAnswers, 12, 18);
			return hardPotAnswers;
		}
		else {
			return potAnswers;
		}
	}

}