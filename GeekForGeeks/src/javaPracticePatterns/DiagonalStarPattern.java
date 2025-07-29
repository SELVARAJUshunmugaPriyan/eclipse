package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DiagonalStarPattern {

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
					
					System.out.println("Crossed-Box pattern:");
					
					for (int i = 1; i <= n; i++) {
						for (int j = 1; j <= n; j++)
							if (i == 1 || i == n || j == 1 || j == n || 
								j == n - i + 1 || j == i)
								System.out.print("* ");
							else
								System.out.print("  ");
						System.out.println();
					}
					
					System.out.println("Cross-hair pattern:");
					
					int x = Math.ceilDiv(n, 2);
					for (int i = 1; i <= n; i++) {
						for (int j = 1; j <= n; j++) {
							int y = x - i < 0 ? (x - i - 1) * -1 : x - i + 1;
							int z = (x + i <= n ? x + i : 3 * x - i) - 1;
							if (i == x || j == x ||
								j == y || j == z)
								System.out.print("* ");
							else
								System.out.print("  ");
						}
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
