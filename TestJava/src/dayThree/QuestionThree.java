package dayThree;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionThree {
	// Contains "soft" and ends with "v"
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String s;
		try {
			while(true) {
				try {
					System.out.println("Enter any string");
					s = scn.nextLine();
					
					System.out.println("Contains \"soft\"?\n"
							+ s.contains("soft")
							+ "\nends with \'v\'?\n"
							+ s.endsWith("v")
							+ "\nContains \"soft\" and ends with \'v\'?\n"
							+ (s.contains("soft") && s.endsWith("v")));
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
