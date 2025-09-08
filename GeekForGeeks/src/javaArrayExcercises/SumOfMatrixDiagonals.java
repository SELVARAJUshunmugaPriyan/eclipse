// Java program to find
// Normal of a matrix
// and trace of square matrix

// Example: Input: [[6, 7, 3, 4], [8, 9, 2, 1], [1, 2, 9, 6], [6, 5, 7, 2]]
//
// 			Output: Sum(principal) is 26
//					Sum(secondary) is 14

package javaArrayExcercises;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SumOfMatrixDiagonals 
{
	// Function for finding the sum of diagonals of matrix
	static int[] sumOfDiagonals(int[][] mat) throws
		ArrayLengthMismatchException
	{
		int dig[] = new int[2], n = mat.length;
		
		for (int i = 0; i < n; i++)
			if (mat[i].length != n)
				
				// Aborting for non-square matrices
				throw new ArrayLengthMismatchException(null);
			else {
				dig[0] += mat[i][i];
				dig[1] += mat[i][n - i - 1];
			}
		
		return dig;
	}
	
	// Driver code
	public static void main(String[] args) 
	{
		
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				int i = 0, j = 0;
				
				System.out.println("Enter matrix in following format:"
						+ "\n[[num1, num2, num3],"
						+ "\n [num1, num2, num3],"
						+ "\n [num1, num2, num3]]");
				
				String[] S = scn.nextLine().split("\\], \\[");
				int[][] I = new int[S.length][];
				
				try {
					for (String s : S) {
						String[] T = s.split(",");
						int arr[] = new int[T.length];
						
						for (String t : T) {
							// Removing "[["
							if (t.indexOf("[[") == 0)
								t = t.substring(2);
							// Removing "]]"
							if (t.indexOf("]]") == t.length() - 2 && t.indexOf("]]") > 0)
								t = t.substring(0, t.length() - 2);
							
							arr[j++] = Integer.parseInt(t.trim());
						}
						I[i++] = arr;
						j = 0;
					}
					
					// Printing principal and secondary sums of
					// diagonals of matrix
					System.out.println("Principal sum of matrix is "
							+ sumOfDiagonals(I)[0]
							+ "\nSecondary sum of matrix is "
							+ sumOfDiagonals(I)[1]);
					
				} catch(NumberFormatException e) {
					System.out.println("Only numbers are accepted");
				} catch(ArrayLengthMismatchException e) {
					System.out.println("Only square matrices are accepted");
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
