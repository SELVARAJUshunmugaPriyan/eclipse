package dayTwo;

public class StringSecondOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "maaaam";
		char[] t = s.toCharArray();
		int pos = s.length();
		
		for(char c : t) {
			int i = s.indexOf(c, s.indexOf(c, s.indexOf(c) + 1) + 1);
			if(i < pos && i >= 0)
				pos = i;
		}
		
		if(pos == s.length())
			System.out.print(false);
		else
			System.out.print(pos);
	}

}
