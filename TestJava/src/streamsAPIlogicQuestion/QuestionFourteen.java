package streamsAPIlogicQuestion;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionFourteen {

	public static void main(String[] args) {
		
		List<Character> list = "Nishanthi".chars()
				.mapToObj(x -> (char) x)
				.collect(Collectors.toList());
		
		// Using stream
		list.stream().filter(x -> {
			return list.stream().filter(y -> y == x).count() > 1;
		}).distinct().forEach(x -> System.out.println(x));;
	}

}
