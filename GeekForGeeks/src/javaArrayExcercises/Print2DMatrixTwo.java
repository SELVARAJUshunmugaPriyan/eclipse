package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

//class ArrayLengthMismatchException extends Exception {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 8521502793853564774L;
//
//	public ArrayLengthMismatchException(String msg) {
//		super(msg);
//	}
//}

public class Print2DMatrixTwo {

	public static void print2D(int[][] ARR) {
		System.out.println(Arrays.deepToString(ARR));
		return;
	}
	
	public static void main(String[] args) {
		
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
				int[][] I = new int[n][];
				
				try {
					for(String s : S) {
						String[] T = s.split(",");
						int[] J = new int[T.length];
						
//						if(T.length != n)
//							throw new ArrayLengthMismatchException(null);
						
						for(String t : T) {
							if(t.indexOf("[[") == 0)
								t = t.substring(2);
							else if(t.indexOf("]]") == t.length() - 2 && t.indexOf("]]") > 0)
								t = t.substring(0, t.length() - 2);
							J[j++] = Integer.parseInt(t.trim());
						}
						I[i++] = J;
						j = 0;
					}
					
					System.out.println("Entered array is ");
					print2D(I);
					
				} catch(NumberFormatException e) {
					System.out.println("Only numbers are accepted");
				}/* catch(ArrayLengthMismatchException e) {
					System.out.println("Only square matrices are accepted");
				}*/
			}
			
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System in resource");
			scn.close();
		}

	}

}
