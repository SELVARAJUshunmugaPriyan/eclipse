package dayOne;

import java.util.Scanner;

public class QuestionFive {
	// CircleArea
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int radius = 0;
		double area;
		try {
			while (true) {
				try {
					System.out.println("Enter radius:");
					radius = scn.nextInt();
					
					area = 3.14 * radius * radius;
					System.out.println("Area of circle is " + area);
				} catch (java.util.InputMismatchException e) {
					System.out.println("Only Integer values are accepted");
					scn.next();
				}
			}
		} catch (java.util.NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
