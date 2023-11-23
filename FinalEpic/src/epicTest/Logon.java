// Author: Victor Pottier
// Login interface and accounts management 


package epicTest;

import java.io.File;
import java.util.ArrayList;

/**
 * Logon class to create simple log in interfaces.
 */
public class Logon {
	
	private Account[] allAccounts;
	private String accountsPath;
	private Account loggedAccount;
	
	private static String CHOOSE_LOGIN_REGEX = Utilities.generateSimpleRegex("123");

	
	/**
	 * Initialises login by reading the account files at the specified path.<br>
	 * By default path is ./data/accounts.
	 * @param accountsPath i.e. the path of the directory where the account files are located
	 */
	public Logon() {
		// TODO Auto-generated constructor stub
		this.accountsPath = Utilities.ACCOUNTS_PATH;
		OutputManager.welcomeMessage();
		this.readAccounts();
		
	}
	
	public double[] getSortedHighScores() { //goes through accounts to find the highest existing scores
		this.readAccounts();
		double[] highestScores = new double[this.allAccounts.length];
		
		for (int i=0; i < this.allAccounts.length; i++)
			highestScores[i] = this.allAccounts[i].getHighestScore();
		
		Utilities.selectionSort(highestScores);
		return highestScores;
	}
	
	
	/**
	 * Finds and returns the 3 accounts with the highest scores among all users
	 * @return An array containing the 3 accounts with the highest scores
	 */
	public Account[] getPodium() {
		Account[] podium = new Account[3];
		double[] highScores = this.getSortedHighScores();
		
		for (int i = highScores.length - 1; i > highScores.length - 4; i--) {
			for (Account acc:  this.allAccounts) {
				if ( acc.getHighestScore() == highScores[i] ) {
					podium[highScores.length - 1 - i] = acc;
				}
			}
		}
		return podium;
	}
	
	
	/**
	 * Finds and returnes the rank of the account in the leaderboards (comparing its highest score to the other users')
	 * @param account i.e. the account that should be ranked
	 * @return The rank of the account according to the highest scores obtained by the users.
	 */
	public int getRank(Account account) {
		double[] highScores = this.getSortedHighScores();
		for (int i = 0; i < highScores.length; i++) {
			if (account.getHighestScore() == highScores[i]) {
				return highScores.length - i;
			}
		}
		return -1;
	}
	
	/**
	 * <p>Main logon menu</p>
	 * Asks the user if they want to log into their account, sign up, or sign in as guest.
	 */
	public void chooseLoginMethod() {
		OutputManager.loginInstructions();
		String chosenOption = InputManager.readFilteredString(CHOOSE_LOGIN_REGEX);
		switch (chosenOption) {
		case "1":
			this.askLogin();
			break;
		case "2":
			this.signUp();
			break;
		default:
			this.guestSignIn();
		}
	}
	
	/**
	 * Generates all existing accounts from the directory containing account files
	 */
	public void readAccounts() {
		File[] dataFiles = FileManager.lsDirectory(this.accountsPath);
		ArrayList<File> accountFiles = new ArrayList<File>();
		for (File fi: dataFiles) {
			if (fi.getName().endsWith(".acc")) {
				accountFiles.add(fi);
			}
		}
		
		this.allAccounts = new Account[accountFiles.size()];
		
		for (int i = 0; i < accountFiles.size(); i++) {
			allAccounts[i] = Account.fromFile(accountFiles.get(i));
		}
		
	}
	
	/**
	 * Creates a new account and its corresponding account file.<br>
	 * Then, updates the account directory with the newly created account file.
	 * @param username i.e. the new account's username
	 * @param password i.e. the new account's password
	 * @return The newly created account object
	 */
	public Account createAccount(String username, String password) {
		String filePath = this.accountsPath + username + ".acc"; 
		FileManager.createFile(filePath);
		String fileContent = password + "\n0";
		FileManager.writeFile(filePath, fileContent);
		ArrayList<Double> initialScoreData = new ArrayList<Double>();
		initialScoreData.add(0.0);
		return new Account(username, password, initialScoreData);
	}
	
	/**
	 * <p>Sign in menu</p>
	 * 
	 * Ask the user to enter their username and password and checks if those login details are correct.<br>
	 * If so, the user successfully signs in the corresponding account.<br>
	 * Otherwise, user is brought back to the main menu. 
	 */
	public void askLogin() {
		OutputManager.authentificationInstructions();
		String username = InputManager.readString();
		OutputManager.enterPassword();
		String password = InputManager.readString();
		OutputManager.jumpLine();
		Account foundAccount = this.authenticate(username, password);
		if (foundAccount == null) {
			this.chooseLoginMethod();
		}
		else {
			this.signIn(foundAccount);
		}
	}
	
	/**
	 * Log into the specified account
	 * @param account i.e. the account to log into
	 */
	public void signIn(Account account) {
		this.loggedAccount = account;
		OutputManager.succesfulSignIn(account.getUsername());
	}
	
	/**
	 * Log into the guest account
	 */
	public void guestSignIn() {
		OutputManager.jumpLine();
		Account guest = Account.guest();
		Account[] tmp = new Account[this.allAccounts.length + 1];
		
		for (int i=0; i < this.allAccounts.length; i++) {
			tmp[i] = this.allAccounts[i];
		}
		tmp[this.allAccounts.length] = guest;
		
		this.signIn(guest);
	}
	
	/**
	 * <p>Sign up menu.</p>
	 * 
	 * <p>Guides the user on how to create their account. Asks for a username and password.<br>
	 * If the username isn't already used by another account and the password is strong<br>
	 * enough, creates a new account with the entered information and sign in this new account</p>
	 */
	public void signUp() {
		OutputManager.signUpInstructions();
		
		OutputManager.enterUsername();
		String username = InputManager.readString();
		
		if (this.findAccount(username) != null) {
			OutputManager.accountAlreadyExistsWarning();
			this.chooseLoginMethod();
		}
		
		else {
		
			OutputManager.enterPassword();
			String password = InputManager.readString();
			
			if (Utilities.securePasswordCheck(password)) {
				
				OutputManager.confirmPassword();
				String passwordConfirm = InputManager.readString();
				
				if (passwordConfirm.equals(password)) {
					Account newAccount = this.createAccount(username, password);
					OutputManager.successfulSignUp(username);
					this.signIn(newAccount);
				}
				else {
					OutputManager.confirmPasswordWarning();
					this.chooseLoginMethod();
				}
			}
			else {
				OutputManager.invalidPasswordFormatWarning();
				this.chooseLoginMethod();
			}
		}
	}
	
	/**
	 * 
	 * @return The account the user is currently logged into
	 */
	public Account getLoggedAccount() {
		return this.loggedAccount;
	}
	
	/**
	 * Checks if authentication details are correct by searching for an account file that matches with the log in details passed in parameter.
	 * @param username i.e. the username to be checked
	 * @param password i.e. the password to be checked
	 * @return The account that matches with the authentification details if it is found. Or null otherwise.
	 */
	public Account authenticate(String username, String password) {
		Account foundAccount = this.findAccount(username);
		if (foundAccount == null || !password.equals( foundAccount.getPassword() )) {
			OutputManager.wrongLoginWarning();
			return null;
		}
		return foundAccount;
	}
	/**
	 * Finds the account associated to the specified username and returns it.
	 * @param username i.e. the username of the account to be searched for
	 * @return The account associated to the specified username if it is found. Null otherwise.
	 */
	public Account findAccount(String username) {
		for  (Account account: this.allAccounts) {
			if (username.equals( account.getUsername() ))
				return account;
		}
		return null;
	}

}