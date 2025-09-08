package streamsAPIlogicQuestion;

import java.util.List;

public class QuestionTwentyThree {

	public static void main(String[] args) {
		
		List<Character> list = "I am coding".chars()
							   .mapToObj(x -> (char) x).toList();
		
		System.out.println("Count of letters is " + list.size());
	}

}
