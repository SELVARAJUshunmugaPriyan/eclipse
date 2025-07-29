package dayOne;
import java.util.Scanner;

public class QuestionSeventeen {
	// ProductOfSum
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 6;
//		int b = 28;
//		int c = (a + b) * (a + b);
//		System.out.println("(a + b) * (a + b) is " + c);
//	}
		Scanner scn = new Scanner(System.in);
		
		double a, b;
		
		try {
			while (true) {
				try {
					System.out.println("Enter two numbers:");
					a = Double.parseDouble(scn.next());
					b = Double.parseDouble(scn.next());
	
					System.out.println("(" + a + " + " + b + ") * (" + a + " + " + b + ") is " +
							((a + b) * (a + b)));
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
