package javaCollectionExercises;

import java.util.Comparator;
import java.util.PriorityQueue;

class PQqHndlDupEleWithCstmComp
{
	private static boolean DEBUG = false;
	
	PQqHndlDupEleWithCstmComp(boolean debug)
	{
		this();
		DEBUG = debug;
	}
	
	PQqHndlDupEleWithCstmComp()
	{
		// Create a custom comparator that considers elements if they have same value
		Comparator<Integer> cmptr = Comparator.comparingInt(i -> i);
		// Create a priority queue with custom constructor
		PriorityQueue<Integer> pq = new PriorityQueue<>(cmptr);
		
		int j = 1;
		for (int i = 1; i > 0; i += j)
			if (i == 6)
				j = -1;
			else {
				pq.add(i);
				if (DEBUG) System.out.println(pq);
			}
		
		System.out.println(pq);
		
		// Check if pQ is empty
		System.out.println(pq.isEmpty());
		
		// Removing all elements
		pq.clear();
		System.out.println("After removing all elements: " + pq.isEmpty());
	}
}

class CustomComparator
{
	CustomComparator()
	{
		PriorityQueue<Student> pQ = new PriorityQueue<Student>(5,
				new StudentComparator());
		
		pQ.add(new Student("Asha", 68.92));
		pQ.add(new Student("Latha", 92.08));
		pQ.add(new Student("Mani", 67.53));
		pQ.add(new Student("Ravi", 44.01));
		pQ.add(new Student("Sekar", 68.92));
		
		while(!pQ.isEmpty())
			System.out.println(pQ.poll().name);
	}
	
}

class StudentComparator implements Comparator<Student>
{
	public int compare(Student s1, Student s2)
	{
		if (s1.cgpa < s2.cgpa)
			return -1;
		else if (s1.cgpa > s2.cgpa)
			return 1;
		return 0;
	}
}

class Student
{
	String name;
	double cgpa;
	
	Student(String name, double cgpa)
	{
		this.name = name;
		this.cgpa = cgpa;
	}
}

// Pair class 
// Used to bind item and weight
// together
class Pair
{
	int weight;
	String item;
	
	Pair(int weight, String item)
	{
		this.weight = weight;
		this.item = item;
	}
}

// Driver class
class SortByWeight
{
	SortByWeight()
	{
		int weight[] = {500, 1000, 250, 50};
		String item[] = {"Laptop", "TV", "Phone", "Watch"};
		
		String[] ans = this.sort(weight, item);
		
		for (String s : ans)
			System.out.println(s);
	}
	
	String[] sort(int[] weight, String[] item)
	{
		// Initialize a priority queue
		// it uses a custom comparator to sort the pairs
		// based on the weight
		// attribute in descending order
		PriorityQueue<Pair> pQ = new PriorityQueue<>(item.length,
				(a, b) -> Integer.compare(b.weight, a.weight));
		
		// add pair in pQ
		for (int i = 0; i < item.length; i++)
			pQ.add(new Pair(weight[i], item[i]));
		
		// initialize ans array
		String[] ans = new String[item.length];
		
//		for (int i = 0; !pQ.isEmpty(); i++)
//			ans[i] = pQ.remove().item;
		
		// initialize idx
		int idx = 0;
		
		// remove pair and place in ans array
		// while priority queue is not empty
		while (!pQ.isEmpty()) {
			Pair p = pQ.remove(); // Remove pair from pQ
			ans[idx++] = p.item;
		}
		
		return ans;
	}
}

// Java Class to Implement Heaps
// by Illustrating Min Heap

// Main class (MinHeap)
class MinimumHeap
{
	// Member variables of this class
	private int heap[], size, maxSize;
	// Initializing front as static with unity
	private static final int FRONT = 1;
	
	// Constructor of this class
	MinimumHeap(int maxSize)
	{
		// this keyword refers to the current object itself
		this.maxSize = maxSize;
		this.size = 0;
		
		this.heap = new int[this.maxSize + 1];
		heap[0] = Integer.MIN_VALUE;
	}
	
	// Method 1
	// Returning the position of
	// the parent for the node currently
	// at pos
	private int parent(int pos) { return pos / 2; }
	
	// Method 2
	// Returning the position of
	// the left child for the node currently at pos
	private int leftChild(int pos) { return 2 * pos; }
	
	// Method 3
	// Returning the position of
	// the right child for the node currently at pos
	private int rightChild(int pos) { return (2 * pos) + 1; }
	
	// Method 4
	// Returning true if the passed
	// node is a leaf node
	private boolean isLeaf(int pos) 
	{
		if (pos > size / 2)
			return true;
		return false;
	}
	
	// Method 5
	// To swap two nodes of the heap
	private void swap(int fpos, int spos)
	{
		int tmp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = tmp;
	}
	
	// Method 6
	// To heapify the node at pos
	private void minHeapify(int pos) 
	{
		if (!isLeaf(pos)) {
			int swapPos = pos;
			// Check with the minimum of the two children
			// to check if right child exists. Otherwise default value will be '0'
			// and that will be swapped with parent node.
			if (rightChild(pos) <= size) {
				swapPos = (heap[leftChild(pos)] < 
						   heap[rightChild(pos)]) ? 
							    leftChild(pos) : rightChild(pos);
			} else
				swapPos = leftChild(pos);
			
			if (heap[pos] > heap[leftChild(pos)] || 
					heap[pos] > heap[rightChild(pos)]) {
				swap(pos, swapPos);
				minHeapify(swapPos);
			}
		}
	}
	
	// Method 7
	// To insert a node into the heap
	public void insert(int element)
	{
		if (size > maxSize)
			return;
		
		heap[++size] = element;
		int current = size;
		
		while(heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	// Method 8
	// To print the contents of the heap
	public void print()
	{
		System.out.println("The Min Heap is ");
		
		for (int i = 1; i <= size / 2; i++) {
			System.out.printf("PARENT : %2d LEFT CHILD : %2d"
					+ " RIGHT CHILD : ", heap[i], heap[2 * i]);
			if (2 * i + 1 <= size)
				System.out.printf("%2d",
						heap[2 * i + 1]);
			System.out.println();			
		}
	}
	
	// Method 8
	// To remove and return the minimum
	// element of the heap
	public int remove()
	{
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		
		minHeapify(FRONT);
		
		return popped;
	}
	
	// Method 10
	// Main driver method
	public static void main(String[] args)
	{
		 // Display message
        System.out.println("The Min Heap is ");

        // Creating object of class in main() method
		MinimumHeap minHeap = new MinimumHeap(15);
		
		// Inserting element to minHeap
        // using insert() method

        // Custom input entries
		minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
		
        // Print all elements of the heap
        minHeap.print();
        
        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is " + 
        		minHeap.remove());
	}
}

// Java class demonstrating
// the implementation of maximum heap
class MaximumHeap
{
	private int heap[], size, maxSize;
	private static final int FRONT = 1;
	
	MaximumHeap(int maxSize)
	{
		this.maxSize = maxSize;
		this.size = 0;
		
		heap = new int[this.maxSize + 1];
		heap[0] = Integer.MAX_VALUE;
	}
	
	private int parent(int pos) { return pos / 2; }
	
	private int leftChild(int pos) { return 2 * pos; }
	
	private int rightChild(int pos) { return (2 * pos) + 1; }
	
	private boolean isLeaf(int pos)
	{
		if (pos > size / 2)
			return true;
		
		return false;
	}
	
	private void swap(int fpos, int spos)
	{
		int tmp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = tmp;
	}
	
	private void maxHeapify(int pos)
	{
		if (!isLeaf(pos)) {
			int swapPos = pos;
			
			if (rightChild(pos) <= size) {
				swapPos = (heap[leftChild(pos)] > 
						  heap[rightChild(pos)]) ? leftChild(pos)
								  : rightChild(pos);
			} else
				swapPos = leftChild(pos);
			
			if (heap[pos] < heap[leftChild(pos)] ||
					heap[pos] < heap[rightChild(pos)]) {
				swap(pos, swapPos);
				maxHeapify(swapPos);
			}
		}
	}
	
	public void insert(int element)
	{
		if (size >= maxSize)
			return;
		
		heap[++size] = element;
		int current = size;
		
		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public int remove()
	{
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		maxHeapify(FRONT);
		return popped;
	}
	
	public void print()
	{
		for (int i = 1; i <= size / 2; i++) {
			System.out.printf("PARENT : %2d LEFT CHILD : %2d "
					+ "RIGHT CHILD : ", heap[i], heap[2 * i]);
			if (2 * i + 1 <= size)
				System.out.println(heap[2 * i + 1]);
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("The Max Heap is ");
		
		MaximumHeap maxHeap = new MaximumHeap(15);
		
		maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        
        System.out.println("The Max val is " 
        		+ maxHeap.remove());
        
        maxHeap.print();
	}
}

class MinHeapWithpQ
{
	public static void main(String[] args)
	{
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		pQ.add(5);
        pQ.add(3);
        pQ.add(17);
        pQ.add(10);
        pQ.add(84);
        pQ.add(19);
        pQ.add(6);
        pQ.add(22);
        pQ.add(9);

        pQ.forEach(i -> System.out.println(i));
        
        pQ.remove();
        
        pQ.forEach(i -> System.out.println(i));
	}
}

class MaxHeapWithpQ
{
	public static void main(String[] args)
	{
		PriorityQueue<Integer> pQ = new PriorityQueue<>(15,
				(a, b) -> Integer.compare(b, a));
		
		pQ.add(5);
        pQ.add(3);
        pQ.add(17);
        pQ.add(10);
        pQ.add(84);
        pQ.add(19);
        pQ.add(6);
        pQ.add(22);
        pQ.add(9);

        pQ.forEach(i -> System.out.println(i));
        
        pQ.remove();
        
        pQ.forEach(i -> System.out.println(i));
	}
}

public class ExercisePriorityQueueCollections {

	public static void main(String[] args) {
		
//		new PQqHndlDupEleWithCstmComp();
//		new CustomComparator();
//		new SortByWeight();
//		MinimumHeap.main(args);
//		MaximumHeap.main(args);
//		MinHeapWithpQ.main(args);
		MaxHeapWithpQ.main(args);
	}

}
