// Java program to add 2 binary strings
// and print their sum in binary.

// Example: Input: "1001" "0011"
//		   Output: "1100"
//	  Explanation: "1001" represents 9 and "11" represents 3
//				   then result should be 12 which means result
//				   = "1100"

package javaStringExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddBinaryStringsTwo {
	
	static String zeroPad(String str, int len)
	{
		len -= str.length();
		
		while (len-- > 0)
			str = "0" + str;
		
		return str;
	}
	
	// function to add two binary strings
	static String binaryAddition(String str1, String str2) throws
		NumberFormatException
	{
		
		String res = ""; // Initialize result
		char c = '0';
		
		// padding zeroes to shorter string
		if (str1.length() > str2.length())
			str2 = zeroPad(str2, str1.length());
		else
			str1 = zeroPad(str1, str2.length());
		
		for (int i = str1.length() - 1; i >= 0; i--) {
			char a = str1.charAt(i);
			char b = str2.charAt(i);
			
			if (a == '1' && b == '1' && c == '1')
				res = '1' + res;
			else if (a == '1' && b == '1' && c == '0') {
				res = '0' + res;
				c = '1';
			} else if ((a == '1' || b == '1') && c == '1')
				res = '0' + res;
			else if ((a == '1' || b == '1') && c == '0')
				res = '1' + res;
			else if (a == '0' && b == '0' && c == '1') {
				res = '1' + res;
				c = '0';
			} else if (a == '0' && b == '0' && c == '0')
				res = '0' + res;
			else
				throw new NumberFormatException();
		}
		
		if (c == '1')
			res = '1' + res;
			
		return res;
	}

	public static void main(String[] args)
	{
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				try {
					System.out.println("Enter a string:");
					String s = scn.nextLine();
					
					System.out.println("Enter another string:");
					String t = scn.nextLine();
					
					if (!s.isBlank()) {
						System.out.println("Binary addition is "
								+ binaryAddition(s, t));
					}
				} catch (NumberFormatException e) {
					System.out.println("Only string of 0s and 1s are accepted.");
				}
			}
		} catch (NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
