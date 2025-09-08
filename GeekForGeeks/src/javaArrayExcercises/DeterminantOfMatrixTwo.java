// Java program to find
// Determinant of a matrix
// without recursion

// Example: Input: [[1, 0, 2, -1], [3, 0, 0, 5], [2, 1, 4, -3], [1, 0, 5, 0]]
//
// 			Output: 30

package javaArrayExcercises;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeterminantOfMatrixTwo 
{
	// Dimension of input square matrix
//	static final int N = 2;
	static int N;
		
	// Function to get determinant of matrix
	static int determinantOfMatrix(int mat[][], int n)
	{
		int num1, num2, det = 1, index,
						total = 1; // Initialize result
		
		// Temporary array for storing row
		int temp[] = new int[n + 1];
		
		// Loop for traversing the diagonal elements
		for (int i = 0; i < n; i++) {
			index = i;
			
			// finding the index which has non-zero value
			while (mat[index][i] == 0 && index < n)
				index++;
			
			if (index == n) // if there is non zero element
				continue;
			
			if (index != i) {
				
				// loop for swapping the diagonal element row
				// and index row
				for (int j = 0; j < n; j++)
					swap(mat, index, j, i, j);
				
				// determinant sign changes when we shift
				// rows go through determinant properties
				det = (int) (det * Math.pow(-1, index - i));
			}
			
			// storing the values of diagonal row elements
			for(int j = 0; j < n; j++)
				temp[j] = mat[i][j];
			
			// traversing every row below the diagonal
			// element
			for (int j = i + 1; j < n; j++) {
				num1 = temp[i]; // value of diagonal element
				num2 = mat[j][i]; // value of next row element
				
				// traversing every column of row 
				// and multiplying to every row
				for(int k = 0; k < n; k++)
					
					// multiply to make the diagonal
					// element and next row element equal
					mat[j][k] = (num1 * mat[j][k])
								- (num2 * temp[k]);
				
				total = total * num1; // Det(kA)=kDet(A);
			}
		}
		
		// multiplying the diagonal elements to get
		// determinant
		for(int i = 0; i < n; i++)
			det = det * mat[i][i];
		
		return (det / total);
	}
	
	static void swap(int[][] arr, int i1, int j1, int i2,
					 int j2)
	{
		int temp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = temp;
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
