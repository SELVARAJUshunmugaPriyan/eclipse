package javaPracticePrograms;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SumOfFibonacciEvenIndicesThree {
	
	static int fibEvenSum(int n) {
		int sum = 0;
		int[] fib = new int[2 * n + 1];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2; i <= 2 * n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
			if(i % 2 == 0)
				sum += fib[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();
					
					System.out.println("Sum of first " + n + " even fibonacci numbers is " + fibEvenSum(n));
					
				} catch(NumberFormatException e) {
					System.out.println("Only integers greater than zero are accepted");
//					scn.next();
				}
			}
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.print("Closing System.in resource");
			scn.close();
		}
	}

}
