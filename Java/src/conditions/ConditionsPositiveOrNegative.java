package conditions;

public class ConditionsPositiveOrNegative {

	public static void main(String[] args) {
		
		int i = 0;
		
		if (i > 0) {
			System.out.println("Positive");
		} else if (i < 0) {
			System.out.println("Negative");
		} else {
			System.out.println("Zero");
		}
	}

}
