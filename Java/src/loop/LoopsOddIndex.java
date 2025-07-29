package loop;

public class LoopsOddIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ONESOFTTECHNOLOGY";
		
		for (int i = 0; i < s.length(); i++)
			if (i % 2 != 0)
				System.out.println(s.charAt(i));
	}

}
