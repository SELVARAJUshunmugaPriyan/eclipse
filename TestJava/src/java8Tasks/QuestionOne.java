package java8Tasks;

import java.util.Scanner;

public class QuestionOne {

	public static void main(String[] args) {
		
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Please enter a string: ");
				scn.useDelimiter("\n");
				String str = scn.next();
				System.out.println("Entered string is \"" + str.substring(0, str.length() - 1) + "\".");
			}
		} catch (java.util.NoSuchElementException e) {
			System.out.println("Closing System.in resource");
		}
	}

}
