package conditions;

public class ConditionsMaxOfFour {

	public static void main(String[] args) {
		
		int i = 24, j = 76, k = 13, l = 23;
		
		if ((i > j) && (i > k) && (i > l)) {
			System.out.println(i + " is greatest");
		} else if ((j > i) && (j > k) && (j > l)) {
			System.out.println(j + " is greatest");
		} else if ((k > i) && (k > j) && (k > l)) {
			System.out.println(k + " is greatest");
		} else if ((l > i) && (l > j) && (l > k)) {
			System.out.println(l + " is greatest");
		}
		
	}

}
