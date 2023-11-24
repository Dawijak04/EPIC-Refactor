package epicTest;

//Imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class QuizGUI{
//Initializing GUI components

		//Frame
		JFrame frame = new JFrame();
		JTextField textfield= new JTextField();
		JTextArea textarea = new JTextArea();
		
		//Buttons
		JButton[] difficultyButtons = new JButton[5];
		JButton[] optionButtons = new JButton[4];
		JButton restartButton = new JButton();

		
		//Answer labels

		JLabel[] answerLabels = new JLabel[5];
		JLabel[] optionLabels = new JLabel[4];

		//End result
		//Statistics
		JTextField number_right = new JTextField();
		JTextField percentage = new JTextField();
		JTextField standardDeviation = new JTextField();
		JTextField average = new JTextField();

		//Leaderboard
		JTextField leaderBoardSign = new JTextField();
		JTextField[] leaderBoardFields = new JTextField[4];

		String[] letters = {"A", "B", "C", "D"}; //used for assigning letters to buttons
		String[] difficulties = {"Novice", "Intermediate", "Expert", "Random", "Increasing Difficulty"};//used for assigning difficulties to labels

		//Methods used to create GUI components
	public JButton initializeButton(JButton button, int y) { //creates buttons to choose difficulty of game
		button = new JButton();
		String number = String.valueOf(y + 1);
		button.setFont(new Font("MV Boli", Font.BOLD, 35));
		button.setBounds(625, (250 + (120 * y)), 100, 100);
		button.setText(number);
		frame.add(button);
		return button;
	}
	public JButton initializeButton(JButton button, int y, String text) { //creates buttons to choose an answer option
		button = new JButton();
		button.setFont(new Font("MV Boli", Font.BOLD, 35));
		button.setBounds(0, (270 + (130 * y)), 100, 100);
		button.setText(text);
		button.addActionListener((ActionListener) this);
		frame.add(button);
		return button;
	}

	public JLabel initializeLabel(JLabel label, int y, String text) { //creates labels describing the difficulty of the game
		label = new JLabel();
		label.setBounds(750, (250 + (y * 120)), 500, 100);
		label.setBackground(new Color(50,50,50));
		label.setFont(new Font("Papyrus",Font.PLAIN,35)); //Font and text size
		label.setText(text);
		frame.add(label);
		label.setVisible(true);
		return label;
	}

	public JLabel initializeLabel(JLabel label, int y) { //creates labels to display answer options
		label = new JLabel();
		label.setBounds(125, (270 + (y * 130)), 1600, 100);
		label.setBackground(new Color(50,50,50));
		label.setFont(new Font("Times New Roman",Font.PLAIN,35)); //Font and text size
		frame.add(label);
		return label;
	}

	public JTextField buildStatField(int pos_y) { //creates podium
		JTextField txtfield = new JTextField();
		txtfield.setBounds(0,pos_y,1600,100);
		txtfield.setBackground(new Color(25,25,25));
		txtfield.setForeground(new Color(37,49,220));
		txtfield.setFont(new Font("Garamond", Font.PLAIN,30));
		txtfield.setBorder(BorderFactory.createBevelBorder(1));
		txtfield.setHorizontalAlignment(JTextField.CENTER);
		txtfield.setEditable(false);
		txtfield.setVisible(false);
		frame.add(txtfield);
		return txtfield;
	}


	public JTextField buildStatField(int pos_x, int pos_y, int width, int height) { //creates boxes to display statistics/results at the end of the game
		JTextField txtfield = new JTextField();
		txtfield.setBounds(pos_x,pos_y,width,height);
		txtfield.setBackground(new Color(194,215,211));
		txtfield.setForeground(new Color(37,49,220));
		txtfield.setFont(new Font("Garamond",Font.BOLD,25));
		txtfield.setBorder(BorderFactory.createBevelBorder(1));
		txtfield.setHorizontalAlignment(JTextField.CENTER);
		txtfield.setEditable(false);
		txtfield.setVisible(false);
		frame.add(txtfield);
		return txtfield;
	}

	public QuizGUI() {
			//Frame
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1600,1000);
			frame.getContentPane().setBackground(new Color(34,34,34));
			frame.setLayout(null);
			frame.setResizable(false);
			frame.setVisible(true);


		//Buttons/Labels displaying game modes
		for (int i = 0; i < 5; i++) {
			difficultyButtons[i] = initializeButton(difficultyButtons[i], i);
			answerLabels[i] = initializeLabel(answerLabels[i], i, difficulties[i]);
		}

		//Buttons/Labels displaying answer options
		for (int i = 0; i < 4; i++) {
			optionButtons[i] = initializeButton(optionButtons[i], i, letters[i]);
			optionLabels[i] = initializeLabel(optionLabels[i], i);
		}

		restartButton.setBounds(1350, 100, 200, 100);
		restartButton.setFont(new Font("Garamond",Font.BOLD,25));
		restartButton.setBackground(new Color(194,215,211));
		restartButton.setForeground(new Color(37,49,220));
		restartButton.setText("Play again");
		restartButton.setEnabled(true);
		restartButton.setVisible(false);
		frame.add(restartButton);

		//Leaderboard is created
		leaderBoardSign = buildStatField(225);
		leaderBoardSign.setBackground(new Color(194,215,211)); //sets background to pale green
		leaderBoardSign.setText("Leaderboard");
		for (int j=0; j<4; j++) {
			leaderBoardFields[j] = buildStatField(100 * (j + 3) + 25); //creates podium. 4 boxes in total, 3 for the best players and a 4th to display the rank of the user
		}

			//Unique colours are assigned to each difficulty label and podium places
		answerLabels[0].setForeground(new Color(25,255,0)); //Foreground colour: Green
		answerLabels[1].setForeground(new Color(255,240,20)); //Foreground colour: Yellow
		answerLabels[2].setForeground(new Color(255,44,20)); //Foreground colour: Red
		answerLabels[3].setForeground(new Color(20,255,240)); //Foreground colour: Cyan
		answerLabels[4].setForeground(new Color(255,169,20)); //Foreground colour: Orange
		leaderBoardFields[0].setForeground(new Color(212,175,55)); //Foreground colour: Gold
		leaderBoardFields[1].setForeground(new Color(192, 192, 192)); //Foreground colour: Silver
		leaderBoardFields[2].setForeground(new Color(169, 113, 66)); //Foreground colour:Bronze


		//build GUI components for statistics
		number_right = this.buildStatField(150, 750, 650, 100);
		percentage = this.buildStatField(150,850,650,100);
		average = this.buildStatField(800, 750, 650, 100);
		standardDeviation = this.buildStatField(800, 850, 650, 100);


		showOptionButtons(false); //option buttons are hidden

		//Title banner/Heading 1
		textfield.setBounds(0,0,1600,100);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(37,49,220));
		textfield.setFont(new Font("Ink Free", Font.PLAIN,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		textfield.setVisible(true);
		frame.add(textfield);
		textfield.setText("Welcome to ISE Quiz :)"); //Heading 1

		//Question banner/Heading 2
		textarea.setBounds(0,100,1600,100);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(37,49,220));
		textarea.setFont(new Font("MV Boli",Font.PLAIN,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		textarea.setText("Select difficulty"); //Heading 2
		frame.add(textarea);

		//title banner and question banner are shown
		textfield.setVisible(true);
		textarea.setVisible(true);

}
		//methods for different scenarios in the quiz
		public void showDifficultyButtons(boolean vis) { //visibility difficulty buttons and labels
			for (int i = 0; i < 5; i++) {
				difficultyButtons[i].setVisible(vis);
				answerLabels[i].setVisible(vis);
			}
		}
		public void enableDifficultyButtons(boolean x) {  //difficulty buttons can be enabled or disabled
			for(int i = 0; i < 5; i++) {
				difficultyButtons[i].setEnabled(x);
			}
		}
		public void setLabelColour(int a, int b, int c) { //option labels set to specific colour
			for(int i = 0; i < 4; i++) {
				optionLabels[i].setForeground(new Color(a, b, c));
			}
		}
		public void enableOptionButtons(boolean x) { //option buttons can be enabled or disabled
			//Buttons are disabled
			for (int i = 0; i < 4; i++) {
				optionButtons[i].setEnabled(x);
			}
		}
		public void showOptionButtons(boolean vis) { //visibility for option buttons and labels
			for (int i = 0; i < 4; i++) {
				optionButtons[i].setVisible(vis);
				optionLabels[i].setVisible(vis);
			}
		}

		public void startQuizSettings() {
			number_right.setVisible(false);
			average.setVisible(false);
			standardDeviation.setVisible(false);
			percentage.setVisible(false);
			leaderBoardSign.setVisible(false);
			for (int i = 0; i < 4; i++) {
				leaderBoardFields[i].setVisible(false);
			}
			restartButton.setVisible(false);
			restartButton.setEnabled(false);
			showDifficultyButtons(true);
			enableDifficultyButtons(true);
			textfield.setText("Welcome to ISE Quiz :)"); //Heading 1
			textarea.setText("Select difficulty"); //Heading 2
			textarea.setFont(new Font("MV Boli",Font.PLAIN,25));
		}
		 public void multipleChoiceQuestionButtons() {
			 optionButtons[0].setVisible(true);
			 optionButtons[3].setVisible(true);
			 optionButtons[0].setEnabled(true);
			 optionButtons[3].setEnabled(true);
			 optionLabels[0].setVisible(true);
			 optionLabels[3].setVisible(true);
			 optionButtons[1].setText("B");
			 optionButtons[2].setText("C");
		 }

		 public void trueOrFalseQuestionButtons() {
			 optionButtons[0].setVisible(false);
			 optionButtons[3].setVisible(false);
			 optionButtons[0].setEnabled(false);
			 optionButtons[3].setEnabled(false);
			 optionLabels[0].setVisible(false);
			 optionLabels[3].setVisible(false);
			 optionButtons[1].setText("T");
			 optionButtons[2].setText("F");
		 }
}