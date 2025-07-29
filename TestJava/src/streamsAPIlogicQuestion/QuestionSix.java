package streamsAPIlogicQuestion;

import java.util.List;
import java.util.ArrayList;

public class QuestionSix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> list = new ArrayList<>();
		String str = "Shunmuga Priyan Selvaraju";
		for (char c : str.toCharArray())
			list.add(c);
		
		// Using loop
		for (char c : list)
			if (list.indexOf(c) == list.lastIndexOf(c)) {
				System.out.println("First non-duplicated character is " + c);
				break;
			}
		
		// Using stream
//		System.out.println("First non-duplicated character is " +
//			list.stream().filter(x -> {
//				return list.stream().filter(y -> y == x).count() == 1;
//			}).findFirst().get());
	}

}
