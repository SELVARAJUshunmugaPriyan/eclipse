package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;

public class QuestionTwentyTwo {

	public static void main(String[] args) {
		
		List<Integer> lstA = Arrays.asList(1, 5, 6, 8, 9, 5);
		List<Integer> lstB = Arrays.asList(6, 9, 3, 4);
		lstA.stream().filter(x -> lstB.contains(x)).forEach(
				x -> System.out.println(x));
	}

}
