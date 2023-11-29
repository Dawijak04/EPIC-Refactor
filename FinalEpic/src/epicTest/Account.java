
package epicTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class that represents user accounts. Accounts group 3 main kinds of data :
 * 
 * <ul>
 * <li>An username</li>
 * <li>A password</li>
 * <li>All previous scores the user has achieved</li>
 * </ul>
 * 
 * An account object can easily be generated from a properly formatted file<br>
 * containing the account information thanks to the <i>fromFile</i> static method.
 */
public class Account {
	
	private String username;
	private String password;
	private ArrayList<Double> allScoresAchieved;


	//Constructor for account object
	public Account(String username, String password, ArrayList<Double> scoreData) {
		this.username = username;
		this.password = password;
		this.allScoresAchieved = scoreData;
		this.allScoresAchieved.remove(0);
	}
	
	/**
	 * 
	 * @return The guest account i.e. the default account. For the guest account, the score data is never saved.
	 */
	public static Account guest() {
		ArrayList<Double> defaultScores = new ArrayList<Double>();
		defaultScores.add(0.0);
		return new Account("guest", "", defaultScores);
	}
	
	/**
	 * <p>Reads a properly formatted file containing an account's information to generate the corresponding account.</p>
	 * 
	 * <p>The formatting rules for the account files are :</p>
	 * 
	 * <ul>
	 * <li>The filename should be &ltusername&gt.txt where &ltusername&gt corresponds to the account's username</li>
	 * <li>First line of the file should be the account's password</li>
	 * <li>Second line of the file should be the score data, where each score entries are separated with a semi-colon (";")</li>
	 * </ul>
	 * @param accountFile i.e. File object built from the account file
	 * @return The Account object corresponding to the file
	 */
	public static Account fromFile(File accountFile) {
		try {
			Scanner fileReader = new Scanner(accountFile);
			String formattedUsername = FileManager.clearFileExtension(accountFile.getName(), 3);
			String readPassword = fileReader.nextLine();
			String[] readScores = fileReader.nextLine().split(";");
			fileReader.close();
			return new Account(formattedUsername, readPassword, Utilities.getConvertedArrayList(readScores));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 
	 * @return The account's username
	 */
	public String getUsername() {
		return this.username;
	}
	
	
	/**
	 * 
	 * @return The account's password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * 
	 * @return All the previously achieved scores represented as an ArrayList&ltDouble&gt object
	 */
	public ArrayList<Double> getScoreData() {
		return this.allScoresAchieved;
	}
	
	/**
	 * 
	 * @return The highest score this user has achieved so far
	 */
	public double getHighestScore() {
		return Stats.findMax(allScoresAchieved);
	}
	
	/**
	 * 
	 * @return The user's mean score
	 */
	public int getMeanScore() {
		return (int) (Math.ceil(Stats.calculateMean(allScoresAchieved))); 
	}
	
	/**
	 * 
	 * @return The user's score standard deviation
	 */
	public int getStandardDeviationScore() {
		return (int) (Math.floor(Stats.calculateStandardDeviation(allScoresAchieved)));
	}
	
	public String getAccountPath() {
		return Utilities.ACCOUNTS_PATH + this.getUsername() + ".acc";
	} //getter for account path
	
	public boolean isGuest() {
		return this.getPassword().length() == 0;
	} //checks if user has account or is logged in as guest
	
	public void updateScore(double newEntry) { //if the user is not a guest, the data from the users current quiz is stored in their account
		this.allScoresAchieved.add(newEntry);
		if (!this.isGuest())
			FileManager.writeFile(this.getAccountPath(), String.format(";%s", newEntry), true);
	}

}