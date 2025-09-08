package javaCollectionExercises;

import java.util.List;
import java.util.Arrays;

public class ExerciseQueueCollections {

	public static void main(String[] args) {
		
		CircularQueue.main(args);
	}

}

// Java class to implement a Circular Queue in Java
class CircularQueue
{
	private static boolean DEBUG = false;
	
	// Maximum size of the circular queue
	private int maxSize;
	// Array to store circular queue elements
	private int queueArray[];
	// Index of the front element
	private int front;
	// Index of the rear element
	private int rear;
	
	// Constructors to initialize the circular queue with a given size
	CircularQueue(boolean debug, int size)
	{
		this(size);
		DEBUG = debug;
	}
	
	CircularQueue(boolean debug, int array[])
	{
		this(array);
		DEBUG = debug;
	}
	
	CircularQueue(boolean debug, List<Integer> list)
	{
		this(list);
		DEBUG = debug;
	}
	
	CircularQueue(int ... array)
	{
		this(array.length);
		queueArray = Arrays.copyOf(array, array.length);
		if (queueArray.length != 0 ) {
			front = 0;
			rear = queueArray.length - 1;
		}
	}
	
	CircularQueue(List<Integer> list)
	{
		this(list.size());
		for(int i = 0; i < list.size(); i++)
			queueArray[i] = list.get(i);
		if (queueArray.length != 0 ) {
			front = 0;
			rear = queueArray.length - 1;
		}
	}
	
	CircularQueue(int size)
	{
		maxSize = size;
		queueArray = new int[maxSize];
		// Initially set front and rear to -1 to indicate an empty queue
		front = -1;
		rear = -1;
	}
	
	// Method to enque(add) an element to the circular queue
	void enque(int item)
	{
		if (isEmpty()) {
			front = 0;
			rear = 0;
			queueArray[rear] = item;
		} else {
			// circular increment of rear index
			rear = (rear + 1) % maxSize;
			if (front == rear) {
				System.out.println("Queue is full");
				// reset rear to its previous index
				rear = (rear - 1 + maxSize) % maxSize;
			} else
				queueArray[rear] = item;
		}
		
		if (DEBUG) System.out.printf("ENQUE: item=%d, %s\n", 
				item, toString());
	}
	
	// Method to deque(remove) an element from the circular queue
	int deque()
	{
		int item = -1; // Assuming -1 represents an empty value
		
		if (!isEmpty()) {
			item = queueArray[front];
			if (front == rear) {
				// reset front and rear to indicate an empty queue
				front = -1;
				rear = -1;
			} else
				// circular increment of front index
				front = (front + 1) % maxSize;
		} else
			System.out.println("Queue is empty");
		
		if (DEBUG) System.out.printf("DEQUE: item=%d, %s\n", 
				item, toString());
		return item;
	}
	
	// Method to peek at the front element of the circular queue without removing it
	int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1; // Assuming -1 represents an empty value
		}
		
		return queueArray[front];
	}
	
	// Method to check if the circular queue is empty
	boolean isEmpty() { return front == -1 && rear == -1; }
	
	// Getters
	public String toString()
	{
		return String.format("MaxSize=%d, Array=%s, front=%d"
				+ ", rear=%d", maxSize, Arrays.toString(queueArray),
				front, rear);
	}
	
	// Main method for testing the circular queue class
	public static void main(String[] args)
	{
		CircularQueue circularQueue = new CircularQueue();
		System.out.println(circularQueue);
	}
}
