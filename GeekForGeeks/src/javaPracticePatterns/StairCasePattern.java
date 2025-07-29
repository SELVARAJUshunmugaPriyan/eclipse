package javaPracticePatterns;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StairCasePattern {
	
	private static final boolean DEBUG = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter a positive integer: ");
				
				int n;
				try {
					n = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					continue;
				}
				
				System.out.println("Descending stairs: ");
				
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= ((i % 2 == 0) ? i : i + 1); j++)
						System.out.print("* ");
					System.out.println();
				}
				
				System.out.println("Ascending stairs: ");
				
				int ascLmt = n;
				for (int i = 1; i <= n; i++) {
					if (i % 2 != 0)
						ascLmt -= 2;
					
					for (int j = 1; j <= ascLmt; j++)
						System.out.print("  ");
					
					for (int j = ascLmt + 1; j <= n; j++)
						System.out.print("* ");
					
					System.out.println();
				}
				
				System.out.println("Mountain stairs: ");
				
				int mtnSrt = n / 2, mtnEnd = n / 2 + 1;
				for (int i = 1; i <= n; i++) {
					if (i % 2 != 0 && i != 1) {
						mtnSrt--;
						mtnEnd++;
					}
					
					if (DEBUG) System.out.print(mtnSrt + " " + mtnEnd);
					
					for (int j = 1; j <= n; j++)
						if (j >= mtnSrt && j <= mtnEnd)
							System.out.print("* ");
						else
							System.out.print("  ");
					
					System.out.println();
				}
				
				System.out.println("Inverted descending stairs: ");
				
				for (int i = n; i >= 1; i--) {
					for (int j = 1; j <= ((i % 2 == 0) ? i : i + 1); j++)
						System.out.print("* ");
					System.out.println();
				}
				
				System.out.println("Inverted mountain stairs: ");
				
				int iMtnSrt = 1, iMtnEnd = n;
				for (int i = 1; i <= n; i++) {
					if (i % 2 != 0 && i != 1) {
						iMtnSrt++;
						iMtnEnd--;
					}
					
					if (DEBUG) System.out.print(iMtnSrt + " " + iMtnEnd);
					
					for (int j = 1; j <= n; j++)
						if (j >= iMtnSrt && j <= iMtnEnd)
							System.out.print("* ");
						else
							System.out.print("  ");
					
					System.out.println();
				}
				
				System.out.println("Inverted ascending stairs: ");
				
				int iDscLmt = n;
				for (int i = 1; i <= n; i++) {
					if (i % 2 != 0 && i != 1)
						iDscLmt -= 2;
					
					for (int j = iDscLmt + 1; j <= n; j++)
						System.out.print("  ");
					
					for (int j = 1; j <= iDscLmt; j++)
						System.out.print("* ");
					
					System.out.println();
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Closing System.in resource");
		}
	}

}
