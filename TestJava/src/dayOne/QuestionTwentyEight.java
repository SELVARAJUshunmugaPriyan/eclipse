package dayOne;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionTwentyEight {
	// SquareNumber
	public static void main(String[] args) {
		
//		int N = 16;
//		System.out.println("Square is " + (N * N));
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				try {
					System.out.println("Enter a number:");
					double d = Double.parseDouble(scn.nextLine());
					System.out.println("Square: " + (d * d));
				} catch (NumberFormatException e) {
					System.out.println("Enter number only");
				}
			}
		} catch (NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
