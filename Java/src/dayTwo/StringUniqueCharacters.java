package dayTwo;

public class StringUniqueCharacters {

	public static void main(String[] args) {
		
		for(int i = 0; i < args[0].length() - 1; i++) {
			System.out.println(i + " " + args[0].charAt(i) + " " + args[0].substring(i + 1).indexOf(args[0].charAt(i)) + " " + args[0].substring(i + 1));
			if(args[0].substring(i + 1, args[0].length()).indexOf(args[0].charAt(i)) >= 0) {
				System.out.print(false);
				return;
			}
		}
		
		System.out.print(true);
	}

}
