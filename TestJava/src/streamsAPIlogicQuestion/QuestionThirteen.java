package streamsAPIlogicQuestion;

import java.util.stream.Stream;

public class QuestionThirteen {

	public static void main(String[] args) {
		
		Stream.iterate(new int[] {0, 1}, x -> new int[] {x[1], x[0] + x[1]})
		.limit(1)
		.map(x -> x[0])
		.forEach(x -> System.out.println(x));
	}

}
