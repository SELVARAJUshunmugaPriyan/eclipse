package array;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.function.BiPredicate;

import array.utility.Recursive;
import array.utility.BiFunctionLocale;
import array.utility.TriConsumerLocale;

@SuppressWarnings("unused")
public class MediumProblems extends MediumProblemsSuper {
	
	private static final boolean DEBUG = true;
	private static final MediumProblems mediumProblems = new MediumProblems();
	
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
					// The sum needs to be added for elements within n
					res[i++] = sum;
			
			Arrays.sort(res, Comparator.reverseOrder());
			
			k = k == 0 ? 1 : k;
			return res[k - 1];
		}
		
		return null;
	}
	
	Integer kthLargestSum(int[] arr, int k, double prefSort)
	{
		if (DEBUG) System.out.printf("In kthLargestSum(int[]=%s,int=%d,+→A↓z)\n",
				Arrays.toString(arr), k);
		
		int n = arr.length;
		
		if (!(k > n * (n + 1) / 2 || k < 0 || n == 0)) {
			
			int prfxSum[] = new int[n + 1];
			
			for (int i = 1; i <= n; i++)
				prfxSum[i] = prfxSum[i - 1] + arr[i - 1];
			
			Integer res[] = new Integer[n * (n + 1) / 2], i = 0;
			
			for (int j = 0; j <= n; j++)
				for (int l = j + 1; l <= n; l++)
					res[i++] = prfxSum[l] - prfxSum[j];
			
			Arrays.sort(res, Comparator.reverseOrder());
			
			k = k == 0 ? 1 : k;
			return res[k - 1];
		}
		
		return null;
	}
	
	Integer kthLargestSum(int[] arr, int k, int minHeap)
	{
		if (DEBUG) System.out.printf("In kthLargestSum(int[]=%s,int=%d,min⛰)\n",
				Arrays.toString(arr), k);
		
		int n = arr.length;
		
		if (!(k > n * (n + 1) / 2 || k < 0 || n == 0)) {
			
			int sum[] = new int[n + 1];
			k = k == 0 ? 1 : k;
			sum[0] = 0;
			sum[1] = arr[0];
			for (int i = 2; i <= n; i++)
				sum[i] = sum[i - 1] + arr[i - 1];
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			for (int i = 1; i <= n; i++) {
				for (int j = i; j <= n; j++) {
					int x = sum[j] - sum[i - 1];
					
					if (pq.size() < k)
						pq.add(x);
					else {
						if (pq.peek() < x) {
							pq.poll();
							pq.add(x);
						}
					}
				}
			}
			
			return pq.peek();
		}
		
		return null;
	}
	
	int samllestMissingNumber(int[] arr, float binarySearch)
	{
		if (DEBUG) System.out.printf("In smallestMissingNumber(int[]=%s,[10_1])\n",
				Arrays.toString(arr));
		
		if (arr.length > 0) {
			
			if (arr[0] != 0)
				return 0;
			
			int low = 0, high = arr.length - 1;
			
			while (low <= high) {
				int mid = low + (high - low) / 2;
				
				if (arr[mid] != mid)
					if (arr[--mid] == mid)
						return ++mid;
					else
						high = mid;
				else
					low = mid + 1;
	
			}
			
			return arr.length;
		}
		
		return -1;
	}
	
	int samllestMissingNumber(int[] arr, short linearSearch)
	{
		if (DEBUG) System.out.printf("In smallestMissingNumber(int[]=%s,[--_-])\n",
				Arrays.toString(arr));
		
		if (arr.length > 0) {
			
//			if (arr[0] != 0)
//				return 0;
//			
//			for (int i = 0; i < arr.length - 1; i++)
//				if (arr[i] + 1 != arr[i + 1])
//					return arr[i] + 1;
			
			for (int i = 0; i < arr.length; i++)
				if (arr[i] != i)
					return i;
			
			return arr.length;
		}

		return -1;
	}
	
	int smallestMissingNumber(int[] arr, int start, int end, double modifiedBinarySearch)
	{
		if (DEBUG) System.out.printf("In smallestMissingNumber(int[]=%s,int=%d,int=%d,[10x1])\n",
				Arrays.toString(arr), start, end);

		if (arr.length == 0)
			return -1;
		
		if (start > end)
			return end + 1;
		
		if (arr[start] != start)
			return start;
		
		int mid = (start + end) / 2;
		
		if (arr[mid] == mid)
			return smallestMissingNumber(arr, mid + 1, end, modifiedBinarySearch);
		
		return smallestMissingNumber(arr, start, mid, modifiedBinarySearch);
	}
	
	int smallestMissingNumber(int[] arr, long recursiveBinarySearch)
	{
		if (DEBUG) System.out.printf("In smallestMissingNumber(int[]=%s,[↻10x1])\n",
				Arrays.toString(arr));

		if (arr.length == 0)
			return -1;
		
		if (arr[0] != 0)
			return 0;
		
		if (arr[arr.length - 1] == arr.length - 1)
			return arr.length;
		
		Recursive<BiFunctionLocale<int[], int[], Integer>> findFirstMissing = new Recursive<>();
		
		findFirstMissing.f = (x, y) -> {
				int start = y[0], end = y[1], first = y[2];
				if (start < end) {
					int mid = (start + end) / 2;
					if (x[mid] != mid + first)
						return findFirstMissing.f.bifunc(x, new int[] {start, mid, first});
					else
						return findFirstMissing.f.bifunc(x, new int[] {mid + 1, end, first});
				}
				return start + first;
			};
		
		int first = arr[0];
		
		return findFirstMissing.f.bifunc(arr, new int[] {0, arr.length - 1, first});
	}
	
	int smallestMissingNumber(int[] arr, int hashVector)
	{
		if (DEBUG) System.out.printf("In smallestMissingNumber(int[]=%s,#<>)\n",
				Arrays.toString(arr));

		if (arr.length == 0)
			return -1;
		
		int m = Arrays.stream(arr).max().getAsInt(), n = arr.length;
		int[] vector = new int[++m];
		
		for (int i = 0; i < n; i++) {
			vector[arr[i]] = 1;
		}
		
		for (int i = 0; i < m; i++) {
			if (vector[i] == 0) {
				return i;
			}
		}
		
		return m;
	}
	
	int smallestSubarraySum(int[] arr, int x, float nstd4)
	{
		if (DEBUG) System.out.printf("In smallestSubarraySum(int[]=%s,int=%d,nstd4)\n",
				Arrays.toString(arr), x);
		
		int smallest[] = new int[] {0, Integer.MAX_VALUE};
		
		if (arr.length > 0)
			for (int i = 0; i < arr.length - 1; i++)
				for (int j = i, sum = arr[j]; j < arr.length; j++,
						sum += arr[j == arr.length ? 0 : j])
					if (sum > x) {
						smallest[0] = 1;
						smallest[1] = Math.min(j - i + 1, smallest[1]);
						break;
					}
		
		if (smallest[0] == 0)
			return 0;
		
		return smallest[1];
	}
	
	int smallestSubarraySum(int[] arr, int x, double prefBinSrch)
	{
		if (DEBUG) System.out.printf("In smallestSubarraySum(int[]=%s,int=%d,+→10_1)\n",
				Arrays.toString(arr), x);
		
		int smallest[] = new int[] {0, Integer.MAX_VALUE}, n = arr.length;
		
		if (n > 0) {
			int[] prfxSum = new int[n + 1];
			IntStream.range(1, n + 1)
			         .forEach(i -> prfxSum[i] = prfxSum[i - 1] + arr[i - 1]);
			
			for (int i = 1; i < prfxSum.length; i++) {
				int toFind = x + prfxSum[i - 1] + 1;
				
				int bound = Arrays.binarySearch(prfxSum, toFind);
				if (bound < 0) {
					bound = -(bound + 1);
				}
				
				if (bound <= n) {
					smallest[0] = 1;
					smallest[1] = Math.min(smallest[1], bound - (i - 1));
				}
			}
		}
		
		if (smallest[0] == 0)
			return 0;
		
		return smallest[1];
	}
	
	@Override
	int smallestSubarraySum(int[] arr, int x, int twoPtr)
	{
		if (twoPtr == 1)
			return super.smallestSubarraySum(arr, x, twoPtr);
			
		if (DEBUG) System.out.printf("In smallestSubarraySum(int[]=%s,int=%d,2*)\n",
				Arrays.toString(arr), x);
		
		int smallest[] = new int[] {0, Integer.MAX_VALUE}, n = arr.length;
		
		if (n > 0) {
			int i = 0, j = 0, sum = 0;
			
			while (j < n) {
				sum += arr[j];
				while (sum > x) {
					smallest[0] = 1;
					smallest[1] = Math.min(smallest[1], j - i + 1);
					sum -= arr[i];
					i++;
				}
				j++;
			}
		}
		
		if (smallest[0] == 0)
			return 0;
		
		return smallest[1];
	}
	
	@Override
	int majorityElement(int[] arr, short nstd4)
	{
		if (nstd4 == 1)
			return super.majorityElement(arr, nstd4);
			
		if (DEBUG) System.out.printf("In majorityElement(int[]=%s,nstd4)\n",
				Arrays.toString(arr));
		
		int n = arr.length;
		
		if (n > 0) {
			return Arrays.stream(arr)
						 .boxed()
						 .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
						 .entrySet()
						 .stream()
						 .filter(x -> x.getValue() > n / 2)
						 .map(x -> x.getKey())
						 .findFirst()
						 .orElse(-1);
		}
		
		return -1;
	}
	
	int majorityElement(int[] arr, float sort)
	{
		if (sort == 1)
			return super.majorityElement(arr, sort);
			
		if (DEBUG) System.out.printf("In majorityElement(int[]=%s,A↓z)\n",
				Arrays.toString(arr));
		
		int n = arr.length;
		
		if (n > 0) {
			
			if (n == 1)
				return arr[0];
			
			Arrays.sort(arr);

			for (int i = 1, count = 1, ref = arr[0]; i < n; i++)
				if (arr[i] != ref) {
					ref = arr[i];
					count = 1;
				} else if (++count > n / 2)
					return ref;
		}
		
		return -1;
	}
	
	int majorityElement(int[] arr, double hashMap)
	{
		if (DEBUG) System.out.printf("In majorityElement(int[]=%s,#🗺)\n",
				Arrays.toString(arr));
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i : arr) {
			int freq = map.getOrDefault(i, 0) + 1;
			if (freq > arr.length / 2) return i;
			map.put(i, freq);
		}
		
		return -1;
	}
	
	int majorityElement(int[] arr, int mooreVoting)
	{
		if (DEBUG) System.out.printf("In majorityElement(int[]=%s,☑)\n",
				Arrays.toString(arr));
		
		int candidate = -1, count = 0;
		
		for (int i : arr)
			if (count == 0) {
				candidate = i;
				count = 1;
			} else if (candidate == i)
				count++;
			else
				count--;
		
		count = 0;
		for (int i : arr)
			if (candidate == i)
				count++;
		
		if (count > arr.length / 2)
			return candidate;
				
		return -1;
	}
	
	int countTriangles(int[] arr, float nstd4)
	{
		if (DEBUG) System.out.printf("In countTriangles(int[]=%s,🪹4)\n",
				Arrays.toString(arr));
		
		if (arr.length > 2) {
			int count = 0;
			for (int i = 0; i < arr.length - 2; i++)
				for (int j = i + 1; j < arr.length - 1; j++)
					for (int k = j + 1; k < arr.length; k++) {
						int a = arr[i], b = arr[j], c = arr[k];
						if (a <= 0 || b <= 0 || c <= 0)
							return -1;
						if (a + b > c && a + c > b && b + c > a)
							count++;
					}
			
			return count;		
		}
		return -1;
	}
	
	int countTriangles(int[] arr, double binarySearch)
	{
		if (DEBUG) System.out.printf("In countTriangles(int[]=%s,10🔍1)\n",
				Arrays.toString(arr));
		
		if (arr.length > 2) {
			Arrays.sort(arr);
			
			if (arr[0] <= 0)
				return -1;
			
			int count = 0;
			for (int i = 0; i < arr.length - 2; i++)
				for (int j = i + 1; j < arr.length - 1; j++) {
					int lo = j + 1, hi = arr.length, mi,
						target = arr[i] + arr[j];
					while (lo < hi) {
						mi = lo + (hi - lo) / 2;
						if (arr[mi] < target)
							lo = mi + 1;
						else
							hi = mi;
					}
					
					count += lo - j - 1;
				}
			
			return count;		
		}
		return -1;
	}
	
	int countTriangles(int[] arr, int twoPointer)
	{
		if (DEBUG) System.out.printf("In countTriangles(int[]=%s,2*)\n",
				Arrays.toString(arr));
		
		if (arr.length > 2) {
			Arrays.sort(arr);
			
			if (arr[0] <= 0)
				return -1;
			
			int count = 0;
			for (int i = 2; i < arr.length; i++) {
				int left = 0, right = i - 1;
				while (left < right) {
					if (arr[left] + arr[right] > arr[i]) {
						count += right - left;
						right--;
					} else {
						left++;
					}
				}
			}
			
			return count;		
		}
		return -1;
	}
	
	int[] subArrayWithGivenSum(int[] arr, int k, float nstd4)
	{
		if (DEBUG) System.out.printf("In subArrayWithGivenSum(int[]=%s,int=%d,🪹4)\n",
				Arrays.toString(arr), k);
		
		if (arr.length != 0) {
			for (int i = 0, n = arr.length; i < n; i++)
				for (int j = i, sum = arr[j]; j < n; j++, sum += j != n ? arr[j] : 0)
					if (sum == k)
						return new int[] {++i, ++j};
		}
		
		return new int[] {-1};
	}
	
	int[] subArrayWithGivenSum(int[] arr, int k, double slidingWindow)
	{
		if (DEBUG) System.out.printf("In subArrayWithGivenSum(int[]=%s,int=%d,▯⟶)\n",
				Arrays.toString(arr), k);
		
		if (arr.length != 0) {
			int l = 0, r = 0, res[] = new int[2];
			int curr = 0;
			for (int i = 0; i < arr.length; i++) {
				curr += arr[i];
				if (curr >= k) {
					r = i;	
					while (curr > k && l < r)
						curr -= arr[l++];
					
					if (curr == k) {
						res[0] = l + 1;
						res[1] = r + 1;
						return res;
					}
				}
			}
		}
		
		return new int[] {-1};
	}
	
	int[] subArrayWithGivenSum(int[] arr, int k, int hashingPrfSum)
	{
		if (DEBUG) System.out.printf("In subArrayWithGivenSum(int[]=%s,int=%d,#🔙Σ)\n",
				Arrays.toString(arr), k);
		
		if (arr.length != 0) {
			Map<Integer, Integer> map = IntStream.rangeClosed(0, arr.length)
												.mapToObj(i -> {
													if (i == 0)
														return "0.-1";
													if (i != 1)
														arr[0] += arr[i - 1];
													return new String (i + "." + arr[0]);
												})
												.collect(Collectors.toMap(
															s -> Integer.parseInt(s.split("\\.")[0]),
															s -> Integer.parseInt(s.split("\\.")[1])));
			
			return IntStream.rangeClosed(1, arr.length)
							.mapToObj(i -> new int[] {
									map.entrySet()
									  .stream()
									  .filter(x -> (k != 0 &&
									  			    x.getValue() == map.get(i) - k) ||
											  	   (k == 0 &&
											  	   !(x.getKey() >= i) &&
											  	    x.getValue() == map.get(i)))
									  .map(Map.Entry::getKey)
									  .min(Comparator.comparingInt(x -> x))
									  .orElse(-2) + 1, i
									 })
//							.peek(x -> System.out.println(Arrays.toString(x)))
							.filter(x -> x[0] != -1)
							.findFirst()
							.orElse(new int[] {-1});
		}
		
		return new int[] {-1};
	}
	
	int longestSubArray01(int[] arr, double nstd4)
	{
		if (DEBUG) System.out.printf("In longestSubArray01(int[]=%s,🪹4)\n",
				Arrays.toString(arr));
		
		if (arr.length > 1) {
			int maxLength = 0;
			
			for (int i = 0; i < arr.length; i++) {
				int sum = 0;
				for (int j = i; j < arr.length; j++) {
					sum += (arr[j] == 0) ? -1 : 1;
					
					if (sum == 0)
						maxLength = Math.max(maxLength, j - i + 1);
				}
			}
				
			
			return maxLength;
		}
		
		return 0;
	}
	
	int longestSubArray01(int[] arr, int hashingPrfSum)
	{
		if (DEBUG) System.out.printf("In longestSubArray01(int[]=%s,#🔙Σ)\n",
				Arrays.toString(arr));
		
		if (arr.length > 1) {
			int maxLength = 0, prefixSum = 0;
			Map<Integer, Integer> map = new HashMap<>();
			
			for (int i = 0; i < arr.length; i++) {
				prefixSum += arr[i] == 0 ? -1 : 1;
				
				if (prefixSum == 0)
					maxLength = i + 1;
				
				if (map.containsKey(prefixSum))
					maxLength = Math.max(maxLength, i - map.get(prefixSum));
				else
					map.put(prefixSum, i);
			}
			
			return maxLength;
		}
		
		return 0;
	}
	
	int longestSpanWithSum(int[] arr1, int[] arr2, float nstd4)
	{
		if (DEBUG) System.out.printf("In longestSpanWithSum(int[]=%s,int[]=%s,🪹4)\n",
				Arrays.toString(arr1), Arrays.toString(arr2));
		
		if (arr1.length == arr2.length && arr1.length != 0) {
			int res = 0;
			
			for (int i = 0; i < arr1.length; i++) {
				int prfSm1 = 0, prfSm2 = 0;
				for (int j = i; j < arr1.length; j++) {
					prfSm1 += arr1[j];
					prfSm2 += arr2[j];
					if (prfSm1 == prfSm2)
						res = Math.max(res, j - i + 1);
				}
			}
			return res;
		}
		return -1;
	}
	
	int longestSpanWithSum(int[] arr1, int[] arr2, double diffArr)
	{
		if (DEBUG) System.out.printf("In longestSpanWithSum(int[]=%s,int[]=%s,[]-[])\n",
				Arrays.toString(arr1), Arrays.toString(arr2));
		
		if (arr1.length == arr2.length && arr1.length != 0) {
			int res = 0, prfSm1 = 0, prfSm2 = 0;
			int[] diff = new int[2 * arr1.length + 1];
			Arrays.fill(diff, -1);
			
			for (int i = 0; i < arr1.length; i++) {
				prfSm1 += arr1[i];
				prfSm2 += arr2[i];
				int currDiff = prfSm1 - prfSm2;
				int index = currDiff + arr1.length;
				if (currDiff == 0)
					res = Math.max(res, i + 1);
				else if (diff[index] != -1)
					res = Math.max(res, i - diff[index]);
				else
					diff[index] = i;
			}
			return res;
		}
		return -1;
	}
	
	int longestSpanWithSum(int[] arr1, int[] arr2, int hashMap)
	{
		if (DEBUG) System.out.printf("In longestSpanWithSum(int[]=%s,int[]=%s,#🗺)\n",
				Arrays.toString(arr1), Arrays.toString(arr2));
		
		if (arr1.length == arr2.length && arr1.length != 0) {
			Map<Integer, Integer> map = new HashMap<>();
			int res = 0, prfSm1 = 0, prfSm2 = 0;
			
			for (int i = 0; i < arr1.length; i++) {
				prfSm1 += arr1[i];
				prfSm2 += arr2[i];
				int currDiff = prfSm1 - prfSm2;
				if (currDiff == 0)
					res = Math.max(res, i + 1);
				else if (map.containsKey(currDiff))
					res = Math.max(res, i - map.get(currDiff));
				else
					map.put(currDiff, i);
			}	
			return res;
		}
		return -1;
	}
	
	int[] pairSumArray(int[] arr)
	{
		if (DEBUG) System.out.printf("In pairSumArray(int[]=%s)\n", Arrays.toString(arr));
		
		if (arr.length > 0) {
			
			if (arr.length == 1)
				return new int[] {1, arr[0] - 1};
			
			int n = (int) ((1 + Math.sqrt(1 + 8 * arr.length)) / 2);
			int res[] = new int[n];
			
			res[0] = (arr[0] + arr[1] - arr[n - 1]) / 2;
			
			for (int i = 1; i < n; i++) 
				res[i] = arr[i - 1] - res[0];
			
			return res;
		}
	
		return new int[0];
	}
	
	ArrayList<int[]> sum2(int[] arr, int target, double nstd4)
	{
		if (DEBUG) System.out.printf("In sum2(int[]=%s,int=%d,🪹4)\n",
							Arrays.toString(arr), target);
		
		if (arr.length > 1) {
			ArrayList<int[]> res = new ArrayList<>();
			
			for (int i = 0; i < arr.length - 1; i++)
				for (int j = i + 1; j < arr.length; j++)
					if (arr[i] + arr[j] == target)
						res.add(new int[] {i, j});
			
			if (res.isEmpty())
				res.add(new int[0]);
			
			return res;
		}
		
		return new ArrayList<>(List.of(new int[0]));
	}
	
	ArrayList<int[]> sum2(int[] arr, int target, int hashing)
	{
		if (DEBUG) System.out.printf("In sum2(int[]=%s,int=%d,###)\n",
							Arrays.toString(arr), target);
		
		if (arr.length > 1) {
			Map<Integer, ArrayList<Integer>> map = new HashMap<>();
			
			ArrayList<int[]> res = new ArrayList<>();
			
			for (int i = 0; i < arr.length; i++) {
				if (map.containsKey(target - arr[i]))
					for (int j : map.get(target - arr[i]))
						res.add(new int[] {j, i});
				
				if (!map.containsKey(arr[i]))
					map.put(arr[i], new ArrayList<>());
				
				map.get(arr[i]).add(i);
			}

			Collections.sort(res, new Comparator<>() {
				@Override
				public int compare(int[] x, int[] y)
				{
					if (x[0] == y[0])
						return x[1] - y[1];
					return x[0] - y[0];
				}
			});
			
			if (res.isEmpty())
				res.add(new int[0]);
				
			return res;
		}
		
		return new ArrayList<>(List.of(new int[0]));
	}
	
	ArrayList<int[]> sum2Distinct(int[] arr, int target, float nstd4)
	{
		if (DEBUG) System.out.printf("In sum2Distinct(int[]=%s,int=%d,🪹4)\n",
							Arrays.toString(arr), target);
		
		if (arr.length > 1) {
			ArrayList<int[]> res = new ArrayList<>();
			
			for (int i = 0; i < arr.length - 1; i++)
				innerloop:
				for (int j = i + 1; j < arr.length; j++)
					if (arr[i] + arr[j] == target) {
						int[] tmp = {arr[i], arr[j]};
						Arrays.sort(tmp);
						for (int[] ref : res)
							if (Arrays.equals(ref, tmp))
								continue innerloop;
						res.add(tmp);
					}
			
			if (!res.isEmpty())
				return res;
		}
		return new ArrayList<>(List.of(new int[0]));
	}
	
	ArrayList<int[]> sum2Distinct(int[] arr, int target, double hashSet)
	{
		if (DEBUG) System.out.printf("In sum2Distinct(int[]=%s,int=%d,#{})\n",
							Arrays.toString(arr), target);
		
		if (arr.length > 1) {
			
			Set<List<Integer>> set = new HashSet<>();
			
			for (int i = 0; i < arr.length - 1; i++)
				for (int j = i + 1; j < arr.length; j++)
					if (arr[i] + arr[j] == target)
						set.add(List.of(arr[i], arr[j]));
			
			if (!set.isEmpty())
				return set.stream()
						  .map(x -> x.get(0) < x.get(1) ? new int[] {x.get(0), x.get(1)} : new int[] {x.get(1), x.get(0)})
						  .collect(Collectors.toCollection(ArrayList::new));
		}
		
		return new ArrayList<>(List.of(new int[0]));
	}
	
	ArrayList<int[]> sum2Distinct(int[] arr, int target, long twoPtr)
	{
		if (DEBUG) System.out.printf("In sum2Distinct(int[]=%s,int=%d,2*)\n",
							Arrays.toString(arr), target);
		
		if (arr.length > 1) {
			ArrayList<int[]> res = new ArrayList<>();
			int l = 0, r = arr.length - 1;
			
			Arrays.sort(arr);
			
			while (l < r)
				if (l > 0 && arr[l] == arr[l - 1])
					l++;
				else if (r < arr.length - 1 && arr[r] == arr[r + 1])
					r--;
				else {
					if (arr[l] + arr[r] == target)
						res.add(new int[] {arr[l++], arr[r--]});
					else if (arr[l] + arr[r] < target)
						l++;
					else
						r--;
				}
			
			if (!res.isEmpty())
				return res;
		}
		
		return new ArrayList<>(List.of(new int[0]));
	}
	
	@Override
	ArrayList<int[]> sum2Distinct(int[] arr, int target, int hashMap)
	{
		if (hashMap == 2)		
			return super.sum2Distinct(arr, target, hashMap);
			
		if (DEBUG) System.out.printf("In sum2Distinct(int[]=%s,int=%d,#🗺)\n",
							Arrays.toString(arr), target);
		
		if (arr.length > 1) {
			
			Map<Integer, Integer> map = new HashMap<>();
			ArrayList<int[]> res = new ArrayList<>();
			
			for (int i : arr) {
				int freq = map.getOrDefault(i, 0);
				
				if (freq == 1 && i + i == target)
					res.add(new int[] {i, i});
				
				if (freq == 0 && map.containsKey(target - i)) {
					if (target - i > i)
						res.add(new int[] {i, target - i});
					else
						res.add(new int[] {target - i, i});
				}
				
				map.put(i, freq + 1);
			}
			
			if (!res.isEmpty())
				return res;
		}
		
		return new ArrayList<>(List.of(new int[0]));
	}
	
	boolean sum3ExistsBy(int[] arr, int target, float nstd4)
	{
		if (DEBUG) System.out.printf("In sum3ExistsBy(int[]=%s,int=%d,🪹4)\n",
				Arrays.toString(arr), target);
		
		if (arr.length > 2) {
			for (int i = 0; i < arr.length - 2; i++)
				for (int j = i + 1; j < arr.length - 1; j++)
					for (int k = j + 1; k < arr.length; k++)
						if (arr[i] + arr[j] + arr[k] == target)
							return true;
		}
		
		return false;
	}
	
	boolean sum3ExistsBy(int[] arr, int target, double hashSet)
	{
		if (DEBUG) System.out.printf("In sum3ExistsBy(int[]=%s,int=%d,#{})\n",
				Arrays.toString(arr), target);
		
		if (arr.length > 2) {
			for (int i = 0; i < arr.length - 2; i++) {
				Set<Integer> set = new HashSet<>();
				for (int j = i + 1; j < arr.length; j++) {
					int second = target - arr[i] - arr[j];
					if (set.contains(second))
						return true;
					set.add(arr[j]);
				}
			}
		}
		
		return false;
	}
	
	boolean sum3ExistsBy(int[] arr, int target, int sort2Ptr)
	{
		if (DEBUG) System.out.printf("In sum3ExistsBy(int[]=%s,int=%d,A↓z2*)\n",
				Arrays.toString(arr), target);
		
		if (arr.length > 2) {
			Arrays.sort(arr);
			
			for (int i = 0, l = i + 1, r = arr.length - 1, sum = 0;
					i < arr.length - 2; l = ++i + 1, r = arr.length - 1)
				while (l < r)
					if ((sum = arr[i] + arr[l] + arr[r]) == target)
						return true;
					else if (sum < target)
						l++;
					else
						r--;
		}
		
		return false;
	}
	
	Integer sum3ClosestTriplet(int[] arr, int target, double nstd4)
	{
		if (DEBUG) System.out.printf("In sum3ClosestTriplet(int[]=%s,int=%d,🪹4)\n",
				Arrays.toString(arr), target);
		
		if (arr.length > 2) {
			int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE};
			
			for (int i = 0; i < arr.length - 2; i++)
				for (int j = i + 1; j < arr.length - 1; j++)
					for (int k = j + 1; k < arr.length; k++) {
						int sum = arr[i] + arr[j] + arr[k], diff = Math.abs(sum - target);
						if (diff < res[0]) {
							res[0] = diff;
							res[1] = sum;
						} else if (diff == res[0])
							res[1] = Math.max(res[1], sum);
					}
			
			return res[1];
		}
		
		return null;
	}
	
	Integer sum3ClosestTriplet(int[] arr, int target, int sort2Ptr)
	{
		if (DEBUG) System.out.printf("In sum3ClosestTriplet(int[]=%s,int=%d,A↓z2*)\n",
				Arrays.toString(arr), target);
		
		if (arr.length > 2) {
			Arrays.sort(arr);
			int res = 0;
			int minDiff = Integer.MAX_VALUE;
			
			for (int i = 0; i < arr.length - 2; i++) {
				int l = i + 1, r = arr.length - 1;
				while (l < r) {
					int currSum = arr[i] + arr[l] + arr[r];
					
					if (Math.abs(currSum - target) < minDiff) {
						minDiff = Math.abs(currSum - target);
						res = currSum;
					} else if (Math.abs(currSum - target) == minDiff)
						res = Math.max(res, currSum);
					
					if (currSum > target)
						r--;
					else
						l++;
				}
			}
			
			return res;
		}
		
		return null;
	}
	
	List<Integer> sum4FindAny(int[] arr, int target, double nstd4)
	{
		if (DEBUG) System.out.printf("In sum4FindAny(int[]=%s,int=%d,🪹4)\n",
				Arrays.toString(arr), target);
		
		if (arr.length > 3) {
			for (int i = 0; i < arr.length - 3; i++)
				for (int j = i + 1; j < arr.length - 2; j++)
					for (int k = j + 1; k < arr.length - 1; k++)
						for (int l = k + 1; l < arr.length; l++)
							if (arr[i] + arr[j] + arr[k] + arr[l] == target)
								return List.of(arr[i], arr[j], arr[k], arr[l]);
		}
		
		return null;
	}
	
	List<Integer> sum4FindAny(int[] arr, int target, int sort2Ptr)
	{
		if (DEBUG) System.out.printf("In sum4FindAny(int[]=%s,int=%d,A↓z2*)\n",
				Arrays.toString(arr), target);
		
		if (arr.length > 3) {
			Arrays.sort(arr);
			
			for (int i = 0; i < arr.length - 3; i++)
				for (int j = i + 1; j < arr.length - 2; j++) {
					int l = j + 1, r = arr.length - 1;
					while (l < r) {
						int currSum = arr[i] + arr[j] + arr[l] + arr[r];
						
						if (currSum == target)
							return List.of(arr[i], arr[j], arr[l], arr[r]);
						else if (currSum > target)
							r--;
						else
							l++;
					}
				}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		
//		modifyArrayTest();
//		maximumCircularSubarrayTest();
//		reorderAnArrayTest();
//		productExceptSelfTest();
//		kthLargestSumTest();
//		smallestMissingNumberTest();
//		smallestSubarraySumTest();
//		majorityElementTest();
//		countTrianglesTest();
//		subArrayWithGivenSumTest();
//		longestSubArray01Test();
//		longestSpanWithSumTest();
//		pairSumArrayTest();
//		sum2Test();
//		sum2DistinctTest();
//		sum3ExistsByTest();
//		sum3ClosestTripletTest();
		sum4FindAnyTest();
	}

	private static void modifyArrayTest()
	{
//		double opt = 1;
//		int opt = 1;
		short opt = 1;
		
		int res[] = new int[] {-1, -1, 1, 8, 3, 2, -1, 4, -1};
		mediumProblems.rearrangeArray(res, opt);
		assert Arrays.equals(res, new int[] {-1, 1, 2, 3, 4, -1, -1, -1, 8});
		
		System.out.println(Arrays.toString(res));
		
		res = new int[] {-1, -1, 1, 6, 9, 3, 2, -1, 4, -1};
		mediumProblems.rearrangeArray(res, opt);
		assert Arrays.equals(res, new int[] {-1, 1, 2, 3, 4, -1, 6, -1, -1, 9});
		
		System.out.println(Arrays.toString(res));
		
		res = new int[] {-1, 2, -1, 1, 3};
		mediumProblems.rearrangeArray(res, opt);
		assert Arrays.equals(res, new int[] {-1, 1, 2, 3, -1});
		
		System.out.println(Arrays.toString(res));
	}
	
	private static void maximumCircularSubarrayTest()
	{
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		int arr[] = {8, -8, 9, -9, 10, -11, 12};
		assert mediumProblems.maximumCircularSubarray(arr, opt) == 22;
		System.out.println(mediumProblems.maximumCircularSubarray(arr, opt));
		
		arr = new int[] {4, -1, -2, 3};
		int res = mediumProblems.maximumCircularSubarray(arr, opt);
		assert res == 7;
		System.out.println(res);
		
		arr = new int[] {5, -2, 3, 4};
		res = mediumProblems.maximumCircularSubarray(arr, opt);
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
		mediumProblems.reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {11, 10, 12});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {1, 2, 3, 4};
		index = new int[] {3, 2, 0, 1};
		mediumProblems.reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {3, 4, 2, 1});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {50, 40, 70, 60, 90};
		index = new int[] {3, 0, 4, 1, 2};
		mediumProblems.reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {40, 60, 90, 50, 70});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {};
		index = new int[] {1};
		mediumProblems.reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {2};
		index = new int[] {1};
		mediumProblems.reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {2});
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {2, 3};
		index = new int[] {1};
		mediumProblems.reorderAnArray(arr, index, opt);
		assert Arrays.equals(arr, new int[] {2, 3});
		System.out.println(Arrays.toString(arr));
	}
	
	private static void productExceptSelfTest()
	{
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		int arr[] = mediumProblems.productExceptSelf(new int[] {10, 3, 5, 6, 2}, opt);
		assert Arrays.equals(arr, new int[] {180, 600, 360, 300, 900});
		System.out.println(Arrays.toString(arr));
		
		arr = mediumProblems.productExceptSelf(new int[] {12, 0}, opt);
		assert Arrays.equals(arr, new int[] {0, 12});
		System.out.println(Arrays.toString(arr));
		
		arr = mediumProblems.productExceptSelf(new int[] {}, opt);
		assert Arrays.equals(arr, new int[] {});
		System.out.println(Arrays.toString(arr));		
	}
	
	private static void kthLargestSumTest()
	{
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		Integer res = mediumProblems.kthLargestSum(new int[] {20, -5, -1}, 3, opt);
		assert res == 14;
		System.out.println(res);
		
		res = mediumProblems.kthLargestSum(new int[] {10, -10, 20, -40}, 6, opt);
		assert res == -10;
		System.out.println(res);
		
		res = mediumProblems.kthLargestSum(new int[] {1}, 2, opt);
		assert res == null;
		System.out.println(res);
		
		res = mediumProblems.kthLargestSum(new int[] {}, 1, opt);
		assert res == null;
		System.out.println(res);
		
		res = mediumProblems.kthLargestSum(new int[] {1, 2, 3}, 0, opt);
		assert res == 6;
		System.out.println(res);
	}
	
	private static void smallestMissingNumberTest()
	{
//		float opt = 1;
//		short opt = 1;
//		double opt = 1;
//		long opt = 1;
		int opt = 1;
		
		int arr[] = {0, 1, 2, 6, 9};
		int res = mediumProblems.smallestMissingNumber(arr, opt);
		assert res == 3;
		System.out.println(res);
		
		arr = new int[] {4, 5, 10, 11};
		res = mediumProblems.smallestMissingNumber(arr, opt);
		assert res == 0;
		System.out.println(res);
		
		arr = new int[] {0, 1, 2, 3};
		res = mediumProblems.smallestMissingNumber(arr, opt);
		assert res == 4;
		System.out.println(res);
		
		arr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 10};
		res = mediumProblems.smallestMissingNumber(arr, opt);
		assert res == 8;
		System.out.println(res);
		
		arr = new int[0];
		res = mediumProblems.smallestMissingNumber(arr, opt);
		assert res == -1;
		System.out.println(res);
	}
	
	private static void smallestSubarraySumTest()
	{
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		int res = mediumProblems.smallestSubarraySum(new int[] {1, 4, 45, 6, 0, 19}, 51, opt);
		assert res == 3;
		System.out.println(res);
		
		res = mediumProblems.smallestSubarraySum(new int[] {1, 10, 5, 2, 7}, 100, opt);
		assert res == 0;
		System.out.println(res);
		
		res = mediumProblems.smallestSubarraySum(new int[0], 0, opt);
		assert res == 0;
		System.out.println(res);
	}
	
	private static void majorityElementTest()
	{
//		short opt = 1;
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		int res = mediumProblems.majorityElement(new int[] {1, 1, 2, 1, 3, 5, 1}, opt);
		assert res == 1;
		System.out.println(res);
		
		res = mediumProblems.majorityElement(new int[] {7}, opt);
		assert res == 7;
		System.out.println(res);
		
		res = mediumProblems.majorityElement(new int[] {2, 13}, opt);
		assert res == -1;
		System.out.println(res);
		
		res = mediumProblems.majorityElement(new int[0], opt);
		assert res == -1;
		System.out.println(res);
	}
	
	private static void countTrianglesTest()
	{
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		int res = mediumProblems.countTriangles(new int[] {4, 6, 3, 7}, opt);
		assert res == 3 : "expected 3 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.countTriangles(new int[] {10, 21, 22, 100, 101, 200, 300}, opt);
		assert res == 6 : "expected 6 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.countTriangles(new int[] {1, 2, 3}, opt);
		assert res == 0 : "expected 0 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.countTriangles(new int[2], opt);
		assert res == -1 : "expected -1 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.countTriangles(new int[] {1, -1, 2}, opt);
		assert res == -1 : "expected -1 but res=" + res;
		System.out.println(res);
	}
	
	private static void subArrayWithGivenSumTest()
	{
//		float opt = 1;
		double opt = 1;
//		int opt = 1;
		
		int[] res = mediumProblems.subArrayWithGivenSum(new int[] {15, 2, 4, 8, 9, 5, 10, 23}, 23, opt);
		assert Arrays.equals(res, new int[] {2, 5}) : "Expected {2, 5} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
		
		res = mediumProblems.subArrayWithGivenSum(new int[] {1, 10, 4, 0, 3, 5}, 7, opt);
		assert Arrays.equals(res, new int[] {3, 5}) : "Expected {3, 5} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
		
		res = mediumProblems.subArrayWithGivenSum(new int[] {1, 4}, 0, opt);
		assert res[0] == -1 : "Expected {-1} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
		
		res = mediumProblems.subArrayWithGivenSum(new int[] {1, 2, -2, 1}, 0, opt);
		assert Arrays.equals(res, new int[] {2, 3}) : "Expected {2, 3} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
		
		res = mediumProblems.subArrayWithGivenSum(new int[] {1, 2, 0, 1}, 0, opt);
		assert Arrays.equals(res, new int[] {3, 3}) : "Expected {3, 3} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
	}
	
	private static void longestSubArray01Test()
	{
		double opt = 1;
//		int opt = 1;
		
		int res = mediumProblems.longestSubArray01(new int[] {1, 0, 1, 1, 1, 0, 0}, opt);
		assert res == 6 : "Expected 6 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.longestSubArray01(new int[] {0, 0, 1, 1, 0}, opt);
		assert res == 4 : "Expected 6 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.longestSubArray01(new int[1], opt);
		assert res == 0 : "Expected 6 but res=" + res;
		System.out.println(res);
	}
	
	private static void longestSpanWithSumTest()
	{
		float opt = 1;
//		double opt = 1;
//		int opt = 1;
		
		int res = mediumProblems.longestSpanWithSum(new int[] {0, 1, 0, 0, 0, 0},
				new int[] {1, 0, 1, 0, 0, 1}, opt);
		assert res == 4 : "Expected 4 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.longestSpanWithSum(new int[] {0, 1, 0, 1, 1, 1, 1},
				new int[] {1, 1, 1, 1, 1, 0, 1}, opt);
		assert res == 6 : "Expected 6 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.longestSpanWithSum(new int[] {0, 0, 0}, new int[] {1, 1, 1}, opt);
		assert res == 0 : "Expected 0 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.longestSpanWithSum(new int[0], new int[1], opt);
		assert res == -1 : "Expected -1 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.longestSpanWithSum(new int[0], new int[0], opt);
		assert res == -1 : "Expected -1 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.longestSpanWithSum(new int[1], new int[0], opt);
		assert res == -1 : "Expected -1 but res=" + res;
		System.out.println(res);
	}
	
	private static void pairSumArrayTest()
	{
		int res[] = mediumProblems.pairSumArray(new int[] {4, 5, 3});
		assert Arrays.equals(res, new int[] {3, 1, 2}) : "Expected {3, 1, 2} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
		
		res = mediumProblems.pairSumArray(new int[] {12, 8, 7, 10, 9, 5});
		assert Arrays.equals(res, new int[] {5, 7, 3, 2}) : "Expected {5, 7, 3, 2} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
		
		res = mediumProblems.pairSumArray(new int[] {3});
		assert Arrays.equals(res, new int[] {1, 2}) : "Expected {1, 2} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
		
		res = mediumProblems.pairSumArray(new int[0]);
		assert res.length == 0 : "Expected {} but res=" + Arrays.toString(res);
		System.out.println(Arrays.toString(res));
	}
	
	private static void sum2Test()
	{
//		double opt = 1;
		int opt = 1;
		
		BiPredicate<ArrayList<int[]>, ArrayList<int[]>> arrayListDeepEquals 
			= (x, y) -> {
				if (x.size() != y.size())
					return false;
				for (int i = 0; i < x.size(); i++)
					if (!Arrays.equals(x.get(i), y.get(i)))
						return false;
				return true;
			};
		
		ArrayList<int[]> res = mediumProblems.sum2(new int[] {10, 20, 30, 20, 10, 30}, 50, opt);
		
		String result = res.stream()
				   		   .map(x -> Arrays.toString(x))
				   		   .collect(Collectors.joining());
		
		assert arrayListDeepEquals.test(res, new ArrayList<>(List.of(
					new int[] {1, 2},
					new int[] {1, 5},
					new int[] {2, 3},
					new int[] {3, 5}
				))) : "Expected {{1, 2}, {1, 5}, {2, 3}, {3, 5}} but res=" + result;
		
		System.out.println(result);
		

		res = mediumProblems.sum2(new int[] {10, 20, 30, 20, 10, 30}, 80, opt);
		
		result = res.stream()
		   		    .map(x -> Arrays.toString(x))
				   	.collect(Collectors.joining());
		
		assert arrayListDeepEquals.test(res, new ArrayList<>(List.of(new int[0]))) : "Expected {} but res=" + result;
		
		System.out.println(result);
		
		res = mediumProblems.sum2(new int[0], 80, opt);
		
		result = res.stream()
	   		    .map(x -> Arrays.toString(x))
			   	.collect(Collectors.joining());
	
		assert arrayListDeepEquals.test(res, new ArrayList<>(List.of(new int[0]))) : "Expected {} but res=" + result;
	
		System.out.println(result);
	}
	
	private static void sum2DistinctTest()
	{
//		float opt = 1;
//		double opt = 1;
//		long opt = 1;
		int opt = 2;
		
		BiPredicate<ArrayList<int[]>, ArrayList<int[]>> arrayListDeepEquals 
			= (x, y) -> {
				if (x.size() != y.size())
					return false;
				outerloop:
				for (int i = 0; i < x.size(); i++) {
					for (int j = 0; j < x.size(); j++)
						if (Arrays.equals(x.get(i), y.get(j)))
							continue outerloop;
					return false;
				}
				return true;
			};
		
		ArrayList<int[]> res = mediumProblems.sum2Distinct(new int[] {1, 5, 7, -1, 5}, 6, opt);
		
		String result = res.stream()
				   		   .map(x -> Arrays.toString(x))
				   		   .collect(Collectors.joining());
		
		assert arrayListDeepEquals.test(res, new ArrayList<>(List.of(
					new int[] {1, 5},
					new int[] {-1, 7}
				))) : "Expected {{1, 5}, {-1, 7}} but res=" + result;
		
		System.out.println(result);
		

		res = mediumProblems.sum2Distinct(new int[] {1, 9, -1, 8, 6}, 4, opt);
		
		result = res.stream()
		   		    .map(x -> Arrays.toString(x))
				   	.collect(Collectors.joining());
		
		assert arrayListDeepEquals.test(res, new ArrayList<>(List.of(new int[0]))) : "Expected {} but res=" + result;
		
		System.out.println(result);
		
		res = mediumProblems.sum2Distinct(new int[0], 80, opt);
		
		result = res.stream()
	   		    .map(x -> Arrays.toString(x))
			   	.collect(Collectors.joining());
	
		assert arrayListDeepEquals.test(res, new ArrayList<>(List.of(new int[0]))) : "Expected {} but res=" + result;
	
		System.out.println(result);
	}
	
	private static void sum3ExistsByTest()
	{
//		float opt = 1;
//		double opt = 1;
		int opt = 1;
		
		boolean res = mediumProblems.sum3ExistsBy(new int[] {1, 4, 45, 6, 10, 8}, 13, opt);
		assert res : "Expected for {1, 4, 45, 6, 10, 8} and 13 : true but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.sum3ExistsBy(new int[] {1, 2, 4, 3, 6, 7}, 10, opt);
		assert res : "Expected for {1, 2, 4, 3, 6, 7} and 10 : true but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.sum3ExistsBy(new int[] {40, 20, 10, 3, 6, 7}, 24, opt);
		assert !res : "Expected for {40, 20, 10, 3, 6, 7} and 24 : false but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.sum3ExistsBy(new int[0], -1, opt);
		assert !res : "Expected for {} and -1 : false but res=" + res;
		System.out.println(res);
	}
	
	private static void sum3ClosestTripletTest()
	{
//		double opt = 1;
		int opt = 1;
		
		Integer res = mediumProblems.sum3ClosestTriplet(new int[] {-1, 2, 2, 4}, 4, opt);
		assert res == 5 : "Expected for {-1, 2, 2, 4} and 4 : 5 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.sum3ClosestTriplet(new int[] {1, 10, 4, 5}, 10, opt);
		assert res == 10 : "Expected for {1, 10, 4, 5} and 10 : 10 but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.sum3ClosestTriplet(new int[0], -1, opt);
		assert res == null : "Expected for {} and -1 : null but res=" + res;
		System.out.println(res);
	}
	
	private static void sum4FindAnyTest()
	{
//		double opt = 1;
		int opt = 1;
		
		ArrayList<Integer> ref = new ArrayList<>() {
			@Override
			public boolean equals(Object obj)
			{
				if (!(obj instanceof Iterable<?>))
					return false;
				int count = 0;
				for (Object o : (Iterable<?>) obj)
					if (++count > 0 && !this.contains(o))
						return false;
				if (count != this.size())
					return false;
				return true;
			}
		};
		
		List<Integer> res = mediumProblems.sum4FindAny(new int[] {2, 4, 6, 8, 1, 3}, 15, opt);
		ref.clear();
		ref.addAll(List.of(2, 4, 6, 3));
		assert ref.equals(res) || 
			res.stream().collect(Collectors.summingInt(x -> x)) == 15 :
				"Expected for {2, 4, 6, 8, 1, 3} and 15 : " + ref + " but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.sum4FindAny(new int[] {1, 2, 3, 4, 10}, 20, opt);
		assert res == null : "Expected for {1, 2, 3, 4, 10} and 20 : {} but res=" + res;
		System.out.println(res);
		
		res = mediumProblems.sum4FindAny(new int[0], -1, opt);
		assert res == null : "Expected for {} and -1 : null but res=" + res;
		System.out.println(res);
	}
}

class MediumProblemsSuper {
	
	int smallestSubarraySum(int[] arr, int x, int twoPtr)
	{
		if (twoPtr == 1) System.out.printf("In spr.smallestSubarraySum(int[]=%s,int=%d)\n",
				Arrays.toString(arr), x);
		
		int smallest[] = new int[] {0, Integer.MAX_VALUE}, n = arr.length;
		
		if (n > 0) {
			int i = 0, j = 0, sum = 0;
			
			while (j < n) {
				while (j < n && sum <= x)
					sum += arr[j++];
				
				if (j == n && sum <= x) break;
				
				while (i < j && sum - arr[i] > x)
					sum -= arr[i++];
				
				smallest[0] = 1;
				smallest[1] = Math.min(smallest[1], j - i);
				
				sum -= arr[i];
				i++;
			}
		}
		
		if (smallest[0] == 0)
			return 0;
		
		return smallest[1];
	}
	
	int majorityElement(int[] arr, short nstd4)
	{
		if (nstd4 == 1) System.out.printf("In spr.majorityElement(int[]=%s,nstd4)\n",
				Arrays.toString(arr));
		
		int n = arr.length;
		
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				if (arr[i] < 0)
					continue;
				
				int count = 1;
				
				for (int j = i + 1; j < n; j++)
					if (arr[j] == arr[i]) {
						arr[j] = -1;
						count++;
					}
				
				if (count > n / 2)
					return arr[i];
			}
		}
		
		return -1;
	}
	
	int majorityElement(int[] arr, float sort)
	{
		if (sort == 1) System.out.printf("In spr.majorityElement(int[]=%s,A↓z)\n",
				Arrays.toString(arr));
		
		int n = arr.length;
		if (n > 0) {
			
			Arrays.sort(arr);
			int candidate = arr[n / 2], count = 0;
			
			for (int i : arr)
				if (i == candidate)
					count++;
			
			if (count > n / 2)
				return candidate;
		}
		
		return -1;
	}
	
	ArrayList<int[]> sum2Distinct(int[] arr, int target, int hashMap)
	{
		if (hashMap == 2) System.out.printf("In spr.sum2Distinct(int[]=%s,int=%d,#🗺)\n",
				Arrays.toString(arr), target);
		
		if (arr.length > 1) {
			ArrayList<int[]> res = new ArrayList<>();
			Map<Integer, Integer> freq = new HashMap<>();
			
			for (int i : arr) {
				int complement = target - i, compFreq = freq.getOrDefault(complement, 0),
					iFreq = freq.getOrDefault(i, 0);
				
				if (complement == i && compFreq == 1)
					res.add(new int[] {i, i});
				else if (compFreq > 0 && iFreq == 0)
					res.add( complement > i ? new int[] {i, complement} : new int[] {complement, i} );
				
				freq.put(i, iFreq + 1);
			}
			
			if (!res.isEmpty())
				return res;
		}
		
		return new ArrayList<>(List.of(new int[0]));
	}
	
}