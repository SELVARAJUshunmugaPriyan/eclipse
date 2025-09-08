package array;

import java.util.Arrays;

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

	public static void main(String[] args) {
		
//		modifyArrayTest();
		maximumCircularSubarrayTest();
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
	
}
