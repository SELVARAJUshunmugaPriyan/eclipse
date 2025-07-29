package streamsAPIlogicQuestion;

import java.util.Arrays;

public class QuestionTwentyOne 
{
	public static void main(String[] args)
	{
		Arrays.asList("aaa", "xxx", "abd", "heg", "ikl").stream()
			  .map(x -> x.toUpperCase())
			  .sorted()
			  .forEach(x -> System.out.println(x));
	}
}
