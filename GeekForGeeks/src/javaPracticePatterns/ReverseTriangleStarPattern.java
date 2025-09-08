package javaPracticePatterns;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReverseTriangleStarPattern {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Reverse triangle star pattern:");
					
					for(int i = n - 1; i >= 0; i--) {
						char C[] = new char[2 * n];
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
