package dayOne;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionTwenty {
	// AddTwoStrings
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "Hello";
//		String s2 = "World";
//		System.out.println(s1 + " " + s2);
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				System.out.println("Enter two strings:");
				System.out.println("Concatenated string is \""
						+ scn.nextLine() + " "
						+ scn.nextLine() + "\"");
			}
		} catch (NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
