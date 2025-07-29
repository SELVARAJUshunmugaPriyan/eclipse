package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReverseNumberTrianglePattern {

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
					
					System.out.println("Reverse number triangle pattern:");
					
					for(int i = n; i >= 1; i--) {
						int j;
						// Printing spaces before numbers
						for(j = 1; j <= n - i; j++)
							System.out.print(" ");
						
						// Printing numbers
//						for(; j <= n; j++)
						while(j <= n)
							System.out.print(j++ + " ");
						
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
