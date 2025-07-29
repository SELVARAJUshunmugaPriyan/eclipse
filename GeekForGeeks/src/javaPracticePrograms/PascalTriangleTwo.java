package javaPracticePrograms;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PascalTriangleTwo {
	
	static int factorial(int i) {
		if(i == 0)
			return 1;
		return i * factorial(i - 1);
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
					
					System.out.println("Pascal triangle:");
					
					for(int i = 0; i <= n; i++) {
						for(int j = 0; j <= n - i; j++)
							System.out.print(" ");
						for(int j = 0; j <= i; j++) {
							System.out.print(" " + (factorial(i) / (factorial(i - j) * factorial(j))));
						}
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
