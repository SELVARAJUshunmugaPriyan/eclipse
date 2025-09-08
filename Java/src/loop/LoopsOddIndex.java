package loop;

public class LoopsOddIndex {

	public static void main(String[] args) {
		
		String s = "ONESOFTTECHNOLOGY";
		
		for (int i = 0; i < s.length(); i++)
			if (i % 2 != 0)
				System.out.println(s.charAt(i));
	}

}
