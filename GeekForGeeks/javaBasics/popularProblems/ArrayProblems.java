package popularProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class ArrayProblems {
	
	private static final boolean DEBUG = true;
	
	private static int secondMax(int arr[])
	{
		int scndMax, max;
		boolean isChanged = false;
		max = scndMax = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				scndMax = max;
				max = arr[i];
			} else if (arr[i] > scndMax && arr[i] != max) {
				isChanged = true;
				scndMax = arr[i];
			}
		}
		if (scndMax == max || !isChanged)
			return -1;
		
		return scndMax;
	}
	
	private static int minJumps(int[] arr) {
		if (DEBUG) System.out.println(Arrays.toString(arr));
        int lmt = arr[0], count = 0;
        
        if (lmt == 0)
            count = -1;
        else {
        	count++;
        	int i = 0;
        	System.out.println(i + " " + arr[i]);
            while (i < lmt) {
                i = maxStep(arr, i + 1, arr[i]);
                System.out.println(i + " " + arr[i]);
                lmt += arr[i];
                count++;
                if (lmt >= arr.length - 1)
                    break;
                if (arr[i] == 0) {
                    count = -1;
                    break;
                }
            }
        }
        
        return count;
    }
	
	private static int maxStep(int arr[], int start, int limit)
	{
		int max = start;
		for (int i = start; i < start + limit; i++)
			if (arr[i] >= arr[max])
				max = i;
		return max;
	}
	
	private static ArrayList<Integer> findDuplicates(int arr[])
	{
		return Arrays.stream(arr)
					 .filter(x -> 
					 	Arrays.stream(arr)
					 		  .filter(y -> y == x)
					 		  .count() > 1)
					 .distinct()
					 .boxed()
					 .collect(Collectors.toCollection(ArrayList::new));
	}
	
	private static int majorityElement(int arr[]) {
        // code here
        int freqArray[] = new int[100_000];
        int chkdArray[] = new int[100_000];
        boolean isSet = false;
        int maj = arr[0], chkdIdx = 0;
        outerloop:
        for (int i = 0; i < arr.length; i++) {
        	for (int j = 0; j < chkdIdx; j++)
        		if (arr[i] == chkdArray[j])
        			continue outerloop;
            freqArray[arr[i]]++;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j])
                    freqArray[arr[i]]++;
            if ((freqArray[arr[i]] > arr.length / 2.0) && 
                freqArray[arr[i]] >= freqArray[maj]) {
                    maj = arr[i];
                    isSet = true;
                }
            chkdArray[chkdIdx++] = arr[i];
        }
        
        if (isSet)
            return maj;
        
        return -1;
    }
	
    static int mergeCount(int arr[], int l, int r)
    {
        int m = (l + r) / 2, res = 0;
        System.out.println("outer: " + l + " " + r);
        if (l < r) {
            res += mergeCount(arr, l, m);
            res += mergeCount(arr, m + 1, r);
            res += count(arr, l, m, r);
        }
        
        return res;
    }
    
    static int count(int arr[], int l, int m, int r)
    {
        int n = m - l + 1, o = r - m, left[] = new int[n], right[] = new int[o],
            res = 0, i = 0, j = 0;
        System.out.println("inner: " + l + " " + m + " " + r + " " + n + " " + o);
        System.arraycopy(arr, l, left, 0, n);
        System.arraycopy(arr, m + 1, right, 0, o);
        
        while (i < n && j < o)
            if (left[i] > right[j] && (res += n - i) > 0)
                arr[l++] = right[j++];
            else
            	arr[l++] = left[i++];
            	
        while (i < n)
            arr[l++] = left[i++];
            
        while (j < o)
            arr[l++] = right[j++];
            
        return res;
    }
    
    static int powerfulInteger(int intervals[][], int k)
    {
    	java.util.TreeMap<Integer, Integer> map = new java.util.TreeMap<>();
    	
    	for (int[] arr : intervals) {
    		map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
    		map.put(arr[1] + 1, map.getOrDefault(arr[1] + 1, 0) - 1);
    	}
    	
    	int ans = -1, temp = 0;
    	
    	for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		int point = entry.getKey();
    		int delta = entry.getValue();
    		
    		if (delta >= 0) {
    			temp += delta;
    			if (temp >= k)
    				ans = point;
    		} else {
    			if (temp >= k)
    				ans = point - 1;
    			temp += delta;
    		}
    	}
    	
    	return ans;
    }
    
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		System.out.println(secondMax(new int[] {10, 10, 5, 10}));
//		try (Scanner scn = new Scanner(System.in)) {
//			while (true) {
//				System.out.println(minJumps(new int[] {3, 2, 1, 1, 0, 5}));
//						javaArrayExcercises
//						.BubbleSort.getRandomArray(scn)));
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		System.out.println(findDuplicates(new int[] {2}));
//		File f = new File("C:\\Users\\monk_\\AppData\\Local\\Temp\\fileInput.txt");
//		Scanner scn = new Scanner(f);
//		ArrayList<Integer> list = new ArrayList<>();
//		while (scn.hasNext())
//			list.add(scn.nextInt());
//		scn.close();
//		int arr[] = new int[list.size()], i = 0;
//		for (int tmp : list)
//			arr[i++] = tmp;
//		System.out.println(majorityElement(arr));
//		System.out.println(mergeCount(new int[] {24, 18, 38, 43, 14, 40, 1, 54}, 0, 7));
		System.out.println(powerfulInteger(new int[][] {{1, 3}, {3, 4}, {3, 6}}, 2));
	}
}
