package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class QuestionNineteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lstA = Arrays.asList(2, 2, 4, 4, 6, 6, 2, 7, 1, 3, 9);
		List<Integer> lstB = Arrays.asList(3, 2, 5, 8, 9, 11, 16, 7, 0, 3, 9);
		List<Integer> lstC = Arrays.asList(8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9);
		List<List<Integer>> list = Arrays.asList(lstA, lstB, lstC);
		list.stream().flatMap(x -> x.stream())
			.collect(Collectors.groupingBy(x -> x % 2 == 0,
					 Collectors.summingInt(x -> (int) x)))
			.forEach((k, v) -> {
				if (k)
					System.out.println("Even sum : " + v);
				else
					System.out.println("Odd sum : " + v);
			});
	}

}
