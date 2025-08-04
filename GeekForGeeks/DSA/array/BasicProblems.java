package array;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import array.utility.ReturnThroughException;

import java.util.ArrayList;
import javaArrayExcercises.BubbleSort;

@SuppressWarnings("unused")
public class BasicProblems extends BasicProblemsSuper {

	private static final boolean DEBUG = true;
	
	private static int linearSearch(int arr[], int key)
	{
		if (DEBUG) System.out.printf("In linearSearch(int[]=%s,int=%d)\n",
						   Arrays.toString(arr), key);
		
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == key)
				return i;
		
		return -1;
	}
	
	@Override
	int binarySearch(int arr[], int key, boolean callSuper)
	{
		if (callSuper)
			return super.binarySearch(arr, key, callSuper);
		
		if (DEBUG) System.out.printf("In binarySearch(int[]=%s,int=%d,bl=%s)\n",
						   Arrays.toString(arr), key, callSuper);
		
		Arrays.sort(arr);
		
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (DEBUG) System.out.println(arr[mid]);
			
			if (arr[mid] == key)
				return 1;
			else if (arr[mid] > key)
				high = --mid;
			else
				low = ++mid;
		}
		
		return -1;
	}
	
	@Override
	int fibonacciSearch(int arr[], int key, boolean callSuper)
	{
		if (callSuper)
			return super.fibonacciSearch(arr, key, callSuper);
			
		if (DEBUG) System.out.printf("In fibonacciSearch(int[]=%s,int=%d,bl=%s)\n",
						   Arrays.toString(arr), key, callSuper);
		
		Arrays.sort(arr);
		
		int fibMMm2 = 0, fibMMm1 = 1, fibM = fibMMm1 + fibMMm2, n = arr.length, offset = -1;
		
		while (fibM < n) {
			fibMMm2 = fibMMm1;
			fibMMm1 = fibM;
			fibM = fibMMm2 + fibMMm1;
		}
		
		while (fibM > 1) {
			int i = Math.min(offset + fibMMm2, n - 1);
			if (arr[i] < key) {
				fibM = fibMMm1;
				fibMMm1 = fibMMm2;
				fibMMm2 = fibM - fibMMm1;
				offset = i;
			} else if (arr[i] > key) {
				fibM = fibMMm2;
				fibMMm1 = fibMMm1 - fibMMm2;
				fibMMm2 = fibM - fibMMm1;
			} else
				return 1;
		}
		
		if (fibMMm1 == 1 && arr[n - 1] == key) {
			return 1;
		}
		
		return -1;
	}
	
	private static void printAlternate(int arr[])
	{
		if (DEBUG) System.out.printf("In printAlternate(int[]=%s)\n", 
				Arrays.toString(arr));
		
		boolean flip = false;
		for (int i : arr)
			if (flip = !flip)
				System.out.print(i + " ");
	}
	
	private static void printAlternate(int arr[], int idx)
	{
		if (DEBUG) System.out.printf("In printAlternate(int[]=%s,int=%d)\n", 
				Arrays.toString(arr), idx);
		
		if (idx < arr.length) {
			if ((idx & 1) == 0)
				System.out.println(arr[idx]);
			printAlternate(arr, idx + 2);
		}
	}
	
	private static List<Integer> printAlternate(Integer arr[])
	{
		if (DEBUG) System.out.printf("In printAlternate(Int[]=%s)\n", 
				Arrays.toString(arr));
		
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < arr.length; i += 2)
			res.add(arr[i]);
		
		return res;
	}
	
	private static void printAlternate(Integer arr[], Integer idx, List<Integer> res)
	{
		if (DEBUG) System.out.printf("In printAlternate(Int[]=%s,Int=%d,L<I>=%s)\n", 
				Arrays.toString(arr), idx, res);
		
		if (idx < arr.length) {
			res.add(arr[idx]);
			printAlternate(arr, idx + 2, res);
		}
	}
	
	@Override
	List<Integer> leaders(int arr[], boolean callSuper)
	{
		if (callSuper)
			return super.leaders(arr, callSuper);
		
		if (DEBUG) System.out.printf("In leaders(int[]=%s,bl=%s)\n", 
				Arrays.toString(arr), callSuper);
		
		List<Integer> res = new ArrayList<>();
		
		for (int i = arr.length - 1, max = Integer.MIN_VALUE; i >= 0; i--)
			if (arr[i] > max) {
				res.addFirst(arr[i]);
				max = arr[i];
			}
		
		return res;
	}
	
	@Override
	boolean isSorted(int arr[], int idx, boolean callSuper)
	{
		if (callSuper)
			return super.isSorted(arr, arr.length, callSuper);
		
		if (DEBUG) System.out.printf("In isSorted(int[]=%s,int=%d,bl=%s)\n", 
				Arrays.toString(arr), idx, callSuper);
		
		if (idx == arr.length - 1)
			return true;
		
		if (idx == 0) {
			arr[0] = arr[0] - arr[1];
			return isSorted(arr, ++idx, callSuper);
		}
		
		if ((arr[0] > 0  && arr[idx] >= arr[idx + 1]) ||
			(arr[0] < 0  && arr[idx] <= arr[idx + 1]))
			return isSorted(arr, ++idx, callSuper);
		
		return false;
	}
	
	@Override
	boolean isSorted(int arr[], boolean callSuper)
	{
		if (callSuper)
			return super.isSorted(arr, callSuper);
			
		if (DEBUG) System.out.printf("In isSorted(int[]=%s,bl=%s)\n",
						   Arrays.toString(arr), callSuper);
		
		int i = 0;
		while (arr[i] == arr[i + 1])
			i++;
		
		if (arr[i] > arr[i + 1]) {
			while (i < arr.length - 1 && arr[i] >= arr[i + 1])
				i++;
			if (i < arr.length - 1)
				return false;
		}
		
		while (i < arr.length - 1 && arr[i] <= arr[i + 1])
			i++;
		if (i < arr.length - 1)
			return false;
		
		return true;
	}
	
	@Override
	List<Integer> removeDuplicates(int arr[], boolean callSuper)
	{
		if (callSuper)
			return super.removeDuplicates(arr, callSuper);
			
		if (DEBUG) System.out.printf("In removeDuplicates(int[]=%s,bl=%s)\n",
							Arrays.toString(arr), callSuper);
		
		List<Integer> res = new ArrayList<>();
		
		for (int i : arr)
			if (!res.contains(i))
				res.add(i);
		
		return res;
	}
	
	private static int[] removeDuplicates(int arr[])
	{
		if (DEBUG) System.out.printf("In removeDuplicates(int[]=%s)\n",
							Arrays.toString(arr));
		
		int tmp[] = new int[arr.length], idx = 0;
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] != arr[i + 1])
				tmp[idx++] = arr[i];
		
		if (tmp[idx - 1] != arr[arr.length - 1])
			tmp[idx++] = arr[arr.length - 1];
		
		return Arrays.copyOf(tmp, idx);
	}
	
	List<List<Integer>> genSubArray(int arr[])
	{
		if (DEBUG) System.out.printf("In genSubArray(int[]=%s)\n",
				   Arrays.toString(arr));
		
		List<List<Integer>> res = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++)
			for (int j = i; j < arr.length; j++) {
				List<Integer> list = new ArrayList<>();
				
				for (int k = i; k <= j; k++)
					list.add(arr[k]);
				
				res.add(list);
			}
		
		return res;
	}
	
	@Override
	void genSubArray(int arr[], int start, int end,
			List<List<Integer>> res, boolean callSuper)
	{
		if (callSuper) {
			super.genSubArray(arr, start, end, res, callSuper);
			return;
		}
		
		if (DEBUG) System.out.printf("In genSubArray(int[]=%s,int=%d,int=%d,L<L<I>>=%s,"
				+ "bl=%s)\n", Arrays.toString(arr), start, end, res, callSuper);
		
		List<Integer> temp = new ArrayList<>();
		
		for (int i = start; i <= end; i++)
			temp.add(arr[i]);
		
		res.add(temp);
		
		if (end < arr.length - 1)
			genSubArray(arr, start, ++end, res, callSuper);
		
		if (start < arr.length - 1)
			genSubArray(arr, ++start, start, res, callSuper);
		
		throw new ReturnThroughException(null);	
	}
	
	private static void reverse(int arr[])
	{		
		if (DEBUG) System.out.printf("In reverse(int[]=%s)\n", Arrays.toString(arr));
		
		int temp[] = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++)
			temp[i] = arr[arr.length - 1 - i];
		
		System.arraycopy(temp, 0, arr, 0, arr.length);
	}
	
	private static void reverse(int arr[], int twoPointer)
	{		
		if (DEBUG) System.out.printf("In reverse(int[]=%s,2Ptr)\n", Arrays.toString(arr));
		
		int left = 0, right = arr.length - 1;
		
		while (left < right) {
			arr[left] = arr[left] ^ arr[right];
			arr[right] = arr[left] ^ arr[right];
			arr[left] = arr[left++] ^ arr[right--];
		}
	}
	
	private static void reverse(int arr[], float swappingElements)
	{		
		if (DEBUG) System.out.printf("In reverse(int[]=%s,swap)\n", Arrays.toString(arr));
		
		int i = 0, n = arr.length;
		
		while (i < n / 2) {
			arr[i] = arr[i] ^ arr[n - 1 - i];
			arr[n - 1 - i] = arr[i] ^ arr[n - 1 - i];
			arr[i] = arr[i] ^ arr[n - 1 - i++];
		}
	}
	
	private static void reverse(int arr[], int start, int end)
	{		
		if (DEBUG) System.out.printf("In reverse(int[]=%s,int=%d,int=%d)\n",
						   Arrays.toString(arr), start, end);
		
		if (start >= end)
			return;
		
		arr[start] = arr[start] ^ arr[end];
		arr[end] = arr[start] ^ arr[end];
		arr[start] = arr[start++] ^ arr[end--];
		
		reverse(arr, start, end);
	}
	
	private static void reverse(int arr[], double builtIn)
	{		
		if (DEBUG) System.out.printf("In reverse(int[]=%s,blt)\n", Arrays.toString(arr));
		
//		List<Integer> list = Arrays.stream(arr)
//								   .boxed()
//								   .collect(java.util.stream.Collectors.toList());
//		java.util.Collections.reverse(list);
//		System.arraycopy(list.stream().mapToInt(Integer::intValue).toArray(), 0, arr, 0, arr.length);
		System.arraycopy(
				java.util.stream.IntStream.range(0, arr.length)
										  .map(i -> arr[arr.length - 1 - i])
										  .toArray(), 0, arr, 0, arr.length);
	}
	
	private static void rotate(int arr[], int d)
	{
		if (DEBUG) System.out.printf("In reverse(int[]=%s,int=%d)\n", Arrays.toString(arr), d);
		
		for (int i = 0; i < d; i++) {
			int last = arr[arr.length - 1];
			
			for (int j = arr.length - 1; j > 0; j--)
				arr[j] = arr[j - 1];
			
			arr[0] = last;
		}
	}
	
	private static void rotate(int arr[], float d)
	{
		if (DEBUG) System.out.printf("In reverse(int[]=%s,flt=%.0f)\n", 
						   Arrays.toString(arr), d);
		
		d %= arr.length;
		
		int temp[] = new int[arr.length];
		
		for (int i = 0; i < d; i++)
			temp[i] = arr[arr.length - (int) d + i];
		
		for (int i = (int) d; i < arr.length; i++)
			temp[i] = arr[i - (int) d];
		
		System.arraycopy(temp, 0, arr, 0, temp.length);
	}
	
	private static void rotate(int arr[], double d)
	{
		if (DEBUG) System.out.printf("In reverse(int[]=%s,dbl=%.0f)\n", 
						   Arrays.toString(arr), d);
		
		int n = arr.length;
		java.util.function.BiFunction<Integer, Integer, Integer>
			gcd = (a, b) -> {
				while (b != 0) {
					int temp = b;
					b = a % b;
					a = temp;					
				}
				return a;
			};
		
		d %= n;
		int cycles = gcd.apply((int) d, n);
		
		for (int i = 0; i < cycles; i++) {
			int currIdx = i;
			int currEle = arr[i];
			
			do {
				int nextIdx = (currIdx + (int) d) % n;
				int nextEle = arr[nextIdx];
				arr[nextIdx] = currEle;
				currEle = nextEle;
				currIdx = nextIdx;
			} while (currIdx != i);
		}
	}
	
	private static void rotate(int arr[], long d)
	{
		if (DEBUG) System.out.printf("In reverse(int[]=%s,lng=%d)\n", 
						   Arrays.toString(arr), d);
		
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, (int) d - 1);
		reverse(arr, (int) d, arr.length - 1);
	}
	
	private static void pushBack0s(int[] arr, int temporaryArray)
	{
		if (DEBUG) System.out.printf("In reverse(int[]=%s,tmp[])\n", 
				   Arrays.toString(arr));
		
		int tmp[] = new int[arr.length], idx = 0;
		
		for (int i : arr)
			if (i != 0)
				tmp[idx++] = i;
		
		System.arraycopy(tmp, 0, arr, 0, arr.length);
	}
	
	private static void pushBack0s(int[] arr, float twoTraversals)
	{
		if (DEBUG) System.out.printf("In reverse(int[]=%s,2tvl)\n", 
				   Arrays.toString(arr));
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != 0)
				arr[count++] = arr[i];
		
		while (count < arr.length)
			arr[count++] = 0;
	}
	
	private static void pushBack0s(int[] arr, double oneTraversals)
	{
		if (DEBUG) System.out.printf("In reverse(int[]=%s,1tvl)\n", 
				   Arrays.toString(arr));
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != 0) {
				int tmp = arr[i];
				arr[i] = arr[count];
				arr[count++] = tmp;
			}
	}
	
	private static void pushBack0s(int[] arr, long stream)
	{
		if (DEBUG) System.out.printf("In reverse(int[]=%s,strm)\n", 
				   Arrays.toString(arr));
		
		System.arraycopy(
			Arrays.stream(arr)
			      .boxed()
				  .collect(java.util.stream.Collectors.groupingBy(x -> x == 0))
				  .values()
				  .stream()
				  .flatMap(x -> x.stream())
				  .mapToInt(Integer::intValue)
				  .toArray(), 0, arr, 0, arr.length);
	}
	
	private static int equalizeStepsCount(int[] arr, int k) 
	{
		if (DEBUG) System.out.printf("In equalizeStepsCount(int[]=%s,int=%d)\n", 
				   Arrays.toString(arr), k);
		int res = 0, max = Integer.MIN_VALUE;
		for (int i : arr)
			if (i > max)
				max = i;
		
		for (int i : arr) {
			if ((max - i) % k != 0)
				return -1;
			
			res += (max - i) / k;
		}
		
		return res;
	}
	
	private static int minCostToSingletonArray(int[] arr) 
	{
		if (DEBUG) System.out.printf("In minCostToSingletonArray(int[]=%s)\n", 
				   Arrays.toString(arr));
		
		int min = Integer.MAX_VALUE;
		for (int i : arr)
			if (i < min)
				min = i;
		
		return min * (arr.length - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scn = new Scanner(System.in)) {
//			System.out.println(linearSearch(BubbleSort.getRandomArray(scn), 14));
//			int array[] = BubbleSort.getRandomArray(scn, 2);
//			System.out.println("Enter the key: ");
//			int key = scn.nextInt();
//			int index = new BasicProblems().binarySearch(array, key, true);
//			int index = new BasicProblems().fibonacciSearch(array, key, true);
//			try {
//				System.out.println("Element " + array[index] + " is found at " + index 
//						+ " position");
//			} catch (ArrayIndexOutOfBoundsException e) {
//				throw new ArrayIndexOutOfBoundsException("Element " + key + " not found");
//			}
//			System.out.println(printAlternate(BubbleSort.getRandIntgrArr(scn)));
//			printAlternate(BubbleSort.getRandIntgrArr(scn), 0,
//					new ArrayList<Integer>());
//			} catch (ArrayIndexOutOfBoundsException e) {
//				if (e.getMessage().contains("not found"))
//					System.out.println(e.getMessage());
//			System.out.println(new BasicProblems().leaders(
//					BubbleSort.getRandomArray(scn), true));
//			Arrays.sort(array, 0, array.length, new Desc()::compare);
//			array = Arrays.stream(array).distinct().boxed()
//					.sorted(java.util.Comparator.reverseOrder())
//					.collect(java.util.stream.Collectors.toList())
//					.stream().mapToInt(Integer::intValue).toArray();
//			System.out.println(new BasicProblems().isSorted(
//					Arrays.stream(array).mapToInt(Integer::intValue).toArray(), true));
//			List<?> res = new BasicProblems().removeDuplicates(
//					new int[] {1, 1, 2, 2, 3, 3}, true);
			int res[] = removeDuplicates(new int[] {1, 1, 2, 2, 2, 3});
			assert Arrays.equals(res, new int[] {1, 2, 3}) : " Application logic error";
			System.out.println(Arrays.toString(res));
//			new BasicProblems().genSubArray(array).forEach(System.out::println);
//			List<List<Integer>> res = new ArrayList<>();
//			
//			try {
//				new BasicProblems().genSubArray(array, 0, 0, res, true);
//			} catch (ReturnThroughException e) {
//				
//			}
//
//			System.out.println(res);
//			reverse(array, 1.0);
//			rotate(array, 3l);
//			pushBack0s(array, 1l);
//			System.out.println(equalizeStepsCount(new int[] {4, 2, 6, 8}, 3));
//			System.out.println(minCostToSingletonArray(new int[] {3, 4}));
			
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}

class BasicProblemsSuper
{
	int binarySearch(int arr[], int key, boolean callSuper)
	{
		if (callSuper) System.out.printf("In binarySearch(int[]=%s,int=%d,bl=%s)\n",
				Arrays.toString(arr), key, callSuper);
		
		int digits = (int) (Math.log10(arr.length)) + 1;
		double newArr[] = new double[arr.length];
		
		// Appending original index in decimal places
		for (int i = 0; i < arr.length; i++)
			newArr[i] = arr[i] + i / Math.pow(10, digits);
		
		// Bubble sort only the integer part
		for (int i = 0; i < newArr.length - 1; i++) {
			boolean unSwapped = true;
			for (int j = 0; j < newArr.length - 1 - i; j++)
				if ((int) newArr[j] > (int) newArr[j + 1]) {
					double temp = newArr[j];
					newArr[j] = newArr[j + 1];
					newArr[j + 1] = temp;
					unSwapped = false;
				}
			
			if (unSwapped)
				break;
		}
		
		// Binary search only the integer part
		int low = 0, high = newArr.length - 1, mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			if (callSuper) System.out.println(low + " " + mid + " " + high + " " + newArr[mid]);
			
			if ((int) newArr[mid] == key)
				return (int) ((newArr[mid] - (int) newArr[mid]) *
						Math.pow(10, digits));
			else if ((int) newArr[mid] > key)
				high = --mid;
			else
				low = ++mid;
		}
		
		return -1;
	}
	
	int fibonacciSearch(int arr[], int key, boolean callSuper)
	{
		if (callSuper) System.out.printf("In fibonacciSearch(int[]=%s,int=%d,bl=%s)\n",
								Arrays.toString(arr), key, callSuper);
		
		int digits = (int) Math.log10(arr.length) + 1, n = arr.length;
		double newArr[] = new double[n];
		
		for (int i = 0; i < n; i++)
			newArr[i] = arr[i] + i / Math.pow(10, digits);
		
//		for (int i = 0; i < newArr.length; i++) {
//			boolean unSwapped = true;
//			
//			for (int j = 0; j < n - 1 - i; j++)
//				if ((int) newArr[j] > (int) newArr[j + 1]) {
//					double temp = newArr[j];
//					newArr[j] = newArr[j + 1];
//					newArr[j + 1] = temp;
//					unSwapped = false;
//				}
//			
//			if (unSwapped)
//				break;
//		}
		
		Arrays.sort(newArr);
		
		int fibMMm2 = 0, fibMMm1 = 1, fibM = fibMMm1 + fibMMm2, offset = -1;
		
		while (fibM < n) {
			fibMMm2 = fibMMm1;
			fibMMm1 = fibM;
			fibM = fibMMm1 + fibMMm2;
		}
		
		while (fibM > 1) {
			int i = Math.min(offset + fibMMm2, n - 1);
			
			if ((int) newArr[i] < key) {
				fibM = fibMMm1;
				fibMMm1 = fibMMm2;
				fibMMm2 = fibM - fibMMm1;
				offset = i;
			} else if ((int) newArr[i] > key) {
				fibM = fibMMm2;
				fibMMm1 = fibMMm1 - fibMMm2;
				fibMMm2 = fibM - fibMMm1;
			} else
				return (int) ((newArr[i] - (int) newArr[i]) * Math.pow(10, digits));
		}
		
		if (fibMMm2 == 1 && (int) newArr[n - 1] == key)
			return (int) ((newArr[n - 1] - (int) newArr[n - 1]) * Math.pow(10, digits));
		
		return -1;
	}
	
	List<Integer> leaders(int arr[], boolean callSuper)
	{		
		if (callSuper) System.out.printf("In leaders(int[]=%s,bl=%s)\n", 
				Arrays.toString(arr), callSuper);
		
		List<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			int j;
			
			for (j = i + 1; j < arr.length; j++)
				if (arr[i] <= arr[j])
					break;
			
			if (j == arr.length)
				res.add(arr[i]);
		}
		
		return res;
	}
	
	boolean isSorted(int arr[], int n, boolean callSuper)
	{
		if (callSuper) System.out.printf("In spr.isSorted(int[]=%s,int=%d,bl=%s)\n", 
				Arrays.toString(arr), n, callSuper);
		
		if (n == 1 || n == 0)
			return true;
		
		return arr[n - 1] <= arr[n - 2] && new BasicProblemsSuper().isSorted(arr, n - 1, callSuper);
	}
	
	boolean isSorted(int arr[], boolean callSuper)
	{
		if (callSuper) System.out.printf("In spr.isSorted(int[]=%s,bl=%s)\n", 
				Arrays.toString(arr), callSuper);
		
		for (int i = 1; i < arr.length; i++)
			if (arr[i - 1] > arr[i])
				return false;
		
		return true;
	}
	
	List<Integer> removeDuplicates(int arr[], boolean callSuper)
	{
		if (callSuper) System.out.printf("In spr.removeDuplicates(int[]=%s,bl=%s)\n",
							Arrays.toString(arr), callSuper);
		
		java.util.Set<Integer> res = new java.util.HashSet<>();
		
		for (int i : arr)
			res.add(i);
		
		return res.stream().toList();
	}
	
	
	void genSubArray(int arr[], int start, int end,
			List<List<Integer>> res, boolean callSuper)
	{
		if (callSuper) System.out.printf("In spr.genSubArray(int[]=%s,int=%d,int=%d,"
				+ "L<L<I>>=%s,bl=%s)\n", Arrays.toString(arr), start, end, res, callSuper);
		
		if (end == arr.length)
			return;
		
		if (start > end)
			new BasicProblemsSuper().genSubArray(arr, 0, end + 1, res, callSuper);
		else {
			List<Integer> subset = new ArrayList<>();
			
			for (int i = start; i <= end; i++)
				subset.add(arr[i]);
			
			res.add(subset);
			
			new BasicProblemsSuper().genSubArray(arr, start + 1, end, res, callSuper);
		}
			
//		return;	
	}
}

class Desc implements java.util.Comparator<Integer>
{
	@Override
	public int compare(Integer a, Integer b)
	{
//		return b - a;
//		return a - b;
		return 0;
	}
	
}