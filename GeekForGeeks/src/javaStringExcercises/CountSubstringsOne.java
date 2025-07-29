// Java program to count substrings of a string
// with equal number 0s, 1s and 2s.

// Example: Input: "102100211"
//		   Output: 5
//	  Explanation: Substring str[0, 2] = "102", str[1, 3] = "021",
//				   str[2, 4] = "210", str[2, 7] = "210021", and
//				   str[5, 7] = "021" each have an equal number
//				   of 0s, 1s and 2s.

package javaStringExcercises;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CountSubstringsOne {
	
	// function to count the substrings
	static int countSubstrs(String s) throws
		NumberFormatException
	{
		int cnt = 0, zero = 0, one = 0, two = 0;
		Map<String, Integer> pairs = new HashMap<String, Integer>();
		
		pairs.put("0,0", 1);
//		System.out.println("  z o t c dif pairs");
		
		for (char c : s.toCharArray()) {
			String diff;
			
			if (c == '0')
				zero++;
			else if (c == '1')
				one++;
			else if (c == '2')
				two++;
			else
				throw new NumberFormatException();
			
			diff = (zero - one) + "," + (zero - two);
//			System.out.println(c + " " + zero + " "
//					+ one + " " + two + " "  
//					+ cnt + " " + diff + " " + pairs.toString());
			cnt += pairs.getOrDefault(diff, 0);
			pairs.put(diff, pairs.getOrDefault(diff, 0) + 1);
		}
		
		return cnt;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
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
