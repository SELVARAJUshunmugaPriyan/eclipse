// Java program to find
// Normal of a matrix
// and trace of square matrix

// Example: Input: [[1, 4, 4], [2, 3, 7], [0, 5, 1]]
//
// 			Output: Normal is 11.0
//					Trace is 5

package javaArrayExcercises;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NormalAndTraceOfMatrix 
{
	// Dimension of input square matrix
	static int N;
	
	// Function for finding the normal of matrix
	static double normalOfMatrix(int[][] mat)
	{
		int nrml = 0;
		
		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat[i].length; j++)
				nrml += Math.pow(mat[i][j], 2);
		
		return Math.sqrt(nrml);
	}
	
	// Function for finding the trace of matrix
	static int traceOfMatrix(int[][] mat) throws
		ArrayLengthMismatchException
	{
		int trce = 0;
		
		for (int i = 0; i < mat.length; i++)
			if (mat[i].length != mat.length)
				
				// Aborting for non-square matrices
				throw new ArrayLengthMismatchException(null);
			else
				trce += mat[i][i];
		
		return trce;
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
				N = S.length;
				int[][] I = new int[N][];
				
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
					
					// Printing normal of matrix
					System.out.println("Normal of matrix is "
							+ normalOfMatrix(I));
					
					// Printing trace of matrix
					System.out.println("Trace of matrix is "
							+ traceOfMatrix(I));
					
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
