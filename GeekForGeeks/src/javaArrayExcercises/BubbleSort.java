// Java program for implementation
// of Bubble Sort
package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort 
{
	public static int[] getArray(Scanner scn) throws NumberFormatException
	{
		System.out.println("Enter array in following format:"
				+ "\n[num1, num2, num3]");
		
		String[] S = scn.nextLine().split(",");
		int I[] = new int[S.length], i = 0;
		
		for(String s : S) {
			if(s.indexOf('[') == 0)
				s = s.substring(1);
			else if(s.indexOf(']') == s.length() - 1)
				s = s.substring(0, s.length() - 1);
			I[i++] = Integer.parseInt(s.trim());
		}
		
		return I;
	}
	
	public static int[] getRandomArray(Scanner scn) throws NumberFormatException
	{
		Random rand = new Random();
		
		System.out.println("Enter the number of elements"
				+ " in the array:");
		int limit = Integer.parseInt(scn.nextLine());
		
		if (limit < 0)
			throw new NumberFormatException();
		
		int	I[] = new int[limit];
		
		for (int i = 0; i < limit; i++)
			I[i] = rand.nextInt(limit);
		
		return I;		
	}
	
	public static int[] getRandomArray(Scanner scn, int range) 
			throws NumberFormatException
	{
		Random rand = new Random();
		
		System.out.println("Enter the number of elements"
				+ " in the array:");
		int limit = Integer.parseInt(scn.nextLine());
		
		if (limit < 0)
			throw new NumberFormatException();
		
		int	I[] = new int[limit];
		
		for (int i = 0; i < limit; i++)
			I[i] = rand.nextInt(range);
		
		return I;		
	}
	
	public static Integer[] getRandIntgrArr(Scanner scn) throws NumberFormatException
	{
		Random rand = new Random();
		
		System.out.println("Enter the number of elements"
				+ " in the array:");
		int limit = Integer.parseInt(scn.nextLine());
		
		if (limit < 0)
			throw new NumberFormatException();
		
		Integer	I[] = new Integer[limit];
		
		for (int i = 0; i < limit; i++)
			I[i] = rand.nextInt(limit);
		
		return I;		
	}
	
	public static String[] getRandStrArr(Scanner scn)
	{
		Random rand = new Random();
		
		System.out.println("Enter the number of elements"
				+ " in the array:");
		int limit = Integer.parseInt(scn.nextLine());
		
		if (limit < 0)
			throw new NumberFormatException();
		
		System.out.println("Enter the maximum length of"
				+ " the string: (default max=30)");
		String len = scn.nextLine();
		int maxLen = len.length() != 0 ? Integer.parseInt(len) + 1
									   : 31;
		
		String	S[] = new String[limit];
		
		final String capLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String smlLetters = capLetters.toLowerCase();
		final int indxOfLetters = capLetters.length() - 1;
		
		for (int i = 0; i < limit; i++) {
			int length = rand.nextInt(1, maxLen);
			S[i] = "";
			for (int j = 0; j < length; j++)
				if (rand.nextInt(2) == 0)
					S[i] += capLetters.charAt(rand.nextInt(indxOfLetters));
				else
					S[i] += smlLetters.charAt(rand.nextInt(indxOfLetters));
		}
		return S;		
	}
	
	static void bubbleSortOne(int arr[])
	{
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++)
				if (arr[j] > arr[j + 1]) {
					
					// swap temp and arr[i]
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
//					System.out.println(Arrays.toString(arr));
				}
//			System.out.println();
		}
	}
	
	static void bubbleSortTwo(int arr[])
	{
		int n = arr.length;
		boolean swapped = false;
		
		for (int i = 0; i < n; i++) {
			swapped = false;
			for (int j = 0; j < n - 1; j++)
				if (arr[j] > arr[j + 1]) {
					
					// swap temp and arr[i]
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					swapped = true;
//					System.out.println(Arrays.toString(arr));
				}
//			System.out.println();
			if(!swapped)
				break;
		}
	}

	public static void main(String[] args) 
	{
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
//					int I[] = getArray(scn);
					int I[] = getRandomArray(scn);
					
					System.out.println("The generated array is "
							+ Arrays.toString(I));
					
					long timeElapsed = System.nanoTime();
					
					bubbleSortOne(I);
//					bubbleSortTwo(I);
					
					timeElapsed = System.nanoTime() - timeElapsed;
					
					System.out.println("The sorted array is "
							+ Arrays.toString(I) 
							+ "\nElapsed time: " + timeElapsed);
					
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
