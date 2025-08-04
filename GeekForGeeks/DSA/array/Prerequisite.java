package array;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

import array.utility.BiFunctionLocale;
import array.utility.Recursive;
import array.utility.ReturnThroughException;

@SuppressWarnings("unused")
public class Prerequisite {

	private static final boolean DEBUG = true;
	
	int binarySearch(int[] arr, int key)
	{
		if (DEBUG) System.out.printf("In binarySearch(int[]=%s,int=%d)\n",
				Arrays.toString(arr), key);
		
		int low = 0, high = arr.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		return -1;
	}
	
	int binarySearch(int[] arr, int low, int high, int key)
	{
		if (DEBUG) System.out.printf("In binarySearch(int[]=%s,int=%d,int=%d,int=%d)\n",
				arr.length > 10 ? "{large array}" : 
				Arrays.toString(arr) , low, high, key);
		
		if (high >= low) {		
			int mid = (low + high) / 2;
			
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key)
				return binarySearch(arr, low, mid - 1, key);
			else
				return binarySearch(arr, mid + 1, high, key);
		}
		
		return -1;
	}
	
	// FIXME
	void selectionSort(int arr[], int i, int j)
		throws ReturnThroughException
	{
		if (DEBUG) System.out.printf("In selectionSort(int[]=%s,int=%d,int=%d)\n",
				arr.length > 25 ? "{large array}" : Arrays.toString(arr), i, j);
		
		if (i == arr.length)
			throw new ReturnThroughException("Exited");
			
		if (j < arr.length) {
			if (arr[j] < arr[i]) {
				swap(arr, i, j);
			}
			
			selectionSort(arr, i, j + 1);
		}
		
		selectionSort(arr, i + 1, i + 1);
		
	}
	
	void insertionSort(int arr[])
	{
		if (DEBUG) System.out.printf("In insertionSort(int[]=%s)\n",
				arr.length > 25 ? "{large array}" : Arrays.toString(arr));
		
		for (int i = 0, j = i; i < arr.length; i++, j = i)
			while (j > 0 && arr[j] < arr[j - 1])
					swap(arr, j, j-- - 1);
	}
	
//	void quickSort(int arr[], int start, int pivot, int end)
//	{
//		if (DEBUG) System.out.printf("In quickSort(int[]=%s,int=%d,int=%d,int=%d)\n",
//				arr.length > 25 ? "{large array}" : Arrays.toString(arr) , start, pivot, end);
//		
//		if (pivot == start && pivot == end)
//			return;
//		
//		int temp[] = new int[arr.length];
//		
//		
//	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		binarySearchTest();
//		selectionSortTest();
//		insertionSortTest();
//		quickSortTest();
		BinarySearchProblems.main(DEBUG);
	}
	
	private static Map<Integer, int[]> getKeyAndArray()
	{
		try (java.util.Scanner scn = new java.util.Scanner(System.in)) {
			Map<Integer, int[]> res = new HashMap<>();
			
			System.out.println("Enter a number as key : ");
			
			res.put(Integer.parseInt(scn.nextLine()),
					javaArrayExcercises.BubbleSort.getRandomArray(scn));
			
			return res;
		} catch (NumberFormatException | java.util.NoSuchElementException e) {
			System.err.println(e);
		}
		
		return null;
	}
	
	private static void swap(int[] arr, int i, int j)
	{
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	private static void binarySearchTest()
	{
		Map<Integer, int[]> map = getKeyAndArray();
		int arr[] = {};
		int key = -1;
		
		if (map != null)
			for (Integer k : map.keySet()) {
				key = k;
				arr = map.get(k);
				Arrays.sort(arr);
			}
		
//		int ans = new Prerequisite().binarySearch(arr, key);
		int ans = new Prerequisite().binarySearch(arr, 0, arr.length - 1, key);
		assert ans == Arrays.binarySearch(arr, key);
		System.out.println(ans);
	}
	
	private static void selectionSortTest()
	{
		Map<Integer, int[]> map = getKeyAndArray();
		int arr[] = {};
		int key = -1;
		
		if (map != null)
			for (Integer k : map.keySet()) {
				key = k;
				arr = map.get(k);
			}
		
		try {
			new Prerequisite().selectionSort(arr, 0, 0);
		} catch (ReturnThroughException e) {
//			e.printStackTrace();
		}
		
		assert new BasicProblems().isSorted(arr, false); // new int[] {0, 11, 9, 4, 11, 0, 6, 3, 6, 0, 8, 2}
														 // count = 91
		System.out.println(Arrays.toString(arr));
	}
	
	private static void insertionSortTest()
	{
		Map<Integer, int[]> map = getKeyAndArray();
		int arr[] = {};
		int key = -1;
		
		if (map != null)
			for (Integer k : map.keySet()) {
				key = k;
				arr = map.get(k);
			}
		
		new Prerequisite().insertionSort(arr); // count = 36
		assert new BasicProblems().isSorted(arr, false);
		System.out.println(Arrays.toString(arr));
	}
	
//	private static void quickSortTest()
//	{
//		Map<Integer, int[]> map = getKeyAndArray();
//		int arr[] = {};
//		int key = -1;
//		
//		if (map != null)
//			for (Integer k : map.keySet()) {
//				key = k;
//				arr = map.get(k);
//			}
//		
//		new Prerequisite().quickSort(arr, 0, arr.length / 2, arr.length - 1);
//		assert new BasicProblems().isSorted(arr, false);
//		System.out.println(Arrays.toString(arr));
//	}
}

@SuppressWarnings("unused")
class BinarySearchProblems extends BinarySearchProblemsSuper
{
	private static boolean DEBUG;
	
	public static void main(boolean debug)
	{
		DEBUG = debug;
		// NOTE Refer logicBuilding.MediumProblems.squareRoot;
//		System.out.println(Arrays.toString(
//				firstAndLastPositions(new int[] {0, 0, 0,                         // 3
//                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1,    // 10
//                        2, 2, 2, 2, 2, 2, 2,             // 7
//                        3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, // 20
//                        4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, 3)));
//		System.out.println(count1s(new int[] {1, 0, 0, 0}));
//		System.out.println(firstPositive(x -> x * x - 10 * x - 20));
//		System.out.println(minOfSortedRotatedArray(new int[] {5, 6, 1, 2, 3, 4}, false));
//		System.out.println(new BinarySearchProblems().searchSortedRotatedArray(new int[] 
//				{5, 6, 7, 8, 9, 10, 1, 2, 3}, 3, true));
		System.out.println(aggressiveCows(new int[] {6, 7,  9, 11, 13, 15}, 5));
	}
	
	private static int[] firstAndLastPositions(int[] arr, int k)
	{
		if (DEBUG) System.out.printf("In firstAndLastPositions(int[]=%s,int=%d)\n",
				Arrays.toString(arr), k);
		
		int first = binarySearch(arr, k, true);
		int last = binarySearch(arr, k, false);
		
		return new int[] {first, last};
	}
	
	private static int binarySearch(int[] arr, int k, boolean findFirst)
	{
		int low = 0, high = arr.length - 1, index = -1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == k) {
				index = mid;
				if (findFirst)
					high = mid - 1;
				else
					low = mid + 1;
			} else if (arr[mid] > k)
				high = mid - 1;
			else
				low = mid + 1;
		}
			
		return index;
	}
	
	private static int count1s(int arr[])
	{
		if (DEBUG) System.out.printf("In count1s(int[]=%s)\n", Arrays.toString(arr));
		
//		Arrays.sort(arr);
//		int index = 0;
//		return (index = binarySearch(arr, 1, false)) == -1 ? 0 : index -
//			   ((index = binarySearch(arr, 1, true)) == -1 ? 1 : index - 1);
		
		int low = 0, high = arr.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == 0)
				high = mid - 1;
			else if (mid == arr.length - 1 || arr[mid + 1] == 0)
				return mid + 1;
			else
				low = mid + 1;
		}
		
		return 0;
	}
	
	private static int firstPositive(Function<Integer, Integer> func)
	{
		if (DEBUG) System.out.printf("In firstPositive(func)\n");
		
		Recursive<BiFunctionLocale<Integer, Integer, Integer>> binSrch =
				new Recursive<>();
		
		binSrch.f = (low, high) -> {
			if (low <= high) {
				int mid = low + (high - low) / 2;
				if (func.apply(mid) > 0 && (mid == low || func.apply(mid - 1) <= 0))
					return mid;
				else if (func.apply(mid) <= 0)
					return binSrch.f.bifunc(mid + 1, high);
				else
					return binSrch.f.bifunc(low, mid - 1);
			}
			return -1;
		};
		
		int i = 1;
		
		while(func.apply(i) <= 0)
			i *= 2;
		
		return binSrch.f.bifunc(i / 2, i);
	}
	
	private static int minOfSortedRotatedArray(int[] arr, boolean index)
	{
		if (DEBUG) System.out.printf("In minOfSortedRotatedArray(int[]=%s,bl=%s)\n",
				Arrays.toString(arr), index);
		
		int low = 0, high = arr.length - 1;
		
		while (low < high) {
			
			if (arr[low] < arr[high])
				break;
			
			int mid = low + (high - low) / 2;
			
			if (arr[mid] <= arr[high])
				high = mid;
			else
				low = mid + 1;
		}
		
		if (index)
			return low;
		
		return arr[low];
	}
	
	@Override
	int searchSortedRotatedArray(int[] arr, int k, boolean callSuper)
	{
		if (callSuper)
			return super.searchSortedRotatedArray(arr, k, callSuper);
		
		if (DEBUG) System.out.printf("In searchSortedRotatedArray(int[]=%s,int=%d,bl=%s)\n",
				Arrays.toString(arr), k, callSuper);
		
		int minIdx = minOfSortedRotatedArray(arr, true);
		
		if (arr[minIdx] == k)
			return minIdx;
		
		int low = minIdx + 1, high = arr.length - 1;
		
		if (arr[minIdx] > arr[0]) {
			low = 0;
			high = minIdx - 1;
		}
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == k)
				return mid;
			else if (arr[mid] > k)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		return -1;
	}
	
	private static int aggressiveCows(int[] stalls, int cows)
	{
		if (DEBUG) System.out.printf("In aggressiveCows(int[]=%s,int=%d)\n",
				Arrays.toString(stalls), cows);
		
		Function<Integer, Boolean> place = dist -> {
			int cnt = 1, prev = stalls[0];
			for (int i : stalls)
				if (i - prev >= dist) {
					cnt++;
					prev = i;
				}
			return cnt >= cows;
		};
		int low = 1, high = stalls[stalls.length - 1] - stalls[0], res = -1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (!place.apply(mid))
				high = mid - 1;
			else {
				low = mid + 1;
				res = mid;
			}
		}
		
		return res;
	}
}

class BinarySearchProblemsSuper
{
	int searchSortedRotatedArray(int[] arr, int k, boolean callSuper)
	{
		if (callSuper) System.out.printf("In spr.searchSortedRotatedArray(int[]=%s,int=%d,"
				+ "bl=%s)\n", Arrays.toString(arr), k, callSuper);
		
		int low = 0, high = arr.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == k)
				return mid;
			
			if (arr[mid] <= arr[high])
				if (k > arr[mid] && k <= arr[high])
					low = mid + 1;
				else
					high = mid - 1;
			else {
				if (k >= arr[low] && k < arr[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		
		return -1;
	}
}