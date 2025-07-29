package loop;

public class LoopsFindUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "OneSofT", t = s.toUpperCase();
		
		for (int i = 0; i < s.length(); i++)
			if(s.charAt(i) == t.charAt(i))
				System.out.println(s.charAt(i));
	}

}
