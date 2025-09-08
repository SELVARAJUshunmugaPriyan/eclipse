package conditions;

public class ConditionsVowelString {

	public static void main(String[] args) {
		
		String s= "swyggy";
		
		if (s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
			System.out.println("Vowel string");
		} else {
			System.out.println("Not a vowel string");
		}
		
	}

}
