package epicTest;


//Imports:
//GUI
import java.awt.event.*;   
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;




public class Quiz extends QuizGUI implements ActionListener {

	java.util.List<Question> questionBank;



	private Logon accountsData;
	private Account loggedAccount;
	private CustomTimer gameTimer = new CustomTimer();
	// END




	//Initialisation of variables
	int answer;
	int index;
	int randIndex;
	int incDifIndex;
	int score = 0;
	int result;
	int mode;
	int numberOfQuestions = 6;


	//Used for random number generator


	//QuizGUI GUI = new QuizGUI();

	public void run(Logon accountsData) {


		// Author : Victor - Linking login and user accounts
		this.accountsData = accountsData;
		this.loggedAccount = this.accountsData.getLoggedAccount();
		// END


		//End of quiz results


		//End of quiz results
		Color paleGreen = new Color(194, 215, 211);
		Color darkBlue = new Color(37, 49, 220);
		Font statsFont = new Font("Garamond",Font.BOLD,25);
		//Score


		// Author Victor - Stats/Leaderboards GUI
//wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww

		/// END

//wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww


		//Buttons
		buttonA.addActionListener(this); //Takes user input
		buttonB.addActionListener(this); //Takes user input
		buttonC.addActionListener(this); //Takes user input
		buttonD.addActionListener(this); //Takes user input

		//Button 1/Easy
		button1.addActionListener(new ActionListener() { //Takes User input
			@Override
			public void actionPerformed(ActionEvent e) {
//				//questions = bank.getQuestions(1); //Assigns easy questions
//				//potAnswers = bank.getPotAnswers(1); //Assigns easy Potential Answers
//				//answers = bank.getAnswers(1); //Assigns easy answers
//
//				QuestionReader.fileReading(Difficulty.Easy);
//				java.util.List<Question> QuestionsBank = QuestionReader.getQuestionBank();
//				System.out.println(QuestionsBank.get(3));

				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Easy);
				//System.out.println(questionBank.get(3).getAnswer1());

				setLabelColour(25, 255, 0);
				nextQuestion(); //Method is run, question appears


			}
		});

		//Button 2/Medium
		button2.addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				//questions = bank.getQuestions(2);
				//potAnswers = bank.getPotAnswers(2);
				//answers = bank.getAnswers(2);

				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Medium);
				setLabelColour(255, 240, 20);
				nextQuestion(); //Method is run, question appears
			}
		});

		//Button 3/Hard
		button3.addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				//questions = bank.getQuestions(3);
				//potAnswers = bank.getPotAnswers(3);
				//answers = bank.getAnswers(3);

				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Hard);
				setLabelColour(255, 44, 20);
				nextQuestion(); //Method is run, question appears
			}
		});

		//Button 4/Random
		button4.addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.All);
				setLabelColour(20, 255, 240);
				nextQuestion(); //Method is run, question appears

			}
		});

		//Button 5/Increasing Difficulty  !This method continues later in the code!
		button5.addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				mode = 5; //Assigns mode 5
				//This mode begins with easy mode

				//questions = bank.getQuestions(mode);
				//potAnswers = bank.getPotAnswers(mode);
				//answers = bank.getAnswers(mode);
				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Easy);

				setLabelColour(255, 169, 20);
				nextQuestion(); //Method is run, question appears
			}
		});


	}

	public int randGenerate() {
		usedNumbers.add(100); //Used to begin while loop
		int localRand = 100; //Used to begin while loop

		while (usedNumbers.contains(localRand)) { //If chosen number was already used, another one is generated
			localRand = rand.nextInt(questionBank.size()); //Random number is generated
		}
		usedNumbers.add(localRand);    //Generated number is added to list of used numbers
		return localRand; //Random number is generated
	}

	public void nextQuestion() {

		// Author Victor : updating the display of total points obtained so far
		//this.scoreDisplay.setText(String.format("Score: %s", this.detailedScore));
		// END


		if (index >= numberOfQuestions) { //If end of quiz
			results();   //Display results
		} else {
			this.gameTimer.reset();
			//Increasing difficulty mode
			if (mode == 5) {
				if (incDifIndex == 2) { //Once 2 questions from easy category are asked, code moves to medium category of questions
					//questions = bank.getQuestions(2);
					//potAnswers = bank.getPotAnswers(2);
					//answers = bank.getAnswers(2);
					questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Medium);
				}
				if (incDifIndex == 4) { //Once 2 questions from medium category are asked, code moves to hard category of questions
					//questions = bank.getQuestions(3);
					//potAnswers = bank.getPotAnswers(3);
					//answers = bank.getAnswers(3);
					questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Hard);




				}
				incDifIndex++; //Increment Increasing difficulty index

			}


			randIndex = randGenerate(); //random number is generated and assigned
			//System.out.println(questionBank.get(randIndex).getType());
			//System.out.println(questionBank.get(randIndex).getDifficulty());
			//System.out.println(questionBank.get(randIndex).getDifficulty());

			//Buttons and labels for modes are hidden
			setDifficultyButtonVisibility(false);

			//Buttons for questions are shown
			setOptionButtonVisibility(true);


			textfield.setText("Questions " + (index + 1)); //Question number is displayed
			textarea.setText(questionBank.get(randIndex).getQuestion()); //question is displayed


			if (questionBank.get(randIndex).getType() == QuestionType.TrueOrFalse) {
				answer_labelB.setText(questionBank.get(randIndex).getAnswer1());
				answer_labelC.setText(questionBank.get(randIndex).getAnswer2());
				buttonA.setVisible(false);
				buttonD.setVisible(false);
				buttonA.setEnabled(false);
				buttonA.setEnabled(false);
				answer_labelA.setVisible(false);
				answer_labelD.setVisible(false);
			} else if (questionBank.get(randIndex).getType() == QuestionType.MultipleChoice) {
				answer_labelA.setText(questionBank.get(randIndex).getAnswer1());
				answer_labelB.setText(questionBank.get(randIndex).getAnswer2());
				answer_labelC.setText(questionBank.get(randIndex).getAnswer3());
				answer_labelD.setText(questionBank.get(randIndex).getAnswer4());
				buttonA.setVisible(true);
				buttonD.setVisible(true);
				buttonA.setEnabled(true);
				buttonA.setEnabled(true);
				answer_labelA.setVisible(true);
				answer_labelD.setVisible(true);
			}

	}

}




	/**
	 * Calculates the amount of points obtained when answering correctly a question based on the time spent to answer and on the question's difficulty.
	 * @return The amount of points obtained
	 *
	 * Author: Victor
	 */ //channge get difficukty function
	public int calculateDetailedScore() {
		Difficulty difficulty = questionBank.get(randIndex).getDifficulty();
		int difficultyModifier = 1000;
		int timeSpentOnQuestion = this.gameTimer.getTimeSeconds();

		if (difficulty == Difficulty.Medium) {
			difficultyModifier /= 2;
		}
		else if (difficulty == Difficulty.Easy) {
			difficultyModifier /= 4;
		}
		return (int) (difficultyModifier * Math.pow(0.9, timeSpentOnQuestion));
	}

	public void actionPerformed(ActionEvent e) { ///////////////////////////////////////////////////////////////////////
		//All buttons are disabled
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);

		//Converting user input (via buttons) into an integer, stored in the variable "answer"
		if(e.getSource()==buttonA) {
			answer = 1;
		}
		if(e.getSource()==buttonB) {
			answer = 2;
		}
		if(e.getSource()==buttonC) {
			answer = 3;
		}
		if(e.getSource()==buttonD) {
			answer = 4;

		}
		if(questionBank.get(randIndex).getCorrectAnswer() == answer) { //If correct answer
			score++; //Increment score
			detailedScore += this.calculateDetailedScore();
			//System.out.println("Correct");
		}
		//else System.out.println("Incorrect");

		displayAnswer(); //Correct answer is indicated
	}

	public void displayAnswer() { /////////////////////////////////////////////////////////////////////////////////////
		//Buttons are disabled
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);



		//Timer, for 50 milliseconds break when answer is selected
		Timer pause = new Timer(50,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//Buttons are enabled
				buttonA.setEnabled(true); ////////////////////////////////////////////////////////////////////////////////
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++; //Increment index
				nextQuestion(); //Move onto next question
			}
		});

		//1 second break
		pause.setRepeats(false);
		pause.start();
	}

	public void results() {
		hideDisableAll();

		result = (int)((score/(double)6)*100); //Result is calculated into a percentage

		textfield.setText("RESULTS"); //Heading 1 displays "RESULTS"
		textarea.setText("Thank you for playing :)"); //Heading 2 displays "Thank you for playing :)"
		textarea.setFont(new Font("Lucida Handwriting",Font.PLAIN,50));

		number_right.setText("Correct answers: " + score + "/6"); //Score out of 6 is displayed
		percentage.setText("Percentage ratio: " + result + "%"); //Percentage result is displayed


		frame.add(number_right); //Score is added to frame
		frame.add(percentage); //Percentage is added to frame
		frame.add(average);
		frame.add(standardDeviation);




		/// Author: Victor
		if (!this.loggedAccount.getUsername().equals("guest")) {
			this.loggedAccount.updateScore(detailedScore);
		}



		this.buildStats();
		this.leaderBoardSign.setVisible(true);
		this.buildLeaderBoards();

		this.detailedScore = 0;
	}


	////////////////////////////////////////////////////////////////////////////////////////////////

	// Building the leaderboards / stats interface - Victor

	// Building the leaderboards / stats interface - Victor




	/**
	 * Builds the stats related GUI elements
	 */
	public void buildStats() {
		number_right.setText("Correct answers: " + score + "/6"); //Score out of 6 is displayed
		number_right.setVisible(true);
		percentage.setText("Percentage ratio: " + result + "%"); //Percentage result is displayed
		percentage.setVisible(true);
		average.setText(String.format("Your average score: %s", this.loggedAccount.getMeanScore()));
		average.setVisible(true);
		standardDeviation.setText(String.format("Your score's deviation: %s", this.loggedAccount.getStandardDeviationScore()));
		standardDeviation.setVisible(true);
	}private int detailedScore = 0;


	/**
	 * Builds the GUI elements of the leaderboard
	 *///sets texts to leaderboard accounts
	public void buildLeaderBoards() {
		Account[] podium = this.accountsData.getPodium();
		Account currentAccount;
		int rank;
		for (int i=0; i < 4; i++) {
			if (i < 3) {
				currentAccount = podium[i];
				rank = i + 1;
			}
			else {
				currentAccount = this.loggedAccount;
				rank = this.accountsData.getRank(currentAccount);
				if (rank <= 3) {
					break;
				}
			}
			leaderBoardFields[i].setText(String.format("%s. %s: %s", rank, currentAccount.getUsername(), currentAccount.getHighestScore()));
			leaderBoardFields[i].setVisible(true);
		}
	}
}