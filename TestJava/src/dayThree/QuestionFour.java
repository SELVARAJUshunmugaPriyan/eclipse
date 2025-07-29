package dayThree;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionFour {
	// Index of 'a' and character at 4 functions
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String s;
		try {
			while(true) {
				try {
					System.out.println("Enter any string");
					s = scn.nextLine();
					
					System.out.println("Index of \'a\' value:");
					if (s.indexOf('a') < 0)
						System.out.println("Character \'a\' is not present");
					else
						System.out.println(s.indexOf('a'));
					System.out.println("Character at index 4 is \n"
							+ s.charAt(4));
				} catch (InputMismatchException e) {
					System.out.println("Only String accepted");
					scn.next();
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					System.out.println("The length of entered string is less than 4 characters.");
				}
			}
		} catch (NoSuchElementException e ) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
