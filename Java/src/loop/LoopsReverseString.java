package loop;

public class LoopsReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PROGRAMS";
		
		for (int i = s.length() - 1; i >= 0; i--)
			System.out.println(s.charAt(i));
	}

}
