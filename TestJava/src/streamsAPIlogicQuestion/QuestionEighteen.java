package streamsAPIlogicQuestion;

import java.util.Arrays;

public class QuestionEighteen 
{
	public static void main(String[] args)
	{
		Arrays.asList("Nisha", "Kralice", "Demet").stream()
			  .forEach(x -> System.out.println(x + " " + x.length()));
	}
}
