package dayThree;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionSeven {
	// Split string, find length and change it to lowercase
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		String s;
		String[] t;
		try {
			while(true) {
				try {
					System.out.println("Enter any string");
					s = scn.nextLine();
					t = s.split(",");
					
					System.out.println("\nString split with \',\':");
					for (int i = 0; i < t.length; i++) {
						System.out.print(t[i]);
					}
					System.out.println("\n");
					for (int i = 0; i < t.length; i++) {
						System.out.println("Length of " + t[i] + " is " + t[i].length());
					}
					System.out.println("\nLower-case Strings:");
					for (int i = 0; i < t.length; i++) {
						System.out.print(t[i].toLowerCase());
					}
					System.out.println("\n");
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
