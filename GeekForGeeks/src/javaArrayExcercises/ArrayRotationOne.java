package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayRotationOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				int i = 0;
				boolean fwd = true;
				
				System.out.println("Enter array in following format:"
						+ "\n[num1, num2, num3]");
				
				String[] S = scn.nextLine().split(",");
				int[] I = new int[S.length], J = new int[S.length];
				
				try {
					for(String s : S) {
//					
						if(s.indexOf('[') == 0)
							s = s.substring(1);
						else if(s.indexOf(']') == s.length() - 1)
							s = s.substring(0, s.length() - 1);
						
						I[i++] = Integer.parseInt(s.trim());
						
					}
					
					System.out.println("Enter the number of times to be rotated");
					int j = Integer.parseInt(scn.nextLine()) % I.length;
					
					if(j < 0) {
						j *= -1;
						fwd = false;
					}
					
					for(i = 0; i < I.length; i++)
						if(fwd)
							if(i - j < 0)
								J[i] = I[I.length + i - j];
							else
								J[i] = I[i - j];
						else
							if(i + j > I.length - 1)
								J[i] = I[i + j - I.length];
							else
								J[i] = I[i + j];
						
					System.out.println("Rotated array is "
							+ Arrays.toString(J));
					
				} catch(NumberFormatException e) {
					System.out.println("Only numbers are accepted");
				} catch(StringIndexOutOfBoundsException e) {
					;
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
