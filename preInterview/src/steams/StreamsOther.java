package steams;

import java.util.Comparator;
import java.util.List;
//import java.util.stream.IntStream;
//import java.util.stream.Collectors;

public class StreamsOther {

	public static void main(String[] args) {
		
		List<String> words = List.of("Radar", "Level", "apple", "banana", "Civic", "Racecar", "Repaper"); 
		List<String> 
			palindromes = words
							.stream()
//							.filter(x -> IntStream.range(0, x.length())
//									.mapToObj(i -> String.valueOf(
//													x.charAt(x.length() - (i + 1)))
//												 .toLowerCase())
//									.collect(Collectors.joining()).equals(x.toLowerCase()))
							.filter(x -> new StringBuilder(x)
												.reverse()
												.toString()
												.toLowerCase()
												.equals(x.toLowerCase()))
							.sorted(Comparator.comparing(String::length).reversed())
							.toList();
		System.out.println(palindromes);
		
	}

}