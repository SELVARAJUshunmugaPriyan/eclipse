package dayOne;

import java.util.Scanner;

public class QuestionSixteen {
	// HeightAndWeight
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
//		float personHeight = 166.67f;
//		float personWeight = 56.76f;
//		System.out.println("height is " + personHeight + "\n" +
//				"weight is " + personWeight);
		float personHeight, personWeight;
		
		try {
			while (true) {
				try {
					System.out.println("Enter height");
					personHeight = Float.parseFloat(scn.next());
					System.out.println("Enter weight");
					personWeight = Float.parseFloat(scn.next());
					
					System.out.println("height is " + personHeight + "\n" +
					"weight is " + personWeight);
				} catch (NumberFormatException e) {
					System.out.println("Only float values accepted");
					scn.next();
				}
			}
		} catch (java.util.NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closed System.in resource");
			scn.close();
		}
	}

}
