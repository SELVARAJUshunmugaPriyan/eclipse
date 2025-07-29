package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RightPascalTrianglePattern {

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
					
					System.out.println("Right pascal triangle pattern:");
					
					// Upper part
					for(int i = 1; i <= n; i++) {
						for(int j = 1; j <= i; j++)
							System.out.print("* ");
						
						System.out.println();
					}
					// Lower part
					for(int i = n - 1; i >= 1; i--) {
						for(int j = 1; j <= i; j++)
							System.out.print("* ");
						
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
