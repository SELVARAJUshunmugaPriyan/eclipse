package dayThree;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionNine {
	// startsWith, endsWith, length and second-last character
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		String s;
		try {
			while(true) {
				try {
					System.out.println("Enter any string");
					s = scn.nextLine();
					
					System.out.println("Is given string starts with \"F\"?\n"
							+ s.startsWith("F") 
							+ "\nIs given string ends with \"s\"?\n"
							+ s.endsWith("s")
							+ "\nLength of given string:\n"
							+ s.length()
							+ "\nLast second character is "
							+ s.charAt(s.length() - 2));
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
