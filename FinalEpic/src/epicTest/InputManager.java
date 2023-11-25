// Managing user input
// Author: Victor Pottier

package epicTest;

import java.util.Scanner;

/**
 * Manages user inputs using a Scanner object//scanner
 */
public class InputManager {
	
	private static Scanner inputReader = new Scanner(System.in); //creates new scanner
	
	/**
	 * 
	 * @return The string entered by the user
	 */
	public static String readString() {
		return inputReader.next();
	} //scans strings
	
	/**
	 *	Closes the opened scanner. It's a good practice.
	 */
	public static void end() {
		inputReader.close();
	} //closes scanner
	
	
	/**
	 * Asks user to enter a string while this string does not match with the simple regex pattern passed in parameter.
	 * 
	 * <p>A simple regex is a regex in the form <i>^[&ltcharSequence&gt]$</i> used for 1 character long strings.<br> 
	 * Practical to test whether the string is equal to one of the characters included in <i>&ltcharSequence&gt.</i></p>
	 * 
	 * @param simpleRegex i.e. the simple regex that the string format must comply to.
	 * @return The first string entered by the user that matches with regex pattern.
	 */
	public static String readFilteredString(String simpleRegex) {//verifies user input/applies filter. Used when user creates a new account
		String userInput = readString();
		
		while(!Utilities.containsRegexPattern(userInput, simpleRegex)) {
			OutputManager.invalidInputWarning(userInput, Utilities.readSimpleRegex(simpleRegex));
			OutputManager.loginInstructions();
			userInput = readString();
		}
		return userInput;
	}
	
}