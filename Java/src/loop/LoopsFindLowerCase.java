package loop;

public class LoopsFindLowerCase {

	public static void main(String[] args) {
		
		String s = "OneSofT", t = s.toLowerCase();
		
		for (int i = 0; i < s.length(); i++)
			if(s.charAt(i) == t.charAt(i))
				System.out.println(s.charAt(i));
	}

}
