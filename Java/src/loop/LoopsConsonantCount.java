package loop;

public class LoopsConsonantCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "JAVAPROGRAMS";
		char[] c = s.toCharArray();
		int count = 0;
		
		for (int i = 0; i < c.length; i++) {
//			char c = s.charAt(i);
			if (c[i] != 'A' && c[i] != 'E' && c[i] != 'I' && c[i] != 'O' && c[i] != 'U')
				count++;
		}
		
		System.out.println(count);
	}

}
