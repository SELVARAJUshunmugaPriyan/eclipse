package steams;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Streams1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// find first duplicate
		List<Integer> res = Arrays.asList(1, 2, 3, 1, 4, 5, 5);
		
		int result = res.stream()
				 		.filter(x -> (res.stream()
				 						.filter(y -> y == x)
				 						.count()
				 				     ) > 1).findFirst().get();
		// 1st Duplicate
		String str = "programming";
		
		result = str.chars()
					.mapToObj(x -> (char) x)
					.collect(Collectors.groupingBy(x -> x,
							 LinkedHashMap:: new,
							 Collectors.counting()))
					.entrySet()
					.stream()
					.filter(x -> x.getValue() > 1)
					.map(Map.Entry::getKey)
					.findFirst()
					.get();
		
		System.out.println((char) result);
		
		// 1st Duplicate with Count
		Map.Entry<Character, Long> firstCount = str.chars()
												   .mapToObj(x -> (char) x)
												   .collect(Collectors.groupingBy(
														   		x -> x,
														   		LinkedHashMap::new,
														   		Collectors.counting()
														   	))
												   .entrySet()
												   .stream()
												   .filter(x -> x.getValue() > 1)
												   .findFirst()
												   .orElse(null);
		
		System.out.println(firstCount.getKey() + " " + firstCount.getValue());
		
		// 2nd duplicate
		char secondCount = str.chars()
							  .mapToObj(x -> (char) x)
							  .collect(Collectors.groupingBy(
									  		x -> x,
									  		LinkedHashMap::new,
									  		Collectors.counting()
									  ))
							  .entrySet()
							  .stream()
							  .filter(x -> x.getValue() > 1)
							  .skip(1)
							  .map(x -> x.getKey())
							  .findFirst()
							  .get();
		
		System.out.println(secondCount);
		
		// 2nd Duplicate with count
		Map.Entry<Character, Long> secondCountMapEntry = str.chars()
															.mapToObj(x -> (char) x)
															.collect(Collectors.groupingBy(
																		x -> x,
																		LinkedHashMap::new,
																		Collectors.counting()
																	))
															.entrySet()
															.stream()
															.filter(x -> x.getValue() > 1)
															.skip(1)
															.findFirst()
															.get();
		
		System.out.println(secondCountMapEntry.getKey() + " " + 
				secondCountMapEntry.getValue());
		
		// Last Duplicate with reduce method
		char lastDuplicate = str.chars()
								.mapToObj(x -> (char) x)
								.collect(Collectors.groupingBy(
											x -> x,
											LinkedHashMap::new,
											Collectors.counting()
										))
								.entrySet()
								.stream()
								.filter(x -> x.getValue() > 1)
								.map(Map.Entry::getKey)
								.reduce((x, y) -> y)
								.get();
		
		System.out.println(lastDuplicate);
		
		// Last Duplicate without reduce method
		List<Character> duplicates = str.chars()
										.mapToObj(x -> (char) x)
										.collect(Collectors.groupingBy(
													x -> x,
													LinkedHashMap::new,
													Collectors.counting()
												))
										.entrySet()
										.stream()
										.filter(x -> x.getValue() > 1)
										.map(Map.Entry::getKey)
										.collect(Collectors.toList());
		
		System.out.println(duplicates.get(duplicates.size() - 1));
		
		// 2nd last Duplicate
		duplicates = str.chars()
					   .mapToObj(x -> (char) x)
					   .collect(Collectors.groupingBy(
							   		x -> x,
							   		LinkedHashMap::new,
							   		Collectors.counting()
							   ))
					   .entrySet()
					   .stream()
					   .filter(x -> x.getValue() > 1)
					   .map(Map.Entry::getKey)
					   .collect(Collectors.toList());
		
		char secondLast = duplicates.get(duplicates.size() - 1);
		System.out.println(secondLast);
		
		// Max Duplicate
		char maxDuplicate = str.chars()
							   .mapToObj(x -> (char) x)
							   .collect(Collectors.groupingBy(
									   		x -> x,
									   		LinkedHashMap::new,
									   		Collectors.counting()
									   ))
							   .entrySet()
							   .stream()
							   .max(Map.Entry.comparingByValue())
							   .map(x -> x.getKey())
							   .get();
		
		System.out.println(maxDuplicate);
		
		// 2nd Max Duplicate
		List<Character> max2nd = str.chars()
									.mapToObj(x -> (char) x)
									.collect(Collectors.groupingBy(
												x -> x,
												LinkedHashMap::new,
												Collectors.counting()
											))
									.entrySet()
									.stream()
									.filter(x -> x.getValue() > 1)
									.sorted(Comparator.comparingLong(
												Map.Entry<Character, Long>::getValue
										   )
										   .reversed())
									.map(Map.Entry::getKey)
									.skip(1)
									.toList();
		
		System.out.println(max2nd);
		
		// Finding the duplicate in the integer array
		int[] n1 = { 40, 20, 20, 10, 30, 40 };
		LinkedHashSet<Integer> num = new LinkedHashSet<>();
		List<Integer> n = Arrays.stream(n1)
							  .boxed()
							  .filter(x -> !num.add(x))
							  .toList();
		List<Integer> num1 = new ArrayList<>(num);
		
		Collections.sort(num1);
		
		System.out.println(num); // distinct
		System.out.println(n);
		
		// finding duplicate in integer array using grouping method
		List<Integer> nums = Arrays.stream(n1)
										.boxed()
										.collect(Collectors.groupingBy(
													x -> x,
													LinkedHashMap::new,
													Collectors.counting()
												))
										.entrySet()
										.stream()
										.filter(x -> x.getValue() > 1)
										.map(x -> x.getKey())
										.toList();
		
		System.out.println(nums);
		
		// finding duplicate integer in string
		String val = "ajaisuriya2243@gmail.com";
		
		Character dupInt = val
								.chars()
								.mapToObj(x -> (char) x)
								.filter(x -> x >= '0' && x <= '9')
								.collect(Collectors.groupingBy(
											x -> x,
											Collectors.counting()
										))
								.entrySet()
								.stream()
								.filter(x -> x.getValue() > 1)
								.map(x -> x.getKey())
								.findFirst()
								.orElse((char) 0);
		
		System.out.println(dupInt);
		
		// Anagram
		String a = "silent";
		String b = "listen";
		
		boolean anagram = Arrays.equals(a.chars().sorted().toArray(),
										b.chars().sorted().toArray());
		
		System.out.println( anagram ? "It is anagram" : "It is not anagram" );
	}

}
