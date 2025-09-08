package javaPracticePrograms;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PascalTriangleOne {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					int[] I = {1};
					
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Pascal triangle:");
					
					for(int i = 0; i <= n; i++) {
						int[] J = new int[i + 1];
						for(int j = 0; j <= i; j++) {
							if(j == 0)
								J[j] = 1;
							else if(j == J.length - 1)
								J[j] = 1;
							else
								J[j] = I[j - 1] + I[j];
							System.out.print(J[j] + " ");
						}
						I = J;
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
