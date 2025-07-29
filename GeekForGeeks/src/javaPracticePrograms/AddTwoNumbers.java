package javaPracticePrograms;

//import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter two numbers:");
					System.out.println("Sum of numbers = " + (Double.parseDouble(scn.next()) + Double.parseDouble(scn.next())));
				} catch(NumberFormatException e) {
					System.out.println("Only numbers are accepted");
//					scn.next();
				}
			}
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.print("Closing System.in resource");
			scn.close();
		}
	}

}
