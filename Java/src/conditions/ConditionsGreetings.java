package conditions;

public class ConditionsGreetings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time = 6;
		
		if ((time >= 1) && (time <= 4)) {
			System.out.print("Good morning");
		} else if ((time > 4) && (time <= 6)) {
			System.out.print("Good noon");
		} else if ((time > 6) && (time <= 9)) {
			System.out.print("Good afternoon");
		} else if ((time > 9) && (time <= 12)) {
			System.out.print("Good night");
		}
	}

}
