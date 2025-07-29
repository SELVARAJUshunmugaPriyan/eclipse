package streamsAPIlogicQuestion;

import java.util.Arrays;

public class QuestionTwentyFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer nums[] = Arrays.asList(12, 39, 5, 6, 98, 0, -2).stream()
				.sorted().toArray(Integer[]::new);
		Arrays.stream(nums).forEach(x -> System.out.println(x));
	}

}
