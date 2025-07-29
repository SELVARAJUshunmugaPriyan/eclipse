package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GaneshPattern {

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
					
					System.out.println("Ganesh pattern:");
					
					for (int i = 1; i <= n; i++) {
						for (int j = 1; j <= n; j++)
							if (j == (n / 2 + 1) || (i < (n / 2 + 1) && j == 1) || (i > (n / 2 + 1) && j == n) ||
								i == (n / 2 + 1) || (j > (n / 2 + 1) && i == 1) || (j < (n / 2 + 1) && i == n))
								System.out.print("* ");
							else
								System.out.print("  ");
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
