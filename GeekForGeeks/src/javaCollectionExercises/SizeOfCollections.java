// Java program to demonstrate
// size() method of collection
package javaCollectionExercises;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SizeOfCollections {
	
	static void sizeOfList()
	{
		List<Integer> l = Arrays.stream(javaArrayExcercises
							.BubbleSort.getRandomArray(
							new Scanner(System.in)))
							.boxed().collect(Collectors.toList());
		System.out.println("List : " + l
				+ "\nSize of List : " + l.size());
	}
	
	static void sizeOfArrayList()
	{
		// Creating object of List<Integer>
		List<Integer> arrayList = new ArrayList<Integer>(
				Arrays.asList(1, 2, 3, 4));
		
		// add elements
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		
		// getting total size of list
		// using size() method
		int size = arrayList.size();
		
		// print the size of list
		System.out.println("Size of list = " + size);
		
		// print the list
		System.out.println("ArrayList = " + arrayList);
	}

	static void sizeOfLinkedList()
	{
		// Creating object of LinkedList<String>
		List<String> ll = new LinkedList<String>(
				Arrays.asList("keerthana", "priyan"));
		
		// population LinkedList
		ll.add("GEEKS");
		ll.add("FOR");
		ll.add("GEEKS");
		
		// getting total size of LinkedList
		// using size() method
		int size = ll.size();
		
		// print the size
		System.out.println("Size of list = " + size);
		
		// print the LinkedList
		System.out.println("LinkedList = " + ll);
	}
	
	public static void main(String[] args) {
		
//		sizeOfList();
//		sizeOfArrayList();
		sizeOfLinkedList();
	}

}
