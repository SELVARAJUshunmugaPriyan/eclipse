package dayOne;

import java.util.Scanner;

public class QuestionSeven {
	// ProductFloat
	public static void main (String[] args) {
//		float a = 123.4f;
//		float b = 27.78f;
//		System.out.println("product is " + (a * b));
//	}
		Scanner scn = new Scanner(System.in);
	
		double a, b;
		
		try {
			while (true) {
				try {
					System.out.println("Enter two numeric values");
					a = Double.parseDouble(scn.next());
					b = Double.parseDouble(scn.next());
					
					System.out.println("product is " + (a * b));
					
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
