package popularProblems;

@SuppressWarnings("unused")
public class StringProblems {

	private static final boolean DEBUG = true;
	
	java.util.ArrayList<Integer> asciiSum(String s) 
	{
		return s.chars().parallel()
						.distinct()
						.filter(x -> s.indexOf(x) != s.lastIndexOf(x) &&
						             s.lastIndexOf(x) != s.indexOf(x) + 1)
						.peek(x -> System.out.print((char) x + " "))
						.mapToObj(x -> s.subSequence(s.indexOf(x) + 1, s.lastIndexOf(x)))
						.peek(System.out::println)
						.map(x -> x.chars()
								   .parallel()
								   .sum())
						.sorted()
						.collect(java.util.stream.Collectors.toCollection(
								 java.util.ArrayList::new));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringProblems().asciiSum("xhnwazunnwdrkdmccz"));
	}

}
