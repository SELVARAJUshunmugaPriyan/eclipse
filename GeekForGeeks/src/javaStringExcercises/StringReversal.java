package javaStringExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringReversal {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				String s;
				
				System.out.println("Enter a string:");
				s = scn.nextLine();
				
				if(!s.isBlank()) {
					System.out.println("Reversed string:");
					for(int i = s.length() - 1; i >= 0; i--)
						System.out.print(s.charAt(i));
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
