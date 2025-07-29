package dayOne;

import java.util.Scanner;

public class QuestionEleven {
	// DifferenceAge
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int fatherAge;// = 45;
		int sonAge;// = 13;
		
		try {
			while (true) {
				try {
					System.out.println("Enter Father's age");
					fatherAge = scn.nextInt();
					if (fatherAge > 130) {
						System.out.println("Age must be in integer value less than 130");
						continue;
					}
					
					System.out.println("Enter Son's age");
					sonAge = scn.nextInt();
					if (sonAge > 130) {
						System.out.println("Age must be in integer value less than 130");
						continue;
					} else if (sonAge > fatherAge) {
						System.out.println("Son's age cannot be greater than Father's age");
						continue;
					}
					
					System.out.println("Difference between their ages is " +
							(fatherAge - sonAge));
				} catch (java.util.InputMismatchException e) {
					System.out.println("Age must be in integer value less than 130");
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
