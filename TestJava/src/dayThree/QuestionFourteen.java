package dayThree;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionFourteen {
	// Split, length, upper-case and concat
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				try {
					System.out.println("Enter a string:");
					
					String s = scn.nextLine();
					String[] t = s.split(" ");
					
					for (int i = 0; i < t.length; i++)
						System.out.print(t[i] + " ");
					System.out.println("\n");
					
					for (int i = 0; i < t.length; i++) {
						System.out.println("Length of " + t[i] + " is " + t[i].length());
						System.out.println("Upper-case of " + t[i] + " is " + t[i].toUpperCase());
					}
					
					System.out.println("Concated string is \"" + s.concat(" programs\""));
					
				} catch (InputMismatchException e) {
					System.out.println("Only Strings should be entered.");
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
