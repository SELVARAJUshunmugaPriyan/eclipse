package dayOne;
import java.util.Scanner;

public class QuestionEighteen {
	// ProductOfDifference
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		double a; // = 36;
		double b; // = 38;
//		int c = (a - b) * (a - b);
		
		try {
			while (true) {
				try {
					System.out.println("Enter two numbers:");
					a = Double.parseDouble(scn.next());
					b = Double.parseDouble(scn.next());
	
					System.out.println("(" + a + " - " + b + ") * (" + a + " - " + b + ") is " +
							((a - b) * (a - b)));
				} catch (NumberFormatException e) {
					System.out.println("Input must be number.");
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
