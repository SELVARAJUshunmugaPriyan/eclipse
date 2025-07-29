package dayThree;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionEight {
	// Character array
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		char[] t;
		
		try {
			while(true) {
				try {
					System.out.println("Enter any string");
					t = scn.nextLine().toCharArray();
					
					System.out.println("Character array of entered string:");
					System.out.println(t);
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
