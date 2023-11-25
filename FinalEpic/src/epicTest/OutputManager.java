// Author: Victor Pottier
// CLI Interface for the logon

package epicTest;

/**
 * Manages the command line UI by printing various instructions.
 */
public class OutputManager { //prints statements into console
	
	private static final String APP_TITLE = "The EPIC Quizz";
	
	private static final String DEFAULT_SEPARATOR_CHAR = "-";
	private static final int DEFAULT_SEPARATOR_LENGTH = 150;
	
	public static void jumpLine() {
		System.out.println();
	}

	
	public static void welcomeMessage() { //prints welcome message
		displaySeparator();
		System.out.println(String.format("Welcome to %s!", APP_TITLE));
		jumpLine();
		System.out.println("Proposed by KISS Solutions PLC.");
		displaySeparator();
		jumpLine();
	}
	
	
	public static void loginInstructions() { //prints login options
		jumpLine();
		System.out.println("Enter 1 to log in to your account.");
		System.out.println("Enter 2 to sign up and create an account.");
		System.out.println("Or enter 3 to sign in as guest.");
		jumpLine();
	}
	
	public static void authentificationInstructions() { //prints instruction how to log in
		jumpLine();
		System.out.println("To sign in, please enter your username and password.");
		jumpLine();
		enterUsername();
	}
	
	public static void accountAlreadyExistsWarning() { //prints account already exists
		jumpLine();
		displaySeparator();
		System.out.println("Failed to create account: an account associated to that username already exists. Please choose another username.");
		displaySeparator();
	}
	
	public static void signUpInstructions() { //prints instructions on how to sign up
		jumpLine();
		displaySeparator();
		System.out.println("To create an account, please enter an username and a password.");
		jumpLine();
		passwordInstructions();
		displaySeparator();
		jumpLine();
	}
	
	public static void passwordInstructions() { //prints criteria for passowrd
		System.out.println("Please note that your password must:");
		System.out.println("\t- Be at least 8 characters long");
		System.out.println("\t- Contain at least one digit");
		System.out.println("\t- Contain at least one upper case letter");
		System.out.println("\t- Contain at least one lower case letter");
		System.out.println("\t- Contain at least one special character");
	}
	
	public static void invalidPasswordFormatWarning() { //prints invalid password warning
		jumpLine();
		displaySeparator();
		System.out.println("Failed to create account: password is not strong enough. Please choose another password.");
		displaySeparator();
	}
	
	public static void successfulSignUp(String username) { //prints account created succesfully
		jumpLine();
		System.out.println("Account creation successful!");
	}
	
	public static void wrongLoginWarning() { //incorrect details entered
		displaySeparator();
		System.out.println("Failed to log in: wrong username or password");
		displaySeparator();
	}
	
	public static void enterUsername() {
		System.out.print("Enter your username: ");
	} //enter username
	
	public static void enterPassword() {
		System.out.print("Enter your password: ");
	} //enter password
	
	public static void confirmPassword() {
		System.out.print("Confirm password: ");
	} //confirm password
	
	public static void confirmPasswordWarning() { //confirm password and initial password dont match
		jumpLine();
		displaySeparator();
		System.out.println("Failed to create account: passwords do not match. Please try again.");
		displaySeparator();
	}
	
	public static void invalidInputWarning(String invalidInput, String expectedInputs) { //invalid password entered/ doesn't match criteria
		jumpLine();
		displaySeparator();
		System.out.println(String.format("Refused: '%s' is an invalid input in this context.", invalidInput));
		System.out.println("Please enter a valid input among: " + expectedInputs);
		displaySeparator();
		jumpLine();
	}
	
	public static void succesfulSignIn(String username) {
		System.out.println("Successfully signed in as: " + username);
	} //succesful sign in
	
	public static void repeatPrint(String repeatedString, int loops) { //used in separator
		for (int i = 0; i < loops; i++) {
			System.out.print(repeatedString);
		}
		jumpLine();
	}
	
	/**
	 * Repeatedly prints a separator character to clearly distinguish different paragraphs
	 */
	public static void displaySeparator() { //used for CLI to print lines between sections
		repeatPrint(DEFAULT_SEPARATOR_CHAR, DEFAULT_SEPARATOR_LENGTH);
	}
	
}