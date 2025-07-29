// Java program to rotate
// a mattrix

// Example: Input: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
//
// 		   Output: [[4, 1, 2],
//				    [7, 5, 3],
//					[8, 9, 6]]

package javaArrayExcercises;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MatrixRotationOne 
{
	
	// Function to rotate matrix
	int[][] rotateMatrix(int[][] mat)
	{
		int res[][] = new int[mat.length][mat.length];
		
		for(int i = 0; i < mat.length; i++) {
			
			for(int j = 0; j < mat.length; j++) {
				/*
				 *  * * * -
				 *  - * - -
				 *  - - - - 
				 *  - - - - 
				 */
				
				// Top rows moved right once
				if (i < mat.length / 2 && j >= i && j < mat.length - 1 - i)
					res[i][j + 1] = mat[i][j];
				
				/*
				 *  - - - *
				 *  - - * *
				 *  - - - *
				 *  - - - -
				 */
				
				// Right columns moved down once
				else if (j >= mat.length / 2 && i >= mat.length - 1 - j && i < j)
					res[i + 1][j] = mat[i][j];
				
				/*
				 * - - - -
				 * - - - -
				 * - - * -
				 * - * * *
				 */
				
				// Last row moved right once
				else if (i >= mat.length / 2 && j > mat.length - 1 - i && j <= i)
					res[i][j - 1] = mat[i][j];
				
				/*
				 * - - - -
				 * * - - -
				 * * * - -
				 * * - - -
				 */
				
				// First column moved up once
				else if (j < mat.length / 2 && i > j && i <= mat.length - 1 - j)
					res[i - 1][j] = mat[i][j];
				
				else
					res[i][j] = mat[i][j];
			}
		}
		
		return res;
	}
	
	// Driver code
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MatrixRotationOne rotate = new MatrixRotationOne();
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
					
					// Printing the rotated matrix
//					Print2DMatrixThree.print2D(I);
					System.out.println("Rotated matrix is ");
					Print2DMatrixThree.print2D(rotate.rotateMatrix(I));
					
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
