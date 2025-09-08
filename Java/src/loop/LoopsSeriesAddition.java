package loop;

public class LoopsSeriesAddition {

	public static void main(String[] args) {
		
		int total = 0, grandTotal = 0;
		
		for (int i = 1; i <= 5; i++) {
//			total = 0;
//			for (int j = 1; j <= i; j++)
//				total += j;
			System.out.print(i + " ");
			System.out.print(total + " ");
			total += i;
			System.out.print(total + " ");
			System.out.print(grandTotal + " ");
			grandTotal += total;
			System.out.print(grandTotal + " ");
			System.out.println();
		}
		
//		System.out.println(total);
	}

}
