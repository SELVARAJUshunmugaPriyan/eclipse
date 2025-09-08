package conditions;

public class ConditionsWeekdays {

	public static void main(String[] args) {
		
		String weekday = "Wednesday";
		
		switch (weekday) {
		case "Monday":
			System.out.println("First day of week");
			break;
		case "Tuesday":
			System.out.println("Second day of week");
			break;
		case "Wednesday":
			System.out.println("Third day of week");
			break;
		case "Thursday":
			System.out.println("Fourth day of week");
			break;
		case "Friday":
			System.out.println("Fifth day of week");
			break;
		case "Saturday":
			System.out.println("Sixth day of week");
			break;
		case "Sunday":
			System.out.println("Seventh day of week");
			break;
		default:
			System.out.println("Invalid");
			break;
		}
	}

}
