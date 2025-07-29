package forThree;

public class NestedForStringRepeatLettersOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "banana";
		char[] C = S.toCharArray(), D = new char[S.length()];
		int k = 0;
		
		for(int i = 0; i < C.length; i++)
			for(int j = i + 1; j < C.length; j++)
				if(C[i] == C[j]) {
					for(char c : D) {
						if(c == C[i])
							break;
						D[k++] = C[i];
						break;
					}
					break;
				}
		
		for(char c : D)
			if(c >= 'a' || c <= 'z')
				System.out.print(c + " ");
	}
}

