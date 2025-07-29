package javaStringExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					String s, t;
					boolean isAnagram = true;
					
					System.out.println("Enter a string:");
					s = scn.nextLine();
					
					System.out.println("Enter another string:");
					t = scn.nextLine();
					
					if(s.length() != t.length())
						isAnagram = false;
					else
						for(int i = 0; i <= s.length() / 2; i++)
							if(t.indexOf(s.charAt(i)) == -1) {
								isAnagram = false;
								break;
							}
					
					if(isAnagram)
						System.out.println("\"" + s + "\" and \"" + t + "\" are anagrams");
					else
						System.out.println("\"" + s + "\" and \"" + t + "\" are not anagrams");
					
				} catch(StringIndexOutOfBoundsException e) {
					;
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
