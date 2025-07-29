package dayOne;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionThrity {
	// EqualsZero
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 20;
//		System.out.println("Is zero ?\n" + (a == 0));
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				try {
					System.out.println("Enter a number:");
					System.out.println("Is zero? " + (Double.parseDouble(scn.nextLine()) == 0));
				} catch (NumberFormatException e) {
					System.out.println("Only numbers are accepted.");
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
