package dayOne;

import java.util.Scanner;

public class QuestionFour {
	// OperatorLong
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
//		long a = 9176453505l;
//		long b = 8808342318l;
		long a, b;
		
		try {
			while (true) {
				try {
					System.out.println("Enter two long values");
					a = scn.nextLong();
					b = scn.nextLong();
					
					System.out.println(a + " - " + b + " = " + (a - b));
				} catch (java.util.InputMismatchException e) {
					System.out.println("Only long values are accepted");
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
