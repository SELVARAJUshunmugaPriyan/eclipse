package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RightHalfPyramidPattern {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Right-half pyramid pattern:");
					
					for(int i = 1; i <= n; i++) {
						for(int j = 1; j <= i; j++)
							System.out.print("*");
						
						System.out.println();
					}
					
				} catch(NumberFormatException e) {
					System.out.println("Only integers greater than zero are accepted");
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
