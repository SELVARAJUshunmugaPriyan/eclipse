// Java program to add elements in
// Collection using add() method
package javaCollectionExercises;

import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.ArrayDeque;
import java.util.Collections;
//import java.util.stream.Collectors;
import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.ConcurrentLinkedDeque;

class AddingArrayList
{
	static void addArrayList()
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		// add method for integer ArrayList
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
	}
	
	static void indexAddArrayList()
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		// add method for integer ArrayList
		list.add(1);
		list.add(2);
		
		// Index is zero based
		// 3 gets added to the 1st
		// position(zero-based)
		list.add(1, 3);
		
		// 4 gets added to the 2nd
		// position(zero-based)
		list.add(2, 4);	
		
		System.out.println(list);
	}
}

class AddingHashSet
{
	static void initializingHashSet()
	{
		// Using Constructor
//		Set<Integer> set = new HashSet<>(Arrays.asList(1, 1, 2, 2));
		// Using Collections
		Set<Integer> set = Collections.<Integer> emptySet();
		Collections.addAll(set = new HashSet<Integer>(Arrays.asList(1, 1, 2, 2)));
		System.out.println(set);
	}
}

class AddingStack
{
	AddingStack()
	{
		Stack<Integer> stack = new Stack<>();
		
		// Using add() and add(index, element)
		Integer array[] = javaArrayExcercises.BubbleSort
				.getRandIntgrArr(new Scanner(System.in));
		
		System.out.println(Arrays.toString(array));
		
		for (int i : array)
			stack.add(i);
		stack.addFirst(0);
		stack.addLast(Integer.MAX_VALUE);
		stack.add(stack.size() - 2, 100);
		
		System.out.println(stack);
	}
}

class AddingQueue
{
	AddingQueue()
	{
		Queue<Integer> que;
		
		// As LinkedList
		
		// using stream
//		try (Scanner scn = new Scanner(System.in)) {
//			que = Arrays.stream(javaArrayExcercises.BubbleSort
//					.getRandIntgrArr(scn)).collect(Collectors.
//					toCollection(LinkedList::new));
//		}
		
		// using add() method
//		que = new LinkedList<>();
//		
//		que.add(1);
//		que.add(2);
//		que.add(3);
//		que.add(4);
		
		// using addAll() method
//		que = new LinkedList<>();
//		Integer array[] = {1, 2, 3, 4, 5};
//		
//		Collections.addAll(que, array);
		
//		try (Scanner scn = new Scanner(System.in)) {
//		que = Arrays.stream(javaArrayExcercises.BubbleSort
//				.getRandIntgrArr(scn)).collect(Collectors.
//				toCollection(LinkedList::new));
//	}
		
		// As ArrayDeque()
//		try (Scanner scn = new Scanner(System.in)) {
//		que = Arrays.stream(javaArrayExcercises.BubbleSort
//				.getRandIntgrArr(scn)).collect(Collectors.
//				toCollection(ArrayDeque::new));
//		}
		
		// As LinkedBlockingDeque()
//		try (Scanner scn = new Scanner(System.in)) {
//			que = Arrays.stream(javaArrayExcercises.BubbleSort
//					.getRandIntgrArr(scn)).collect(Collectors.
//					toCollection(LinkedBlockingDeque::new));
//		}
		
		// As ConcurrentLinkedDeque()
//		try (Scanner scn = new Scanner(System.in)) {
//			que = Arrays.stream(javaArrayExcercises.BubbleSort
//				.getRandIntgrArr(scn)).collect(Collectors.
//				toCollection(ConcurrentLinkedDeque::new));
//		}
//		
//		// illustrating NullPointerException
//		try {
//			que.add(null);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		// illustrating IllegalStateException
		que = new LinkedBlockingDeque<>(3);
		
		try {
			que.add(1);
			que.add(1);
			que.add(1);
			que.add(1);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(que);
	}
}

public class AddElementCollections {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AddingArrayList.addArrayList();
//		AddingArrayList.indexAddArrayList();
//		AddingHashSet.initializingHashSet();
		new AddingStack();
//		new AddingQueue();
	}

}
