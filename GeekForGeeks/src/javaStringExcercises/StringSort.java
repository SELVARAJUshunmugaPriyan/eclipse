// Java program to sort characters in a string

// Example: Input: software
//		   Output: aeforstw

package javaStringExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringSort {
	
	public static void sort(char[] arr)
	{
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (arr[i] > arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
	}

	public static void main(String[] args)
	{
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				System.out.println("Enter a string:");
				char[] cArr = scn.nextLine().toCharArray();
				
				if (cArr.length != 0) {
					System.out.println("Sorted string:");
					
					sort(cArr);
					System.out.println(cArr);
				}
			}
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
