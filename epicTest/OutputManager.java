// Author: Victor Pottier
// CLI Interface for the logon

package epicTest;

/**
 * Manages the command line UI by printing various instructions.
 */
public class OutputManager {
	
	private static final String APP_TITLE = "The EPIC Quizz";
	
	private static final String DEFAULT_SEPARATOR_CHAR = "-";
	private static final int DEFAULT_SEPARATOR_LENGTH = 150;
	
	public static void jumpLine() {
		System.out.println();
	}
	
	public static void jumpLines(int lineAmount) {
		for (int i=0; i < lineAmount; i++) {
			jumpLine();
		}
	}
	
	public static void welcomeMessage() {
		displaySeparator();
		System.out.println(String.format("Welcome to %s!", APP_TITLE));
		jumpLine();
		System.out.println("Proposed by KISS Solutions PLC.");
		displaySeparator();
		jumpLine();
	}
	
	
	public static void loginInstructions() {
		jumpLine();
		System.out.println("Enter 1 to log in to your account.");
		System.out.println("Enter 2 to sign up and create an account.");
		System.out.println("Or enter 3 to sign in as guest.");
		jumpLine();
	}
	
	public static void authentificationInstructions() {
		jumpLine();
		System.out.println("To sign in, please enter your username and password.");
		jumpLine();
		enterUsername();
	}
	
	public static void accountAlreadyExistsWarning() {
		jumpLine();
		displaySeparator();
		System.out.println("Failed to create account: an account associated to that username already exists. Please choose another username.");
		displaySeparator();
	}
	
	public static void signUpInstructions() {
		jumpLine();
		displaySeparator();
		System.out.println("To create an account, please enter an username and a password.");
		jumpLine();
		passwordInstructions();
		displaySeparator();
		jumpLine();
	}
	
	public static void passwordInstructions() {
		System.out.println("Please note that your password must:");
		System.out.println("\t- Be at least 8 characters long");
		System.out.println("\t- Contain at least one digit");
		System.out.println("\t- Contain at least one upper case letter");
		System.out.println("\t- Contain at least one lower case letter");
		System.out.println("\t- Contain at least one special character");
	}
	
	public static void invalidPasswordFormatWarning() {
		jumpLine();
		displaySeparator();
		System.out.println("Failed to create account: password is not strong enough. Please choose another password.");
		displaySeparator();
	}
	
	public static void successfulSignUp(String username) {
		jumpLine();
		System.out.println("Account creation successful!");
	}
	
	public static void wrongLoginWarning() {
		displaySeparator();
		System.out.println("Failed to log in: wrong username or password");
		displaySeparator();
	}
	
	public static void enterUsername() {
		System.out.print("Enter your username: ");
	}
	
	public static void enterPassword() {
		System.out.print("Enter your password: ");
	}
	
	public static void confirmPassword() {
		System.out.print("Confirm password: ");
	}
	
	public static void confirmPasswordWarning() {
		jumpLine();
		displaySeparator();
		System.out.println("Failed to create account: passwords do not match. Please try again.");
		displaySeparator();
	}
	
	public static void invalidInputWarning(String invalidInput, String expectedInputs) {
		jumpLine();
		displaySeparator();
		System.out.println(String.format("Refused: '%s' is an invalid input in this context.", invalidInput));
		System.out.println("Please enter a valid input among: " + expectedInputs);
		displaySeparator();
		jumpLine();
	}
	
	public static void succesfulSignIn(String username) {
		System.out.println("Successfully signed in as: " + username);
	}
	
	public static void repeatPrint(String repeatedString, int loops) {
		for (int i = 0; i < loops; i++) {
			System.out.print(repeatedString);
		}
		jumpLine();
	}
	
	/**
	 * Repeatedly prints a separator character to clearly distinguish different paragraphs
	 */
	public static void displaySeparator() {
		repeatPrint(DEFAULT_SEPARATOR_CHAR, DEFAULT_SEPARATOR_LENGTH);
	}
	
}