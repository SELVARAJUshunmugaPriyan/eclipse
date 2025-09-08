package forThree;

public class WhileNumberPalindromeTwo {

	public static void main(String[] args) {
		
//		for(int i = 1; i < Short.MAX_VALUE; i++) {
			int N = 1234, rev = 0, temp = N;
			
			while(temp > 0) {
				rev = (rev * 10) + (temp % 10);
				temp /= 10;
			}
			
			if(rev == N)
				System.out.println(N + " is palindrome");
	//		else
	//			System.out.print(N + " is not palindrome");
//		}
	}

}
