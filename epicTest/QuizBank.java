package epicTest;

public class QuizBank {
	String[] totalQuestions = {
			//Easy
			"What does BNF stand for?",
			"What's the name of the no.1 supercomputer in the world?",
			"Combining two or more propositions using logical expressions is a:",
			"What is a BDD?",
			"Which of those is NOT a subset of {x ∈ N|√x ∉ N}?",
			"What is the equivalent of the decimal number 357 in base 2?",
			
			//Medium
			"What does it mean if two algorithms are semantically the same?",
			"What is the Von Neuman Bottleneck",
			"What is tautology?",
			"What is the formal definition of a symmetric relation R ⊆ S x S?", 
			"What is the formal definition of an injective function",
			"What is the result of the binary subtraction 11001011011 - 101111101 in hexadecimal format?",
			
			//Hard
			"What equivalence relation is this? (x,y) and (y,z) imply (x,z)",
			"Which generation of computers were computers based on intergrated circuits?",
			"When is a matrix invertible?",
			"Which of these is a partial order relation?", 
			"On an island where knights always tell the truth and knaves always lie, an inhabitant declares: 'If I am lying, then I am a knight'. Is that inhabitant a knight or knave?",
			"What are the 9 first bits (i.e. sign and exponent) of decimal number -1212.573 written in IEEE 754 single precision format?"
			};
	
	//Potential Answers
		String[][] totalPotAnswers = {
				//Easy
				{"(A) Brand New Function" , "(B) Brendan Nor Form",  "(C) Backus Naur Format" , "(D) Bring Nine Forward"}, //(C)
				{"(A) Cray",  "(B) Frontier", "(C) Kay",  "(D) Summit"}, //(B)
				{"(A) Compound proposition",  "(B) Propositional variable",  "(C) Conjunction Variable",  "(D) Propositional Quantifier"}, //(A)
				{"(A) A specific part of an algorithm that allows us to prove its correctness",  "(B) A language used to define grammar rules",  "(C) An endless recursion problem inside the definition of a syntax",  "(D) A data structure that represents a boolean function "}, //(D)
				{"(A) S = {3,2,8}",  "(B) S = {32, 128}",  "(C) S = {4, 8, 64}",  "(D) S = {Ø}"}, //(C)
				{"(A) 110001011",  "(B) 101100101",  "(C) 110101111",  "(D) 101101011"}, //(B)
				
				//Medium
				{"(A) Code is identical",  "(B) Code is similar",  "(C) Stored in same location",  "(D) Output is the same"}, //(D)
				{"(A) CPU is idle",  "(B) CPU overheats",  "(C) Insufficient storage",  "(D) ALU doesn't cooperate with CU"}, //(A)
				{"(A) Compoud proposition that is always false",  "(B) Compoud propositon that is always true",  "(C) Undefined variable",  "(D) Error in a truth table"}, //(B)
				{"(A) ∀ a,b ∈ S aRb => bRa",  "(B) ∀ a,b ∈ S aRb ^a ≠ b => bRa" , "(C) ∀ a,b ∈ S aRb ^ bRa => a =b",  "(D) ∀ a,b ∈ S aRb ^bRa => a≠b"}, //(A)
				{"(A) ∀ b ∈ B ∃ a ∈ A.f(a) = b",  "(B) ∃ b ∈ B ∀ a ∈ A.f(a) ≤ b",  "(C) ∃ b ∈ B ∀ a ∈ A.f(a) ≥ b",  "(D) ∀ a, b ∈ A.f(a) = f(b) => a = b "},//(D)
				{"(A) 4DE",  "(B) 2AF",  "(C) 3CO",  "(D) 2B9"}, //(A)
				
				//Hard
				{"(A) Symmetry",  "(B) Transitivity",  "(C) Reflexivity",  "(D) Asymmetry"}, //(B)
				{"(A) 1",  "(B) 2",  "(C) 3",  "(D) 4"}, //(C)
				{"(A) When all the values are the same",  "(B) When the sum of the values is an even number",  "(C) When the sum of values is an odd number" , "(D) When the determinant is not 0"},//(D)
				{"(A) R = {(a,b),(b,b),(a,c),(b,c)}",  "(B) R = {(b,a),(a,c),(a,a),(b,c),(b,b),(c,c)}",  "(C) R = {(a,b),(a,a),(a,c),(b,c),(b,b),(c,c)",  "(D) R = {(a,a),(b,b),(c,c),(a,c),(c,b),(b,a)"}, //(C)
				{"(A) A knight",  "(B) A knave",  "(C) Could be both",  "(D) None of them"}, //(A)
				{"(A) 110001001",  "(B) 011000101",  "(C) 111011001",  "(D) 111001101"} //(A)
		};
		
		//Correct Answers
		int[] totalAnswers = {
				//Easy
				3, 2, 1, 4, 3, 2,
				
				//Medium
				4, 1, 2, 1, 4, 1,
				
				//Hard
				2, 3, 4, 3, 1, 1
				};
		
	public String[] getQuestions(int diff) {
		QuestionSorting allQuestions = new QuestionSorting(totalQuestions);
		return allQuestions.getQuestions(diff);
	}
	
	public String[][] getPotAnswers(int diff) {
		potAnswerSorting allPotAnswers = new potAnswerSorting(totalPotAnswers);
		return allPotAnswers.getPotAnswers(diff);
	}
	public int[] getAnswers(int diff) {
		answerSorting allCorAnswers = new answerSorting(totalAnswers);
		return allCorAnswers.getAnswers(diff);
	}
	
	
}