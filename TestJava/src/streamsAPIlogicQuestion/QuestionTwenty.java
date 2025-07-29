package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;

public class QuestionTwenty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(2, 2, 4, 4, 6, 6, 2, 7, 1, 3, 9);
		Arrays.asList(list.stream().reduce((x, y) -> x + y).get())
			  .stream()
			  .mapToDouble(x -> (float) x)
			  .forEach(x -> System.out.println(x));;
	}

}
