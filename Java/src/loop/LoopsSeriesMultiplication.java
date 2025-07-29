package loop;

public class LoopsSeriesMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0, grandTotal = 1;
		
		for (int i = 1; i <= 5; i++) {
			total = 0;
			for (int j = 1; j <= i; j++)
				total += j;
			grandTotal *= total;
		}
		
		System.out.println(grandTotal);
	}

}
