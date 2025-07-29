package javaPracticePrograms;

//import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					float prin = 0, rate = 0, numOfYears = 0; 
					
					System.out.println("Enter principal:");
					prin = Float.parseFloat(scn.next());
					
					System.out.println("Enter rate:");
					rate = Float.parseFloat(scn.next());
					
					System.out.println("Enter number of years:");
					numOfYears = Float.parseFloat(scn.next());
					
					System.out.println("Simple interest = " + (prin * rate * numOfYears / 100));
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
