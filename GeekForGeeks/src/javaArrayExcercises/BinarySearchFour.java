package javaArrayExcercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BinarySearchFour {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				System.out.println("Enter array in following format:"
						+ "\n[num1, num2, num3]");
				
				String[] S = scn.nextLine().split(",");
				ArrayList<Integer> I = new ArrayList<Integer>();
				
				try {
					for(String s : S) {
//					
						if(s.indexOf('[') == 0)
							s = s.substring(1);
						else if(s.indexOf(']') == s.length() - 1)
							s = s.substring(0, s.length() - 1);
						
						I.add(Integer.parseInt(s.trim()));
						
					}
					
					System.out.println("Enter the target");
					int j = Integer.parseInt(scn.nextLine());
					
					System.out.println("The index of '" + j
							+ "' in array " + I.toString()
							+ " is " + Collections.binarySearch(I, j));
					
				} catch(NumberFormatException e) {
					System.out.println("Only integers are accepted");
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
