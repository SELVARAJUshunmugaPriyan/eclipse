package forThree;

public class NestedForStringRepeatLettersThree {

	public static void main(String[] args) {
		
		String S = "aluminium";
		char[] C = S.toCharArray();
		int unique = 0;
		
		for(int i = 0; i < C.length; i++) {
			int count = 1;
			for(int j = i + 1; j < C.length; j++) {
				if(C[i] == C[j]) {
					C[j] = '#';
					count++;
				}
			}
			if(count >= 1 && C[i] != '#')
				unique++;
		}
		System.out.println("Unique: " + unique);
	}

}
