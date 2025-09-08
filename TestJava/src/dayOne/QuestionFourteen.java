package dayOne;

import java.util.Scanner;

public class QuestionFourteen {
	//MultiplicationAddition
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int a, b, c;
//		int a = 3;
//		int b = 5;
//		int c = 6;
		try {
			while (true) {
				try {
					System.out.println("Enter three integer values");
					a = scn.nextInt();
					b = scn.nextInt();
					c = scn.nextInt();
					
					System.out.println(a + " * " + b + " is " + (a * b));
					System.out.println("(" + a + " * " + b + ") + " + c + " is " + ((a * b) + c));
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
