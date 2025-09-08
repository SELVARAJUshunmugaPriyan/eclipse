package conditions;

public class ConditionsArithematicOperations {

	public static void main(String[] args) {
		
		float i = 10, j = 20;
		String operation = "Division";
		
		switch (operation) {
		case "Addition" :
			System.out.println("Addition of " + i + " and " + j + " is " + (i + j));
			break;
		case "Subtraction" :
			System.out.println("Subtraction of " + i + " and " + j + " is " + (i - j));
			break;
		case "Multiplication" :
			System.out.println("Multiplication of " + i + " and " + j + " is " + (i * j));
			break;
		case "Division" :
			System.out.println("Division of " + i + " and " + j + " is " + (i / j));
			break;
		case "Modulo" :
			System.out.println("Modulo of " + i + " and " + j + " is " + (i % j));
			break;
		default :
			System.out.println("Invalid operation");
			break;
		}
	}

}
