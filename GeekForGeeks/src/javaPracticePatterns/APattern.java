package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class APattern {

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
					
					System.out.println("'A' pattern:");
					
//					for (int i = 0; i < n; i++) {
//						char C[] = new char[2 * n];
//						for (int j = 0; j < 2 * n; j++)
//							if (j == n - i || j == n + i ||
//							   (i == n - 3 && j > n - i && j < n + i))
//								C[j] = '*';
//						
//						System.out.println(C);
//					}
					
					for (int i = 0; i < n; i++) {
						char C[] = new char[n / 2 + 1];
						for (int j = 0; j <= n / 2; j++)
							if (i != 0 && (j == 0 || j == n / 2) || i == n / 2 ||
							   (i == 0 && j != 0 && j != n / 2))
								C[j] = '*';
						
						System.out.println(C);
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
