package lms;

public class SolutionCharacterCount {

	public static void main(String[] args) {
		
		char[] C = args[0].toCharArray();
		for(int i = 0; i < C.length; i++) {
			int count = 1;
			for(int j = i + 1; j < C.length; j++)
				if(C[i] == C[j]) {
					C[j] = '#';
					count++;
				}
			if(count > 1 && C[i] != '#')
				System.out.print((char) (C[i] - 'a' + 'A') + " count is " + count + " ");
		}
	}

}
