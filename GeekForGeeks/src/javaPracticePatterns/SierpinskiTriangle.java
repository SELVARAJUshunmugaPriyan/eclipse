package javaPracticePatterns;

import java.util.Scanner;

public class SierpinskiTriangle {

	public static void main(String[] args) {
		
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter a non-zero positive integer: ");
				int n;
				
				try {
					n = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					continue;
				}
				
				System.out.println("Sierpinski triangle pattern: ");
				
				for (int y = n - 1; y >= 0; y--) {
					for (int x = 0; x < y; x++)
						System.out.print(" ");
					for (int x = 0; x + y < n; x++)
						if ((x & y) != 0)
							System.out.print("  ");
						else
							System.out.print("* ");
					System.out.println();
				}
			}
		} catch (java.util.NoSuchElementException e) {
			System.out.println("Closing System.in resource");
		}
	}

}
