package forThree;

public class NestedForStringStringReversalTwo {

	public static void main(String[] args) {
		
		String s = "I,am,an,Engineer";
		String[] S = s.split(",");
		for(int i = 0; i < S.length; i++) {
			for(int j = S[i].length() - 1; j >= 0; j--)
				System.out.print(S[i].charAt(j));
			System.out.print(" ");
		}
	}

}
