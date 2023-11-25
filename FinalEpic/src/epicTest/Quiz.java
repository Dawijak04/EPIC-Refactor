package epicTest;


//Imports:
//Action Listeners
import java.awt.event.*;   
import java.awt.*;
import java.awt.event.ActionListener;
//Used for random number generate
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Quiz extends QuizGUI implements ActionListener {

	//List of questions
	private java.util.List<Question> questionBank;

	//Accounts data
	private Logon accountsData;
	private Account loggedAccount;

	//Timer
	private CustomTimer gameTimer = new CustomTimer();





	//Initialisation of variables
	private int answer; //user input answer
	private int index; //index of question out of 6
	private int randIndex; //random number used for picking a question
	private int incDifIndex; //used for increasing difficulty mode.Switches difficulties once 2 questions of one more are asked
	private int score = 0; //score
	private int result; //used for calculating percentage of score
	private int mode; //used for the program to recognize if increasing difficulty mode is activated
	private int numberOfQuestions = 6; //limit of questions asked

	//Used for random number generator
	private Random rand = new Random();
	private Set<Integer> usedNumbers = new HashSet<>();






	//application is run
	public void run(Logon accountsData) {
		//appropriate account is found
		this.accountsData = accountsData;
		loggedAccount = this.accountsData.getLoggedAccount();

		showDifficultyButtons(true);//difficulty buttons are displayed
		index = 0;
		score = 0;
		incDifIndex = 0;
		mode = 0;
		result = 0;
		usedNumbers.clear();


		//Button 1/Easy
		difficultyButtons[0].addActionListener(new ActionListener() { //Takes User input
			@Override
			public void actionPerformed(ActionEvent e) {
				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Easy); //easy questions are assigned to the question list
				setLabelColour(25, 255, 0); //answer labels are set to green
				nextQuestion(); //Method is run, question appears
			}
		});

		//Button 2/Medium
		difficultyButtons[1].addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Medium); //medium questions are assigned to the question list
				setLabelColour(255, 240, 20); //answer labels are set to yellow
				nextQuestion(); //Method is run, question appears
			}
		});

		//Button 3/Hard
		difficultyButtons[2].addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Hard); //hard questions are assigned to the question list
				setLabelColour(255, 44, 20); //answer labels are set to red
				nextQuestion(); //Method is run, question appears
			}
		});

		//Button 4/Random
		difficultyButtons[3].addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.All); //all questions are assigned to the question list
				setLabelColour(20, 255, 240); //answer labels are set to cyan
				nextQuestion(); //Method is run, question appears

			}
		});

		//Button 5/Increasing Difficulty  !This method continues later in the code!
		difficultyButtons[4].addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				mode = 5; //Assigns mode 5
				questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Easy); //Starts off with the easy questions and changes progressively
				setLabelColour(255, 169, 20); //answer labels are set to orange
				nextQuestion(); //Method is run, question appears
			}
		});
	}
//Generates a random number within the range of questions without repeating it
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
		enableDifficultyButtons(false); //difficulty buttons are disabled
		showDifficultyButtons(false); //difficulty buttons are hidden
		enableOptionButtons(true); //option buttons are enabled
		showOptionButtons(true); //option buttons are shown


		if (index >= numberOfQuestions) { //If end of quiz
			results();   //Display results
		} else {
			this.gameTimer.reset();
			//Increasing difficulty mode
			if (mode == 5) {
				if (incDifIndex == 2) { //Once 2 questions from easy category are asked, code moves to medium category of questions
					questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Medium);
				}
				if (incDifIndex == 4) { //Once 2 questions from medium category are asked, code moves to hard category of questions
					questionBank = ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Hard);
				}
				incDifIndex++; //Increment Increasing difficulty index

			}

			randIndex = randGenerate(); //random number is generated and assigned

			//Buttons for questions are shown
			showOptionButtons(true);


			textfield.setText("Questions " + (index + 1)); //Question number is displayed
			textarea.setText(questionBank.get(randIndex).getQuestion()); //question is displayed

			if (questionBank.get(randIndex).getType() == QuestionType.TrueOrFalse) {
				optionLabels[1].setText(questionBank.get(randIndex).getAnswer1());
				optionLabels[2].setText(questionBank.get(randIndex).getAnswer2());
				trueOrFalseQuestionButtons();
			} else if (questionBank.get(randIndex).getType() == QuestionType.MultipleChoice) {
				optionLabels[0].setText(questionBank.get(randIndex).getAnswer1());
				optionLabels[1].setText(questionBank.get(randIndex).getAnswer2());
				optionLabels[2].setText(questionBank.get(randIndex).getAnswer3());
				optionLabels[3].setText(questionBank.get(randIndex).getAnswer4());
				multipleChoiceQuestionButtons();
			}
	}
}


	//calculates the points a user gets for a specific question by taking into account the time spent on the question, the difficulty and users input
	public int calculateDetailedScore() {
		Difficulty difficulty = questionBank.get(randIndex).getDifficulty(); //gets the difficulty of the current question
		int difficultyModifier = 1000;
		int timeSpentOnQuestion = gameTimer.getTimeSeconds(); //time spent on question

		if (difficulty == Difficulty.Medium) {
			difficultyModifier /= 2; //points are divided by 2 if in medium mode
		}
		else if (difficulty == Difficulty.Easy) {
			difficultyModifier /= 4; //points are divided by 4 if in hard mode
		}
		return (int) (difficultyModifier * Math.pow(0.9, timeSpentOnQuestion)); //returns points for that question
	}

	public void actionPerformed(ActionEvent e) {
		enableOptionButtons(false); //once pressed, option buttons are disabled
		//Converting user input (via buttons) into an integer, stored in the variable "answer"
		if(e.getSource()==optionButtons[0]) {
			answer = 1;
		}
		if(e.getSource()==optionButtons[1]) {
			answer = 2;
		}
		if(e.getSource()==optionButtons[2]) {
			answer = 3;
		}
		if(e.getSource()==optionButtons[3]) {
			answer = 4;
		}
		if(questionBank.get(randIndex).getCorrectAnswer() == answer) { //If correct answer
			score++; //Increment score
			detailedScore += calculateDetailedScore();
		}
		index++; //index is incremented
		nextQuestion(); //Correct answer is indicated
	}

	public void results() {
		enableOptionButtons(false); //option buttons are disabled
		showOptionButtons(false); //option buttons are hidden

		result = (int)((score/(double)6)*100); //Result is calculated into a percentage

		textfield.setText("RESULTS"); //Heading 1 displays "RESULTS"
		textarea.setText("Thank you for playing :)"); //Heading 2 displays "Thank you for playing :)"
		textarea.setFont(new Font("Lucida Handwriting",Font.PLAIN,50));

		frame.add(number_right); //Score is added to frame
		frame.add(percentage); //Percentage is added to frame
		frame.add(average); //average is added to frame
		frame.add(standardDeviation); //standard deviation is added to frame


		if (!loggedAccount.getUsername().equals("guest")) { //if user is logged into an account
			loggedAccount.updateScore(detailedScore); //score is saved into their accounts file
		}

		buildStats(); //stat data is set to GUI components to be displayed for the user
		leaderBoardSign.setVisible(true); //Leaderboard sign is shown
		buildLeaderBoards(); //podium is set

		detailedScore = 0;

		restartButton.setVisible(true);
		restartButton.setEnabled(true);
		restartButton.addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				startQuizSettings();
				run(Logon.getUser());
			}
		});
	}

	/**
	 * Builds the stats related GUI elements
	 */
	public void buildStats() {
		number_right.setText("Correct answers: " + score + "/6"); //Score out of 6 is displayed
		number_right.setVisible(true);
		percentage.setText("Percentage ratio: " + result + "%"); //Percentage result is displayed
		percentage.setVisible(true);
		average.setText(String.format("Your average score: %s", loggedAccount.getMeanScore())); //Average score of account is displayed (Shows null if logged in as guest)
		average.setVisible(true);
		standardDeviation.setText(String.format("Your score's deviation: %s", loggedAccount.getStandardDeviationScore())); //Standard deviation is displayed (Shows null if logged in as guest)1
		standardDeviation.setVisible(true);
	}private int detailedScore = 0;


	/**
	 * Builds the GUI elements of the leaderboard
	 *///sets texts to leaderboard accounts
	public void buildLeaderBoards() {
		Account[] podium = accountsData.getPodium(); //array of podium accounts
		Account currentAccount;
		int rank;
		for (int i=0; i < 4; i++) {
			if (i < 3) {
				currentAccount = podium[i];
				rank = i + 1;
			}
			else {
				currentAccount = loggedAccount;
				rank = accountsData.getRank(currentAccount);
				if (rank <= 3) {
					break;
				}
			}
			leaderBoardFields[i].setText(String.format("%s. %s: %s", rank, currentAccount.getUsername(), currentAccount.getHighestScore())); //account details are set to the leaderboard GUI
			leaderBoardFields[i].setVisible(true);
		}
	}
}