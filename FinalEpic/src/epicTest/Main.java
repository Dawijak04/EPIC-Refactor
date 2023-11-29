// Main Code

package epicTest;



public class Main {

	public static void main(String[] args) {

		Logon login = new Logon();
		login.chooseLoginMethod(); //login method is chosen

		Logon userAccount = login;
		Logon.setUser(userAccount);

		Quiz quiz = new Quiz();
		quiz.run(login); //quiz is ran
		
		InputManager.end(); //scanner is closed

	}

}