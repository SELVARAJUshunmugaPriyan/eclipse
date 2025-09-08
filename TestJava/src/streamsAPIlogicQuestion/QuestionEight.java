package streamsAPIlogicQuestion;

import java.util.List;
import java.util.ArrayList;

public class QuestionEight {

	public static void main(String[] args) {
		
		String str = "@123&";
		List<Character> list = new ArrayList<>();
		for (char c : str.toCharArray())
			list.add(c);
		
		list.stream().map(x -> String.valueOf(x)).filter(x -> 
			x.matches("\\W")).forEach(x -> System.out.println(x));
	}

}
