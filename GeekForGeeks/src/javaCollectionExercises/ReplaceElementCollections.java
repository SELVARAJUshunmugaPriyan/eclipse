package javaCollectionExercises;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReplaceElementCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReplaceElementArrayList(new String());
	}

}

// Java class to demonstrate replacing
// with set() method in ArrayList
class ReplaceElementArrayList
{
	ReplaceElementArrayList()
	{
		// Create an integer ArrayList of user-defined length
		List<Integer> al = 
				Arrays.stream(
					javaArrayExcercises
					.BubbleSort
					.getRandomArray(
				 		 new Scanner(System.in)))
					.boxed().collect(Collectors.toList());
		
		// Replace element last element to -1
		if (al.size() != 0)
			al.set(al.size() - 1, -1);
		
		// Printing the updated ArrayList
		System.out.println(al);
	}
	
	ReplaceElementArrayList(String s)
	{
		try {
			// Creating an object of ArrayList
			ArrayList<String> a = new ArrayList<>();
			
			a.add("A");
			a.add("B");
			a.add("C");
			a.add("D");
			
			// 2 is the index of element "C".
			// "C" will be replaced by "E"
			a.set(2, "E");
			
			System.out.println(a);
			
			a.set(a.size(), s); // Error
		} // catch block to handle exceptions
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
