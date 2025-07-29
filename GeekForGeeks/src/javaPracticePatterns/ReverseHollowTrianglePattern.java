package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReverseHollowTrianglePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Reverse hollow triangle pattern:");
					
					for(int i = n; i >= 1; i--) {
						// Printing spaces before numbers
						for(int j = 0; j < n - i; j++)
							System.out.print(" ");
						
						// Printing stars
						for(int j = 1; j < 2 * i; j++)
							if(j == 1 || j == 2 * i - 1 || i == n)
								System.out.print("*");
							else
								System.out.print(" ");
						
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
