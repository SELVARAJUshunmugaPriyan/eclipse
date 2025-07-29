package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ButterflyPatternOne {
	
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
					
					System.out.println("Butterfly pattern:");
//					123456	i	2n-i
//					*    *  1	 5
//					**  **  2	 4
//					******  3    3
//					******  3    3
//					**  **  2    4
//					*    *  1    5
					
					// Upper part					
					for(int i = 1; i <= n; i++) {
						for(int j = 1; j <= 2 * n; j++)
							if(j > i && j <= 2 * n - i)
								System.out.print(" ");
							else
								System.out.print("*");
						System.out.println();
					}
					
					// Lower part
					for(int i = n; i >= 1; i--) {
						for(int j = 1; j <= 2 * n; j++)
							if(j > i && j <= 2 * n - i)
								System.out.print(" ");
							else
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
