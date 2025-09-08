package javaPracticePatterns;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TriangleStarPattern {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Triangle star pattern:");
					
					char[] C = new char[2 * n];
					Arrays.fill(C, ' ');
					
					for(int i = 0; i < n; i++) {
						for(int j = n - i; j <= n + i; j++) {
//							System.out.println("i=" + i + " j=" + j); 
							C[j] = '*';
						}
						System.out.println(C);
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
