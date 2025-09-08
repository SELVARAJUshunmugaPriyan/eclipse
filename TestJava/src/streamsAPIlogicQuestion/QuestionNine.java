package streamsAPIlogicQuestion;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QuestionNine {

	public static void main(String[] args) {
		
		String str = "capgeminii";
		List<Character> list = new ArrayList<>();
		for (char c : str.toCharArray())
			list.add(c);
		
//		Map<Boolean, List<Character>> map = list.stream().collect(
//				Collectors.groupingBy(x -> {
//					return list.stream().filter(y -> y == x)
//						   .count() > 1;
//				}));
		
//		map.forEach((k, v) -> {
//			if (k)
//				System.out.println("Count of repeated characters is " + v.size());
//			else
//				System.out.println("Overall count is " + list.size());
//		});
		
		Map<Character, Long> map = list.stream().collect(
				Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		long cnt = map.values().stream().filter(x -> x > 1).count();
		
		System.out.println("Overall count is " + list.size());
		System.out.println("Count of repeated characters is " + cnt);
	}

}
