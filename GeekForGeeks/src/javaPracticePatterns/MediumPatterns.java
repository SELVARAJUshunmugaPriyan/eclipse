package javaPracticePatterns;

import java.util.Scanner;

@SuppressWarnings("unused")
public class MediumPatterns {
	
	private static final boolean DEBUG = true;
	
	private static void zigZagNumber(int n)
	{
		if (DEBUG) System.out.printf("In zigZagNumber(int=%d)\n", n);
		System.out.println("Zig-Zag number pattern: ");
		
		for (int i = 1, nxt = 0; i <= n; i++) {
			nxt += i;
			
			if (i % 2 == 1)
				for (int j = nxt - i + 1; j <= nxt; j++) {
					String str = j + (j == nxt ? "" : "*");
					System.out.print(str);
				}
			else
				for (int j = nxt, k = 1; k <= i; j--, k++) {
					String str = j + (k == i ? "" : "*");
					System.out.print(str);
				}
			
			System.out.println();
		}

	}
	
	private static void trianlgePyramidNumber(int n)
	{
		if (DEBUG) System.out.printf("In trianlgePyramidNumber(int=%d)\n", n);
		System.out.println("Triangle number pyramid pattern: ");
		
		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= n - i; j++)
				System.out.print(" ");
			
			for (int j = 1; j <= i; j++)
				System.out.print(j + " ");
			
			System.out.println();
		}

	}

	private static void numberPyramid(int n)
	{
		if (DEBUG) System.out.printf("In numberPyramid(int=%d)\n", n);
		System.out.println("Number pyramid pattern: ");
		
		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= n - i; j++)
				System.out.print(" ");
			
			int k = i;
			for (int j = 1; j < 2 * i; j++)
				if (j < i)
					System.out.print(k++);
				else if (j == i)
					System.out.print(k);
				else
					System.out.print(--k);
			
			System.out.println();
		}

	}
	
	private static void arrow(Integer n)
	{
		if (DEBUG) System.out.printf("In arrow(Int=%d)\n", n);
		System.out.println("Arrow pattern: ");
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
		
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	private static void arrow(int n)
	{
		if (DEBUG) System.out.printf("In arrow(int=%d)\n", n);
		System.out.println("Arrow pattern: ");
		
		for (int i = 1; i < 2 * n; i++) {
			int size = i;
			
			if (i >= n)
				size = 2 * n - i;
			
			for (int j = 1; j <= 2 * size; j++)
				if (j <= size)
					System.out.print(" ");
				else
					System.out.print("*");
			System.out.println();
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter a non-zero positive integer: ");
				int n;
				
				try {
					n = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					continue;
				}
				
//				arrow(n);
//				numberPyramid(n);
//				trianlgePyramidNumber(n);
				zigZagNumber(n);
			}
		} catch (java.util.NoSuchElementException e) {
			System.out.println("Closing System.in resource");
		}
	}

}
