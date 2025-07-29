package dayOne;

import java.util.Scanner;

public class QuestionOne {
	// OperaterInt
	public static void main (String[] args) {
//		int a = 5;
//		int b = 7;
//		System.out.println("a + b = " + (a + b));
//		System.out.println("a - b = " + (a - b));
//		System.out.println("a * b = " + (a * b));
//		System.out.println("a / b = " + (a / b));
		Scanner scn = new Scanner(System.in);

		double a, b;
		
		try {
			while (true) {
				try {
					System.out.println("Enter two numeric values");
					a = Double.parseDouble(scn.next());
					b = Double.parseDouble(scn.next());
					
					System.out.println(a + " + " + b + " = " + (a + b));
					System.out.println(a + " - " + b + " = " + (a - b));
					System.out.println(a + " * " + b + " = " + (a * b));
					System.out.println(a + " / " + b + " = " + (a / b));
					System.out.println(a + " % " + b + " = " + (a % b));
				} catch (NumberFormatException e) {
					System.out.println("Only numeric values are accepted");
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
