package javaStringExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class RemoveLeadingZeroes {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				String s;
				boolean b = true;
				
				System.out.println("Enter a string:");
				s = scn.nextLine();
				
				if(!s.isBlank()) {
					System.out.println("Trimmed string:");
					for(int i = 0; i < s.length(); i++) {
						char c = s.charAt(i);
						if(c == '0' && b)
							continue;
						b = false;
						System.out.print(c);
					}
					System.out.println();
				}
			}
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
