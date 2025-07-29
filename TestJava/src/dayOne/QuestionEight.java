package dayOne;

import java.util.Scanner;

public class QuestionEight {
	// StudentAge
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int age; // = 16;
		try {
			while (true) {
				try {
					System.out.println("Enter age:");
					age = scn.nextInt();
					if (age > 130) {
//						throw new java.util.InputMismatchException();
						System.out.println("Age can be only less than 130");
						continue;
					}
					
					System.out.println("Is minor?");
					
					if (age < 18) {
						System.out.println("yes");
					} else {
						System.out.println("no");
					}
				} catch (java.util.InputMismatchException e) {
					System.out.println("Age can be only less than 130");
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
