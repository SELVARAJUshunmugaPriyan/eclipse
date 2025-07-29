package conditions;

public class ConditionsDivisibleByTwoAndThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 9;
		
		if (((i % 2) == 0) && ((i % 3) == 0)) {
			System.out.println("Divisble by both 2 and 3");
		} else {
			System.out.println("Not divisble by both 2 and 3");
		}
	}

}
