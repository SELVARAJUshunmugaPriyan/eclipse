package streamsAPIlogicQuestion;

import java.util.List;
import java.util.ArrayList;

public class QuestionFive {

	public static void main(String[] args) {
		
		List<Character> list = new ArrayList<>();
		String str = "Shunmuga Priyan Selvaraju";
		for (char c : str.toCharArray())
			list.add(c);
		
		// Using loop
//		int cnt = 0;
//		while (cnt < list.size())
//			cnt++;
//		System.out.println("count=" + cnt);
		
		// Using stream
		System.out.println("count=" + list.stream().count());
	}

}
