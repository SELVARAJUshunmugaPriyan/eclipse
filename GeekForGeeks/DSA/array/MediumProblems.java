package array;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import array.utility.TriConsumerLocale;

@SuppressWarnings("unused")
public class MediumProblems {
	
	private static final boolean DEBUG = true;
	
	void rearrangeArray(int[] arr, double nestd4) 
	{
		if (DEBUG) System.out.printf("In rearrangeArray(int[]=%s,nstd4)\n",
				Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length; j++)
				if (arr[j] == i) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
		
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != i)
				arr[i] = -1;
	}
	
	void rearrangeArray(int[] arr, int tempArr)
	{
		if (DEBUG) System.out.printf("In rearrangeArray(int[]=%s,temp▯)\n",
				Arrays.toString(arr));
		
		int temp[] = new int[arr.length];
		Arrays.fill(temp, -1);
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1)
				temp[arr[i]] = arr[i];
		}
		
		System.arraycopy(temp, 0, arr, 0, arr.length);
	}
	
	void rearrangeArray(int[] arr, short stayIfCorrect)
	{
		if (DEBUG) System.out.printf("In rearrangeArray(int[]=%s,stayIfCorrect)\n",
				Arrays.toString(arr));
		
		int i = 0;
		
		while (i < arr.length) {
			if (arr[i] != -1 && arr[i] != arr[arr[i]]) {
				int temp = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = temp;
			} else
				i++;
		}

	}
	
	int maximumCircularSubarray(int[] arr, float genAllPos)
	{
		if (DEBUG) System.out.printf("In maximumCircularSubarray(int[]=%s,genAllPos)\n",
				Arrays.toString(arr));
		
		int res = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0, sum = 0; j < arr.length; j++) {
				int idx = (i + j) % arr.length;
				sum = sum + arr[idx];
				res = Math.max(res, sum);
			}
		}
		
		return res;
	}
	
	int maximumCircularSubarray(int[] arr, int kadanes)
	{
		if (DEBUG) System.out.printf("In maximumCircularSubarray(int[]=%s,kadanes)\n",
				Arrays.toString(arr));
		
		int totalSum = 0;
		int currMaxSum = 0, currMinSum = 0;
		int maxSum = arr[0], minSum = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			// Kadane's to find maximum sum subarray
			currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
			maxSum = Math.max(maxSum, currMaxSum);
			
			// Kadane's to find minimum sum subarray
			currMinSum = Math.min(currMinSum + arr[i], arr[i]);
			minSum = Math.min(minSum, currMinSum);
			
			// Sum of all elements of input array
			totalSum += arr[i];
		}
		
		int normalSum = maxSum;
		int circularSum = totalSum - minSum;
		
		// If the minimum subarray is equal to total Sum
		// then we just need to return normalSum
		if (minSum == totalSum) {
			return normalSum;
		}
		
		return Math.max(normalSum, circularSum);
	}
	
	void reorderAnArray(int[] arr, int[] index, short sort)
	{
		if (DEBUG) System.out.printf("In reorderAnArray(int[]=%s,int[]=%s,A↓z)\n",
				Arrays.toString(arr), Arrays.toString(index));
		
		if (arr.length == 0 || arr.length != index.length)
			return;
		
		List<int[]> paired = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++)
			if (index[i] >= arr.length)
				return;
			else
				paired.add(new int[] {index[i], arr[i]});
		
		Collections.sort(paired, (a, b) -> Integer.compare(a[0], b[0]));
		
		for (int i = 0; i < paired.size(); i++)
			arr[i] = paired.get(i)[1];
	}
	
	void reorderAnArray(int[] arr, int[] index, float auxillary)
	{
		if (auxillary == 1)
		if (DEBUG) System.out.printf("In reorderAnArray(int[]=%s,int[]=%s,[]->[])\n",
				Arrays.toString(arr), Arrays.toString(index));
		
		if (arr.length == 0)
			return;
		
		int tmp[] = new int[arr.length], i = 0;

//		for (int i = 0; i < arr.length; i++)
//			reordered[index[i]] = arr[i];
		
		for (int j : index)
			if (j >= arr.length)
				return;
			else
				tmp[j] = arr[i++];
		
		if (i != arr.length)
			return;
		
		System.arraycopy(tmp, 0, arr, 0, arr.length);
	}
	
	void reorderAnArray(int[] arr, int[] index, double cyclicSort)
	{
		if (DEBUG) System.out.printf("In reorderAnArray(int[]=%s,int[]=%s,🛞A↓z)\n",
				Arrays.toString(arr), Arrays.toString(index));
		
		if (arr.length == 0 || arr.length != index.length)
			return;
		
		int i = 0;
		TriConsumerLocale<int[], Integer, Integer> swap = (x, y, z) -> {
			int temp = x[y];
			x[y] = x[z];
			x[z] = temp;
		};
		
		for (int j : index)
			if (j >= arr.length)
				return;
		
		while (i < arr.length)
			if (i != index[i]) {
				swap.accept(arr, i, index[i]);
				swap.accept(index, i, index[i]);
			}
			else
				i++;	
	}

	void reorderAnArray(int[] arr, int[] index, int mathFormula)
	{
		if (DEBUG) System.out.printf("In reorderAnArray(int[]=%s,int[]=%s,'x+y=z')\n",
				Arrays.toString(arr), Arrays.toString(index));
		
		if (arr.length == 0 || arr.length != index.length)
			return;
		
		for (int j : index)
			if (j >= arr.length)
				return;
		
		int value = Integer.MIN_VALUE;
		for (int i : arr)
			if (i > value)
				value = i;
		
		value++;
		
		for (int i = 0; i < arr.length; i++)
			arr[index[i]] += (arr[i] % value) * value;
		
		for (int i = 0; i < arr.length; i++)
			arr[i] /= value;
	}
	
	int[] productExceptSelf(int[] arr, float nstd4)
	{
		if (DEBUG) System.out.printf("In productExceptSelf(int[]=%s,nstd4)\n",
				Arrays.toString(arr));
		
		if (arr.length > 1) {
			int res[] = new int[arr.length];
			
//			Arrays.fill(res, 1);
			
			for (int i = 0; i < arr.length; i++)
				for (int j = 0; j < arr.length; j++)
					if ((j == 0 && i != 0) || (j == 1 && i == 0))
						res[i] = arr[j];
					else if (j != i)
						res[i] *= arr[j];
			
			return res;
		}
		
		return new int[] {};
	}
	
	int[] productExceptSelf(int[] arr, double prefSuffPdt)
	{
		if (DEBUG) System.out.printf("In productExceptSelf(int[]=%s,→x←*)\n",
				Arrays.toString(arr));
		
		if (arr.length > 1) {
			int n = arr.length;
			int[] res = new int[n], 
				  prf = new int[n], 
				  suf = new int[n];
			
			prf[0] = 1;
			for(int i = 1; i < n; i++)
				prf[i] = arr[i - 1] * prf[i - 1];
			
			suf[n - 1] = 1;
			for(int i = n - 2; i >= 0; i--)
				suf[i] = arr[i + 1] * suf[i + 1];
			
			for (int i = 0; i < arr.length; i++)
				res[i] = prf[i] * suf[i];
			
			return res;
		}
		
		return new int[] {};
	}
	
	int[] productExceptSelf(int[] arr, int prdArr)
	{
		if (DEBUG) System.out.printf("In productExceptSelf(int[]=%s,*[])\n",
				Arrays.toString(arr));
		
		if (arr.length > 1) {
			
			int zeroes = 0, prd = 1, idx = -1, res[] = new int[arr.length];
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0) {
					zeroes++;
					idx = i;
				} else
					prd *= arr[i];
				
				if (zeroes > 1)
					return res;
			}
			
			if (zeroes == 0)
				for (int i = 0; i < arr.length; i++)
					res[i] = prd / arr[i];
			else
				res[idx] = prd;
			
			return res;
		}
		
		return new int[] {};
	}
	
	Integer kthLargestSum(int[] arr, int k, float genAll)
	{
		if (DEBUG) System.out.printf("In kthLargestSum(int[]=%s,int=%d,gen!)\n",
				Arrays.toString(arr), k);
		
		int n = arr.length;
		
		if (!(k > n * (n + 1) / 2 || k < 0 || n == 0)) {
			
			Integer res[] = new Integer[n * (n + 1) / 2], i = 0;
			
			for (int j = 0; j < n; j++)
				for (int l = j, sum = arr[j]; l < n; sum += ++l < n ? arr[l] : 0)
					// This loop needs to run j..n-1 times or n times at max
					// The sum needs to be added for elements withing n
					res[i++] = sum;
			
			Arrays.sort(res, Comparator.reverseOrder());
			
			k = k == 0 ? 1 : k;
			return res[k - 1];
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		
//		modifyArrayTest();
//		maximumCircularSubarrayTest();
//		reorderAnArrayTest();
//		productExceptSelfTest();
		kthLargestSumTest();
	}

	private static void modifyArrayTest()
	{
//		double opt = 1;
//		int opt = 1;
		short opt = 1;
		
		int res[] = new int[] {-1, -1, 1, 8, 3, 2, -1, 4, -1};
		new MediumProblems().rearrangeArray(res, opt);
		assert Arrays.equals(res, new int[] {-1, 1, 2, 3, 4, -1, -1, -1, 8});
		
		System.out.println(Arrays.toString(res));
		
		res = new int[] {-1, -1, 1, 6, 9, 3, 2, -1, 4, -1};
		new MediumProblems().rearrangeArray(res, opt);
		assert Arrays.equals(res, new int[] {-1, 1, 2, 3, 4, -1, 6, -1, -1, 9});
		
		System.out.println(Arrays.toString(res));
		
		res = new int[] {-1, 2, -1, 1, 3};
		new MediumProblems().rearrangeArray(res, opt);
		assert Arrays.equals(res, new int[] {-1, 1, 2, 3, -1});
		
		System.out.println(Arrays.toString(res));
	}
	
	private static void maximumCircularSubarrayTest()
	{
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		int arr[] = {8, -8, 9, -9, 10, -11, 12};
		assert new MediumProblems().maximumCircularSubarray(arr, opt) == 22;
		System.out.println(new MediumProblems().maximumCircularSubarray(arr, opt));
		
		arr = new int[] {4, -1, -2, 3};
		int res = new MediumProblems().maximumCircularSubarray(arr, opt);
		assert res == 7;
		System.out.println(res);
		
		arr = new int[] {5, -2, 3, 4};
		res = new MediumProblems().maximumCircularSubarray(arr, opt);
		assert res == 12;
		System.out.println(res);
	}
	
	private static void reorderAnArrayTest()
	{
//		short opt = 1;
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		int[] arr = {10, 11, 12}, index = {1, 0, 2};
		new MediumProblems().reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {11, 10, 12});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {1, 2, 3, 4};
		index = new int[] {3, 2, 0, 1};
		new MediumProblems().reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {3, 4, 2, 1});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {50, 40, 70, 60, 90};
		index = new int[] {3, 0, 4, 1, 2};
		new MediumProblems().reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {40, 60, 90, 50, 70});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {};
		index = new int[] {1};
		new MediumProblems().reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {2};
		index = new int[] {1};
		new MediumProblems().reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {2});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {2, 3};
		index = new int[] {1};
		new MediumProblems().reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {2, 3});
		System.out.println(Arrays.toString(arr));
	}
	
	private static void productExceptSelfTest()
	{
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		int arr[] = new MediumProblems().productExceptSelf(new int[] {10, 3, 5, 6, 2}, opt);
		assert Arrays.equals(arr, new int[] {180, 600, 360, 300, 900});
		System.out.println(Arrays.toString(arr));
		
		arr = new MediumProblems().productExceptSelf(new int[] {12, 0}, opt);
		assert Arrays.equals(arr, new int[] {0, 12});
		System.out.println(Arrays.toString(arr));
		
		arr = new MediumProblems().productExceptSelf(new int[] {}, opt);
		assert Arrays.equals(arr, new int[] {});
		System.out.println(Arrays.toString(arr));		
	}
	
	private static void kthLargestSumTest()
	{
		float opt = 1;
//		double opt = 1;
//		int opt = 1;
		
		Integer res = new MediumProblems().kthLargestSum(new int[] {20, -5, -1}, 3, opt);
		assert res == 14;
		System.out.println(res);
		
		res = new MediumProblems().kthLargestSum(new int[] {10, -10, 20, -40}, 6, opt);
		assert res == -10;
		System.out.println(res);
		
		res = new MediumProblems().kthLargestSum(new int[] {1}, 2, opt);
		assert res == null;
		System.out.println(res);
		
		res = new MediumProblems().kthLargestSum(new int[] {}, 1, opt);
		assert res == null;
		System.out.println(res);
		
		res = new MediumProblems().kthLargestSum(new int[] {1, 2, 3}, 0, opt);
		assert res == 6;
		System.out.println(res);
	}
	
}