package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;

public class QuestionEleven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		System.out.println(nums.stream().filter(x -> x % 2 == 0)
				.reduce((x, y) -> x + y).get());
	}

}
