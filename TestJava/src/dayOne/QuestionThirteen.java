package dayOne;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionThirteen {
	// Print2Char
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char a = 'a';
//		char b = 'b';
//		System.out.println(a + " " + b);
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				try {
					System.out.println("Enter two characters");
					System.out.println("Entered characters are:\n" + scn.nextLine() + " " + scn.nextLine());
				} catch (InputMismatchException e) {
					System.out.println("Only characters are accepted");
					scn.next();
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
