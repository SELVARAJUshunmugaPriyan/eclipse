package steams;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
		
		// Joining list of Strings
		List<String> names = List.of("ajai", "suriya", "R C");
		String joinedNames = names.stream().collect(Collectors.joining(" "));
		System.out.println(joinedNames);
		
		// Joining Array of Strings
		String[] namesArray = {"ajai", "suriya", "R C"};
		joinedNames = Arrays.stream(namesArray).collect(Collectors.joining(" "));
		System.out.println(joinedNames);
		
		// missing integer
		int[] numArr = {10, 2, 5, 7, 5, 6, 7};
		
		java.util.Set<Integer> numSet = Arrays.stream(numArr)
										      .boxed()
										      .collect(Collectors.toSet());
										    
		int minNum = Arrays.stream(numArr).min().getAsInt();
		int maxNum = Arrays.stream(numArr).max().getAsInt();
		
		int missing = java.util.stream.IntStream.rangeClosed(minNum, maxNum)
//									  .filter(x -> numSet.add(x))
									  .filter(x -> !Arrays.stream(numArr)
											  			 .anyMatch(y -> y == x))
									  .findFirst()
									  .getAsInt();
		
		System.out.println(missing);
		
		// missing integer list (cont. from above)
		nums = java.util.stream.IntStream.rangeClosed(minNum, maxNum)
										 .filter(x -> !numSet.contains(x))
										 .boxed()
										 .collect(Collectors.toList());
		
		System.out.println(nums);
		
		// target sum pairs
		List<Integer> numsA = List.of(2, 4, 3, 5, 7, 8, 1);	
		int missingA = 9;
		
		names = IntStream.range(0, numsA.size())
						 .boxed()
						 .flatMap(i -> IntStream.range(i + 1, numsA.size())
								 			    .filter(
							 			    		j -> numsA.get(i) +
							 			    		     numsA.get(j) == 
							 			    		     missingA
								 			    )
								 			    .mapToObj(
							 			    		j -> "(" + numsA.get(i) +
							 			    			 "," + numsA.get(j) +
							 			    			 ")"
								 			    )
								 )
						 .collect(Collectors.toList());
		
		System.out.println(names);
		
		// target sum pairs with for loop
		names = new ArrayList<>();
		
		for (int i = 0; i < numsA.size(); i++)
			for (int j = i + 1; j < numsA.size(); j++)
				if (numsA.get(i) + numsA.get(j) == missingA)
					names.add("(" + numsA.get(i) + "," + numsA.get(j) + ")");
		
		System.out.println(names);
		
		// find list of prime numbers in given range
		IntStream.rangeClosed(10, 20)
				 .filter(number -> number > 1 &&
						 			IntStream.range(2, number)
						 					 .allMatch(x -> number % x != 0)
						)
				 .forEach(System.out::println);
		
		// find given number is prime or not
		int c = 7;
		boolean x = IntStream.range(2, c).allMatch(i -> c % i != 0);
		
		System.out.println( x ? "isPrime" : "isNotPrime" );
		
		// find first prime number in given range
		Integer xx = IntStream.rangeClosed(10, 20)
					      .filter(number -> number > 1 &&
					    		  			IntStream.range(2, number)
					    		  					 .allMatch(z -> number % z != 0)
					    		  )
					      .findFirst()
					      .getAsInt();
		
		System.out.println(xx);
	}
	
	void streams1Answers()
	{
		return;
	}
}
