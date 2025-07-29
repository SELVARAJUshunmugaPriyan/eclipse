package conditions;

public class ConditionsMaxOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 12, j = 16, k = 9;
		
		if ((i > j) && (i > k)) {
			System.out.println(i + " is greater");
		} else if ((j > i) && (j > k)) {
			System.out.println(j + " is greater");
		} else if ((k > i) && (k > j)) {
			System.out.println(k + " is greater");
		} 
	}

}
