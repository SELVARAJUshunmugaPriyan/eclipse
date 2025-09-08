// Java program to count substrings of a string
// with equal number 0s, 1s and 2s.

// Example: Input: "102100211"
//		   Output: 5
//	  Explanation: Substring str[0, 2] = "102", str[1, 3] = "021",
//				   str[2, 4] = "210", str[2, 7] = "210021", and
//				   str[5, 7] = "021" each have an equal number
//				   of 0s, 1s and 2s.

package javaStringExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CountSubstringsTwo {
	
	// function to count the substrings
	static int countSubstrs(String s) throws
		NumberFormatException
	{
		int cnt = 0;
		
		for (int i = 0; i < s.length(); i++)
			for (int j = i + 1; j <= s.length(); j++) {
				int zero = 0, one = 0, two = 0;
				
				for (char c : s.substring(i, j).toCharArray())
					if (c == '0')
						zero++;
					else if (c == '1')
						one++;
					else if (c == '2')
						two++;
					else
						throw new NumberFormatException();
				
				if (zero == one && zero == two) {
//					System.out.println(s.substring(i, j));
					cnt++;
				}
			}
		return cnt;
	}

	public static void main(String[] args)
	{
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				try {
					System.out.println("Enter a string:");
					String s = scn.nextLine();
					
					if (!s.isBlank()) {
						System.out.println("Number of "
								+ "substrings with equal "
								+ "0s, 1s and 2s: "
								+ countSubstrs(s));
					}
				} catch (NumberFormatException e) {
					System.out.println("Only string of 0s, 1s or 2s are accepted.");
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
