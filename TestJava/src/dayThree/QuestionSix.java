package dayThree;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionSix {
	// String equals "wonder land" without case-sensitivity
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		String s;
		try {
			while(true) {
				try {
					System.out.println("Enter any string");
					s = scn.nextLine();
					
					System.out.println("Is given string equals \"wonder land\"?\n"
							+ s.equalsIgnoreCase("wonder land"));
				} catch (InputMismatchException e) {
					System.out.println("Only String accepted");
					scn.next();
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
