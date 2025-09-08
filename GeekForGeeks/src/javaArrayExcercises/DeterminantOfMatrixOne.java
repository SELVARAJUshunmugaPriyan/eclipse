// Java program to find
// Determinant of a matrix
// using recursion

// Example: Input: [[1, 0, 2, -1], [3, 0, 0, 5], [2, 1, 4, -3], [1, 0, 5, 0]]
//
// 			Output: 30

package javaArrayExcercises;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeterminantOfMatrixOne 
{
	// Dimension of input square matrix
//	static final int N = 2;
	static int N;
	
	// Function to get cofactor of
	// mat[p][q] in temp[][]. n is
	// current dimension of mat[][]
	static void getCofactor(int mat[][], int temp[][],
							int p, int q, int n) 
	{
		int i = 0, j = 0;
		
		// Looping for each element
		// of the matrix
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				
				// Copying into temporary matrix
				// only those elements which are
				// not in given row and column
				if (row != p && col != q) {
					temp[i][j++] = mat[row][col];
					
					// Row is filled, so increase
					// row index and reset col index
					if (j == n - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}
	
	// Recursive function for finding determinant
	// of matrix. n is current dimension of mat[][].
	static int determinantOfMatrix(int mat[][], int n)
	{
		int D = 0; // Initialize result
		
		// Base case : if matrix 
		// contains single element
		if (n == 1)
			return mat[0][0];
		
		// To store cofactors
		int temp[][] = new int[n - 1][n - 1];
		
		// To store sign multiplier
		int sign = 1;
		
		// Iterate for each element of first row
		for (int f = 0; f < n; f++) {
			
			// Getting cofactor of mat[0][f]
			getCofactor(mat, temp, 0, f, n);
//			System.out.println(Arrays.deepToString(temp));
//			display(temp);
			D += sign * mat[0][f]
					* determinantOfMatrix(temp, n - 1);
			
			// terms are to be added
			// with alternate sign
			sign = -sign;
		}
		
		return D;
	}
	
	// function for displaying the matrix
	static void display(int mat[][], int row, int col)
	{
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(mat[i][j]);
			
			System.out.print("\n");
		}
	}
	
	// function for displaying the matrix
	static void display(int mat[][])
	{
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");
			
			System.out.print("\n");
		}
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
				int[][] I = new int[N][N];
				
				try {
					for (String s : S) {
						String[] T = s.split(",");
						
						if (T.length != N)
							throw new ArrayLengthMismatchException(null);
						
						for (String t : T) {
							// Removing "[["
							if (t.indexOf("[[") == 0)
								t = t.substring(2);
							// Removing "]]"
							if (t.indexOf("]]") == t.length() - 2 && t.indexOf("]]") > 0)
								t = t.substring(0, t.length() - 2);
							
							I[i][j++] = Integer.parseInt(t.trim());
						}
						i++;
						j = 0;
					}
					
					System.out.println("Determinant of array is "
							+ determinantOfMatrix(I, N));
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
