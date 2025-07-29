package dayOne;

import java.util.Scanner;

public class QuestionSix {
	// Average
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		
//		int a = 3;
//		int b = 4;
//		System.out.println("Average is " + ((a + b) / 2.0));
		int a, b;
		try {
			while (true) {
				try {
					System.out.println("Enter two integer values");
					a = scn.nextInt();
					b = scn.nextInt();
					
					System.out.println("Average of " + a + " and " + b + " is " + ((a + b) / 2.0));
				} catch (java.util.InputMismatchException e) {
					System.out.println("Only integer values are accepted");
					scn.next();
				}
			}
		} catch (java.util.NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	
	}
}
