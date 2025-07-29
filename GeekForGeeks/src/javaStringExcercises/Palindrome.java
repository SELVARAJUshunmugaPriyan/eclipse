package javaStringExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				String s;
				boolean isPalindrome = true;
				
				System.out.println("Enter a string:");
				s = scn.nextLine();
				
				for(int i = 0; i <= s.length() / 2; i++)
					if(s.charAt(i) != s.charAt(s.length() - 1 -i)) {
						isPalindrome = false;
						break;
					}
				
				if(isPalindrome)
					System.out.println("\"" + s + "\" is a Palindrome");
				else
					System.out.println("\"" + s + "\" is not a Palindrome");
			}
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
