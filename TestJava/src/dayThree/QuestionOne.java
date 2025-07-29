package dayThree;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionOne {
	// String Upper Case
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String s;
		try {
			while(true) {
				try {
					System.out.println("Enter any string");
					s = scn.nextLine();
					
					System.out.println("Upper case string:\n"
							+ s.toUpperCase() + "\n length is "
							+ s.length());
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
