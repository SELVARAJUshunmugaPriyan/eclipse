package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class ArrayLengthMismatchException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8521502793853564774L;

	public ArrayLengthMismatchException(String msg) {
		super(msg);
	}
}

public class TransposeOfMatrixOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				int i = 0, j = 0, n = 0;
				
				System.out.println("Enter array in following format:"
						+ "\n[[num1, num2, num3],"
						+ "\n [num1, num2, num3],"
						+ "\n [num1, num2, num3]]");
				
				String[] S = scn.nextLine().split("\\], \\[");
				n = S.length;
				int[][] I = new int[n][n], J = new int[n][n];
				
				try {
					for(String s : S) {
						String[] T = s.split(",");
						
						if(T.length != n)
							throw new ArrayLengthMismatchException(null);
						
						for(String t : T) {
							if(t.indexOf("[[") == 0)
								t = t.substring(2);
							else if(t.indexOf("]]") == t.length() - 2 && t.indexOf("]]") > 0)
								t = t.substring(0, t.length() - 2);
							I[i][j++] = Integer.parseInt(t.trim());
						}
						i++;
						j = 0;
					}
					
					for(i = 0; i < I.length; i++)
						for(j = 0; j < I.length; j++)
							J[j][i] = I[i][j];
					
					System.out.println("Transpose array is ");
					
					for(int[] K : J)
						System.out.println(Arrays.toString(K));
					
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
