package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayCopy {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				int i = 0;
				
				System.out.println("Enter array in following format:"
						+ "\n[num1, num2, num3]");
				
				String[] S = scn.nextLine().split(",");
				int[] I = new int[S.length], J;
				
				try {
					for(String s : S) {
						if(s.indexOf('[') == 0)
								s = s.substring(1);
							else if(s.indexOf(']') == s.length() - 1)
								s = s.substring(0, s.length() - 1);
							
							I[i++] = Integer.parseInt(s.trim());
						}
					
					J = arrayCopyIndividually(I);
						
					System.out.println("Individual copy method:\n"
							+ "Address of array "
							+ Arrays.toString(I) + " is " + I
							+ "\nAddress of array "
							+ Arrays.toString(J) + " is " + J);
					
					J = I.clone();
					
					System.out.println("Clone copy method:\n"
							+ "Address of array "
							+ Arrays.toString(I) + " is " + I
							+ "\nAddress of array "
							+ Arrays.toString(J) + " is " + J);
					
					System.arraycopy(I, 0, J, 0, I.length);
					
					System.out.println("Array copy method:\n"
							+ "Address of array "
							+ Arrays.toString(I) + " is " + I
							+ "\nAddress of array "
							+ Arrays.toString(J) + " is " + J);
					
					J = Arrays.copyOf(I, i);
					
					System.out.println("CopyOf method:\n"
							+ "Address of array "
							+ Arrays.toString(I) + " is " + I
							+ "\nAddress of array "
							+ Arrays.toString(J) + " is " + J);
					
					J = Arrays.copyOfRange(I, 0, i);
					
					System.out.println("CopyOfRange method:\n"
							+ "Address of array "
							+ Arrays.toString(I) + " is " + I
							+ "\nAddress of array "
							+ Arrays.toString(J) + " is " + J);
					
				} catch(NumberFormatException e) {
					System.out.print("Only numbers are accepted");
				}
			}
			
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System in resource");
			scn.close();
		}

	}

	private static int[] arrayCopyIndividually(int[] I) {
		
		int[] J = new int[I.length];
		for(int i = 0; i < I.length; i++)
			J[i] = I[i];
		return J;
	}

}
