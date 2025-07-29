package dayOne;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionThrityOne {
	// StudentSection
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String studentName = "Varun";
//		int standard = 10;
//		char section = 'c';
//		System.out.println(studentName + "\'s section is " + section);
		Scanner scn = new Scanner(System.in);
		try {
			while (true) {
				try {
					System.out.println("Enter student name and class section:");
					String s = scn.nextLine();
					String[] student = {};
					if (s.contains(" "))
						student = s.split(" ");
					else if (s.contains(","))
						student = s.split(",");
					if (student[1].toLowerCase().charAt(0) < 'a' || student[1].toLowerCase().charAt(0) > 'z')
						continue;
					System.out.println("The class section of " + student[0] + " is " + student[1]);
				} catch (Exception e) {
					throw e;
				}
			}
		} catch (NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource.");
			scn.close();
		}
	}

}
