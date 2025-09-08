// NOTE To enable assert use '-ea' in run config > arguments > VM arguments

package array;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

import array.utility.BiFunctionLocale;
import array.utility.TriFunctionLocale;

import java.util.function.Function;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

import javaArrayExcercises.BubbleSort;

@SuppressWarnings("unused")
public class EasyProblems extends EasyProblemsSuper
{
	
	private static final boolean DEBUG = true;
	
	@Override
	boolean duplicatedWithinKdist(int[] arr, int d, boolean callSuper)
	{
		if (callSuper)
			return super.duplicatedWithinKdist(arr, d, callSuper);
			
		if (DEBUG) System.out.printf("In duplicatedWithinKdist(int[]=%s,int=%d,bl=%s)\n", 
						   Arrays.toString(arr), d, callSuper);
		
		for (int i = 0, n = arr.length; i < n - d; i++)
			for (int j = i + 1; j <= i + d; j++)
				if (arr[i] == arr[j])
					return true;
		
		return false;
	}
	
	private static boolean duplicatedWithinKdist(int[] arr, float d)
	{		
		if (DEBUG) System.out.printf("In duplicatedWithinKdist(int[]=%s,flt=%.0f)\n", 
						   Arrays.toString(arr), d);
		
		Set<Integer> set = new HashSet<>();		
		for (int i = 0, n = arr.length; i < n; i++) {
			if (set.contains(arr[i]))
				return true;
			
			set.add(arr[i]);
			
			if (i >= d)
				set.remove(arr[i - (int) d]);
		}
		
		return false;
	}
	
	@Override
	int[] setEvenPosGrtr(int[] arr, boolean callSuper)
	{	
		if (callSuper)
			return super.setEvenPosGrtr(arr, callSuper);
			
		if (DEBUG) System.out.printf("In setEvenPosGrtr(int[]=%s,bl=%s)\n", 
						   Arrays.toString(arr), callSuper);
		
		for (int i = 1; i < arr.length; i += 2)
			if (arr[i] < arr[i - 1]) {
				arr[i] = arr[i] ^ arr[i - 1];
				arr[i - 1] = arr[i] ^ arr[i - 1];
				arr[i] = arr[i] ^ arr[i - 1];
			}
		
		return arr;
	}
	
	@Override
	int sumOfAllSubArrays(int[] arr, boolean callSuper)
	{
		if (callSuper)
			return super.sumOfAllSubArrays(arr, callSuper);
			
		if (DEBUG) System.out.printf("In sumOfAllSubArrays(int[]=%s,bl=%s)\n", 
				   Arrays.toString(arr), callSuper);
		
		for (int i = 0, res = 0; i < arr.length; i++)
			for (int j = i; j < arr.length; j++)
				for (int k = i; k <= j; k++) {
					res += arr[k];
					if (i == arr.length - 1)
						return res;
				}
		
		return 0;
	}
	
	int sumOfAllSubArrays(int[] arr)
	{			
		if (DEBUG) System.out.printf("In sumOfAllSubArrays(int[]=%s)\n", 
				   Arrays.toString(arr));
		
		for (int i = 0, res = 0; i < arr.length; i++) {
			res += arr[i] * (i + 1) * (arr.length - i);
			if (i == arr.length - 1)
				return res;
		}
		
		return 0;
	}
	
	@Override
	int buySellStocks(int[] arr, boolean callSuper)
	{	
		if (callSuper)
			return super.buySellStocks(arr, callSuper);
			
		if (DEBUG) System.out.printf("In buySellStocks(int[]=%s,bl=%s)\n", 
				   Arrays.toString(arr), callSuper);
		
		int buy = 0, sell = 0;
		boolean isBought = false;
		
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] < arr[i + 1] && !isBought) {
				buy = arr[i];
				isBought = true;
			} else if (arr[i] > arr[i + 1] && isBought) {
				sell += arr[i] - buy;
				isBought = false;
			}
		
		if (isBought)
			sell += arr[arr.length - 1] - buy;
		
		return sell;
	}

	private static int buySellStocks(int[] arr, int start, int end)
	{
		if (DEBUG) System.out.printf("In buySellStocks(int[]=%s,int=%d,int=%d)\n",
						   Arrays.toString(arr), start, end);
		int res = 0;
		
		for (int i = start; i < end; i++)
			for (int j = i + 1; j <= end; j++)
				if (arr[j] > arr[i]) {
					int curr = (arr[j] - arr[i]) + 
							   buySellStocks(arr, start, i - 1) +
							   buySellStocks(arr, j + 1, end);
					if (DEBUG) System.out.println("start=" + start + " end=" + end + " curr=" +
							   curr + " i=" + i + " j=" + j + " res=" + res);
					res = Math.max(curr, res);
				}
		
		return res;
	}
	
	private static int buySellStocks(int[] arr)
	{
		if (DEBUG) System.out.printf("In buySellStocks(int[]=%s)\n", 
				   Arrays.toString(arr));
		
		int res = 0;
		
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] < arr[i + 1])
				res += arr[i + 1] - arr[i]; 
		
		return res;
	}
	
	@Override
	List<Integer> singleAmongDoubles(int[] arr, boolean callSuper)
	{
		if (callSuper)
			return super.singleAmongDoubles(arr, callSuper);
			
		if (DEBUG) System.out.printf("In singleAmongDoubles(int[]=%s,bl=%s)\n", 
				   Arrays.toString(arr), callSuper);
		
		return Arrays.stream(arr)
					 .filter(x -> Arrays.stream(arr).filter(y -> y == x).count() == 1)
					 .boxed()
					 .toList();
	}
	
	private static List<Integer> singleAmongDoubles(int[] arr)
	{
		if (DEBUG) System.out.printf("In singleAmongDoubles(int[]=%s)\n", 
				   Arrays.toString(arr));
		
		Map<Integer, Long> freqMap = Arrays.stream(arr)
									  		  .boxed()
									  		  .collect(Collectors.groupingBy(
									  				  Function.identity(),
									  				  Collectors.counting()));
		Set<Integer> res = new HashSet<>();
		freqMap.forEach((x, y) -> {
			if (y == 1)
				res.add(x);
		});
		
		return res.stream()
				  .toList();
	}	
	
	private static int singleAmongDoubles(int[] arr, int XoR)
	{
		if (DEBUG) System.out.printf("In singleAmongDoubles(int[]=%s,XoR)\n", 
				   Arrays.toString(arr));
		
		int res = 0;
		
		for (int i : arr)
			res ^= i;
		
		return res;
	}
	
	private static int missingNumber(int[] arr)
	{
		if (DEBUG) System.out.printf("In missingNumber(int[]=%s)\n", 
				   Arrays.toString(arr));
		
		int n = arr.length + 1, sum = (int) ((n + 1) * n / 2.0);
		
		for (int i : arr)
			sum -= i;
		
		return sum;
	}
	
	private static int missingNumber(int[] arr, float linearSearch)
	{
		if (DEBUG) System.out.printf("In missingNumber(int[]=%s,lSch)\n", 
				   Arrays.toString(arr));
		
		int n = arr.length + 1;
		
		outerloop:
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < arr.length; j++)
				if (arr[j] == i)
					continue outerloop;
			return i;
		}
		
		return -1;
	}
	
	private static int missingNumber(int[] arr, double hashArray) // also known as Visited array
	{
		if (DEBUG) System.out.printf("In missingNumber(int[]=%s,hArr)\n", 
				   Arrays.toString(arr));
		
		int n = arr.length, hash[] = new int[n + 2];
		
		for (int i : arr)
			hash[i]++;
		
		for (int i = 1; i < hash.length; i++)
			if (hash[i] == 0)
				return i;
		
		return -1;
	}
	
	private static int missingNumber(int[] arr, int xOr)
	{
		if (DEBUG) System.out.printf("In missingNumber(int[]=%s,xOr)\n", 
				   Arrays.toString(arr));
		
		int xOrN = 1, xOrM = arr.length == 0 ? 0 : arr[0] , n = arr.length + 1;
		
		for (int i = 2; i <= n; i++)
			xOrN ^= i;
		
		for (int i = 1; i < arr.length; i++)
			xOrM ^= arr[i];
		
		return xOrN ^ xOrM;
	}
	
	private static int[] missingNRepeatingNumber(int[] arr, double visitedArray) // also known as Visited array
	{
		if (DEBUG) System.out.printf("In missingNRepeatingNumber(int[]=%s,vst[])\n", 
				   Arrays.toString(arr));
		
		int n = arr.length, hash[] = new int[n + 1], res[] = new int[3];
		
		for (int i : arr)
			hash[i]++;
		
		for (int i = 1; i < hash.length; i++)
			if (hash[i] == 0)
				res[0] = i;
			else if (hash[i] == 2)
				res[2] = i;
		
		return res;
	}
	
	private static int[] missingNRepeatingNumber(int[] arr, float arrayMarking) // also known as Visited array
	{
		if (DEBUG) System.out.printf("In missingNRepeatingNumber(int[]=%s,[]mrk)\n", 
				   Arrays.toString(arr));
		
		int n = arr.length, res[] = new int[3];
		
		for (int i = 0; i < n; i++) {
			int idx = Math.abs(arr[i]);
			
			if (arr[idx - 1] > 0)
				arr[idx - 1] *= -1;
			else
				res[2] = idx;
		}
		
		for (int i = 1; i <= n; i++)
			if (arr[i - 1] > 0) {
				res[0] = i;
				break;
			}
		
		return res;
	}
	
	private static int[] missingNRepeatingNumber(int[] arr, long arrayMarking) // also known as Visited array
	{
		if (DEBUG) System.out.printf("In missingNRepeatingNumber(int[]=%s,frm)\n", 
				   Arrays.toString(arr));
		
		int n = arr.length, res[] = new int[3]; // <-- {miss, 0, repeat}
		int s = n * (n + 1) / 2, ssq = (n * (n + 1) * (2 * n + 1)) / 6;
		
		for (int i : arr) {
			s -= i;
			ssq -= i * i;
		}
		
		res[0] = s == 0 ? 0 : (s + ssq / s) / 2 ;
		res[2] = res[0] - s;
		
		return res;
	}
	
	private static int[] missingNRepeatingNumber(int[] arr, int arrayMarking) // also known as Visited array
	{
		if (DEBUG) System.out.printf("In missingNRepeatingNumber(int[]=%s,xOr)\n", 
				   Arrays.toString(arr));
		
		int n = arr.length, res[] = new int[3], // <-- {miss, 0, repeat}
			x = 0, y = 0, xOrVal = 0, MSB, xCount = 0; 
		
		for (int i = 0; i < n; i++) {
			xOrVal ^= arr[i];
			xOrVal ^= (i + 1);
		}
		
		MSB = xOrVal & ~(xOrVal - 1);
		
		for (int i = 0; i < n; i++) {
			if ((arr[i] & MSB) != 0)
				x ^= arr[i];
			else
				y ^= arr[i];
			
			if (((i + 1) & MSB) != 0)
				x ^= (i + 1);
			else
				y ^= (i + 1);
		}
		
		for (int i : arr)
			if (i == x)
				xCount++;
		
		res[0] = xCount == 0 ? x : y ;
		res[2] = xCount != 0 ? x : y ;
		
		return res;
	}
	
	private static int singleRepeat(int[] arr, double nestedFor)
	{
		if (DEBUG) System.out.printf("In singleRepeat(int[]=%s,nst)\n",
						Arrays.toString(arr));
		
		int n = arr.length;
		
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (arr[i] == arr[j])
					return arr[i];
		
		return 0;
	}
	
	private static int singleRepeat(int[] arr, float sort)
	{
		if (DEBUG) System.out.printf("In singleRepeat(int[]=%s,srt)\n",
						Arrays.toString(arr));
		
		int n = arr.length;
		Arrays.sort(arr);
		
		for (int i = 0; i < n - 1; i++)
			if (arr[i] == arr[i + 1])
				return arr[i];
		
		return 0;
	}
	
	@Override
	int singleRepeat(int[] arr, long collections)
	{
		if (collections == 1)
			super.singleRepeat(arr, collections);
			
		if (DEBUG) System.out.printf("In singleRepeat(int[]=%s,coll)\n",
						Arrays.toString(arr));
		
		String str = "";
		
		for (int i : arr)
			if (str.indexOf(i + '0') != -1)
				return i;
			else
				str += i;
		
		return 0;
	}
	
	private static int singleRepeat(int[] arr, int sum)
	{
		if (DEBUG) System.out.printf("In singleRepeat(int[]=%s,sum)\n",
						Arrays.toString(arr));
		
		int n = arr.length - 1, sumOfAP = n * (n + 1) / 2;
		try {
			sum = Arrays.stream(arr).reduce((x, y) -> x + y).getAsInt();
		} catch (java.util.NoSuchElementException e) {
			return 0;
		}
		
		return sum - sumOfAP == n + 1 ? 0 : sum - sumOfAP;
	}
	
	@Override
	int singleRepeat(int[] arr, short xOr)
	{
		if (xOr == 1)
			return super.singleRepeat(arr, xOr);
			
		if (DEBUG) System.out.printf("In singleRepeat(int[]=%s,xOr)\n",
						Arrays.toString(arr));
		
		for (int i = 1; i < arr.length; i++)
			xOr ^= i;
		
		for (int i : arr)
			xOr ^= i;
		
		return xOr == arr.length ? 0 : xOr ;
	}
	
	private static int singleRepeat(int[] arr, char negation)
	{			
		if (DEBUG) System.out.printf("In singleRepeat(int[]=%s,neg)\n",
						Arrays.toString(arr));
		
		for (int i : arr)
			if (arr[Math.abs(i) - 1] < 0)
				return Math.abs(i);
			else
				arr[Math.abs(i) - 1] = -arr[Math.abs(i) - 1];
		
		return 0;
	}
	
	private static int singleRepeat(int[] arr, byte negation)
	{			
		if (DEBUG) System.out.printf("In singleRepeat(int[]=%s,neg)\n",
						Arrays.toString(arr));
		
		if (arr.length == 0)
			return 0;
		
		int slow, fast;
		slow = fast = arr[0];
		
		try {
			do {
				slow = arr[slow];
				fast = arr[arr[fast]];
			} while (slow != fast);
			
			fast = arr[0];
			
			while (slow != fast) {
				slow = arr[slow];
				fast = arr[fast];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
		
		return slow;
	}
	
	int[] sortedSubsequenceOf3(int arr[], double nestedFor)
	{
		if (DEBUG) System.out.printf("In sortedSubsequenceOf3(int[]=%s,nst4)\n",
				Arrays.toString(arr));
		
		if (arr.length > 2)
			for (int i = 0; i < arr.length - 2; i++) {
				int res[] = new int[3], idx = 0;
				res[idx++] = arr[i];
				
				for (int j = i + 1; j < arr.length; j++)
					if (res[idx - 1] < arr[j] && idx < 3)
						res[idx++] = arr[j];
				
				if (idx == 3)
					return res;
			}
		
		return new int[] {};
	}
	
	@Override
	int[] sortedSubsequenceOf3(int arr[], float doublePointer)
	{
		if (doublePointer == 1)
			return super.sortedSubsequenceOf3(arr, doublePointer);
			
		if (DEBUG) System.out.printf("In sortedSubsequenceOf3(int[]=%s,dblPtr)\n",
				Arrays.toString(arr));
		
		int n = arr.length;
		
		if (n > 2) {
			int[] left = new int[n], right = new int[n];
			
			for (int i = 0; i < n; i++)
				left[i] = right[i] = -1;
			
			for (int i = 1; i < n; i++)
				for (int j = 0; j < i; j++)
					if (arr[j] < arr[i] && (left[i] = j) == j)
						break;
			
			for (int i = 0; i < n - 1; i++)
				for (int j = i + 1; j < n; j++)
					if (arr[j] > arr[i] && (right[i] = j) == j)
						break;
			
			for (int i = 0; i < n; i++)
				if (left[i] != -1 && right[i] != -1)
					return new int[] {arr[left[i]], arr[i], arr[right[i]]};
		}
		
		return new int[] {};
	}
	
	@Override
	int[] sortedSubsequenceOf3(int arr[], int twoMinimum)
	{	
		if (twoMinimum == 1)
			return super.sortedSubsequenceOf3(arr, twoMinimum);
			
		if (DEBUG) System.out.printf("In sortedSubsequenceOf3(int[]=%s,2min)\n",
				Arrays.toString(arr));
		
		int n = arr.length;
		
		if (n > 2) {
			int min_min = Integer.MAX_VALUE, min = min_min, j = -1;
			
			for (int i = 0; i < n; i++)
				if (arr[i] < min_min) {
					min = min_min;
					min_min = arr[i];
				} else if (arr[i] < min && arr[i] != min_min)
					min = arr[j = i];
			
			for (int i = j + 1; i < n; i++)
				if (arr[i] > min)
					return new int[] {min_min, min, arr[i]};
		}
		
		return new int[] {};
	}
	
	int maxSubarraySum(int[] arr, double nestedFor)
	{
		if (DEBUG) System.out.printf("In maxSubarraySum(int[]=%s,nst4)\n",
				Arrays.toString(arr));
		
		if (arr.length != 0) {
			for (int i = 0, res = Integer.MIN_VALUE; i < arr.length; i++) {
				for (int j = i, sum = 0; j < arr.length; j++) {
					sum += arr[j];
					if (sum > res)
						res = sum;
				}
				
				if (i == arr.length - 1)
					return res;
			}
		}
		
		return -1;
	}
	
	int maxSubarraySum(int[] arr, int prefixSum)
	{
		if (DEBUG) System.out.printf("In maxSubarraySum(int[]=%s,prf+)\n",
				Arrays.toString(arr));
		
		if (arr.length != 0) {
			int sum = arr[0], res = sum;
			
			for (int i = 1; i < arr.length; i++) {
				sum = Math.max(sum + arr[i], arr[i]);
				res = Math.max(sum, res);
			}

			return res;
		}
		
		return -1;
	}
	
	int equilibriumIndex(int[] arr, double nestedFor)
	{
		if (DEBUG) System.out.printf("In equilibriumIndex(int[]=%s,nst4)\n",
				Arrays.toString(arr));
		
		if (arr.length > 2) {
			
			for (int i = 1; i < arr.length - 1; i++) {
				int prf = 0, suf = 0;
				for (int j = 0; j < i; j++)
					prf += arr[j];
				
				for (int j = i + 1; j < arr.length; j++)
					suf += arr[j];
				
				if (prf == suf)
					return i;
			}
		}
		
		return -1;
	}
	
	int equilibriumIndex(int[] arr, float sumArray)
	{
		if (DEBUG) System.out.printf("In equilibriumIndex(int[]=%s,sum[])\n",
				Arrays.toString(arr));
		
		if (arr.length > 2) {
			int[] pref = new int[arr.length], suff = new int[arr.length];
			pref[0] = arr[0];
			suff[arr.length - 1] = arr[arr.length - 1];
			
			for (int i = 1; i < arr.length; i++)
				pref[i] = pref[i - 1] + arr[i];
			
			for (int i = arr.length - 2; i >= 0; i--)
				suff[i] = suff[i + 1] + arr[i];
			
			for (int i = 0; i < arr.length; i++)
				if (pref[i] == suff[i])
					return i;
		}
		
		return -1;
	}
	
	int equilibriumIndex(int[] arr, int prefixSumSuffixSum)
	{
		if (DEBUG) System.out.printf("In equilibriumIndex(int[]=%s,pFsF)\n",
				Arrays.toString(arr));
		
		if (arr.length > 2) {
			int total = Arrays.stream(arr).boxed().collect(Collectors.summingInt(x -> x));
			int prefx = 0, suffx = 0;					
			
			for (int i = 0; i < arr.length; i++) {
				suffx = total - arr[i] - prefx;
				if (suffx == prefx)
					return i;
				prefx += arr[i];
			}
		}
		
		return -1;
	}
	
	boolean pairWithGivenSum(int[] arr, int k, double generatingAllPossibilites)
	{
		if (DEBUG && arr.length < 10) System.out.printf("In pairWithGivenSum(int[]=%s,"
				+ "k=%d,gen!)\n", Arrays.toString(arr), k);
		
		if (arr.length > 1 && generatingAllPossibilites == 0) {
			for (int i = 0; i < arr.length - 1; i++)
				for (int j = i + 1; j < arr.length; j++)
					if (arr[i] + arr[j] == k)
						return true;
		}
		
		if (generatingAllPossibilites != 0)
			return generatingAllPossibilites == 1;
		
		return false;
	}
	
	boolean pairWithGivenSum(int[] arr, int k, float sortAndBinSearch)
	{
		if (DEBUG && arr.length < 10) System.out.printf("In pairWithGivenSum(int[]=%s,"
				+ "k=%d,↑bScr)\n", Arrays.toString(arr), k);
		
		if (arr.length > 1) {
			Arrays.sort(arr);
			
			for (int i = 0; i < arr.length; i++) {
				int compliment = k - arr[i];
				int low = i + 1, high = arr.length - 1;
				
				while (low <= high) {
					int mid = low + (high - low) / 2;
					
					if (arr[mid] == compliment)
						return true;
					if (arr[mid] > compliment)
						high = mid - 1;
					else
						low = mid + 1;
				}
			}
		}
		
		return false;
	}
	
	boolean pairWithGivenSum(int[] arr, int k, short sortAnd2Pointer)
	{
		if (DEBUG && arr.length < 10) System.out.printf("In pairWithGivenSum(int[]=%s,"
				+ "k=%d,↑2*)\n", Arrays.toString(arr), k);
		
		if (arr.length > 1) {
			Arrays.sort(arr);
			
			int left = 0, right = arr.length - 1;
			
			while (left < right) {
				if (arr[left] + arr[right] == k)
					return true;
				if (arr[left] + arr[right] > k)
					right--;
				else
					left++;
			}
		}
		
		return false;
	}
	
	boolean pairWithGivenSum(int[] arr, int k, int hashSet)
	{
		if (DEBUG && arr.length < 10) System.out.printf("In pairWithGivenSum(int[]=%s,"
				+ "k=%d,↑2*)\n", Arrays.toString(arr), k);
		
		if (arr.length > 1) {
			Set<Integer> set = new HashSet<>();
			
			for (int i : arr) {
				if (set.contains(k - i))
					return true;
				set.add(i);
			}
		}
		
		return false;
	}
	
	int twoSumClosestPair2Zero(int[] arr, double genAllPairs)
	{
		if (DEBUG && arr.length < 10) System.out.printf("In twoSumClosestPair2Zero(int[]=%s,"
				+ "Gen!)\n", Arrays.toString(arr));
		
		int sum = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (Math.abs(arr[i] + arr[j]) < Math.abs(sum))
					sum = arr[i] + arr[j];
				else if (Math.abs(arr[i] + arr[j]) == Math.abs(sum))
					sum = arr[i] + arr[j] > 0 ? arr[i] + arr[j] : sum ;
		return sum;
	}
	
	int twoSumClosestPair2Zero(int[] arr, float sortBinSrch)
	{
		if (DEBUG && arr.length < 10) System.out.printf("In twoSumClosestPair2Zero(int[]=%s,"
				+ "↑bSrch)\n", Arrays.toString(arr));
		
		int sum = Integer.MAX_VALUE;
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length - 1; i++) {
			int low = i + 1, high = arr.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (arr[i] + arr[mid] == 0)
					return 0;
				else if (arr[i] + arr[mid] > 0)
					high = mid - 1;
				else
					low = mid + 1;
				
				if (Math.abs(arr[i] + arr[mid]) < Math.abs(sum))
					sum = arr[i] + arr[mid];
				else if (Math.abs(arr[i] + arr[mid]) == Math.abs(sum))
					sum = Math.max(arr[i] + arr[mid], sum);
			}
		}
			
		return sum;
	}
	
	int twoSumClosestPair2Zero(int[] arr, int sortBinSrch)
	{
		if (DEBUG && arr.length < 10) System.out.printf("In twoSumClosestPair2Zero(int[]=%s,"
				+ "↑2*)\n", Arrays.toString(arr));
		
		int sum = Integer.MAX_VALUE;
		
		Arrays.sort(arr);
		
		int left = 0, right = arr.length - 1;
		while (left < right) {			
			if (Math.abs(arr[left] + arr[right]) < Math.abs(sum))
				sum = arr[left] + arr[right];
			else if (Math.abs(arr[left] + arr[right]) == Math.abs(sum))
				sum = Math.max(arr[left] + arr[right], sum);
			
			if (arr[left] + arr[right] == 0)
				return 0;
			else if (arr[left] + arr[right] > 0)
				right--;
			else
				left++;
		}
			
		return sum;
	}
	
	@Override
	int[] divideArrayInto3Parts(int[] arr, double genAllPos)
	{
		if (genAllPos != 0)
			return super.divideArrayInto3Parts(arr, genAllPos);
			
		if (DEBUG && arr.length < 11) System.out.printf("In divideArrayInto3Parts(int[]=%s"
				+ ",gen!)\n", Arrays.toString(arr));
		
		if (arr.length > 2) {
			outerloop:
			for (int i = 0; i < arr.length - 2; i++)
				for (int j = i + 1; j < arr.length - 1; j++)
					for (int k = j + 1; k < arr.length; k++) {
						if (Thread.interrupted())
							break outerloop;
						int sum1 = 0, sum2 = 0, sum3 = 0;
						for (int l = 0; l <= i; l++)
							sum1 += arr[l];
						for (int l = j; l <= k; l++)
							sum2 += arr[l];
						for (int l = k; l < arr.length; l++)
							sum3 += arr[l];
						if (sum1 == sum2 && sum1 == sum3)
							return new int[] {i, j};
					}
		}
		
		return new int[] {-1, -1};
	}
	
	int[] divideArrayInto3Parts(int[] arr, int runningSum)
	{
		if (DEBUG && arr.length < 11) System.out.printf("In divideArrayInto3Parts(int[]=%s"
				+ ",+→)\n", Arrays.toString(arr));
		
		int total, sum = 0;
		if (arr.length > 2 && (total = Arrays.stream(arr).sum()) % 3 == 0) {
			for (int i = 0, res[] = {-1, -1}, j = 0; i < arr.length; i++) {
				if (Thread.interrupted())
					break;
				sum += arr[i];
				if (sum == total / 3) {
					res[j++] = i;
					if (j == 2 && i != arr.length - 1)
						return res;
					sum = 0;
				}
			}
		}
		
		return new int[] {-1, -1};
	}
	
	Integer maxOnes(int[] arr, int key, double genAll)
	{
		if (DEBUG && arr.length < 11) System.out.printf("In maxOnes(int[]=%s,int=%d"
				+ ",gen!)\n", Arrays.toString(arr), key);
		
		int res = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i; j < arr.length; j++) {
				if (Thread.interrupted())
					return null;
				else if (arr[j] == 0)
					count++;
				if (count <= key)
					res = Math.max(res, j - (i - 1));
			}
		}
		
		return arr.length == 0 ? 0 : res ;
	}
	
	Integer maxOnes(int[] arr, int key, int slidingWindow)
	{
		if (DEBUG && arr.length < 11) System.out.printf("In maxOnes(int[]=%s,int=%d"
				+ ",▯⟶)\n", Arrays.toString(arr), key);
		
		int res = 0, start = 0, end = 0, n = arr.length, count = 0;
		
		while (end < n) {
			if (arr[end] == 0)
				count++;
			while (count > key) {
				if (arr[start] == 0)
					count--;
				start++;
			}
			res = Math.max(res, end - (start - 1));
			end++;
		}
		
		return arr.length == 0 ? 0 : res ;
	}
	
	// Driver code
	public static void main(String[] args) {
		
		// NOTE To enable assert use '-ea' in run config > arguments > VM arguments
		try (Scanner scn = new Scanner(System.in)) {
//			System.out.println(duplicatedWithinKdist(new int[] {1, 2, 3, -1, 4, 5, 6, 4}, 3f));
//			System.out.println(Arrays.toString(new EasyProblems().setEvenPosGrtr(
//					/*BubbleSort.getRandomArray(scn)*/
//					new int[] {2, 0, 3, 4, 1}, true)));
//			System.out.println(new EasyProblems().
//					sumOfAllSubArrays(new int[] {1, 4, 5, 3, 2}));
//			System.out.println(buySellStocks(new int[] {100, 180, 260, 310, 40, 535, 695}));
//			System.out.println(singleAmongDoubles(new int[] {2, 3, 5, 4, 5, 3, 4}
//					/*BubbleSort.getRandomArray(scn)*/, 1));
//			missingNumberTest();
//			missingNRepeatingNumberTest();
//			singleRepeatTest();
//			sortedSubsequenceOf3Test();
//			maxSubarraySumTest();
//			equilibriumIndexTest();
//			pairWithGivenSumTest();
//			twoSumClosestPair2ZeoTest();
//			divideArrayInto3PartsTest();
			maxOnesTest();
		} catch (NumberFormatException | java.util.NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	// Utility Function
	private static <T, U, V> V task(BiFunctionLocale<T, U, V> func, T t, U u)
	{
		ExecutorService executor = newSingleThreadExecutor();
		
		Callable<V> task = () -> {
			return func.bifunc(t, u);
		}; 
		
		Future<V> future = executor.submit(task);
		
		try {
			return future.get(10, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			System.out.println(e);
			future.cancel(true);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
		
		return null;
	}
	
	private static <T, U, V, W> W task(TriFunctionLocale<T, U, V, W> func, T t, U u, V v)
	{
		ExecutorService executor = newSingleThreadExecutor();
		
		Callable<W> task = () -> {
			return func.trifunc(t, u, v);
		};
		
		Future<W> future = executor.submit(task);
		
		try {
			return future.get(10, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			System.out.println(e);
			future.cancel(true);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();			
		} finally {
			executor.shutdown();
		}
		
		return null;
	}
	
	private static void missingNumberTest()
	{
//		double val = 0;
//		float val = 0;
		int val = 0;
		int i = missingNumber(new int[] {8, 2, 4, 5, 3, 7, 1}, val);
		assert i == 6 : "Application logic error";
		System.out.println(i);
		i = missingNumber(new int[] {1, 2, 3, 5}, val);
		assert i == 4 : "Application logic error";
		System.out.println(i);
		i = missingNumber(new int[] {1, 2, 3, 4}, val);
		assert i == 5 : "Application logic error";
		System.out.println(i);
		i = missingNumber(new int[0], val);
		assert i == 1 : "Application logic error";
		System.out.println(i);
	}
	
	private static void missingNRepeatingNumberTest()
	{
//		double val = 0;
//		float val = 0;
//		long val = 0;
		int val = 0;
		int arr[] = missingNRepeatingNumber(new int[] {3, 1, 3}, val);
		assert Arrays.equals(arr, new int[] {2, 0, 3}) : "Application logic error";
		System.out.println(Arrays.toString(arr));
		arr = missingNRepeatingNumber(new int[] {4, 3, 6, 2, 1, 1}, val);
		assert Arrays.equals(arr, new int[] {5, 0, 1}) : "Application logic error";
		System.out.println(Arrays.toString(arr));
		arr = missingNRepeatingNumber(new int[] {1, 2, 3}, val);
		assert Arrays.equals(arr, new int[] {0, 0, 0}) : "Application logic error";
		System.out.println(Arrays.toString(arr));
		arr = missingNRepeatingNumber(new int[] {1}, val);
		assert Arrays.equals(arr, new int[] {0, 0, 0}) : "Application logic error";
		System.out.println(Arrays.toString(arr));
		arr = missingNRepeatingNumber(new int[] {}, val);
		assert Arrays.equals(arr, new int[] {0, 0, 0}) : "Application logic error";
		System.out.println(Arrays.toString(arr));
	}
	
	private static void singleRepeatTest()
	{
//		double opt = 0;
//		float opt = 0;
//		long opt = 1;
//		int opt = 0;
//		short opt = 1;
//		char opt = 0;
		byte opt = 0;
		int val = singleRepeat(new int[] {1, 5, 1, 2, 3, 4}, opt);
		assert val == 1 : "Application logic error";
		System.out.println(val);
		val = singleRepeat(new int[] {1, 3, 2, 3, 4}, opt);
		assert val == 3 : "Application logic error";
		System.out.println(val);
		val = singleRepeat(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 11}, opt);
		assert val == 0 : "Application logic error";
		System.out.println(val);
		val = singleRepeat(new int[] {1}, opt);
		assert val == 0 : "Application logic error";
		System.out.println(val);
		val = singleRepeat(new int[] {}, opt);
		assert val == 0 : "Application logic error";
		System.out.println(val);
	}
	
	private static void sortedSubsequenceOf3Test()
	{
//		double opt = 0;
//		float opt = 0;
		int opt = 1;
		int[] res = new EasyProblems().sortedSubsequenceOf3(new int[] {12, 11, 10, 5, 6, 2, 30},
															opt);
		assert Arrays.equals(res, new int[] {5, 6, 30}) : "Application Logic Error";
		System.out.println(Arrays.toString(res));
		res = new EasyProblems().sortedSubsequenceOf3(new int[] {1, 2, 3, 4}, opt);
		assert Arrays.equals(res, new int[] {1, 2, 3}) || 
			   Arrays.equals(res, new int[] {1, 2, 4}) ||
			   Arrays.equals(res, new int[] {1, 3, 4}) ||
			   Arrays.equals(res, new int[] {2, 3, 4})  : "Application Logic Error";
		System.out.println(Arrays.toString(res));
		res = new EasyProblems().sortedSubsequenceOf3(new int[] {4, 3, 2, 1}, opt);
		assert Arrays.equals(res, new int[0]) : "Application Logic Error";
		System.out.println(Arrays.toString(res));
		res = new EasyProblems().sortedSubsequenceOf3(new int[] {1}, opt);
		assert Arrays.equals(res, new int[0]) : "Application Logic Error";
		System.out.println(Arrays.toString(res));
		res = new EasyProblems().sortedSubsequenceOf3(new int[] {},	opt);
		assert Arrays.equals(res, new int[0]) : "Application Logic Error";
		System.out.println(Arrays.toString(res));
		res = new EasyProblems().sortedSubsequenceOf3(new int[] {4, 3, 2, 1, 2, 3}, opt);
		assert Arrays.equals(res, new int[] {1, 2, 3}) : "Application Logic Error";
		System.out.println(Arrays.toString(res));
		res = new EasyProblems().sortedSubsequenceOf3(new int[] {4, 3, 2, 1, 2}, opt);
		assert Arrays.equals(res, new int[0]) : "Application Logic Error";
		System.out.println(Arrays.toString(res));
		res = new EasyProblems().sortedSubsequenceOf3(new int[] {4, 3, 2, 1, 2, 2}, opt);
		assert Arrays.equals(res, new int[0]) : "Application Logic Error";
		System.out.println(Arrays.toString(res));
	}
	
	private static void maxSubarraySumTest()
	{
//		double opt = 0;
		int opt = 0;
		int res = new EasyProblems().maxSubarraySum(new int[] {2, 3, -8, 7, -1, 2, 3}, opt);
		assert res == 11 : "Application logic error";
		System.out.println(res);
		res = new EasyProblems().maxSubarraySum(new int[] {-2, -4}, opt);
		assert res == -2: "Application logic error";
		System.out.println(res);
		res = new EasyProblems().maxSubarraySum(new int[] {5, 4, 1, 7, 8}, opt);
		assert res == 25 : "Application logic error";
		System.out.println(res);
		res = new EasyProblems().maxSubarraySum(new int[] {5}, opt);
		assert res == 5 : "Application logic error";
		System.out.println(res);
		res = new EasyProblems().maxSubarraySum(new int[] {}, opt);
		assert res == -1 : "Application logic error";
		System.out.println(res);
		res = new EasyProblems().maxSubarraySum(new int[] {5, 5, 5, 5, 5}, opt);
		assert res == 25 : "Application logic error";
		System.out.println(res);
	}
	
	private static void equilibriumIndexTest()
	{
//		double opt = 0;
		float opt = 0;
//		int opt = 0;
		int res = new EasyProblems().equilibriumIndex(new int[] {1, 2, 0, 3}, opt);
		assert res == 2 : "Failed equilibriumIndex(1, 2, 0, 3) exp: 2 but res=" + res;
		System.out.println(res);
		res = new EasyProblems().equilibriumIndex(new int[] {1, 1, 1, 1}, opt);
		assert res == -1 : "Failed for equilibriumIndex(1, 1, 1, 1) exp: -1 res=" + res;
		System.out.println(res);
		res = new EasyProblems().equilibriumIndex(new int[] {-7, 1, 5, 2, -4, 3, 0}, opt);
		assert res == 3 : "Failed for equilibriumIndex(-7, 1, 5, 2, -4, 3, 0) exp: 3 res=" + res;
		System.out.println(res);
		res = new EasyProblems().equilibriumIndex(new int[] {2, 2}, opt);
		assert res == -1 : "Failed for equilibriumIndex(2, 2) exp: -1 res=" + res;
		System.out.println(res);
		res = new EasyProblems().equilibriumIndex(new int[] {1}, opt);
		assert res == -1 : "Failed for equilibriumIndex(1) exp: -1 res=" + res;
		System.out.println(res);
		res = new EasyProblems().equilibriumIndex(new int[] {}, opt);
		assert res == -1 : "Failed for equilibriumIndex({}) exp: -1 res=" + res;
		System.out.println(res);
		res = new EasyProblems().equilibriumIndex(new int[] {0, 1, -1}, opt);
		assert res == 0 : "Failed for equilibriumIndex({}) exp: 0 res=" + res;
		System.out.println(res);
	}
	
	private static void pairWithGivenSumTest()
	{
//		double opt = 0;
//		float opt = 0;
		int opt = 0;
//		short opt = 0;
		
        boolean res = new EasyProblems().pairWithGivenSum(new int[]{0, -1, 2, -3, 1}, -2, opt);
        assert res : "Test-1: Failed for pairWithGivenSum({0, -1, 2, -3, 1}, -2) exp=true but res=" + res;
        System.out.println(res);
        
        res = new EasyProblems().pairWithGivenSum(new int[]{1, -2, 1, 0, 5}, 0, opt);
        assert !res : "Test-1: Failed for pairWithGivenSum({0, -1, 2, -3, 1}, -2) exp=false but res=" + res;
        System.out.println(res);
        
		// Test 1: Empty array — no pairs
        res = new EasyProblems().pairWithGivenSum(new int[]{}, 10, opt);
        assert !res : "Test-1: Failed for pairWithGivenSum({}, 10) exp=false but res=" + res;
        System.out.println(res);

        // Test 2: Single element — can't form a pair
        res = new EasyProblems().pairWithGivenSum(new int[]{5}, 10, opt);
        assert !res : "Test-2: Failed for pairWithGivenSum({5}, 10) exp=false but res=" + res;
        System.out.println(res);

        // Test 3: Two elements that sum to target
        res = new EasyProblems().pairWithGivenSum(new int[]{4, 6}, 10, opt);
        assert res : "Test-3: Failed for pairWithGivenSum({4, 6}, 10) exp=true but res=" + res;
        System.out.println(res);

        // Test 4: Two elements, no valid pair
        res = new EasyProblems().pairWithGivenSum(new int[]{1, 2}, 10, opt);
        assert !res : "Test-4: Failed for pairWithGivenSum({1, 2}, 10) exp=false but res=" + res;
        System.out.println(res);

        // Test 5: All identical elements, valid pair
        int[] arr5 = new int[100000];
        for (int i = 0; i < arr5.length; i++) arr5[i] = 5;
        res = new EasyProblems().pairWithGivenSum(arr5, 10, opt);
        assert res : "Test-5: Failed for pairWithGivenSum({5,...}, 10) exp=true but res=" + res;
        System.out.println(res);

        // Test 6: All identical elements, no valid pair
        int[] arr6 = new int[100000];
        for (int i = 0; i < arr6.length; i++) arr6[i] = 3;
        res = new EasyProblems().pairWithGivenSum(arr6, 10, opt);
        assert !res : "Test-6: Failed for pairWithGivenSum({3,...}, 10) exp=false but res=" + res;
        System.out.println(res);

        // Test 7: Very large array with valid pair at ends
        int[] arr7 = new int[1000000];
        for (int i = 0; i < 499999; i++) arr7[i] = 1;
        arr7[499999] = 2;
        for (int i = 500000; i < 1000000; i++) arr7[i] = 999999;
        res = new EasyProblems().pairWithGivenSum(arr7, 1000001, opt);
        assert res : "Test-7: Failed for pairWithGivenSum({...}, 1000001) exp=true but res=" + res;
        System.out.println(res);

        // Test 8: Large array, no two elements sum to target
        int[] arr8 = new int[1000000];
        for (int i = 0; i < 1000000; i++) arr8[i] = i + 1;
        res = new EasyProblems().pairWithGivenSum(arr8, 200002, opt);
        assert res : "Test-8: Failed for pairWithGivenSum({1,2,...}, 200002) exp=true but res=" + res;
        System.out.println(res);

        // Test 9: Negative and positive values sum to 0
        res = new EasyProblems().pairWithGivenSum(new int[]{-1000000, 1000000, 5, 3}, 0, opt);
        assert res : "Test-9: Failed for pairWithGivenSum({-1000000, 1000000, 5, 3}, 0) exp=true but res=" + res;
        System.out.println(res);

        // Test 10: Integer overflow boundaries (32-bit)
        res = new EasyProblems().pairWithGivenSum(new int[]{2147483637, 10, -10}, 2147483647, opt);
        assert res : "Test-10: Failed for pairWithGivenSum({2147483640, 10, -10}, 2147483647) exp=true but res=" + res;
        System.out.println(res);

        // Test 11: Duplicates allowed in solution
        res = new EasyProblems().pairWithGivenSum(new int[]{5, 5, 3}, 10, opt);
        assert res : "Test-11: Failed for pairWithGivenSum({5, 5, 3}, 10) exp=true but res=" + res;
        System.out.println(res);

        // Test 12: Zeroes in the array
        res = new EasyProblems().pairWithGivenSum(new int[]{0, 0, 1}, 0, opt);
        assert res : "Test-12: Failed for pairWithGivenSum({0, 0, 1}, 0) exp=true but res=" + res;
        System.out.println(res);

        // Test 13: Negative sum
        res = new EasyProblems().pairWithGivenSum(new int[]{-3, -7, 10}, -10, opt);
        assert res : "Test-13: Failed for pairWithGivenSum({-3, -7, 10}, -10) exp=true but res=" + res;
        System.out.println(res);

        // Test 14: 1M elements with no valid pair (just for performance)
        int[] arr14 = new int[1000000];
        for (int i = 0; i < 1000000; i++) arr14[i] = i * 2;
        res = new EasyProblems().pairWithGivenSum(arr14, 1999999, opt);
        assert !res : "Test-14: Failed for pairWithGivenSum({0,2,4,...}, 1999999) exp=false but res=" + res;
        System.out.println(res);

	}
	
	private static void twoSumClosestPair2ZeoTest()
	{
//		double opt = 0;
//		float opt = 0;
		int opt = 0;
		
        // Test-1: Basic test case
        int res = new EasyProblems().twoSumClosestPair2Zero(new int[]{-8, 5, 2, -6}, opt);
        assert res == -1 : "Test-1: Failed for twoSumClosestPair2Zero(-8,5,2,-6) exp=-1 but res=" + res;
        System.out.println(res);

        // Test-2: Closest positive and negative pair
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{1, 60, -10, 70, -80, 85}, opt);
        assert res == 5 : "Test-2: Failed for twoSumClosestPair2Zero(1,60,-10,70,-80,85) exp=5 but res=" + res;
        System.out.println(res);

        // Test-3: All negative numbers
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{-5, -3, -1, -7}, opt);
        assert res == -4 : "Test-3: Failed for twoSumClosestPair2Zero(-5,-3,-1,-7) exp=-4 but res=" + res;
        System.out.println(res);

        // Test-4: All positive numbers
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{2, 3, 6, 8}, opt);
        assert res == 5 : "Test-4: Failed for twoSumClosestPair2Zero(2,3,6,8) exp=5 but res=" + res;
        System.out.println(res);

        // Test-5: Multiple closest-to-zero sums (check maximum sum among them)
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{-3, 1, 2, -2}, opt);
        assert res == 0 : "Test-5: Failed for twoSumClosestPair2Zero(-3,1,2,-2) exp=0 but res=" + res;
        System.out.println(res);

        // Test-6: Includes zero
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{-1, 0, 1}, opt);
        assert res == 0 : "Test-6: Failed for twoSumClosestPair2Zero(-1,0,1) exp=0 but res=" + res;
        System.out.println(res);

        // Test-7: Exactly zero sum (like -2, 2)
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{-2, 4, 2, -4}, opt);
        assert res == 0 : "Test-7: Failed for twoSumClosestPair2Zero(-2,4,2,-4) exp=0 but res=" + res;
        System.out.println(res);

        // Test-8: Large numbers
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{Integer.MAX_VALUE, -1, -Integer.MAX_VALUE + 1}, opt);
        assert res == 1 : "Test-8: Failed for twoSumClosestPair2Zero(MAX,-1,MIN+1) exp=1 but res=" + res;
        System.out.println(res);

        // Test-9: Very close values
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{-1000000, 999999}, opt);
        assert res == -1 : "Test-9: Failed for twoSumClosestPair2Zero(-1000000,999999) exp=-1 but res=" + res;
        System.out.println(res);

        // Test-10: Only two elements
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{-10, 9}, opt);
        assert res == -1 : "Test-10: Failed for twoSumClosestPair2Zero(-10,9) exp=-1 but res=" + res;
        System.out.println(res);
        
        // Edge cases
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{9}, opt);
        assert res == Integer.MAX_VALUE : "Test-10: Failed for twoSumClosestPair2Zero(9) exp=Integer.MAX_VALUE but res=" + res;
        System.out.println(res);
        
        res = new EasyProblems().twoSumClosestPair2Zero(new int[]{}, opt);
        assert res == Integer.MAX_VALUE : "Test-10: Failed for twoSumClosestPair2Zero({}) exp=Integer.MAX_VALUE but res=" + res;
        System.out.println(res);
        
        // Stress Test
        int[] largeArr = new int[100000];
        
        for (int i = 0; i < 50000; i++) {
            largeArr[i] = -i;
            largeArr[99999 - i] = i;
        }
        
        res = new EasyProblems().twoSumClosestPair2Zero(largeArr, opt);
        // Closest to 0 would be (-1 + 0) = -1, but (-50000 + 50000) = 0 gives maximum
        assert res == 0 : "Stress-Test: Failed for twoSumClosestPair2Zero(0,-1,..,50000,..), exp=0 but res=" + res;
        System.out.println(res);
	}
	
	private static void divideArrayInto3PartsTest()
	{
//		Double opt = 0.0;
		Integer opt = 0;
		
		// Test-1: Empty array (edge case)
		int[] res = new EasyProblems().divideArrayInto3Parts(new int[]{}, opt);
		assert res[0] == -1 && res[1] == -1 : "Test-1: Failed for divideArrayInto3Parts([]) exp=[-1,-1] but res=[" + res[0] + "," + res[1] + "]";
		System.out.println("Test-1: " + Arrays.toString(res));

		// Test-2: Singleton array (edge case)
		res = new EasyProblems().divideArrayInto3Parts(new int[]{5}, opt);
		assert res[0] == -1 && res[1] == -1 : "Test-2: Failed for divideArrayInto3Parts([5]) exp=[-1,-1] but res=[" + res[0] + "," + res[1] + "]";
		System.out.println("Test-2: " + Arrays.toString(res));

		// Test-3: Stress test with large equal values
		int[] large = new int[30_000];
		Arrays.fill(large, 3);
		BiFunctionLocale<int[], Integer, int[]> func =
				new EasyProblems()::divideArrayInto3Parts;
		res = task(func, large, opt);
		assert res == null || res[0] > 0 && res[1] > res[0] && res[1] < large.length - 1 : "Test-3: Failed stress test on large array for res=[" + res[0] + "," + res[1] + "]";
		System.out.println("Test-3: " + Arrays.toString(res));

		// Test-4: Valid split in the middle
		res = new EasyProblems().divideArrayInto3Parts(new int[]{1, 3, 4, 0, 4}, opt);
		assert res[0] == 1 && res[1] == 2 : "Test-4: Failed for divideArrayInto3Parts([1, 3, 4, 0, 4]) exp=[1,2] but res=[" + res[0] + "," + res[1] + "]";
		System.out.println("Test-4: " + Arrays.toString(res));

		// Test-5: No valid partition
		res = new EasyProblems().divideArrayInto3Parts(new int[]{1, 2, 3, 4, 5}, opt);
		assert res[0] == -1 && res[1] == -1 : "Test-5: Failed for divideArrayInto3Parts([1,2,3,4,5]) exp=[-1,-1] but res=[" + res[0] + "," + res[1] + "]";
		System.out.println("Test-5: " + Arrays.toString(res));

		// Test-6: All zeros (multiple valid splits possible)
		res = new EasyProblems().divideArrayInto3Parts(new int[]{0, 0, 0, 0, 0, 0}, opt);
		assert res[0] == 0 && res[1] == 1 : "Test-6: Failed for divideArrayInto3Parts([0,0,0,0,0,0]) exp=[0,1] but res=[" + res[0] + "," + res[1] + "]";
		System.out.println("Test-6: " + Arrays.toString(res));

		// Test-7: Valid split with negative numbers
		res = new EasyProblems().divideArrayInto3Parts(new int[]{1, -1, 1, -1, 1, -1, 1, -1}, opt);
		assert res[0] == 1 && res[1] == 3 : "Test-7: Failed for divideArrayInto3Parts([1, -1, 1, -1, 1, -1, 1, -1]) exp=[1,3] but res=[" + res[0] + "," + res[1] + "]";
		System.out.println("Test-7: " + Arrays.toString(res));

	}
	
	private static void maxOnesTest()
	{
//		Double opt = 0.0;
		Integer opt = 0;
		
		// Test-1: Empty array (edge case)
		int res = new EasyProblems().maxOnes(new int[]{}, 2, opt); 
		assert res == 0 : "Test-1: Failed for maxOnes([]) exp=0 but res=" + res; 
		System.out.println("Test-1: " + res);

		// Test-2: No flips allowed (edge case)
		res = new EasyProblems().maxOnes(new int[]{1, 0, 1, 1, 0}, 0, opt); 
		assert res == 2 : "Test-2: Failed for maxOnes([1,0,1,1,0]) k=0 exp=2 but res=" + res; 
		System.out.println("Test-2: " + res);

		// Test-3: Stress case (large array with 2 zeros)
		int[] largeArr = new int[100000];
		Arrays.fill(largeArr, 1);
		largeArr[5000] = 0;
		largeArr[99999] = 0;
		TriFunctionLocale<int[], Integer, Integer, Integer> func =
				new EasyProblems()::maxOnes;	
		Integer resInteger = task(func, largeArr, 2, opt);
		assert resInteger == null || resInteger == 100000 : "Test-3: Failed for maxOnes(largeArray) exp=100000 but res=" + resInteger; 
		System.out.println("Test-3: " + resInteger);

		// Test-4: Flip all zeros
		res = new EasyProblems().maxOnes(new int[]{0, 0, 0}, 3, opt); 
		assert res == 3 : "Test-4: Failed for maxOnes([0,0,0]) k=3 exp=3 but res=" + res; 
		System.out.println("Test-4: " + res);

		// Test-5: Mixed zeros and ones
		res = new EasyProblems().maxOnes(new int[]{1, 0, 0, 1, 0, 1, 0, 1}, 2, opt); 
		assert res == 5 : "Test-5: Failed for maxOnes([1,0,0,1,0,1,0,1]) k=2 exp=5 but res=" + res; 
		System.out.println("Test-5: " + res);

		// Test-6: Zeros spread out
		res = new EasyProblems().maxOnes(new int[]{1, 0, 1, 0, 1, 0, 1}, 2, opt); 
		assert res == 5 : "Test-6: Failed for maxOnes([1,0,1,0,1,0,1]) k=2 exp=5 but res=" + res; 
		System.out.println("Test-6: " + res);

		// Test-7: Only one flip needed
		res = new EasyProblems().maxOnes(new int[]{1, 1, 0, 1, 1}, 1, opt); 
		assert res == 5 : "Test-7: Failed for maxOnes([1,1,0,1,1]) k=1 exp=5 but res=" + res; 
		System.out.println("Test-7: " + res);

	}
		
}

class EasyProblemsSuper
{
	boolean duplicatedWithinKdist(int[] arr, int d, boolean callSuper)
	{
		if (callSuper) System.out.printf("In spr.duplicatedWithinKdist(int[]=%s,int=%d,bl=%s)\n", 
						   Arrays.toString(arr), d, callSuper);
		
		for (int i = 0, n = arr.length; i < n; i++)
			for (int c = 1; c <= d && (i + c) < n; c++)
				if (arr[i] == arr[i + c])
					return true;
		
		return false;
	}
	
	int[] setEvenPosGrtr(int[] arr, boolean callSuper)
	{		
		if (callSuper) System.out.printf("In spr.setEvenPosGrtr(int[]=%s,bl=%s)\n", 
						   Arrays.toString(arr), callSuper);
		
		Arrays.sort(arr);
		int n = arr.length, temp[] = new int[n], ptr1 = 0, ptr2 = n - 1;
		
		for (int i = 0; i < n; i++)
			if (i % 2 == 0)
				temp[i] = arr[ptr2--];
			else
				temp[i] = arr[ptr1++];
		
		System.arraycopy(temp, 0, arr, 0, n);
		
		return arr;
	}
	
	int sumOfAllSubArrays(int[] arr, boolean callSuper)
	{
		if (callSuper) System.out.printf("In spr.sumOfAllSubArrays(int[]=%s,bl=%s)\n", 
				   Arrays.toString(arr), callSuper);
		
		for (int i = 0, res = 0; i < arr.length; i++)
			for (int j = i, sum = 0; j < arr.length; j++) {
				sum += arr[j];
				res += sum;
				
				if (i == arr.length - 1)
					return res;
			}
				
		
		return 0;
	}
	
	int buySellStocks(int[] arr, boolean callSuper)
	{			
		if (callSuper) System.out.printf("In spr.buySellStocks(int[]=%s,bl=%s)\n", 
				   Arrays.toString(arr), callSuper);
		
		int res = 0, lMin = arr[0], lMax = arr[0], i = 0, n = arr.length;
		
		while (i < n - 1) {
			while (i < n - 1 && arr[i] >= arr[i + 1])
				i++;
			lMin = arr[i];
			
			while (i < n - 1 && arr[i] <= arr[i + 1])
				i++;
			lMax = arr[i];
			
			res += lMax - lMin;
		}
		
		return res;
	}
	
	List<Integer> singleAmongDoubles(int[] arr, boolean callSuper)
	{
		if (callSuper) System.out.printf("In spr.singleAmongDoubles(int[]=%s,bl=%s)\n", 
				   Arrays.toString(arr), callSuper);
		
		Set<Integer> res = new HashSet<>();
		
		for (int i : arr) {
			int count = 0;
			for (int j = 0; j < arr.length; j++)
				if (arr[j] == i)
					count++;
			if (count == 1)
				res.add(i);
		}
		
		return res.stream()
				  .toList();
	}
	
	int singleRepeat(int arr[], long collections)
	{
		if (collections == 1) System.out.printf("In spr.singleRepeat(int[]=%s,coll)\n", 
				   Arrays.toString(arr));
		
		Set<Integer> set = new HashSet<>();
		
		for (int i : arr) {
			int size = set.size();
			set.add(i);
			if (set.size() == size)
				return i;
		}
		
		return 0;
	}
	
	int singleRepeat(int arr[], short xOr)
	{
		if ((xOr = 0) == 0) System.out.printf("In spr.singleRepeat(int[]=%s,xOr)\n", 
				   Arrays.toString(arr));
		
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++)
			xOr ^= (i + 1) ^ arr[i];
		
		if (n != 0)
			xOr ^= arr[n - 1];
		
		return xOr == n ? 0 : xOr ;
	}

	int[] sortedSubsequenceOf3(int arr[], float doublePointer)
	{
		if (doublePointer == 1) System.out.printf("In spr.sortedSubsequenceOf3(int[]=%s,"
				+ "dblPtr)\n", Arrays.toString(arr));
		
		int n = arr.length;
		
		if (n > 2) {
			int left[] = new int[n], right[] = new int[n], min = 0, max = n - 1;
			
			left[min] = right[max] = -1;
			for (int i = 1; i < n; i++)
				if (arr[i] <= arr[min]) {
					min = i;
					left[i] = -1;
				} else
					left[i] = min;
			
			for (int i = n - 2; i >= 0; i--)
				if (arr[i] >= arr[max]) {
					max = i;
					right[i] = -1;
				} else
					right[i] = max;
			
			for (int i = 0; i < n; i++)
				if (left[i] != -1 && right[i] != -1)
					return new int[] {arr[left[i]], arr[i], arr[right[i]]};
		}
		
		return new int[] {};
	}
	
	int[] sortedSubsequenceOf3(int arr[], int twoMinimum)
	{			
		if (twoMinimum == 1) System.out.printf("In sortedSubsequenceOf3(int[]=%s,2min)\n",
				Arrays.toString(arr));
		
		int n = arr.length;
		
		if (n > 2) {
			int minNum = arr[0], seq = 1, maxSeq = Integer.MIN_VALUE, storeMin = minNum;
			
			for (int i : arr)
				if (i == minNum)
					continue;
				else if (i < minNum)
					minNum = i;
				else if (i < maxSeq) {
					maxSeq = i;
					storeMin = minNum;
				} else if (i > maxSeq) {
					seq++;
					if (seq == 3)
						return new int[] {storeMin, minNum, i};
					maxSeq = i;
				}
		}
		
		return new int[] {};
	}
	
	int[] divideArrayInto3Parts(int[] arr, double genAllPos)
	{
		if (genAllPos == 1 && arr.length < 11) System.out.printf("In spr.divideArrayInto3Parts(int[]=%s"
				+ ",gen!)\n", Arrays.toString(arr));
		
		if (arr.length > 2) {
			outerloop:
			for (int i = 0, n = arr.length; i < n - 2; i++)
				for (int j = i + 1; j < n - 1; j++) {
					if (Thread.interrupted())
						break outerloop;
					int sum1 = Arrays.stream(arr).limit(i + 1).sum();
					int sum2 = Arrays.stream(arr).skip(i + 1).limit(j - i).sum();
					int sum3 = Arrays.stream(arr).skip(j + 1).sum();
//					int sum1 = 0, sum2 = 0, sum3 = 0;
//					
//					for (int k = 0; k <= i; k++)
//						sum1 += arr[k];
//					
//					for (int k = i + 1; k <= j; k++)
//						sum2 += arr[k];
//					
//					for (int k = j + 1; k < n; k++)
//						sum3 += arr[k];
					
					if (sum1 == sum2 && sum1 == sum3)
						return new int[] {i, j};
				}
					
		}
		
		return new int[] {-1, -1};
	}
}