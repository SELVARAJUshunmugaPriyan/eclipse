package forTwo;

public class LoopsStringLastChar {
	public static void main(String[] args) {
		String[] sa = {"Hello", "Worlds", "doggy", "dolly"};
		
		for(int i = 0; i < sa.length; i++)
			System.out.println(sa[i].charAt(sa[i].length() - 1));
	}
}
