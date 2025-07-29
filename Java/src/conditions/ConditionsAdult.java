package conditions;

public class ConditionsAdult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 35;
		
		if (age >= 0 && age < 12) {
			System.out.println("kid");
		} else if (age >= 12 && age < 18) {
			System.out.println("adult");
		} else if (age >= 18 && age < 28) {
			System.out.println("men");
		} else {
			System.out.println("grown-up");
		}
	}

}
