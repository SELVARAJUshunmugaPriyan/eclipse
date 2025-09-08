package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BinarySearchTwo {
	
	public static int binarySearch(int[] I, int k) {
		int start = 0, end = I.length - 1, pos = -1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(I[mid] == k)
				return mid;
			else if(I[mid] > k)
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return pos;		
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				int i = 0;
				
				System.out.println("Enter array in following format:"
						+ "\n[num1, num2, num3]");
				
				String[] S = scn.nextLine().split(",");
				int[] I = new int[S.length];
				
				try {
					for(String s : S) {
//					
						if(s.indexOf('[') == 0)
							s = s.substring(1);
						else if(s.indexOf(']') == s.length() - 1)
							s = s.substring(0, s.length() - 1);
						
						I[i++] = Integer.parseInt(s.trim());
						
					}
					
					Arrays.sort(I);
					
					System.out.println("Enter the target");
					int j = Integer.parseInt(scn.nextLine());
					
					System.out.println("The index of '" + j
							+ "' in array " + Arrays.toString(I)
							+ " is " + binarySearch(I, j));
					
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
