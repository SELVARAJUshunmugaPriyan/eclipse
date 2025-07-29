package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RhombusPattern {

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
					
					System.out.println("Solid rhombus pattern:");
					
					for(int i = 1; i <= n; i++) {
						// Printing spaces
						for(int j = 1; j <= n - i; j++)
							System.out.print(" ");
						
						// Printing * line
						for(int j = 0; j < n; j++)
							System.out.print("*");
						
						System.out.println();
					}
					
					System.out.println("Hollow rhombus pattern:");
					
					for (int i = 1; i <= n; i++) {
						// Printing spaces
						for (int j = 1; j <= n - i; j++)
							System.out.print(" ");
						
						// Printing * line
						for (int j = 0; j < n; j++)
							if (i == 1 || i == n || j == 0 || j == n - 1)
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
