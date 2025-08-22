package array;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.BiConsumer;

import array.utility.BiFunctionLocale;
import array.utility.Recursive;
import array.utility.ReturnThroughException;
import array.utility.BiConsumerLocale;

@SuppressWarnings("unused")
public class Prerequisite extends PrerequisiteSuper {

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
	
	private class QuickSort
	{
		QuickSort(int arr[])
		{
			quickSortNaivePartition(arr, 0, arr.length - 1);
//			quickSortLomutoPartition(arr, 0, arr.length - 1);
//			quickSortHoarePartition(arr, 0, arr.length - 1);
		}
		
		void quickSortNaivePartition(int arr[], int start, int end)
		{
			if (DEBUG) System.out.printf("In quickSort(int[]=%s,int=%d,int=%d)\n",
					arr.length > 25 ? "{large array}" : Arrays.toString(arr) , start, end);
			
			if (start < end) {
				int temp[] = new int[end - start + 1], left = 0, right = temp.length - 1,
					count = 0;
				
				for (int i = start; i <= end; i++)
					if (arr[i] < arr[start + (end - start) / 2])
						temp[left++] = arr[i];
					else if (arr[i] == arr[start + (end - start) / 2])
						count++;
					else
						temp[right--] = arr[i];
				
				for (int i = 0; i < count; i++)
					temp[left + i] = arr[start + (end - start) / 2];
				
				System.arraycopy(temp, 0, arr, start, temp.length);
				
				quickSortNaivePartition(arr, start, --left + start);
				quickSortNaivePartition(arr, start + ++right, end);
			}
		}
		
		void quickSortLomutoPartition(int arr[], int start, int end)
		{
			if (DEBUG) System.out.printf("In quickSort(int[]=%s,int=%d,int=%d)\n",
					arr.length > 25 ? "{large array}" : Arrays.toString(arr) , start, end);
			
			BiConsumer<Integer, Integer> swap =
					(x, y) -> {
						int temp = arr[x];
						arr[x] = arr[y];
						arr[y] = temp;
					};
			
			if (start < end) {
				int i = start - 1;
				
				for (int j = start; j < end; j++)
					if (arr[j] < arr[end])
						swap.accept(j, ++i);
				swap.accept(i + 1, end);
				
				quickSortLomutoPartition(arr, start, i);
				quickSortLomutoPartition(arr, i + 2, end);
			}
		}
		
		void quickSortHoarePartition(int arr[], int start, int end)
		{
			if (DEBUG) System.out.printf("In quickSort(int[]=%s,int=%d,int=%d)\n",
					arr.length > 25 ? "{large array}" : Arrays.toString(arr) , start, end);
			
			BiConsumer<Integer, Integer> swap =
					(x, y) -> {
						int temp = arr[x];
						arr[x] = arr[y];
						arr[y] = temp;
					};
			
			if (start < end) {
				int i = start - 1, j = end + 1;
				
				while (true) {
					
					do {
						i++;
					} while (arr[i] < arr[start]);
					
					do {
						j--;
					} while (arr[j] > arr[start]);
					
					if (i >= j)
						break;
					
					swap.accept(i, j);
				}
				
				quickSortHoarePartition(arr, start, j);
				quickSortHoarePartition(arr, j + 1, end);
			}
		}
	}
	
	void mergeSort(int arr[], int start, int end)
	{
		if (DEBUG) System.out.printf("In mergeSort(int[]=%s,int=%d,int=%d)\n",
				arr.length > 25 ? "{large array}" : Arrays.toString(arr) , start, end);
		
		BiConsumer<Integer, Integer> merge = 
				(l, r) -> {
					int m = l + (r - l) / 2, n1 = m - l + 1, n2 = r - m, L[] = new int[n1],
						R[] = new int[n2], i = 0, j = 0;
					
					System.arraycopy(arr, l, L, 0, n1);
					System.arraycopy(arr, m + 1, R, 0, n2);
					
					while (i < n1 && j < n2)
						arr[l++] = L[i] <= R[j] ? L[i++] : R[j++];
					while (i < n1)
						arr[l++] = L[i++];
					while (j < n2)
						arr[l++] = R[j++];
					
				};
		
		if (start < end) {
			int m = start + (end - start) / 2;
			
			mergeSort(arr, start, m);
			mergeSort(arr, m + 1, end);
			
			merge.accept(start, end);
		}
	}
	
	void cycleSort(int[] arr, boolean callSuper)
	{
		if (callSuper) {
			super.cycleSort(arr, callSuper);
			return;
		}
			
		if (DEBUG) System.out.printf("In cycleSort(int[]=%s)\n",
				arr.length > 25 ? "{large array}" : Arrays.toString(arr) );
		
		int n = arr.length;
		
		for (int start = 0; start < n - 1; start++) {
			int item = arr[start];
			int position = start;
			
			for (int i = start + 1; i < n; i++)
				if (arr[i] < item)
					position++;
			
			if (position == start)
				continue;
			
			while (arr[position] == item)
				position++;
			
			int temp = arr[position];
			arr[position] = item;
			item = temp;
			
			while (position != start) {
				position = start;
				
				for (int i = start + 1; i < n; i++)
					if (arr[i] < item)
						position++;
				
				while (arr[position] == item)
					position++;
				
				temp = arr[position];
				arr[position] = item;
				item = temp;
			}
		}
	}
	
	void heapSort(int[] arr)
	{
		if (DEBUG) System.out.printf("In heapSort(int[]=%s)\n",
				arr.length > 25 ? "{large array}" : Arrays.toString(arr) );
		
		Recursive<BiConsumerLocale<Integer, Integer>> heapify = new Recursive<>();
		Recursive<BiConsumerLocale<Integer, Integer>> swap = new Recursive<>();
		
		swap.f = (i, j) -> {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		};
		
		heapify.f = (n, i) -> {
			int largest = i, l = 2 * i + 1, r = 2 * (i + 1);
			if (l < n && arr[l] > arr[largest])
				largest = l;
			if (r < n && arr[r] > arr[largest])
				largest = r;
			if (largest != i) {
				swap.f.accept(largest, i);
				heapify.f.accept(n, largest);
			}
		};
		
		int n = arr.length;
		
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify.f.accept(n, i);
		
 		for (int i = n - 1; i > 0; i--) {
			swap.f.accept(0, i);
			heapify.f.accept(i, 0);
		}
	}
	
	boolean twoPntr(int[] arr, int target)
	{
		if (DEBUG) System.out.printf("In twoPntr(int[]=%s,tgt=%d)\n", 
				Arrays.toString(arr), target);
		
		int left = 0, right = arr.length - 1;
		
		if (!new BasicProblems().isSorted(arr, false))
			mergeSort(arr, 0, arr.length - 1);
		
		while (left < right) {
			if (arr[left] + arr[right] == target)
				return true;
			else if (arr[left] + arr[right] > target)
				right--;
			else
				left++;
		}
		
		return false;
	}
	
	int[] prefixSum(int[] arr)
	{
		if (DEBUG) System.out.printf("In prefixSum(int[]=%s)\n", Arrays.toString(arr));
		
		int[] res = new int[arr.length];
		
		res[0] = arr[0];
		
		for (int i = 1; i < arr.length; i++)
			res[i] = arr[i] + res[i - 1];
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		binarySearchTest();
//		selectionSortTest();
//		insertionSortTest();
//		quickSortTest();
//		mergeSortTest();
//		BinarySearchProblems.main(DEBUG);
//		cycleSortTest();
//		heapSortTest();
//		twoPntrTest();
		prefixSumTest();
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
	
	private static void quickSortTest()
	{
		Map<Integer, int[]> map = getKeyAndArray();
		int arr[] = {};
		int key = -1;
		
		if (map != null)
			for (Integer k : map.keySet()) {
				key = k;
				arr = map.get(k);
			}
		
		new Prerequisite().new QuickSort(arr);
		assert new BasicProblems().isSorted(arr, false);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void mergeSortTest()
	{
		Map<Integer, int[]> map = getKeyAndArray();
		int arr[] = {};
		int key = -1;
		
		if (map != null)
			for (Integer k : map.keySet()) {
				key = k;
				arr = map.get(k);
			}
		
		new Prerequisite().mergeSort(arr, 0, arr.length - 1);
		assert new BasicProblems().isSorted(arr, false);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void cycleSortTest()
	{
		Map<Integer, int[]> map = getKeyAndArray();
		int arr[] = {};
		int key = -1;
		
		if (map != null)
			for (Integer k : map.keySet()) {
				key = k;
				arr = map.get(k);
			}
		
		new Prerequisite().cycleSort(arr, true);
		
		assert new BasicProblems().isSorted(arr, false);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void heapSortTest()
	{
		Map<Integer, int[]> map = getKeyAndArray();
		int arr[] = {};
		int key = -1;
		
		if (map != null)
			for (Integer k : map.keySet()) {
				key = k;
				arr = map.get(k);
			}
		
		new Prerequisite().heapSort(arr);
		
		assert new BasicProblems().isSorted(arr, false);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void twoPntrTest()
	{
		assert new Prerequisite().twoPntr(new int[] {10, 20, 35, 50}, 70);
		assert !new Prerequisite().twoPntr(new int[] {10, 20, 30}, 70);
		assert new Prerequisite().twoPntr(new int[] {-8, 1, 4, 6, 10, 45}, 16);
		System.out.println("true");
	}
	
	private static void prefixSumTest()
	{
		assert Arrays.equals(new Prerequisite().prefixSum(new int[] {10, 20, 10, 5, 15}),
				new int[] {10, 30, 40, 45, 60});
		assert Arrays.equals(new Prerequisite().prefixSum(new int[] {30, 10, 10, 5, 50}),
				new int[] {30, 40, 50, 55, 105});
		System.out.println("true");
	}
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

class PrerequisiteSuper {
	
	// FIXME
	void cycleSort(int[] arr, boolean callSuper) {
		
		if (callSuper) System.out.printf("In spr.cycleSort(int[]=%s)\n",
				arr.length > 25 ? "{large array}" : Arrays.toString(arr) );
		
		int i = 0, j = Arrays.stream(arr).filter(x -> x == 0).count() > 0 ? 0 : 1 ;
		
		while (i < arr.length) {
			int correctPosition = arr[i] - j;
			
			if (arr[i] <= arr.length && arr[i] != arr[correctPosition]) {
				int temp = arr[i];
				arr[i] = arr[correctPosition];
				arr[correctPosition] = temp;
			} else
				i++;
		}
	}
}