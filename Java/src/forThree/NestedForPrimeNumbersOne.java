package forThree;

public class NestedForPrimeNumbersOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
//		int N = Integer.MAX_VALUE;
		
		for(int i = 2; i <= N; i++) {
			boolean isPrime = true;
			for(int j = 2; j < i; j++)
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			if(isPrime)
				System.out.println(i);
		}
		
	}

}
