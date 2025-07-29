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

public class MatrixRotationTwo 
{
	static int R = 5;
	static int C = 4;
	
	// A function to rotate a matrix
	// mat[][] of size R x C
	// initially m = R and n = C
	void rotateMatrix(int m, int n, int mat[][])
	{
		int row = 0, col = 0;
		int prev, curr;
		
		/*
		 row - Starting row index
		 m - ending row index
		 col - starting column index
		 n - ending column index
		 i -terator 
		 */
		while (row < m && col < n) {
			
			if (row + 1 == m || col + 1 == n)
				break;
			
			// Store the first element of next
			// row, this element will replace
			// first element of current row
			prev = mat[row + 1][col];
			
			// Move elements of first row
			// from the remaining rows
			for (int i = col; i < n; i++) {
				curr = mat[row][i];
				mat[row][i] = prev;
				prev = curr;
			}
			row++;
			
			// Move elements of last column
			// from the remaining columns
			for (int i = row; i < m; i++) {
				curr = mat[i][n - 1];
				mat[i][n - 1] = prev;
				prev = curr;
			}
			n--;
			
			// Move elements from last row
			// from the remaining rows
			if (row < m) {
				for (int i = n - 1; i >= col; i--) {
					curr = mat[m - 1][i];
					mat[m - 1][i] = prev;
					prev = curr;
				}
			}
			m--;
			
			// Move elements from first column
			// from the remaining columns
			if (col < n) {
				for (int i = m - 1; i >= row; i--) {
					curr = mat[i][col];
					mat[i][col] = prev;
					prev = curr;
				}
			}
			col++;
			
			// Print rotated matrix
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++)
					System.out.print(mat[i][j] + " ");
				System.out.print("\n");
			}
		}
	}
	
	// Driver code
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MatrixRotationTwo rotate = new MatrixRotationTwo();
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
					rotate.rotateMatrix(R, C, I);
					
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
