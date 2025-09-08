package forTwo;

public class loopsLongestString {

	public static void main(String[] args) {
		
		String[] s = {"Hello", "Worlds", "longest"};
		String longest = s[0];
		
		for(int i = 1; i < s.length; i++)
			if(s[i].length() > longest.length())
				longest = s[i];
		
		System.out.print(longest);
	}

}
