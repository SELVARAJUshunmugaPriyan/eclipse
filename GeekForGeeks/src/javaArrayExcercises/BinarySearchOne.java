package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BinarySearchOne {
	
	public static int binarySearch(int[] I, int start, int end, int k) {
		int mid = (start + end) / 2, pos = -1;
//		System.out.println(start + " " + end);
		if(start <= end)
			if(I[mid] == k)
				pos = mid;
			else if(I[mid] > k)
				pos = binarySearch(I, start, mid - 1, k);
			else
				pos = binarySearch(I, mid + 1, end, k);
//		else
//			throw new ArrayIndexOutOfBoundsException();
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
							+ " is " + binarySearch(I, 0, I.length -1, j));
					
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
