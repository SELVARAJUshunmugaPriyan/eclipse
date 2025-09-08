package dayOne;

import java.util.Scanner;

public class QuestionNine {
	// CubeOfThree
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		double a;
		
		try {
			while (true) {
				try {
					System.out.println("Enter a number");
					a = Double.parseDouble(scn.next());
					
					System.out.println("Cube of " + a + ": " + (a * a * a));
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
//		int a = 5;
//		int b = 7;
//		int c = 9;
		
//		System.out.println("Cube of " + a + " is " + a * a * a);
//		System.out.println("Cube of " + b + " is " + b * b * b);
//		System.out.println("Cube of " + c + " is " + c * c * c);
	}

}
