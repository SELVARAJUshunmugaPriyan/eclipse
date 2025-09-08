package loop;

import java.util.Scanner;

public class LoopsVowels {

	public static void main(String[] args) {
		
//		String s = "PROGRAMS";
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		
		s = s.toUpperCase();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
				System.out.println(c);
		}
		
		scn.close();
	}

}
