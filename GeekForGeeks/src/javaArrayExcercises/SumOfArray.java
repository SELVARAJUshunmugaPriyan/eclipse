package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				double sum = 0;
				int i = 0;
				
				System.out.println("Enter array in following format:"
						+ "\n[num1, num2, num3]");
				
				String[] S = scn.nextLine().split(",");
				double[] D = new double[S.length];
				
				try {
					for(String s : S) {
//						try {
//							D[i] = Double.parseDouble(s);
//						} catch(NumberFormatException e) {
//							
//							if(s.indexOf('[') == 0)
//								s = s.substring(1);
//							else if(s.indexOf(']') == s.length() - 1)
//								s = s.substring(0, s.length() - 1);
//							else
//								throw new NumberFormatException();
//							
//						}
						if(s.indexOf('[') == 0)
							s = s.substring(1);
						else if(s.indexOf(']') == s.length() - 1)
							s = s.substring(0, s.length() - 1);
						
						D[i] = Double.parseDouble(s.trim());
						
						sum += D[i++];
					}
					
					System.out.println("Largest element of array "
							+ Arrays.toString(D) + " is " + sum);
					
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

}
