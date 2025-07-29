package dayOne;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionTwentyFive {
	// studentRollNo
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String studentName1 = "Shunmuga";
//		String studentName2 = "priyan";
//		int rollNumber1 = 11501;
//		int rollNumber2 = 11502;
//		System.out.println(studentName1 + " - " + rollNumber1);
//		System.out.println(studentName2 + " - " + rollNumber2);
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				System.out.println("Enter student name and roll number:");
				System.out.println("Entered details:\n"
						+ scn.nextLine() + " - "
						+ scn.nextLine() + "\n"
						+ scn.nextLine() + " - "
						+ scn.nextLine());				
			}
		} catch (NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
