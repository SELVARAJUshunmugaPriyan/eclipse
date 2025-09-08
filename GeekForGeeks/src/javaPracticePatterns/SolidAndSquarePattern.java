package javaPracticePatterns;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SolidAndSquarePattern {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Solid pattern:");
					
					// Solid part
					char C[] = new char[n];
					Arrays.fill(C, '*');
					for (int i = 0; i < n; i++) {
						System.out.println(C);
					}
					
					System.out.println("\nHollow pattern:");
					
					// Hollow part
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++)
							if (j == 0 || j == n - 1 || i == 0 || i == n - 1)
								System.out.print("*");
							else
								System.out.print(" ");
						System.out.println();
					}
					
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
