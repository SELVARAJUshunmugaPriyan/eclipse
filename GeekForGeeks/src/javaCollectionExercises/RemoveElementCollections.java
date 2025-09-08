package javaCollectionExercises;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RemoveElementCollections {
	
	RemoveElementCollections()
	{
		List<Integer> l = Arrays.stream(javaArrayExcercises
				.BubbleSort.getRandomArray(
				 new Scanner(System.in)))
				.boxed().collect(Collectors.toList());
		System.out.println("The generated list is "
			+ l + "\nPerforming removal of first element");
		l.remove(0);
		System.out.println("The list after removal : " + l);
	}

	public static void main(String[] args) {
		
//		new RemoveElementCollections();
//		new IndexRemoveArrayList();
//		new ObjectRemoveArrayList();
		new IteratorRemoveArrayList();
	}

}

// Java Class to Remove a Specific Element
// from a Collection based on the index
class IndexRemove
{
	// Auto executing static block
	static {
		// Creating an object of List interface with
		// reference to ArrayList class
		List<Integer> al = new ArrayList<>();
		
		// Adding elements to our ArrayList
		// using add() method	
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(1);
		al.add(2);
		
		// If elements set is larger use
		// iteration in loops to insert element
		
		// Display ArrayList after insertion
		System.out.println("Original ArrayList : " + al);
		
		// Making 1st remove call
		// which throw 20 out of list
		al.remove(1);
		
		// Here ArrayList: 10 30 1 2
		
		// Making 2nd remove call
		// which throw 30 out of list
		al.remove(1);
		// Here ArrayList: 10 1 2
		
		// Printing modified ArrayList after deleting few 
		// elements
		System.out.println("Modified ArrayList : " + al);
	}
}

// Java class to illustrate the removal
// of specific element from ArrayList
class ObjectRemoveArrayList
{
	@SuppressWarnings("removal")
	ObjectRemoveArrayList()
	{
		// Creating an ArrayLsit and 
		// storing elements in List
		List<Integer> al = new ArrayList<>();
		
		// Addition of elements to List
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(1);
		al.add(2);
		
		// This makes a call to remove(Object) and
		// removes element 1
//		Integer one = 1;
//		al.remove(one);
//		al.remove(new Integer(1));
		al.remove(Integer.valueOf(1));
		
		// This makes a call to remove(Object) and
		// removes element 2
		al.remove(new Integer(2));
		
		// Printing modified ArrayList
		System.out.println("Modified ArrayList : " + al);
	}
}

// Java class to demonstrate working of
// Iterator.remove() on an Integer ArrayList
class IteratorRemoveArrayList
{
	// Auto executing static block
	static {
		// Creating an ArrayLsit and 
		// storing elements in List
		List<Integer> al = new ArrayList<>();
		
		// Addition of elements to List
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(1);
		al.add(2);
		
		// printing the current ArrayList
		System.out.println(al);
		
		// Creating an Iterator object
		Iterator<Integer> iter = al.iterator();
		
		// Holds true till there is single element
		// remaining in the object
		while (iter.hasNext()) {
			
			// Remove elements smaller than 10 using
			// Iterator.remove()
			int x = (Integer) iter.next(); 
			if (x > 10)
				iter.remove();
		}
		
		// printing the updated ArrayList
		System.out.println(al);
	}
}
