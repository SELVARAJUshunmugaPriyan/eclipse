package javaCollectionExercises;

import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class ComparingCollections {

	public static void main(String[] args) {
		
//		new Comparing2ArrayLists();
//		Comparing2ArrayLists.usingEquals();
//		new Compare2Array();
		ComparingHashSet.sort();
	}

}

// Java class to compare two
// ArrayList
class Comparing2ArrayLists
{
	// Using '==' in a loop
	Comparing2ArrayLists()
	{
		// Creating a random list
		List<Integer> list = Arrays.stream(
				javaArrayExcercises.BubbleSort.getRandomArray(
				new Scanner(System.in))).boxed().collect(
						Collectors.toList());
		
		// Copying list to a ArrayList
		List<Integer> al = new ArrayList<>(list);
//		al.remove(0);
		
		// Comparing each element in both list
		if (list.size() != al.size()) {
			System.out.println("Inequal ArrayLists");
			return;
		}
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i) != al.get(i)) {
				System.out.println("Inequal ArrayLists");
				return;
			}
		
		System.out.println("Equal ArrayLists");
	}
	
	// using equals() method
	static void usingEquals()
	{
		// Create two ArrayLists
		ArrayList<Integer> al1 = new ArrayList<>(
				Arrays.asList(1, 2, 3, 4, 5));
		ArrayList<Integer> al2 = new ArrayList<>(
				Arrays.asList(1, 2, 3, 4, 5));
		
		// Displaying both ArrayLists
		System.out.println("ArrayList1 = " + al1 
				+ "\nArrayList2 = " + al2);
		
		// Compare them
		System.out.println(al1.equals(al2) ? "ArrayLists are equal"
				: "ArrayLists are not equal");
		
		// Insert one more element in ArrayList
		al1.add(6);
		
		// Displaying both ArrayLists
		System.out.println("ArrayList1 = " + al1 
				+ "\nArrayList2 = " + al2);
		
		// Compare them again
		System.out.println(al1.equals(al2) ? "ArrayLists are equal"
				: "ArrayLists are not equal");
	}
}

// Comparing two arrays
// using Arrays.equals()
class Compare2Array implements Comparator<Integer>
{
	static {
//		compare2Array();
		compare2ArrayWithComparator();
	}
	
	static void compare2Array()
	{
		int[] A = {1, 2, 3, 4, 5}, B = {1, 2, 3, 4, 5};
		System.out.println("Arrays are " + 
				(Arrays.equals(A, B) ? "equal" : "not equal"));
	}
	
	static void compare2ArrayWithComparator()
	{
		Integer[] C = {1, 2, 3, 4, 5}, D = {0, 1, 2, 3, 4};
		System.out.println("Arrays are " + 
				(Arrays.equals(C, D, new Compare2Array()) ?
						"equal" : "not equal"));
	}
	
	@Override
	public int compare(Integer a, Integer b)
	{
		return b > a ? 1 : 0;
	}
	
}

class ComparingHashSet
{
	static void sort()
	{
		Set<String> set = new HashSet<>(Arrays
				.asList("Geeks", "For", "ForGeeks",
						"GeeksForGeeks"));
		
		// Using Collections with List
//		List<String> sortedSet = new ArrayList<>(set);
//		Collections.sort(sortedSet);
//		System.out.println(sortedSet);
		
		// Using brute-force
//		List<String> sortedSet = stringSortAlphaNumero(set);

		// Using TreeSet
		Set<String> sortedSet = new TreeSet<>(set);
		
		System.out.println(sortedSet);
	}
	
	static List<String> stringSortAlphaNumero(Set<String> set)
	{
		List<String> list = new ArrayList<>();
		
		for (String s : set) {
			String t = s.toLowerCase();
			boolean isAdded = false, isSame = false;
			int size = list.size();
			for (int i = 0; i < size; i++) {
				String u = list.get(i).toLowerCase();
				int limit = t.length() < u.length() ? t.length() : u.length();
				for (int j = 0; j < limit; j++)
					if (t.charAt(j) == u.charAt(j))
						isSame = true;
					else if (t.charAt(j) < u.charAt(j)) {
						isSame = false;
						list.add(i, s);
						isAdded = true;
						break;
					} else {
						isSame = false;
						break;
					}
				if (isAdded)
					break;
				if (isSame && s.length() == limit) {
					list.add(i, s);
					isAdded = true;
					break;
				}
			}
			if (!isAdded)
				list.add(s);
		}
		
		return list;
	}
}
