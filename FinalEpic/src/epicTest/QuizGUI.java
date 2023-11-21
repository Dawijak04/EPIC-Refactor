package epicTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class QuizGUI {

		JFrame frame = new JFrame();
		JTextField textfield = new JTextField();
		JTextField textfield2 = new JTextField();
		JTextArea textarea = new JTextArea();
		
		//Buttons
		JButton buttonA = new JButton();
		JButton buttonB = new JButton();
		JButton buttonC = new JButton();
		JButton buttonD = new JButton();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JButton button5 = new JButton();
		
		//ANswer labels
		JLabel answer_labelA = new JLabel();
		JLabel answer_labelB = new JLabel();
		JLabel answer_labelC = new JLabel();
		JLabel answer_labelD = new JLabel();
		JLabel answer_label1 = new JLabel();
		JLabel answer_label2 = new JLabel();
		JLabel answer_label3 = new JLabel();
		JLabel answer_label4 = new JLabel();
		JLabel answer_label5 = new JLabel();
		
		//End result
		JTextField number_right = new JTextField();
		JTextField percentage = new JTextField();


//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		JTextField standardDeviation = new JTextField();
		JTextField leaderBoardSign = new JTextField();
		JTextField average = new JTextField();

		JTextField scoreDisplay = new JTextField();
		JTextField[] leaderBoardFields = new JTextField[4];
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


		Random rand = new Random(); 
		Set<Integer> usedNumbers = new HashSet<>();
	
		public QuizGUI() {

		
		
		
		
		
		
		
			
			//Frame
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1600,1000);
			frame.getContentPane().setBackground(new Color(34,34,34));
			frame.setLayout(null);
			frame.setResizable(false);
			
			//Title banner/Heading 1
			textfield.setBounds(0,0,1600,100);
			textfield.setBackground(new Color(25,25,25));
			textfield.setForeground(new Color(37,49,220));
			textfield.setFont(new Font("Ink Free", Font.PLAIN,30));
			textfield.setBorder(BorderFactory.createBevelBorder(1));
			textfield.setHorizontalAlignment(JTextField.CENTER);
			textfield.setEditable(false);
			
			
			//Question banner/Heading 2
			textarea.setBounds(0,100,1600,100);
			textarea.setLineWrap(true);
			textarea.setWrapStyleWord(true);
			textarea.setBackground(new Color(25,25,25));
			textarea.setForeground(new Color(37,49,220));
			textarea.setFont(new Font("MV Boli",Font.PLAIN,25));
			textarea.setBorder(BorderFactory.createBevelBorder(1));
			textarea.setEditable(false);
			
			
			//Button A
			buttonA.setBounds(0,270,100,100); //Size and location
			buttonA.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and text size
			buttonA.setText("A"); //Text
			
			//Button B
			buttonB.setBounds(0,400,100,100);//Size and location
			buttonB.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and text size
			buttonB.setText("B"); //Text
			
			//Button C
			buttonC.setBounds(0,530,100,100); //Size and location
			buttonC.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and size
			buttonC.setText("C");//Text
			
			//Button D
			buttonD.setBounds(0,660,100,100); //Size and location
			buttonD.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and text size
			buttonD.setText("D"); //Text

			//Answer label A
			answer_labelA.setBounds(125, 270, 1600, 100); //Size and location
			answer_labelA.setBackground(new Color(50,50,50)); //Background colour
			//answer_labelA.setForeground(new Color(25,255,0)); //Foreground colour
			answer_labelA.setFont(new Font("Times New Roman",Font.PLAIN,35)); //Font and text size
			
			//Answer label B
			answer_labelB.setBounds(125, 400, 1600, 100); //Size and location
			answer_labelB.setBackground(new Color(50,50,50)); //Background colour
			//answer_labelB.setForeground(new Color(25,255,0)); //Background colour
			answer_labelB.setFont(new Font("Times New Roman",Font.PLAIN,35)); //Font and text size
			
			//Answer label C
			answer_labelC.setBounds(125, 530, 1600, 100); //Size and location
			answer_labelC.setBackground(new Color(50,50,50)); //Background colour
			//answer_labelC.setForeground(new Color(25,255,0)); //Foreground colour
			answer_labelC.setFont(new Font("Times New Roman",Font.PLAIN,35)); //Font and text size
			
			//Answer label D
			answer_labelD.setBounds(125, 660, 1600, 100); //Size and location
			answer_labelD.setBackground(new Color(50,50,50)); //Background colour
			//answer_labelD.setForeground(new Color(25,255,0)); //Foreground colour
			answer_labelD.setFont(new Font("Times New Roman",Font.PLAIN,35)); //Font and text size
			
			
			//End of quiz results
			//Score


		
			
			//Buttons
			//Button 1/Easy
			button1.setBounds(625,210,100,100); //Location and size
			button1.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and text size
			button1.setText("1"); //Text
	
				
			
			//Button 2/Medium
			button2.setBounds(625,330,100,100); //Location and size
			button2.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and text size
			button2.setText("2"); //Text
		
			//Button 3/Hard
			button3.setBounds(625,450,100,100); //Location and size
			button3.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and text size
			button3.setText("3"); //Text
			
			//Button 4/Random  
			button4.setBounds(625,570,100,100); //Location and size
			button4.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and text size
			button4.setText("4"); //Text
		

			//Button 5/Increasing Difficulty  !This method continues later in the code!
			button5.setBounds(625,690,100,100); //Location and size
			button5.setFont(new Font("MV Boli",Font.BOLD,35)); //Font and text size
			button5.setText("5"); //Text
		
			
			
			
			
		
			
			//Answer Labels for difficulty modes
			//Label 1
			answer_label1.setBounds(750, 210, 500, 100); //Location and size
			answer_label1.setBackground(new Color(50,50,50)); //Background colour
			answer_label1.setForeground(new Color(25,255,0)); //Foreground colour
			answer_label1.setFont(new Font("Papyrus",Font.PLAIN,35)); //Font and text size
			
			//Label 2
			answer_label2.setBounds(750, 330, 500, 100); //Location and size
			answer_label2.setBackground(new Color(50,50,50)); //Background colour
			answer_label2.setForeground(new Color(255,240,20)); //Foreground colour
			answer_label2.setFont(new Font("Papyrus",Font.PLAIN,35)); //Font and text size
			
			//Label 3
			answer_label3.setBounds(750, 450, 500, 100); //Location and size 
			answer_label3.setBackground(new Color(50,50,50)); //Background colour
			answer_label3.setForeground(new Color(255,44,20)); //Foreground colour
			answer_label3.setFont(new Font("Papyrus",Font.PLAIN,35)); //Font and text size
			
			//Label 4
			answer_label4.setBounds(750, 570, 500, 100); //Location and size
			answer_label4.setBackground(new Color(50,50,50)); //Background colour
			answer_label4.setForeground(new Color(20,255,240)); //Foreground colour
			answer_label4.setFont(new Font("Papyrus",Font.PLAIN,35)); //Font and text size
			
			//Label 5
			answer_label5.setBounds(750, 690, 500, 100); //Location and size
			answer_label5.setBackground(new Color(50,50,50)); //Background colour
			answer_label5.setForeground(new Color(255,169,20)); //Foreground colour
			answer_label5.setFont(new Font("Papyrus",Font.PLAIN,35)); //Font and text size
			
			//Score
			Color paleGreen = new Color(194,215,211);
			Color darkBlue = new Color(37,49,220);
			Font statsFont = new Font("Garamond",Font.BOLD,25);






///xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			// Author Victor - Stats/Leaderboards GUI/////////////////////////////////////////////////////////////////////////

			leaderBoardSign = buildStatField(225);
			leaderBoardSign.setBackground(paleGreen);
			leaderBoardSign.setText("Leaderboard");
			for (int j=0; j<4; j++) { //////////////////////******************************************************************************************
				leaderBoardFields[j] = buildStatField(100 * (j + 3) + 25);
			}

			leaderBoardFields[0].setForeground(new Color(212,175,55));
			leaderBoardFields[1].setForeground(new Color(192, 192, 192));
			leaderBoardFields[2].setForeground(new Color(169, 113, 66));



			//average = buildStatField(800, 750, 650, 100, paleGreen, darkBlue, statsFont);
			//standardDeviation = buildStatField(800, 850, 650, 100, paleGreen, darkBlue, statsFont);

			number_right.setBounds(150,750,650,100); //Location and size
			number_right.setBackground(new Color(194,215,211)); //Background colour
			number_right.setForeground(new Color(37,49,220)); //Foreground colour
			number_right.setFont(statsFont); //Font and text size
			number_right.setBorder(BorderFactory.createBevelBorder(1)); //Border
			number_right.setHorizontalAlignment(JTextField.CENTER); //Centre of box
			number_right.setEditable(false); //Not editable


			//Percentage
			percentage.setBounds(150, 850,650,100); //Location and size
			percentage.setBackground(paleGreen); //Background colour
			percentage.setForeground(darkBlue); //Foreground colour
			percentage.setFont(statsFont); //Font and text size
			percentage.setBorder(BorderFactory.createBevelBorder(1)); //Border
			percentage.setHorizontalAlignment(JTextField.CENTER); //Centre of box
			percentage.setEditable(false); //Not editable


			/////////////////////////////////////////////xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
			
			//Everything is added to the frame 
			//Headings
			frame.add(textarea);
			frame.add(textfield); 
			
			
			//Buttons for modes
			frame.add(button1); 
			frame.add(button2);
			frame.add(button3);
			frame.add(button4);
			frame.add(button5);
			
			//Labels for modes 
			frame.add(answer_label1);
			frame.add(answer_label2);
			frame.add(answer_label3);
			frame.add(answer_label4);
			frame.add(answer_label5);

			
			//Labels for questions
			frame.add(answer_labelA);
			frame.add(answer_labelB);
			frame.add(answer_labelC);
			frame.add(answer_labelD);
			
			//Buttons for questions
			frame.add(buttonA);
			frame.add(buttonB);
			frame.add(buttonC);
			frame.add(buttonD);
			
			//Visibility enabled
			frame.setVisible(true);
			
			//Buttons and labels for questions are disabled/hidden
			setOptionButtonVisibility(false);
		
			
			//Text
			textfield.setText("Welcome to ISE Quiz :)"); //Heading 1
			textarea.setText("Select difficulty"); //Heading 2
			answer_label1.setText("Novice"); //Easy mode label
			answer_label2.setText("Intermediate"); //Medium mode label
			answer_label3.setText("Expert"); //Hard mode label
			answer_label4.setText("Random"); //Random mode label
			answer_label5.setText("Increasing Difficulty"); //Increasing difficulty mode label
			
}
	
		public void setDifficultyButtonVisibility(boolean vis) {
			//Buttons and labels for modes are hidden
			button1.setVisible(vis);
			button2.setVisible(vis);
			button3.setVisible(vis);
			button4.setVisible(vis);
			button5.setVisible(vis);
			answer_label1.setVisible(vis);
			answer_label2.setVisible(vis);
			answer_label3.setVisible(vis);
			answer_label4.setVisible(vis);
			answer_label5.setVisible(vis);
		
		}
		public void setOptionButtonVisibility(boolean vis) {
			buttonA.setVisible(vis);
			buttonB.setVisible(vis);
			buttonC.setVisible(vis);
			buttonD.setVisible(vis);
			answer_labelA.setVisible(vis);
			answer_labelB.setVisible(vis);
			answer_labelC.setVisible(vis);
			answer_labelD.setVisible(vis);
		}
		public void setLabelColour(int a, int b, int c) {
			answer_labelA.setForeground(new Color(a,b,c)); //Foreground colour
			answer_labelB.setForeground(new Color(a,b,c));
			answer_labelC.setForeground(new Color(a,b,c));
			answer_labelD.setForeground(new Color(a,b,c));
		}
		
		public void hideDisableAll() {
			//Buttons are disabled
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			//Buttons are hidden
			buttonA.setVisible(false);
			buttonB.setVisible(false);
			buttonC.setVisible(false);
			buttonD.setVisible(false);
			
			//Answer labels are hidden
			answer_labelA.setVisible(false);;
			answer_labelB.setVisible(false);
			answer_labelC.setVisible(false);;
			answer_labelD.setVisible(false);
		}


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
		frame.add(txtfield);
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
		frame.add(txtfield);
		return txtfield;
	}


	}

