package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayEquals {
	
	public static boolean arrayEquals(int[][] I, int[][] J) {
		boolean isEqual = true;
		
		if(I.length != J.length)
			// Detecting rows mismatch
			isEqual = false;
		
		for(int i = 0; i < I.length && isEqual; i++) {
			isEqual = Arrays.equals(I[i], J[i]);
			
//			if(I[i].length != J[i].length)
//				// Detecting columns mismatch
//				isEqual = false;
//			
//			for(int j = 0; j < I[i].length; j++)
//				if(I[i][j] != J[i][j])
//					isEqual = false;
		}
		
		return isEqual;
	}
	
	public static int[][] receiveMatrix(Scanner scn) {
		int i = 0, j = 0, n = 0;
		
		System.out.println("Enter array in following format:"
				+ "\n[[num1, num2, num3], or [num1, num2, num3]"
				+ "\n [num1, num2, num3],"
				+ "\n [num1, num2, num3]]");
		
		String[] S = scn.nextLine().split("\\], \\[");
		n = S.length;
		int[][] I = new int[n][];
		
		for(String s : S) {
			String[] T = s.split(",");
			int[] K = new int[T.length];
			j = 0;
			// Parsing the matrix
			for(String t : T) {
				if(t.indexOf("[[") == 0)
					 // Removing "[["
					t = t.substring(2);
				if(t.indexOf("]]") == t.length() - 2 && t.indexOf("]]") > 0)
					 // Removing "]]"
					t = t.substring(0, t.length() - 2);
				if(t.indexOf("[") == 0)
					 // Removing "["
					t = t.substring(1);
				if(t.indexOf("]") == t.length() - 1 && t.indexOf("]") > 0)
					 // Removing "]"
					t = t.substring(0, t.length() - 1);
				
				K[j++] = Integer.parseInt(t.trim());
			}
			I[i++] = K;
		}
		
		return I;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				try {
					System.out.print("First: ");
					int[][] I  = receiveMatrix(scn);
					System.out.print("Second: ");
					int[][] J = receiveMatrix(scn);
					
					boolean isEqual;
					
//					isEqual = arrayEquals(I, J);
					isEqual = Arrays.deepEquals(I, J);
					
					if(isEqual)
						System.out.println("They are equal");
					else
						System.out.println("They are not equal");
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
