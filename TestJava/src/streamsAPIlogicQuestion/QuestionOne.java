package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;

public class QuestionOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(10, 20, 30, 10, 25);
		nums.stream().filter(x -> {
			return nums.stream().filter(y -> y == x).count() > 1;
		}).distinct().forEach(x -> System.out.println(x));
	}

}
