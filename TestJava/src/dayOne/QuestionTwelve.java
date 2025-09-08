package dayOne;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionTwelve {
	// DifferenceWeight
	public static void main(String[] args) {
		
//		int student1Weight = 40;
//		int student2Weight = 30;
//		System.out.println("Difference between their weight is " +
//				(student1Weight - student2Weight));
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				try {
					System.out.println("Enter two weights");
					System.out.println("Difference between their weights is "
							+ (Double.parseDouble(scn.nextLine()) - Double.parseDouble(scn.nextLine())));
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
