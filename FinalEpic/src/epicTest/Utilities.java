package epicTest;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

/**
 * General purpose functions and constants.
 */
public class Utilities {
	
	/**
	 * Path to the folder containing the account files
	 */
	public static final String ACCOUNTS_PATH = "./data/accounts/";


	/**
	 * Finds the minimum elment, starting at the specified index and ignoring all previous elements, in an array of numbers and returns its index
	 * @param sourceArray i.e. The array of numbers from which the minimum should be searched
	 * @param startIndex i.e. The index from which the search begins, thus ignoring all previous elements.
	 * @return The index of the minimum element found.
	 */
	public static int findMinEltIndex(double[] sourceArray, int startIndex) {
		double minElement = sourceArray[startIndex];
		int minEltIndex = startIndex;
 		
		for (int i = startIndex + 1; i < sourceArray.length; i ++) {
			if (sourceArray[i] < minElement) {
				minElement = sourceArray[i];
				minEltIndex = i;
			}
		}
		return minEltIndex;
	}

	
	/**
	 * Swaps the index position of two elements inside an array
	 * @param sourceArray i.e. the targeted array
	 * @param i i.e. the index where the current sourceArray[j] should be placed
	 * @param j i.e. the index where the current sourceArray[i] should be placed
	 */
	public static void swapElements(double[] sourceArray, int i, int j) {
		double saved = sourceArray[i];
		sourceArray[i] = sourceArray[j];
		sourceArray[j] = saved;
	}
	
	
	/**
	 * Sorts an array of numbers using selection sort algorithm
	 * @param unsortedArray i.e. the array to be sorted
	 */
	public static void selectionSort(double[] unsortedArray) {
		
		for (int i=0; i < unsortedArray.length - 1; i++) {
			
			swapElements(unsortedArray, i, findMinEltIndex(unsortedArray, i));
		}
	}
	
	
	/**
	 *  Converts an array of strings String[] to an ArrayList containing doubles
	 *  
	 *  
	 *  <p>Example:</p>
	 *  	<p>String[ ]  numStringArray = {"91", "8", "234", "1982.38"};<br>
	 *  	getConvertedArrayList(numStringArray) -> ArrayList&ltDouble&gt(91.0, 8.0, 234.0, 1982.38)</p>
	 * @param initialArray i.e. the array to be converted
	 * @return The ArrayList obtained from the converted initialArray
	 */
	public static ArrayList<Double> getConvertedArrayList(String[] initialArray) {
		ArrayList<Double> convertedArray = new ArrayList<Double>();
		
		for (int index=0; index < initialArray.length; index++) {
			 convertedArray.add(Double.parseDouble(initialArray[index]));
		}
		return convertedArray;
	}
	
	
	/**
	 * <p>Reads a simple regex and formats it in a more readable format.</p>
	 * 
	 * <p>A simple regex is a regex in the form <i>^[&ltcharSequence&gt]$</i> used for 1 character long strings.<br> 
	 * Practical to test whether the string is equal to one of the characters included in <i>&ltcharSequence&gt.</i></p>
	 * 
	 * ^[abc12]$ simple regex for example can be used to test whether a string is<br>equal to a, or equal to b, or equal to c, or to 1, or to 2.
	 * 
	 * <p>Example: readSimpleRegex("^[abc12]$") -> "a, b, c, 1, or 2"</p>
	 * 	
	 * @param simpleRegex i.e. the simple regex to be formatted 
	 * @return a more readable format of the simple regex in the format "option1, option2, ..., or optionN"
	 */
	public static String readSimpleRegex(String simpleRegex) {
		// Simple regex are in the format ^[<possibleChar1><possibleChar2>....<possibleCharN>]$
		// TODO check if the simpleRegex is properly formatted with another regex
		String userFriendlyFormat = "";
		
		for (int i = 2; i < simpleRegex.length() - 3; i++) {
			userFriendlyFormat += simpleRegex.charAt(i);
			userFriendlyFormat += ", ";
		}
		userFriendlyFormat += String.format("or %s", simpleRegex.charAt(simpleRegex.length() - 3));
		return userFriendlyFormat;
	}
	
	
	/**
	 * Returns a simple regex from a string of possible characters.
	 * 
	 * <p>A simple regex is a regex in the form <i>^[&ltcharSequence&gt]$</i> used for 1 character long strings.<br> 
	 * Practical to test whether the string is equal to one of the characters included in <i>&ltcharSequence&gt.</i></p>
	 * 
	 * ^[abc12]$ simple regex for example can be used to test whether a string is<br>equal to a, or equal to b, or equal to c, or to 1, or to 2.
	 * 
	 * <p>Example: generateSimpleRegex("abc12") -> "^[abc12]$"</p>
	 * @param possibleChars i.e. the sequence of possible characters in the simple regex
	 * @return The simple regex associated to the sequence of possible characters passed in parameter.
	 */
	public static String generateSimpleRegex(String possibleChars) {
		return "^[" + possibleChars + "]$";
	}
	
	/**
	 * Checks if a string matches a regex pattern.
	 * 
	 * @param testedString i.e. the string to be tested
	 * @param regex i.e. the regex the tested string is matched to
	 * @return True if the tested string matches with the regex pattern, false otherwise
	 */
	public static boolean containsRegexPattern(String testedString, String regex) {
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(testedString).find();
	}

	
	/**
	 * Checks if a password is strong enough.
	 * 
	 *	<p>A password is strong enough only if it meets all the following conditions:</p>
	 *	<ul>
	 *		<li>It is at least 8 characters long</li>
	 *		<li>It contains at least one lower case letter</li>
	 *		<li>It contains at least one upper case letter</li>
	 *		<li>It contains at least one digit</li>
	 *		<li>It contains at least one special character (e.g. $, *, %, &, etc...)</li>
	 *	</ul>
	 * 
	 */
	public static boolean securePasswordCheck(String password) {
		String digits = "^.*[0-9]{1,}.*$";
		String upperCase = "^.*[A-Z]{1,}.*$";
		String lowerCase = "^.*[a-z]{1,}.*$";
		String specialChars = "^.*[^a-zA-Z0-9]{1,}.*$";
		
		if (password.length() < 8) {
			return false;
		}
		if (!containsRegexPattern(password, digits)) {
			System.out.println("no digits found");
			return false;
		}
		
		if (!containsRegexPattern(password, upperCase)) {
			System.out.println("no upper case found");
			return false;
		}
		
		if (!containsRegexPattern(password, lowerCase)) {
			System.out.println("no lower case found");
			return false;
		}
		
		if (!containsRegexPattern(password, specialChars)) {
			System.out.println("no special char found");
			return false;
		}
		return true;
	}
	
}