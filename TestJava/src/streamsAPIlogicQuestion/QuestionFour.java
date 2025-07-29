package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class QuestionFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = Arrays.asList(12, 39, 5, 6, 98, 0, -2);
		
		// Using stream
		nums.stream().sorted(Comparator.reverseOrder())
			.skip(2).limit(1).forEach(x -> System.out.println("Third max = " + x));
	}

}
