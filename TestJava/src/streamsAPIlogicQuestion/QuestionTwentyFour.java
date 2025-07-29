package streamsAPIlogicQuestion;

//import java.util.stream.Stream;

public class QuestionTwentyFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Stream.iterate(1, x -> x + 1)
//		.limit(20)
		"123456789".chars()
		.mapToObj(x -> x - '0')
		.filter(x -> x != 4 && x != 8 && x != 10)
		.forEach(x -> System.out.println(x));
	}

}
