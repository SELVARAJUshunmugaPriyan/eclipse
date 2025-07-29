// Java program for array left rotation

// Example: Input: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
//
//					6

package javaArrayExcercises;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayRotationTwo 
{
	// function to left rotate arr[] of size n by d positions
	public static void leftRotate(int arr[], int d)
	{
		
		// Storing array length
		int n = arr.length;
		
		// If d >= n, reduce d to a value within the array bounds
		d %= n;
		
		int i, j, k, temp;
		int g_c_d = gcd(d, n); // Calculate GCD of d and n
//		System.out.println("GCD=" + g_c_d);
		// Process each set of elements as per GCD value
		for (i = 0; i < g_c_d; i++) {
			
			// Move i-th element of each block
			temp = arr[i];
			j = i;
			
			while (true) {
				k = j + d; // Calculate the index to swap with
				
				// Wrap around if k exceeds array length
				if (k >= n)
					k -= n;
				
				// Break when we complete the cycle for this block
				if (k == i)
					break;
				
				arr[j] = arr[k]; // Move elements within the set
				j = k;
			}
			arr[j] = temp; // Place initial element at end of cycle
		}
	}
	
	// Utility function to print an array
	void printArray(int arr[], int size)
	{
		for(int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}
	
	// Function to calculate GCD of a and b
	static int gcd(int a, int b)
	{	
		if (b == 0)
			return a;
		else
//			System.out.println("a=" + a + " b=" + b + " a%b=" + a % b);
			return gcd(b, a % b);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while (true) {
				int i = 0;
				
				System.out.println("Enter array in following format:"
						+ "\n[num1, num2, num3]");
				
				String[] S = scn.nextLine().split(",");
				int[] I = new int[S.length];
				
				try {
					for (String s : S) {
					
						// Removeing leading '['
						if(s.indexOf('[') == 0)
							s = s.substring(1);
						// Removeing trailing ']'
						if(s.indexOf(']') == s.length() - 1 && s.indexOf(']') > -1)
							s = s.substring(0, s.length() - 1);
						
						I[i++] = Integer.parseInt(s.trim());
						
					}
					
					System.out.println("Enter the number of times to be rotated");
					int j = Integer.parseInt(scn.nextLine());
					
					leftRotate(I, j);
					
					System.out.println("Rotated array is "
							+ Arrays.toString(I));
					
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
