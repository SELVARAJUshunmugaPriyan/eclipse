package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class QuestionThree {
	
	private static final boolean DEBUG = true;

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(12, 39, 5, 6, 98, 0, -2);
		
		if (DEBUG) System.out.println(nums);
		
		// Using for loop
		for (int i = 0; i < nums.size() - 1; i++)
			for (int j = i + 1; j < nums.size(); j++)
				if (nums.get(j) > nums.get(i)) {
					Integer tmp = nums.get(i);
					nums.set(i, nums.get(j));
					nums.set(j, tmp);
				}
		
		if (DEBUG) System.out.println(nums);
		
		System.out.println("Second max = " + nums.get(1));
		
		// Using stream
		nums.stream().sorted(Comparator.reverseOrder())
			.skip(1).limit(1).forEach(x -> System.out.println("Second max = " + x));
	}

}
