package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class QuestionSeventeen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(2, 2, 4, 4, 6, 6, 2, 7, 1, 3, 9);
		int arr[] = list.stream()
						.filter(x -> Collections.frequency(list, x) == 1)
						.mapToInt(x -> x)
						.toArray();
		System.out.print(Arrays.toString(arr));
	}

}
