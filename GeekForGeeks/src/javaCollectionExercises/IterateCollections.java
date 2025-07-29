// Java program to demonstrate how to
// Print a Collection
package javaCollectionExercises;

import java.util.*;
import java.util.stream.Collectors;

// Basic printing
class BasicPrinting
{
	public static void main(String[] args)
	{
		String[] geeks
			= {"keerthana", "priyan", "mohana", "koti"};
		
		List<String> al = new ArrayList<String>();
		
		// Adding elements of array to arrayList.
		Collections.addAll(al, geeks);
		
		System.out.println(al);
	}
}

// Java class to print an arraylist of an
// user-defined collection
class ArrayListCollection
{
	String name;
	int rollNo;
	
	// Constructor of class ArrayListCollection
	ArrayListCollection(String s, int n) 
	{
		// TODO Auto-generated constructor stub
		name = s;
		rollNo = n;
	}
	
	// Overriding the toString method
	// to print the collection
	public String toString()
	{
		return "Name : " + name + " | Roll No : " + rollNo;
	}
	
	// Driver main method
	public static void main(String[] args)
	{
		// creating an arraylist of user-defined collection
		ArrayList<ArrayListCollection> arr = new ArrayList<ArrayListCollection>();
		
		// creating objects of class ArrayListCollection
		ArrayListCollection t1 = new ArrayListCollection("keerthana", 101);
		ArrayListCollection t2 = new ArrayListCollection("priyan", 102);
		ArrayListCollection t3 = new ArrayListCollection("mohana", 103);
		ArrayListCollection t4 = new ArrayListCollection("koti", 104);
		
		// adding objects to arraylist
		arr.add(t1);
		arr.add(t2);
		arr.add(t3);
		arr.add(t4);
		
		// printing the collection
		for (ArrayListCollection c : arr)
			System.out.println(c);
	}
}

// Java class for printing hashMap
// of an user-defined collection
class HashMapCollection
{
	String firstName;
	String lastName;
	
	// Constructor
	HashMapCollection(String fn, String ln) 
	{
		firstName = fn;
		lastName = ln;
	}
	
	// Function- toString()
	public String toString()
	{
		// Over-riding the toString method to print the
		// collection
		return "| First Name : " + firstName
			+ " | LastName : " + lastName;
	}
	
	// Driver main method
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		// Creating a hashmap with key as ID and
		// value as user defined class
		HashMap<Integer, HashMapCollection> hm
			= new HashMap<Integer, HashMapCollection>();
		
		// creating objects
		HashMapCollection p1 = new HashMapCollection("keerthana", "devindran");
		HashMapCollection p2 = new HashMapCollection("priyan", "selvaraju");
		HashMapCollection p3 = new HashMapCollection("mohana", "velu");
		HashMapCollection p4 = new HashMapCollection("koti", "velu");
		
		// adding mappings
		hm.put(101, p1);
		hm.put(102, p2);
		hm.put(103, p3);
		hm.put(104, p4);
		
		// Iterating HashMap through for loop and printing the collection
		for (Map.Entry m : hm.entrySet())
			System.out.println(m.getKey() + " "
							   + m.getValue().toString());
	}
	
	static class Iteration
	{
		Iteration()
		{
			Map<String, String> names = new HashMap<String, String>();
			names.put("D.", "Keerthana");
			names.put("S.", "Shunmuga priyan");
			
			// Using for loop over keys and values
//			for(Map.Entry<String, String> name : names.entrySet())
//				System.out.println(name.getKey() + " " 
//						+ name.getValue());
			
			// Using forEach (Lambda expressions)
//			names.forEach((key, value) -> 
//					System.out.println(key + " " + value));
			
			// Using Iterator
//			Iterator< Map.Entry<String, String> > iter 
//					= names.entrySet().iterator();
//			while(iter.hasNext()) {
//				Map.Entry<String, String> entry = iter.next();
//				System.out.println(entry.getKey() + " " 
//						+ entry.getValue());
//			}
			
			// Using stream
			names.entrySet().stream().forEach(entry
					-> System.out.println(entry.getKey()
							   + " " + entry.getValue()));
		}
		
	}
}

// Java class to demonstrate iteration
// through LinkedList
class LinkedListCollection
{
	public static void main(String[] args) {
		// Creating a LinkedList of Integer type
	    LinkedList<Integer> ll = new LinkedList<>(
	    		Arrays.asList(1, 2, 3));
		
		// Iterating using for loop
//		for (int i = 0; i < ll.size(); i++)
//			System.out.println(ll.get(i));
		
		// Iterating using while loop
//		int i = 0;
//		while (i < ll.size())
//			System.out.println(ll.get(i++));
		
		// Iterating using enhanced-for loop
//		for (int j : ll)
//			System.out.println(j);
	    
	    // Iterating using iterator
//	    Iterator<Integer> iter = ll.iterator();

        // Inside the while loop we check if the next element
        // exists or not if the next element exists then we print
        // the next element and move to it otherwise we come out
        // of the loop
      
        // hasNext() method return boolean value
          // It returns true when the next element
          // exists otherwise returns false
	    
//	    while (iter.hasNext())
//	    	System.out.println(iter.next());
	    
//	    while (ll.iterator().hasNext()) // Error
//	    	System.out.println(ll.iterator().next()); // Error
	    
	    // Using forEach() mehtod
	    ll.forEach(i -> System.out.println(i));
	}
}

class HashSetCollection
{
	HashSetCollection()
	{
		Set<String> set = Arrays.stream(javaArrayExcercises
				.BubbleSort.getRandStrArr(new Scanner(System.in)))
				.collect(Collectors.toCollection(HashSet::new));
		
		// Using brute-force
		
		// 1. enhanced for loop
//		for (String i : set)
//			System.out.println(i);
		
		// 2. System.out.println();
//		System.out.println(set);
		
		// Using forEach
//		set.forEach(s -> System.out.print(s + " "));
		
		// Using iterator
		Iterator<String> itr = set.iterator();
		
		while (itr.hasNext())
			System.out.println(itr.next());
	}
}

class QueueCollection
{
	private static boolean DEBUG = false;
	
	QueueCollection(boolean debug)
	{
		DEBUG = debug;
		new QueueCollection();
	}
	
	QueueCollection()
	{
		Queue<Integer> que;
		
		try (Scanner scn = new Scanner(System.in)) {
			que = Arrays.stream(javaArrayExcercises.BubbleSort
					.getRandIntgrArr(scn)).collect(Collectors
					.toCollection(LinkedList::new));
		}
		
		// using enhanced for loop
		if (DEBUG) for (int i : que)
			System.out.println(i);
		
		// using iterator
		Iterator<Integer> itr = que.iterator();
		
		while (itr.hasNext() && DEBUG)
			System.out.println(itr.next());
		
		// using forEach
		if (DEBUG) que.forEach(i -> System.out.println(i));
	}
}

// Driver class
public class IterateCollections 
{
	// Main Function
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		BasicPrinting.main(args);
//		ArrayListCollection.main(args);
//		HashMapCollection.main(args);
//		LinkedListCollection.main(args);
//		new HashMapCollection.Iteration();
//		new HashSetCollection();
		new QueueCollection(true);
	}

}
