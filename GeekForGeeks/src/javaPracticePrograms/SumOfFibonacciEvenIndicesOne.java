package javaPracticePrograms;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SumOfFibonacciEvenIndicesOne {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					int n1 = 0, n2 = 1, n3 = 0, sum = 0;
					
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();
					
					for(int i = 0; i <= 2 * n; i++) {
						n3 = n1 + n2;
						if(i % 2 == 0)
							sum += n1;
						n1 = n2;
						n2 = n3;
					}
					
					System.out.println("Sum of first " + n + " even fibonacci numbers is " + sum);
					
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
