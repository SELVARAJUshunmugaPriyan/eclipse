package javaCollectionExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ComparatorCollections 
{

	public static void main(String[] args) 
	{
		
		Scanner scn = new Scanner(System.in);
		List<Integer> l = new ArrayList<>();
		try {
			for (int i : javaArrayExcercises.
							BubbleSort.getRandomArray(scn))
				l.add(i);
			
			System.out.println("The generated array is "
					+ l);
			
			// Maximum in the list
			int maximum = Collections.max(l);
			// Minimum in the list
			int minimum = Collections.min(l);
			
			if (minimum == maximum)
				System.out.println("All elements are equal");
			else {
				System.out.println("Maximum value is " 
						+ maximum);
				System.out.println("Minimum value is "
						+ minimum);
			}
		} catch (NumberFormatException e) {
			System.out.println("Only non negative integers are accepted.");
		} finally {
			scn.close();
			System.out.println("Closed System.in resoruce");
		}
	}

}
