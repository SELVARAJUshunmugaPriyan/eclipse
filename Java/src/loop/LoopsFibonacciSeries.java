package loop;

public class LoopsFibonacciSeries {

	public static void main(String[] args) {
		
		int n1 = 0, n2 = 1/*, tot*/;
		
		for (int i = 0; i <= 5; i++) {
			int n3 = n2 + n1;
//			tot += n1;
			System.out.println(n3);
			n1 = n2;
			n2 = n3;
		}
		
//		System.out.println(tot);
	}

}
