package forTwo;

public class LoopsIndividualLongestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = new String[3];
		s[0] = "Hello";
		s[1] = "worlds";
		s[2] = "longest";
		String longest = s[0];
		
		for(int i = 1; i < s.length; i++)
			if(s[i].length() > longest.length())
				longest = s[i];
		
		System.out.print(longest);
	}

}
