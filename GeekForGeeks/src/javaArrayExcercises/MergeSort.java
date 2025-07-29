// Java program for implementation
// of Merge Sort
package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MergeSort 
{
	
	// Merges two subarrays of arr[]
	static void mergeOne(int arr[], int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for (int i = 0; i < n1; i++)
			L[i] = arr[l + i];
//		System.out.println("L=" + Arrays.toString(L));
		for (int j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];
//		System.out.println("R=" + Arrays.toString(R));
		// merge the temp arrays
		// Initialize the indexes of first and second subarrays
		int i = 0, j = 0, k = l;
		
		while (i < n1 && j < n2)
			if (L[i] <= R[j])
				arr[k++] = L[i++];
			else
				arr[k++] = R[j++];
		
		while (i < n1) 
			arr[k++] = L[i++];
		
		while (j < n2)
			arr[k++] = R[j++];
//		System.out.println(Arrays.toString(arr));
	}
	
	// Main function that sorts a[l..r] using
	// merge()
	static void mergeSortOne(int arr[], int l, int r)
	{
//		System.out.println("0 : " + l + "-" + r);
		if (l < r) {
			
			int m = (l + r) / 2;
//			System.out.println("1 : " + l + "-" + r);
			// Sort first and second halves
			mergeSortOne(arr, l, m);
			mergeSortOne(arr, m + 1, r);
//			System.out.println("2 : " + l + "-" + r);
			// merge the sorted arrays
			mergeOne(arr, l, m, r);
		}
	}
	
	static void mergeTwo(int arr[], int l, int m, int r)
	{
		int n1 = m - l + 1, n2 = r - m;
		int[] L = new int[n1], R = new int[n2];
		
		for (int i = 0; i < n1; i++)
			L[i] = arr[l + i];	
		for (int i = 0; i < n2; i++)
			R[i] = arr[m + 1 + i];
		
		int i = 0, j = 0, k = l;
		
		while (i < n1 && j < n2)
			if (L[i] <= R[j])
				arr[k++] = L[i++];
			else
				arr[k++] = R[j++];
		
		while (i < n1)
			arr[k++] = L[i++];
		
		while (j < n2)
			arr[k++] = R[j++];
	}
	
	static void mergeSortTwo(int arr[], int l, int r)
	{
		if (l < r) {
			int m = (l + r) / 2;
			mergeSortTwo(arr, l, m);
			mergeSortTwo(arr, m + 1, r);
			mergeTwo(arr, l, m, r);
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
//					int I[] = BubbleSort.getArray(scn);
					int I[] = BubbleSort.getRandomArray(scn);
					
					System.out.println("The generated array is "
							+ Arrays.toString(I));
					
					long timeElapsed = System.nanoTime();
					
					mergeSortOne(I, 0, I.length - 1);
//					mergeSortTwo(I, 0, I.length - 1);
					
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
