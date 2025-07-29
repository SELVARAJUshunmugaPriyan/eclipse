package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PalindromeTrianglePattern {

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
					
					System.out.println("Palindrome triangle pattern:");
					
					for(int i = 1; i <= n; i++) {
						// Printing spaces before numbers
						for(int j = 0; j < n - i; j++)
							System.out.print("  ");
						
						// Printing descending number
						for(int j = i; j >= 1; j--)
							System.out.print(j + " ");
						
						// Printing ascending number
						for(int j = 2; j <= i; j++)
							System.out.print(j + " ");
						
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
