package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DiamondStarPattern {

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
					
					System.out.println("Diamond star pattern:");
					
					for(int i = 1; i < 2 * n; i++) {
//						Considering n = 3, finding j and * lines
//						n - 1 = 2		2n - (2j + 1) = 1
//						n - 2 = 1		2n - (2j + 1) = 3
//						n - 3 = 0		2n - (2j + 1) = 5
//						n - 4 = -1		2n - (2j + 1) = 3
//						n - 5 = -2		2n - (2j + 1) = 1
						int j = ((n - i) < 0) ? (i - n) : (n - i);
						
						// Printing spaces
						for(int k = 1; k <= j; k++)
							System.out.print(" ");
						
						// Printing * line
						for(int k = 0; k < (2 * n) - (2 * j + 1); k++)
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
