package forTwo;

public class LoopsEForLongestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sa = {"Hello", "Worlds"};
		String longest = sa[0];
		
		for(String s : sa)
			if(s.length() > longest.length())
				longest = s;
		
		System.out.print(longest);
	}

}
