package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;

public class QuestionTwelve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("Shunmuga", "Priyan", "Keerthana");
		list.stream().map(x -> x.replaceFirst(".$", "")).forEach(
				x -> System.out.println(x));
	}

}
