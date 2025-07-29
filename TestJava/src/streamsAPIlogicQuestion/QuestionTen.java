package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.stream.Collectors;

public class QuestionTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
//		nums.parallelStream().forEach(x -> System.out.println(x));
		
//		nums.stream().distinct().forEach(x -> System.out.println(x + "'s frequency is " + 
//				Collections.frequency(nums, x)));
		
//		System.out.println(nums.stream().collect(Collectors.counting()));
		
		System.out.println(nums.stream().reduce((x, y) -> x + y).get());
	}

}
