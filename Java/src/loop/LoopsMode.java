package loop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LoopsMode{
	public static void main(String[] args) {
		String[] vals = args[0].split(",");
		int[] nums = new int[vals.length], indexArray;
		int maxCount = 1, CurrentCount = 1;
		Set<Integer> modes = new HashSet<>();
		

		for(int i = 0; i < nums.length; i++)
			nums[i] = Integer.parseInt(vals[i]);
		
		
		Arrays.sort(nums);
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i - 1])
				CurrentCount++;
			else
				CurrentCount = 1;
			
			if(CurrentCount > maxCount) {
				maxCount = CurrentCount;
				modes.clear();
				modes.add(nums[i]);
			} else if(CurrentCount == maxCount)
				modes.add(nums[i]);
		}
		
		if(nums.length == 1)
			modes.add(nums[0]);
		
		indexArray = new int[modes.size()];
	
		Iterator<Integer> itr = modes.iterator();

		for(int i = 0; i < modes.size(); i++) {
			int j = itr.next();
			for(int k = 0; k < vals.length; k++)
				if(vals[k].equals("" + j)) {
					indexArray[i] = k;
					break;
				}
		}
		
		Arrays.sort(indexArray);
				
		for(int i = 0; i < indexArray.length; i++) {
			System.out.print(vals[indexArray[i]]);
			if(i != indexArray.length - 1)
				System.out.print(",");
		}
		
//		Iterator<Integer> itr = modes.iterator();
//		
//		System.out.print(itr.next());
//		
//		while(itr.hasNext())
//			System.out.print("," + itr.next());
	}
}
//
//package loop;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class LoopsMode {
//	public static void main(String[] args) {
//		String[] vals = args[0].split(",");
//		int[] nums = new int[vals.length];
//		int maxFrequency = 0;
//		
//		Set<Integer> modes = new HashSet<>();
//		Map<Integer, Integer> frequencyMap = new HashMap<>();
//		
//		for(int i = 0; i < nums.length; i++)
//			nums[i] = Integer.parseInt(vals[i]);
//		
//		for(int num : nums)
//			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//		
//		for(int frequency : frequencyMap.values())
//			if(frequency > maxFrequency)
//				maxFrequency = frequency;
//		
//		for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet())
//			if(entry.getValue() == maxFrequency)
//				modes.add(entry.getKey());
//		
//		System.out.print(frequencyMap);
//	}
//}