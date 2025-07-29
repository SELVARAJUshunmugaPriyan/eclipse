// Java program for implementation
// of Merge Sort
package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuickSort 
{
	static int partitionOne(int arr[], int low, int high)
	{
		int pivot = arr[high], i = low - 1;
		
		for (int j = low; j < high; j++)
			
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				int tmp = arr[++i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		
		int tmp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = tmp;
//		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, low, high)));
		return i + 1;
	}
	
	/* Main function that implements QuickSort()
	   arr[] --> array to be sorted,
	   low --> starting index,
	   high --> ending index */
	
	static void quickSortOne(int arr[], int low, int high)
	{
		if (low < high) {
			int pi = partitionOne(arr, low, high);
			
			// Recursively sort elements before
			// partition and after partition
			quickSortOne(arr, low, pi - 1);
			quickSortOne(arr, pi + 1, high);
		}
	}
	
	// Driver program
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
					
					quickSortOne(I, 0, I.length - 1);
					
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
