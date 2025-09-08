package forThree;

public class NestedForStringRepeatLettersTwo {

	public static void main(String[] args) {
		
		String S = "aluminium";
		char[] C = S.toCharArray();
		
		for(int i = 0; i < C.length; i++) {
			int count = 1;
			for(int j = i + 1; j < C.length; j++) {
				if(C[i] == C[j]) {
					C[j] = '#';
					count++;
				}
			}
			if(count > 1 && C[i] != '#')
				System.out.println(C[i] + " " + count);
		}
	}

}
