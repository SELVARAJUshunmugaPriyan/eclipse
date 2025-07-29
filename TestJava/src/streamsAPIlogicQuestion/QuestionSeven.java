package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;

public class QuestionSeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(10, 20, 30, 7, 9);
		nums.stream().filter(x -> x % 2 == 0)
			.forEach(x -> System.out.println(x));
	}

}
