package epicTest;


//Imports:
//GUI
import java.awt.event.*;   
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

//Sorting arrays
import java.util.Arrays;

//Random number generator
import java.util.Random;
import java.util.HashSet;
import java.util.Set;


public class Quiz extends QuizGUI implements ActionListener{
	
	
	//Quiz Bank 
	QuizBank bank = new QuizBank();
	java.util.List<Question> questionBank;
	
	
	// Author: Victor - Account linked and score calculation attributes
	private Logon accountsData;
	private Account loggedAccount;
	private int detailedScore = 0;
	private CustomTimer gameTimer = new CustomTimer();
	// END
	
	//private JTextField rankHighestScore; //GUI////////////////////////////////////////////////////////////
	private JTextField standardDeviation;
	private JTextField leaderBoardSign;
	private JTextField average;
	private JTextField scoreDisplay;
	private JTextField[] leaderBoardFields = new JTextField[4];
	
	//Initialisation of variables
	int answer;
	int index;
	int randIndex;
	int incDifIndex;
	int score = 0;
	int result;
	int mode;
	int numberOfQuestions = 6;
	String[] questions = bank.getQuestions(0);
	String[][] potAnswers = bank.getPotAnswers(0);
	int[] answers = bank.getAnswers(0);
	
	
	//Used for random number generator
	
	
	//QuizGUI GUI = new QuizGUI();
	
	public void run(Logon accountsData) {
	
		
		// Author : Victor - Linking login and user accounts
		this.accountsData= accountsData;
		this.loggedAccount = this.accountsData.getLoggedAccount();
		// END
		
	
		
		//End of quiz results
	
		Color paleGreen = new Color(194,215,211);
		Color darkBlue = new Color(37,49,220);
		Font statsFont = new Font("Garamond",Font.BOLD,25);
	
		
		
		// Author Victor - Stats/Leaderboards GUI/////////////////////////////////////////////////////////////////////////
		
		this.leaderBoardSign = this.buildStatField(225);
		this.leaderBoardSign.setBackground(paleGreen);
		this.leaderBoardSign.setText("Leaderboard");
		for (int j=0; j<4; j++) {
			this.leaderBoardFields[j] = this.buildStatField(100 * (j + 3) + 25);
		}
		
		this.leaderBoardFields[0].setForeground(new Color(212,175,55));
		this.leaderBoardFields[1].setForeground(new Color(192, 192, 192));
		this.leaderBoardFields[2].setForeground(new Color(169, 113, 66));
		
		//rankHighestScore = this.buildStatField(100 * 6);
		this.scoreDisplay = new JTextField();
		this.scoreDisplay.setVisible(false);
		this.scoreDisplay.setBackground(new Color (25, 25, 25));
		this.scoreDisplay.setForeground(new Color(255,255,255));
		this.scoreDisplay.setBounds(1350, 0, 200, 100);
		this.scoreDisplay.setFont(new Font("Garamond",Font.BOLD,22)); //Font and text size
		this.scoreDisplay.setHorizontalAlignment(JTextField.CENTER);
		this.scoreDisplay.setText("");
		this.scoreDisplay.setVisible(true);
		frame.add(this.scoreDisplay);
		
		average = this.buildStatField(800, 750, 650, 100, paleGreen, darkBlue, statsFont);
		standardDeviation = this.buildStatField(800, 850, 650, 100, paleGreen, darkBlue, statsFont);////////////////////////////////////////////////////
		/// END
		
		
		
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

				questionBank =  ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Easy);
				//System.out.println(questionBank.get(3).getAnswer1());

				setLabelColour(25,255,0);
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

				questionBank =  ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Medium);
				setLabelColour(255,240,20);
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

				questionBank =  ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Hard);
				setLabelColour(255,44,20);
				nextQuestion(); //Method is run, question appears
			}
		});
		
		//Button 4/Random  
		button4.addActionListener(new ActionListener() { //Takes user input
			@Override
			public void actionPerformed(ActionEvent e) {
				questionBank =  ReturnQuestionsByDifficulty.filterByDiff(Difficulty.All);
				setLabelColour(20,255,240);
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
				questionBank =  ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Easy);
				
				setLabelColour(255,169,20);
				nextQuestion(); //Method is run, question appears
			}
		});
		
		
		
		

	}

	public int randGenerate() {
		usedNumbers.add(20); //Used to begin while loop
		int localRand = 20; //Used to begin while loop
		
		while (usedNumbers.contains(localRand)) { //If chosen number was already used, another one is generated
			localRand = rand.nextInt(questionBank.size()); //Random number is generated
		}
			usedNumbers.add(localRand);	//Generated number is added to list of used numbers
			return localRand; //Random number is generated
	}
	
	public void nextQuestion() {
		
		// Author Victor : updating the display of total points obtained so far
		//this.scoreDisplay.setText(String.format("Score: %s", this.detailedScore));
		// END
		
		
		if(index >= numberOfQuestions) { //If end of quiz
			results();   //Display results
		}
		else {
			this.gameTimer.reset();
			//Increasing difficulty mode 
			if (mode == 5 ) {
				if (incDifIndex == 2) { //Once 2 questions from easy category are asked, code moves to medium category of questions
					//questions = bank.getQuestions(2);
					//potAnswers = bank.getPotAnswers(2);
					//answers = bank.getAnswers(2);
					questionBank =  ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Medium);
				}
				if (incDifIndex == 4) { //Once 2 questions from medium category are asked, code moves to hard category of questions
					//questions = bank.getQuestions(3);
					//potAnswers = bank.getPotAnswers(3);
					//answers = bank.getAnswers(3);
					questionBank =  ReturnQuestionsByDifficulty.filterByDiff(Difficulty.Hard);
				}
				incDifIndex++; //Increment Increasing difficulty index 

			}
	
			
			randIndex = randGenerate(); //random number is generated and assigned 
			//Buttons and labels for modes are hidden
			setDifficultyButtonVisibility(false);
			
			//Buttons for questions are shown
			setOptionButtonVisibility(true);
			
			
			textfield.setText("Questions " +(index + 1)); //Question number is displayed
			textarea.setText(questionBank.get(randIndex).getQuestion()); //question is displayed
			//Potential answers are displayed in labels
			answer_labelA.setText(questionBank.get(randIndex).getAnswer1());
			answer_labelB.setText(questionBank.get(randIndex).getAnswer2());
			answer_labelC.setText(questionBank.get(randIndex).getAnswer3());
			answer_labelD.setText(questionBank.get(randIndex).getAnswer4());
		}
		
	}
	
	
	/**
	 * Gets a question's difficulty by searching from which question bank it is from
	 * @param question i.e. The question that we want to find the difficulty of.
	 * @return The difficulty of the question represented by a string: "EASY" or "MEDIUM" or "HARD".
	 * If the question wasn't found in any question bank, returns an empty string.
	 */
	public String getDifficulty(String question) {
		
		for (int i =1; i <= 3; i++) {
			if (Utilities.searchString(question, bank.getQuestions(i))) {
				return i == 1 ? "EASY" : i == 2 ? "MEDIUM" : "HARD";
			}
		}
		return "";
	}
	///returning difficulty of the question. Used in next method
	
	/**
	 * Calculates the amount of points obtained when answering correctly a question based on the time spent to answer and on the question's difficulty.
	 * @return The amount of points obtained
	 * 
	 * Author: Victor
	 */ //channge get difficukty function
	public int calculateDetailedScore() {
		String difficulty = this.getDifficulty(questions[randIndex]);
		int difficultyModifier = 1000;
		int timeSpentOnQuestion = this.gameTimer.getTimeSeconds();
		
		if (difficulty.equals("MEDIUM")) {
			difficultyModifier /= 2;
		}
		else if (difficulty.equals("EASY")) {
			difficultyModifier /= 4;
		}
		return (int) (difficultyModifier * Math.pow(0.9, timeSpentOnQuestion));
	}
	
	public void actionPerformed(ActionEvent e) {
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
		}
		
		displayAnswer(); //Correct answer is indicated
	}
	
	public void displayAnswer() {
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
				buttonA.setEnabled(true);
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
		
		
		
		/// Author: Victor
		if (!this.loggedAccount.getUsername().equals("guest")) {
			this.loggedAccount.updateScore(this.detailedScore);
		}
		
		
		this.buildStats();
		this.leaderBoardSign.setVisible(true);
		this.buildLeaderBoards();
		
		this.detailedScore = 0;
		/// End
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Building the leaderboards / stats interface - Victor
	
	/**
	 * Quickly initialise specific GUI elements (e.g. for leaderboards / stats)
	 * Author: Victor
	 *///Rows on leaderboard
	public JTextField buildStatField(int pos_y) {
		JTextField txtfield = new JTextField();
		txtfield.setBounds(0,pos_y,1600,100);
		txtfield.setBackground(new Color(25,25,25));
		txtfield.setForeground(new Color(37,49,220));
		txtfield.setFont(new Font("Ink Free", Font.PLAIN,30));
		txtfield.setBorder(BorderFactory.createBevelBorder(1));
		txtfield.setHorizontalAlignment(JTextField.CENTER);
		txtfield.setEditable(false);
		txtfield.setVisible(false);
		this.frame.add(txtfield);
		return txtfield;
	}
	
	
	/**
	 * Quickly initialise specific GUI elements (e.g. for leaderboards / stats), higher flexibility version
	 * Author: Victor
	 *////boxes on leaderboard
	public JTextField buildStatField(int pos_x, int pos_y, int width, int height, Color bgColor, Color fgColor, Font font) {
		JTextField txtfield = new JTextField();
		txtfield.setBounds(pos_x,pos_y,width,height);
		txtfield.setBackground(bgColor);
		txtfield.setForeground(fgColor);
		txtfield.setFont(font);
		txtfield.setBorder(BorderFactory.createBevelBorder(1));
		txtfield.setHorizontalAlignment(JTextField.CENTER);
		txtfield.setEditable(false);
		txtfield.setVisible(false);
		this.frame.add(txtfield);
		return txtfield;
	}
	

	/**
	 * Builds the stats related GUI elements
	 */
	public void buildStats() {
		this.average.setText(String.format("Your average score: %s", this.loggedAccount.getMeanScore()));
		this.average.setVisible(true);
		this.standardDeviation.setText(String.format("Your score's deviation: %s", this.loggedAccount.getStandardDeviationScore()));
		this.standardDeviation.setVisible(true);
	}
	
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
			this.leaderBoardFields[i].setText(String.format("%s. %s: %s", rank, currentAccount.getUsername(), currentAccount.getHighestScore()));
			this.leaderBoardFields[i].setVisible(true);
		}
	}
}