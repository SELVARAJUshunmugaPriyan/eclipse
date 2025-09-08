package functions;

class FunctionsTwo {
	public int maximum(int[] A) {
		int max = A[0];
		for(int i : A)
			if(i > max)
				max = i;
		return max;
	}
	
	public void vowels(String s) {
		String vow = "aeiou";
		for(char c : s.toLowerCase().toCharArray())
			if(vow.indexOf(c) > -1)
				System.out.print(c + " ");
		System.out.println();
		return;
	}
	
	public void evenNumber(int a, int b, int c) {
		if(a % 2 == 0)
			System.out.println(a + " is even");
		if(b % 2 == 0)
			System.out.println(b + " is even");
		if(c % 2 == 0)
			System.out.println(c + " is even");
		return;
	}
	
	public String palindrome(String s) {
		String rev = "";
		for(char c : s.toCharArray())
			rev = c + rev;
		if(s.equals(rev))
			return "palindrome";
		else
			return "Not a palindrome";
	}
	
	public int[] primeNumbers() {
		int n = 50, I[] = new int[50], k = 0;
		for(int i = 2; i < n; i++) {
			boolean isPrime = true;
			for(int j = 2; j < i; j++)
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			if(isPrime)
				I[k++] = i;
		}
		int J[] = new int[k];
		System.arraycopy(I, 0, J, 0, k);
		return J;
	}
	
	public int total(int[] A) {
		int sum = 0;
		for(int i : A)
			sum += i;
		return sum;
	}
	
	public String maxString(String[] S) {
		String max = "";
		for(String s : S)
			if(s.length() > max.length())
				max = s;
		return max;
	}
	
	public int[] seriesAdd(int[] A) {
		int B[] = new int[A.length], k = 0;
		for(int i : A) {
			int sum = 0;
			for(int j = 1; j <= i; j++)
				sum += j;
			B[k++] = sum;
		}
		return B;
	}
	
	public void evenNumbers(int[] A) {
		for(int i = 0; i < A.length; i++)
			if(A[i] % 2 == 0)
				System.out.print(A[i] + " ");
		return;
	}
}

public class UseFunctionsTwo {

	public static void main(String[] args) {
		
		FunctionsTwo f = new FunctionsTwo();
		int[] I = {1, 2, -3};
//		System.out.println(f.maximum(I));
//		f.vowels("priyan");
//		f.evenNumber(48, 55, 31);
//		System.out.println(f.palindrome("appa"));
		I = f.primeNumbers();
//		for(int i : I)
//			System.out.print(i + " ");
		System.out.println(f.total(I));
		I = f.seriesAdd(I);
		for(int i : I)
			System.out.print(i + " ");
		String S[] = {"abc", "abcde", "a"};
		System.out.println("\n" + f.maxString(S));
		f.evenNumbers(I);
	}

}
