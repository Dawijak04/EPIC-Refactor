package epicTest;

public class Question {
	//attributes
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private int correctAnswer;
	private Difficulty difficulty;
	private QuestionType type;


	//question constructor for multiple choice questions
	public Question(String question, String answer1, String answer2, String answer3, String answer4, int correctAnswer, Difficulty difficulty) {
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.correctAnswer = correctAnswer;
		this.difficulty = difficulty;
		type = QuestionType.MultipleChoice;
	}

	//question constructor for true/false questions
	public Question(String question, int correctAnswer, Difficulty difficulty) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.answer1 = "True";
		this.answer2 = "False";
		this.difficulty = difficulty;
		type = QuestionType.TrueOrFalse;
	}

	//getters
	public String getQuestion() {
		return question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public QuestionType getType() {
		return type;
	}
}
