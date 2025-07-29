// Java program  to print only boundary elements

// Example: Input: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
//			Output: [[1 2 3]
//					 [4   6]
//					 [7 8 9]]

package javaArrayExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PrintBoundaryElementsOfMatrix 
{
	// function to print only boundary elements
	static void printBoundary(int[][] ARR) 
	{
		System.out.print("[");
		
		for(int i = 0; i < ARR.length; i++) {
			System.out.print("[");
			
			for(int j = 0; j < ARR[i].length; j++) {
			
				if(i == 0 || j == 0 ||
				   i == ARR.length - 1 || j == ARR[i].length - 1)
					System.out.print(ARR[i][j]);
				else
					System.out.print(" ");
				if(j != ARR[i].length - 1)
					System.out.print(" ");
			
			}
			
			System.out.print("]");
			
			if(i != ARR.length - 1)
				System.out.print("\n ");
		}
		System.out.println("]");
		
		return;
	}

	// Driver code
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				int i = 0, j = 0;
				
				System.out.println("Enter matrix in following format:"
						+ "\n[[num1, num2, num3],"
						+ "\n [num1, num2, num3],"
						+ "\n [num1, num2, num3]]");
				
				String S[] = scn.nextLine().split("\\], \\[");
				int I[][] = new int[S.length][];
				
				try {
					for(String s : S) {
						String T[] = s.split(",");
						int K[] = new int[T.length];
						j = 0;
						// Parsing the matrix
						for(String t : T) {
							if(t.indexOf("[[") == 0)
								t = t.substring(2);
							if(t.indexOf("]]") == t.length() - 2 && t.indexOf("]]") > 0)
								t = t.substring(0, t.length() - 2);
							K[j++] = Integer.parseInt(t.trim());
						}
						I[i++] = K;
					}
					
					System.out.println("Only boundary elements"
							+ " of the matrix are printed:");
					
					printBoundary(I);
				} catch(NumberFormatException e) {
					System.out.println("Only numbers are accepted");
				}
			}
			
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System in resource");
			scn.close();
		}

	}

}
