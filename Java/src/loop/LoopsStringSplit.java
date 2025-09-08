package loop;

public class LoopsStringSplit {

	public static void main(String[] args) {
		
		String t = "Java is a fun and Java is a program";
		String[] S = t.split("");
		
		for(String s : S)
			System.out.println(s.length());
	}
	
}
