package p1;

public class WeightOfParanthesis {
	
	private final static boolean DEBUG = true;

	public static void main(String[] args) {
				
		int weight = weight(args[0]);
		if (weight != -1)
			System.out.println(args[0] + " weight=" + weight);
		else
			System.out.println("Unbalanced paranthesis");
	}
	
	static int weight(String str)
	{
		int nextP = 0, weight = 0;

		if (DEBUG)
			System.out.println("Inside function : " + str);
		for (int i = 0; i < str.length(); i = nextP) {
			nextP = nextParanthesis(str, nextP);
			
			if (nextP == -1)
				return -1;
			
			if (DEBUG)
				System.out.printf("Nxt: %2d %2d "
					+ "%10s %2d\n", i, nextP,
					str.substring(i, nextP), weight);
			if (nextP != i + 2) {
				int tmpWt = weight(str.substring(i + 1, nextP - 1));
				if (tmpWt == -1)
					return -1;
				weight += 2 * tmpWt;
			} else
				weight += 1;
			if (DEBUG)
				System.out.printf("Out: %2d %2d "
					+ "%10s %2d\n", i, nextP, 
					str.substring(i, nextP), weight);
		}
		
		return weight;
	}
	
	static int nextParanthesis(String str, int nextP)
	{
		int count = 0;
		do
			if (str.charAt(nextP++) == '(')
				count++;
			else
				count--;
		while (count > 0 && nextP < str.length());
		return count == 0 ? nextP : -1;
	}

}
