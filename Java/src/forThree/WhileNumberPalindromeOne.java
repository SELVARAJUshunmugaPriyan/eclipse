package forThree;

public class WhileNumberPalindromeOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 1234, i = 0, temp = N;
		int[] I = new int[(int) Math.log10(N) + 1];
		boolean isPalindrome = true;
		
		while(N > 0) {
			I[i++] = N % 10;
			N /= 10;
		}
		
		i = 0;
		while(i < I.length)
			if(I[i] != I[I.length - 1 - i++])
				isPalindrome = false;
		
		if(isPalindrome)
			System.out.print(temp + " is palindrome");
		else
			System.out.print(temp + " is not palindrome");
	}

}
