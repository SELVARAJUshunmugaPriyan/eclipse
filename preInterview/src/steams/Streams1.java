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
//import java.util.Scanner;

public class Streams1 {

	public static void main(String[] args) {
		new Streams1().streams1Questions();
		new Streams1().streams1Answers();
	}
	
	void streams1Questions()
	{
		
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
		List<Person> people = List.of(
					new Person(1, "Priyan"),
					new Person(2, "Keerthana")
				);
		
		people.stream()
			  .sorted(Comparator.reverseOrder())
			  .skip(1)
			  .forEach(System.out::println);
		
		String num = "407";
		int ans = num.chars()
				   .map(x -> x - '0')
				   .map(x -> (int) Math.pow(x, 3))
				   .reduce((x, y) -> x + y).getAsInt();
		System.out.println(Integer.valueOf(num) == ans);
		
		List<Employee> employees = List.of(
					new Employee(1, 11000, "maths"),
					new Employee(2, 22000, "chemistry"),
					new Employee(3, 33000, "physics"),
					new Employee(4, 44000, "sociology"),
					new Employee(5, 55000, "psychology"),
					new Employee(6, 66000, "history"),
					new Employee(7, 77000, "botany")
				);
		
//		List<Employee> employees = new ArrayList<>();
		
		Map<String, Integer> maxSalary = employees.stream()
												  .collect(
			Collectors.groupingBy(
						Employee::getDept,
						Collectors.collectingAndThen(
							Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
							empOut -> empOut.map(x -> x.getSalary()).get())
									));
		
		maxSalary.forEach((x, y) -> System.out.println(x + " " + y));
		
//		int i = 0;
//		Scanner scn = new Scanner(System.in);
		
//		employees.clear();
		
//		while (i < 7) {
//			int id = scn.nextInt();
//			String dept = scn.next();
//			int salary = scn.nextInt();
//			employees.add(new Employee(id, salary, dept));
//			i++;
//		}
//		
//		scn.close();
//		
//		System.out.println(employees.stream()
//				 				.max(Comparator.comparingInt(e -> e.getSalary()))
//				 				.get());
		
//		System.out.println( true ? null : employees.stream()
//								.collect(
//									Collectors.groupingBy(
//										x -> x.getDept(),
//										Collectors.averagingInt(Employee::getSalary)
//									))
//								.entrySet()
//								.stream()
//								.max(Comparator.comparing(Map.Entry<String, Double>::getValue))
//								.map(Map.Entry<String, Double>::getKey)
//								.get());
		
//		List<List<List<Integer>>> transactions = new ArrayList<>();
		
//		List<Integer> cäre = List.of(1, 2, 3);
//		List<Integer> c0re = List.of(4);
//		List<Integer> cöre = List.of(5, 6, 7);
		
//		List<List<Integer>> Core = List.of(cäre, c0re, cöre);
		
//		transactions = List.of(Core);
		
//		List<List<List<Integer>>> transactions = Arrays.asList(
//				Arrays.asList(
//						Arrays.asList(1, 2, 3), Arrays.asList(4), Arrays.asList(5, 6, 7)));
//		
//		List<Integer> core = transactions.stream()
//										 .flatMap(List::stream)
//										 .flatMap(List::stream)
//										 .sorted()
//										 .collect(Collectors.toList());
//		
//		System.out.println(core);
		
		Map<Boolean, List<Integer>> numbers = 
			IntStream.range(1, 20)
					 .boxed()
					 .collect(Collectors.partitioningBy(x -> x != 1 && 
					 	IntStream.range(2, x)
					 	         .allMatch(y -> x % y != 0)
							 ));
		
		System.out.println(numbers);
		
		int sumArray[] = {16, 4, 17, 3, 5, 2};
		
		for (int i = 0; i < sumArray.length; i++) {
			int max = -1;
			for (int j = i + 1; j < sumArray.length; j++)
				if (sumArray[j] > max)
					max = sumArray[j];
			sumArray[i] = max;
		}
		
		System.out.println(IntStream.range(0, sumArray.length)
				 .map(
						 x -> IntStream.range(x, sumArray.length)
						 			   .map(y -> sumArray[y])
						 			   .max().getAsInt()
				 ).boxed().toList());
	}
	
	class Person implements Comparable<Person>
	{
		public int id;
		public String name;
		
		Person(int id, String name)
		{
			this.id = id;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return this.name.length();
		}
		
		@Override
		public String toString() {
			return id + " " + name;
		}
	}
	
	class Employee implements Comparable<Employee> {
		
		public int id, salary;
		public String dept;
		
		Employee(int id, int salary, String dept)
		{
			this.id = id;
			this.salary = salary;
			this.dept = dept;
		}
		
		String getDept()
		{
			return dept;
		}
		
		int getSalary()
		{
			return salary;
		}
		
		@Override
		public int compareTo(Employee employee) {
			return employee.salary;
		}
		
		@Override
		public String toString() {
			return id + " " + salary + " " + dept;
		}
	}
	
	class Transaction
	{
	}
}
