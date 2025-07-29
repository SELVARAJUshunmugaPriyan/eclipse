package javaCollectionQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Answers
{
	public static void main(String[] args)
	{
		/*
		 * Question - 1)
		 * Diff. b/w collection and Collections
		 * 
		 * Collection
		 * ==========
		 * - Collection is the root interface of Java Collections
		 * 	Framework.
		 * - It defines the common behaviour for a group of objects
		 * (elements) to be treated as a single unit.
		 * - It provides fundamental methods to manage elements -
		 * add(), size(), contains(), clear()
		 * - Sub-interfaces like List, Set, Queue extend the Collection
		 * Interface providing more specific behaviours and functionalities
		 * 
		 * Collections
		 * ===========
		 * - Collections is a utility class in java.util package
		 * - It consists of solely static methods to manipulate or
		 * return Collection objects.
		 * - Ex: sort(), min(), max(), binarySearch(), shuffle()
		 * - Collections' methods operate on objects of classes which
		 * implement Collection or its sub-interfaces
		 */
		/*
		 * Q2) Explain Collection Hierarchy
		 * 
		 * Java Collection Framework hierarchy organises interfaces and
		 * classes for managing groups of objects. At the top is the 
		 * Collection interface, which is extended by List, Set, and Queue.
		 * Map is another top-level interface, but it doesn't directly 
		 * extend Collection. These interfaces have various implementations 
		 * like ArrayList, HashSet, and HashMap, providing different 
		 * ways to store and access data.
		 * 
		 * Iterable Interface: The foundation for iterating over collections.
		 * It provides the iterator() method, which is used by other collection
		 * interfaces to enable looping through their elements.
		 * 
		 * Collection Interface: The root of the collection hierarchy. It 
		 * defines basic operations like adding, removing, and checking for the
		 * presence of elements.
		 * 
		 * List Interface: Represents an ordered collection (also known as a 
		 * sequence) that allows duplicate elements. ArrayList, LinkedList, 
		 * and Vector are common implementations. 
		 * 
		 * Set Interface: Represents a collection that does not allow duplicate
		 * elements. HashSet, LinkedHashSet, and TreeSet are common implementations.
		 * 
		 * Queue Interface: Represents a collection used for holding elements
		 * prior to processing. PriorityQueue, LinkedList, and ArrayBlockingQueue
		 * are examples of implementations.
		 *   
		 * Map Interface: Represents a mapping of keys to values. HashMap, TreeMap,
		 * LinkedHashMap, and Hashtable are implementations. 
		 */
		/*
		 * Q3) Diff. b/w List, Set and Map
		 * 
		 * List: Ordered Collection: Elements are stored and accessed by
		 * their index, maintaining the order of insertion.
		 * Allows Duplicates: Multiple instances of the same element can
		 * be stored.
		 * Examples: ArrayList, LinkedList.
		 * 
		 * Set: Unordered Collection (generally): Elements typically do 
		 * not maintain a specific order of insertion, though some 
		 * implementations like LinkedHashSet preserve insertion order.
		 * Does Not Allow Duplicates: Each element in a Set must be 
		 * unique. Attempting to add a duplicate element will not result
		 * in an error but will not modify the Set.
		 * Examples: HashSet, LinkedHashSet, TreeSet.
		 * 
		 * Map: Key-Value Pairs: Stores data as associations between 
		 * unique keys and their corresponding values. 
		 * Unique Keys: Keys must be unique, while values can be 
		 * duplicated.
		 * Efficient Lookups: Provides fast retrieval of values based on 
		 * their associated keys.
		 * Examples: HashMap, LinkedHashMap, TreeMap, Hashtable.
		 */
		/*
		 * Q4) Diff. b/w Array and ArrayList
		 * 
		 * Arrays: Have a fixed size determined at the time of creation.
		 * Their size cannot be changed after initialization.
		 * - Can store primitive and objects
		 * - Better performance with contiguous memory location use.
		 * - Storage and direct index based access
		 * ArrayList: Are dynamic and resizable. They can grow or 
		 * shrink as elements are added or removed.
		 * - Can store only objects (primitives are auto-boxed into 
		 * their wrapper classes)
		 * - Slower performance due to list resizing and element shifting
		 * - Rich set of methods
		 */
		/*
		 * Q5) Diff. b/w ArrayList and LinkedList
		 * 
		 * Diff b/w ArrayList and LinkedList in Java stem from their 
		 * underlying data structures and how they handle common operations:
		 * 
		 * Internal Structure:
		 * ArrayList uses a dynamic array to store elements. Elements are 
		 * stored in contiguous memory locations, allowing for direct 
		 * access by index.
		 * LinkedList uses a doubly linked list. Each element is stored in a
		 * node, and each node contains the data and references to both the
		 * next and previous nodes in the list. Elements are not necessarily
		 * stored in contiguous memory. 
		 * 
		 * Access Time:
		 * ArrayList offers fast random access (retrieving an element by its
		 * index) with O(1) time complexity due to direct array indexing.
		 * LinkedList has slower random access (O(n) time complexity) because
		 * it must traverse the list from the beginning or end to reach a 
		 * specific index.
		 * 
		 * Insertions and Deletions:
		 * ArrayList is less efficient for insertions and deletions in the
		 * middle of the list (O(n) time complexity) because elements after
		 * the insertion/deletion point need to be shifted.
		 * LinkedList excels in insertions and deletions at any position 
		 * (O(1) time complexity after finding the insertion/deletion point) 
		 * because it only requires updating node references, without shifting
		 * elements.
		 * 
		 * Memory Usage:
		 * ArrayList generally has less memory overhead because it only 
		 * stores the elements themselves, although it may allocate more
		 * memory than immediately needed to accommodate future growth.
		 * LinkedList has higher memory overhead because each node stores not
		 * only the data but also two references (to the next and previous nodes).
		 * 
		 * Iteration:
		 * ArrayList is typically faster for sequential iteration as elements
		 * are stored contiguously.
		 * LinkedList can be slower for sequential iteration due to the need
		 * to follow node references.
		 */
		/*
		 * Q6) Conv. Array to ArrayList
		 */
		List<Integer> list = Arrays.asList(3, 4, 5); // Or
		Integer[] array = {12, 13, 14};
		Collections.addAll(list, array); // Or
		for (int i : array)
			list.add(i);
		
		/*
		 * Q7) Conv. ArrayList to Array
		 */
		for (int i = 0; i < array.length; i++) // Or
			array[i] = list.get(i);
		array = list.stream().toArray(Integer[]::new);
		
		/*
		 * Q8) Diff. b/w ArrayList and HashMap
		 * 
		 * ArrayList and HashMap are both part of the Java Collections 
		 * Framework, but they serve different purposes and have distinct 
		 * characteristics:
		 * 1. Data Storage Mechanism:
		 * ArrayList: Stores elements in a dynamic array, where elements 
		 * are accessed by their integer index. It is essentially a 
		 * resizable array.
		 * HashMap: Stores data in key-value pairs using a hash table. 
		 * Each value is associated with a unique key, and retrieval is 
		 * based on the key.
		 * 2. Interface Implementation:
		 * ArrayList: Implements the List interface.
		 * HashMap: Implements the Map interface.
		 * 3. Order Maintenance:
		 * ArrayList: Maintains the insertion order of elements. Elements
		 * are retrieved in the same sequence they were added.
		 * HashMap: Does not guarantee any specific order of elements. The
		 * order of retrieval can vary.
		 * 4. Duplicates: 
		 * ArrayList: Allows duplicate elements.
		 * HashMap: Does not allow duplicate keys, as keys must be unique.
		 * However, it allows duplicate values.
		 * 5. Accessing Elements:
		 * ArrayList: Elements are accessed using their index (e.g., 
		 * arrayList.get(index)), providing O(1) constant-time performance
		 * for random access.
		 * HashMap: Values are accessed using their corresponding keys 
		 * (e.g., hashMap.get(key)). Average-case performance for 
		 * retrieval is O(1), but in the worst case (due to hash 
		 * collisions), it can degrade to O(n).
		 * 6. Null Values:
		 * ArrayList: Allows multiple null values.
		 * HashMap: Allows one null key and multiple null values.
		 */
		/*
		 * Q9) explain how ArrayList stores data internally and
		 * explain load factor and memory shifting
		 * 
		 * An ArrayList in Java stores data internally using a dynamically
		 * resizable array. When the ArrayList's capacity is exceeded, it
		 * creates a new, larger array (typically 1.5 times the original
		 * size) and copies the elements from the old array to the new one.
		 * This process is often referred to as "memory shifting" or 
		 * resizing. The load factor, in the context of ArrayList, is 
		 * related to how full the array is before it resizes, and it 
		 * influences the frequency and cost of resizing operations. 
		 * Internal Storage:
		 * ArrayList uses a regular array ( Object[] ) as its underlying 
		 * data structure. When an element is added, it's placed into the 
		 * next available position in the array. If the array is full, 
		 * ArrayList triggers a resize operation. 
		 * Resizing (Memory Shifting):
		 * Capacity Check: Before adding a new element, ArrayList checks 
		 * if there's enough space in the underlying array. 
		 * New Array Creation: If the array is full, a new array is created
		 * with a larger capacity. Typically, the new capacity is 
		 * calculated as oldCapacity * 3 / 2 + 1 (or 1.5 times the old 
		 * capacity, plus one). 
		 * Element Copying: The elements from the old array are copied to 
		 * the new array. 
		 * Reference Update: The elementData reference (which points to the
		 * internal array) is updated to point to the new, larger array.
		 * Old Array Discarded: The old array is eligible for garbage 
		 * collection. 
		 * Load Factor:
		 * The load factor, in the context of ArrayList, is implicitly 
		 * related to how full the internal array gets before resizing.
		 * While ArrayList doesn't explicitly use a loadFactor variable
		 * like hash-based collections (like HashMap), the concept is 
		 * still relevant to how frequently it resizes. 
		 * A higher load factor (meaning the array gets more full before
		 * resizing) can lead to fewer resizing operations and potentially
		 * better memory utilization. However, it also means more elements
		 * need to be copied during resizing.
		 * Conversely, a lower load factor can lead to more frequent 
		 * resizings but potentially faster individual add operations 
		 * (since the array is less full).
		 */
		/*
		 * Q10) Diff. b/w array and collection
		 * 
		 * Arrays and Collections are both used to store and manage data in
		 * Java, but they have key differences. Arrays are fixed in size, 
		 * store homogeneous elements, and offer faster access. Collections,
		 * part of the java.util framework, are dynamic, support 
		 * heterogeneous elements, and provide built-in methods for 
		 * manipulation.
		 */
		/*
		 * Q11) What is Iterable
		 * 
		 * In Java, Iterable is an interface belonging to the java.lang 
		 * package. It signifies that an object can be iterated over, 
		 * meaning its elements can be accessed sequentially.
		 * Defines iterator() method: The Iterable interface has a single 
		 * abstract method: public Iterator<T> iterator(). Classes 
		 * implementing Iterable must provide an implementation for this 
		 * method, which returns an Iterator object.
		 * Foundation for Collections: All classes in the Java Collections
		 * Framework (like ArrayList, HashSet, LinkedList, etc.) implement
		 * the Iterable interface, making them inherently iterable.
		 * Provides forEach() and spliterator() (default methods)
		 */
		/* Q12) What is Hashing technique?
		 * 
		 * Hashing is a technique that converts an input (or key) of 
		 * arbitrary size into a fixed-size value, called a hash code or 
		 * hash value, using a hash function. This process is used in data 
		 * structures like hash tables to enable efficient storage and 
		 * retrieval of data by mapping keys to specific locations (indices)
		 * within the table. 
		 */
		/* Q13) Explain hashcode hash bucket hash collision equals()
		 * hashtable
		 * 
		 * In Java, hashCode() is a method defined in the Object class that
		 * returns an integer value (a hash code) associated with an object.
		 * It's primarily used in hash-based data structures like HashMap,
		 * HashSet, and Hashtable to determine the "bucket" where an object
		 * should be stored and retrieved efficiently
		 * 
		 * In a hash table, a hash bucket is a storage unit, often an array
		 * index, used to hold data elements after they've been processed by
		 * a hash function. Essentially, a hash function maps a key to a 
		 * specific bucket, allowing for efficient data storage and 
		 * retrieval.
		 * 
		 * A hash collision occurs when two different pieces of data 
		 * produce the same hash value after being processed by a hash 
		 * function. This is a common occurrence, especially when dealing
		 * with a large number of inputs and a limited range of possible 
		 * hash values, as hashing functions map an infinite number of 
		 * inputs to a finite set of outputs.
		 * 
		 * The equals() method is used to compare two objects for equality
		 * based on their content or state, rather than just their memory
		 * addresses.
		 * 
		 * A hash table, also known as a hash map, is a data structure that
		 * stores data in key-value pairs, allowing for efficient retrieval
		 * of values based on their corresponding keys. It uses a hash 
		 * function to compute an index into an array, where the value is 
		 * stored. This structure enables fast average-case lookup, 
		 * insertion, and deletion operations. 
		 */
		/* Q14) What is an iterator?
		 * 
		 * In Java, an Iterator is an interface within the java.util package
		 * that provides a standard way to traverse elements in a collection
		 * (like ArrayList, HashSet, LinkedList, etc.) sequentially, without
		 * exposing the underlying data structure. It allows for looping 
		 * through a collection and performing operations on its elements.
		 */
		/* Q15) Purpose of hasNext(), next() and remove()
		 * 
		 * hasNext() : Returns true if the iteration has more elements.
		 * next() : Returns the next element in the iteration.
		 * remove() : Removes the last element returned by the next() method
		 * from the underlying collection.
		 */
		/* Q16) What is ConcurrentModificationException?
		 * 
		 * It occurs when a collection is modified by one thread while 
		 * another thread is iterating over it. This exception is a safety
		 * mechanism to prevent unexpected behavior and data corruption 
		 * that can arise from modifying a collection during iteration. 
		 */
		/* Q17) Difference between failfast and failsafe
		 * 
		 * Feature			Fail-Fast			Fail-Safe
		 * 
		 * Error Handling	Stops execution 	Tries to handle or 
		 * 					immediately			mask errors
		 * 
		 * Data Integrity	High priority		Lower priority than
		 * 										availability
		 * 
		 * Availability		Lower				Higher
		 * 
		 * Error Detection	Early and rapid		Delayed or masked
		 * 
		 * Example (Java)	ConcurrentModif-	No exception, potentially
		 * 					icationException	continuing with a 
		 * 										modified collection
		 */
		/* Q18) What is FIFO and LIFO. Diff. b/w Queue and Stack
		 * 
		 * In Java, LIFO (Last-In, First-Out) and FIFO (First-In, 
		 * First-Out) refer to principles for managing data in data 
		 * structures, specifically related to how elements are added 
		 * and removed.
		 * 
		 * The main difference between a stack and a queue is the order
		 * in which elements are processed. A stack follows a Last-In, 
		 * First-Out (LIFO) principle, meaning the last element added is
		 * the first one removed. A queue follows a First-In, First-Out 
		 * (FIFO) principle, where the first element added is the first
		 * one removed. 
		 */
		/* Q19) What are subclasses of Queue interface?
		 * 
		 * LinkedList: A doubly-linked list implementation of both List and
		 * Deque. 
		 * PriorityQueue: An unbounded priority queue where elements are
		 * ordered based on their natural ordering or a comparator.
		 * ArrayDeque: A resizable-array implementation of Deque. 
		 * ArrayBlockingQueue: A bounded, blocking queue backed by an array.
		 * LinkedBlockingQueue: A bounded, blocking queue backed by a linked
		 * list. 
		 * PriorityBlockingQueue: An unbounded, blocking priority queue.
		 * DelayQueue: A blocking queue for delayed retrieval of elements.
		 * ConcurrentLinkedQueue: An unbounded, thread-safe queue based 
		 * on linked nodes. 
		 * LinkedTransferQueue: An unbounded, thread-safe, and efficient
		 * queue for transferring elements. 
		 */
		/* Q20) Diff. b/w Comparable and Comparator
		 * 
		 * In Java, Comparable and Comparator are interfaces used for sorting
		 * objects, but they differ in how they define the sorting logic. 
		 * Comparable is implemented by the class itself, providing a 
		 * natural ordering for its objects. Comparator is an external 
		 * interface that provides a separate class for defining custom 
		 * sorting logic, allowing for multiple sorting strategies. 
		 */
		/* Q21) Difference between HashMap and HashSet
		 * 
		 * HashMap and HashSet are both implementations of core Java 
		 * collection interfaces that use hashing. The key difference lies 
		 * in their functionality: HashMap stores key-value pairs, while 
		 * HashSet stores unique elements. HashSet internally uses a HashMap
		 * instance for storage. Each element added to the HashSet is stored
		 * as a key in the backing HashMap, with a dummy Object as its value.
		 */
		/* Q22) Diff. b/w HashMap and HashTable
		 * 
		 * HashMap and Hashtable are both implementations of the Map 
		 * interface in Java, but they differ primarily in thread safety 
		 * and null key/value handling. HashMap is unsynchronized and 
		 * allows one null key and multiple null values, while Hashtable 
		 * is synchronized and does not allow null keys or values. 
		 */
		/* Q23) Write a program to join two arraylist with and w/o
		 * stream()
		 */
		List<Integer> lstA = Arrays.asList(1, 2, 3);
		List<Integer> lstB = Arrays.asList(4, 5, 6);
		
		List<Integer> lstC = new ArrayList<>();
		
		for (int i : lstA)
			lstC.add(i);
		
		for (int i : lstB)
			lstC.add(i);								// Or
		
		lstC.addAll(lstA);
		lstC.addAll(lstB);
		
		/* Q24) what happens when two different keys have the same 
		 * hash code in a hashmap in java?
		 * 
		 * When two different keys have the same hash code in a Java
		 * HashMap, it is known as a hash collision. Hash collisions
		 * are handled by storing multiple entries with the same hash
		 * code in the same bucket, typically in a linked list or, 
		 * if the list becomes too long, in a tree. The equals() 
		 * method is then used to distinguish between different keys
		 * that share the same hash code within that bucket.
		 */
		/* Q25) What is Stream API?
		 * 
		 * The Stream API in Java, introduced in Java 8, provides a 
		 * functional and declarative way to process sequences of elements,
		 * typically from collections like Lists, Sets, or Arrays. It
		 * allows for performing operations like filtering, mapping, 
		 * and reducing data in a more concise and expressive manner 
		 * compared to traditional loop-based approaches.
		 * 
		 * Key characteristics and features of the Java Stream API include:
		 * Functional Operations: Streams support various functional 
		 * operations such as filter(), map(), reduce(), sorted(), and 
		 * forEach(), enabling a more declarative style of programming.
		 * Pipelining: Operations can be chained together in a pipeline,
		 * where the output of one operation becomes the input for the 
		 * next, optimizing processing.
		 * Internal Iteration: Unlike external iteration with loops, 
		 * streams manage the iteration over the data source internally, 
		 * abstracting away the iteration logic.
		 * Non-Mutating: Streams do not modify the original data source; 
		 * instead, they produce new streams or results based on the 
		 * operations applied.
		 * Laziness: Intermediate operations are typically lazy, meaning
		 * they are only executed when a terminal operation is invoked.
		 * Parallel Processing: Streams can be easily converted to parallel
		 * streams using parallelStream(), leveraging multi-core 
		 * processors for efficient processing of large datasets.
		 * Sources: Streams can be created from various sources, including
		 * collections, arrays, I/O channels, and even generated values.
		 */
		/* Q26) Diff. b/w intermediate and terminal operations
		 * 
		 * Feature		Intermediate			Terminal
		 * 
		 * Output		Returns another Stream	Returns a 
		 * 										non-stream value
		 * 										or void
		 * 
		 * Execution	Lazy (deferred)			Eager (immediate)
		 * 
		 * Chaining		Can be chained			Cannot be chained 
		 * 										(ends pipeline)
		 * 
		 * Role			Transforms/filters the 	Consumes the stream
		 * 				stream					and produces a result
		 */
		/* Q27) Explain stream api methods
		 * 
		 * filter(Predicate): Returns a stream consisting of elements that
		 * match the given predicate (a function that returns a boolean).
		 * map(Function): Returns a stream consisting of the results of 
		 * applying the given function to each element of this stream.
		 * flatMap(Function): Returns a stream consisting of the results
		 * of replacing each element of this stream with the contents of
		 * a mapped stream, producing a new stream of potentially different
		 * types.
		 * distinct(): Returns a stream consisting of the distinct elements
		 * (duplicates removed) of this stream.
		 * sorted(): Returns a stream consisting of the elements of this 
		 * stream, sorted according to natural order (if elements are 
		 * comparable).
		 * sorted(Comparator): Returns a stream consisting of the elements
		 * of this stream, sorted according to the provided comparator.
		 * peek(Consumer): Returns a stream consisting of the elements of 
		 * this stream, performing an action on each element (primarily for
		 * debugging).
		 * limit(long maxSize): Returns a stream consisting of the elements
		 * of this stream, truncated to be no longer than maxSize in length.
		 * skip(long n): Returns a stream consisting of the remaining 
		 * elements of this stream after skipping the first n elements.  
		 */
		/* Q28) what are collectors and explain its methods
		 * 
		 * In Java, Collectors is a utility class that provides 
		 * implementations for reduction operations on streams. It's 
		 * primarily used with the Stream.collect() method to transform 
		 * stream elements into various data structures like lists, sets, 
		 * maps, or strings. Essentially, Collectors allows you to perform
		 * operations like grouping, summarizing, or converting stream 
		 * elements into a desired output format. 
		 * 
		 * toList()/toSet()/toMap(): Collects stream elements into a List/
		 * Set/Map.
		 * joining(): Concatenates stream elements into a single String.
		 * groupingBy(): Groups stream elements based on a classifier 
		 * function.
		 * counting(): Counts the elements.
		 * joining(): String concatenation.
		 * partitioningBy(predicate): Partitions elements into two groups 
		 * based on a Predicate, returning a Map<Boolean, List<T>>.
		 * summingInt()/summingLong()/summingDouble(): Calculate the sum of
		 * numeric values from stream elements.
		 * averagingInt(), averagingLong(), averagingDouble(): Calculate the
		 * average of numeric values from stream elements.
		 * minBy(), maxBy(): Find the minimum or maximum element based on a
		 * comparator.
		 * collectingAndThen(): Applies a further transformation to the 
		 * result of a collector. (toUnmodifiableList(), toUnmodifiableSet(),
		 * toUnmodifiableMap(): Return unmodifiable (immutable) collections
		 * from the stream.)
		 */
		/* Q29) What are the pre-defined packages are there?
		 * 
		 * java.lang/.util/.net/.awt/.io/.sql/.time/.math/.security
		 */
		/* Q30) How to remove duplicates in ArrayList? What are the ways 
		 * available?
		 */
		
		List<Integer> lstD = Arrays.asList(1, 2, 3, 3, 2, 1);
		lstD = lstD.stream().distinct().toList();
		Set<Integer> SetA = lstD.stream().collect(Collectors.toSet());
		lstD = SetA.stream().toList();
	}
}