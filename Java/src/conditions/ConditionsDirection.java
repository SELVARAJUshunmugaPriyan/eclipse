package conditions;

public class ConditionsDirection {

	public static void main(String[] args) {
		
		char direction = 'N';
		
		switch (direction) {
		case 'N':
			System.out.println("North");
			break;
		case 'S':
			System.out.println("South");
			break;
		case 'W':
			System.out.println("West");
			break;
		case 'E':
			System.out.println("East");
			break;
		default:
			System.out.println("Invalid");
			break;
		}
	}

}
