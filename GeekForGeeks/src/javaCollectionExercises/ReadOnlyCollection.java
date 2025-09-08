package javaCollectionExercises;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

// Java class to make
// Set Interface Object Read-Only

class UnModifiableSet
{
	public static void main(String[] args)
	{
		// Set of Integer
		Set<Integer> numbers = new HashSet<Integer>();
		
		// Set have 1 to 10 numbers
		for (int i = 1; i <= 10; i++)
			numbers.add(i);
		
		// print the Integers
		numbers.stream().forEach(System.out::print);
		
		// removing element from the list
		numbers.remove(5);
		
		System.out.println("\nAfter Performing Operation");
		
		numbers.stream().forEach(System.out::print);
		
		System.out.println(
				"\nSet is also By Default Readable and Writable");
		
		// Now making Read-Only Set
		// using unmodifiableSet() method.
		try {
			numbers = Collections.unmodifiableSet(numbers);
			
			// This line will generate an Exception
			numbers.remove(4);
		} catch (UnsupportedOperationException e) {
			System.out.println("Exception is " + e);
		} finally {
			System.out.println(numbers.contains(4));
			System.out.println("Now Set is Read-Only");
		}
	}
}

//Java class to make
//List Interface Object Read-Only
class UnModifiableList
{
	public static void main(String[] args)
	{
		// List of Integer
		List<Integer> numbers = new ArrayList<>();
		
		// List have 1 to 10 numbers
		for (int i = 1; i <= 10; i++)
			numbers.add(i);
		
		// Iterate on the stream of integers and
		// print them
		numbers.stream().forEach(System.out::print);
		
		// Now we are adding one more element
		numbers.add(11);
		
		// Removing element from the list
		numbers.remove(8);
		
		// Updating List¶
		numbers.set(4, 4);
		
		System.out.println(
				"\nAfter performing some operations");
		
		numbers.stream().forEach(System.out::print);
		
		System.out.println(
				"\nHence By default Collections object is Readable and Writable");
		
		// Now making Read-Only List
		// Using unmodifiableList() method
		try {
			numbers = Collections.unmodifiableList(numbers);
			
			// This line will generate an exception
			numbers.remove(11);
		} catch (UnsupportedOperationException
					unsupportedOperationException) {
			System.out.println(
					"Exception is "
					+ unsupportedOperationException);
		} finally {
			System.out.println(numbers.get(3));
			System.out.println(
					"Now list is only Read-Only");
		}
	}
}

public class ReadOnlyCollection 
{

	public static void main(String[] args) 
	{
		
//		UnModifiableSet.main(args);
//		UnModifiableList.main(args);
	}

}
