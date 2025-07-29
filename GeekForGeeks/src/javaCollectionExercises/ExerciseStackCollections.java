package javaCollectionExercises;

import java.util.Map;
import java.util.Stack;
import java.util.Random;
import java.util.HashMap;
import java.util.Scanner;

class WeightOfParanthesis
{
	private static boolean DEBUG;
	
	// HashMap to store the ending
	// index of every opening bracket
	private static Map<Integer, Integer> endIndex 
					= new HashMap<>();
	
	WeightOfParanthesis(String input, boolean debug)
	{
		DEBUG = debug;
		
//		String input = "()(((()))())";
		int n = input.length();
		
		// Update the closing Index
		getClosingIndex(input);
		
		System.out.println(calculateWeight(input,
										 0, n - 1));
	}
	
	// Function to calculate and store
	// the closing index of each opening
	// bracket in the parenthesis
	static void getClosingIndex(String str)
	{
		int n = str.length();
		
		Stack<Integer> st = new Stack<Integer>();
		
		for (int i = 0; i < n; i++) {
			
			if (str.charAt(i) == ')') {
			
				// It it's a closing bracket,
				// pop index of it's corresponding
				// opening bracket
				int startIndex = st.pop();
				
				// Insert the index of opening
				// bracket and closing bracket
				// as key-value pair in the
				// HashMap
				endIndex.put(startIndex, i);
			} else {
				
				// If it's an opening bracket,
				// push it's index into the stack
				st.push(i);
			}
		}
		
		if (DEBUG) System.out.println(endIndex);
	}
	
	// Function to return the weight of
	// parenthesis
	static int calculateWeight(String str,
							  int low,
							  int high)
	{
		if (DEBUG) System.out.println(str.substring(low, high + 1));
		
		// Base case
		if (high == low + 1) {
			return 1;
		} else {
			
			// mid refers to ending index of
			// opening bracket at index low
			int mid = endIndex.get(low);
			if (mid == high) {
				int weight = calculateWeight(str, low + 1, high - 1);
				if (DEBUG) System.out.println(weight);
				return 2 * weight;
			} else {
				int weight = calculateWeight(str, low, mid) + 
						calculateWeight(str, mid + 1, high);
				if (DEBUG) System.out.println(weight);
				return weight;
			}
		}
	}
	
}

class Binary2UnaryString
{
	private static boolean DEBUG = false;

	Binary2UnaryString(boolean debug)
	{
		DEBUG = debug;
		new Binary2UnaryString();
	}
	
	Binary2UnaryString() throws NumberFormatException
	{
		String bin;
		
		System.out.println("Enter a binary string: ");
		// inputs
		try (Scanner scn = new Scanner(System.in)) {
			bin = scn.nextLine();
		}
		
		if (!bin.matches("[01]+"))
			throw new NumberFormatException("Invalid Binary String");
		// Function call
		System.out.println("Is possible? " + isPossible(bin));
	}

	// Function to check the possibility
	private String isPossible(String bin)
	{
		// Initializing Stack
		Stack<Character> stk = new Stack<>();
		char[] array = bin.toCharArray();
		
		// Iterating over String bin
		for (int i = 0; i < array.length; i++) {
			if (DEBUG) System.out.println("Entering Loop bin:"
					+ bin.substring(0, i + 1) + " stk:" + stk);
			// If current and peek characters are same
			// Then removing that peek element from
			// Stack
			if (!stk.isEmpty() || array[i] == stk.peek()) {
				stk.pop();
				System.out.print("Pushing");
			} else {	// Else putting current character
						// into stack
				stk.push(array[i]);
				System.out.print("Poping ");
			}
			if (DEBUG) System.out.println("  Loop bin:"
					+ bin.substring(0, i + 1) + " stk:" + stk);
		}
		// If there is at max one character in
		// Stack, then output YES else NO
		if (stk.size() < 2)
			return "YES";
		
		return "NO";
	}
}

public class ExerciseStackCollections {
	
	private static boolean DEBUG;
	
	public static String getRandParenthesisStr(Scanner scn,
											boolean isTest,
											boolean debug)
					throws NumberFormatException
	{
		DEBUG = debug;
		String str = "";
		Stack<Character> stk = new Stack<>();
		Random rand = new Random();
		
		System.out.println("Enter the length of string: ");
		
		int len = Integer.parseInt(scn.nextLine());
		
		if (!isTest && len < 2)
			throw new NumberFormatException(
					"Only even integers greater than 2 "
					+ "are accepted.");
		
		if (!isTest && len % 2 == 1)
			throw new NumberFormatException(
					"Only even integers are accepted.");
		
		do {
			int ofst = stk.size() == 0 ? 0 : rand.nextInt(2);
			stk.add(stk.size() / 2 + ofst, '(');
			stk.add(stk.size() / 2 + 1 + ofst, ')');
			if (DEBUG) {
				String tmp = "";
				for (Character c : stk)
					tmp += c;
				System.out.println(tmp);
			}
		} while (stk.size() < len);
		
		for (Character c : stk)
			str += c;
		
		if (DEBUG) System.out.println(str);
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new WeightOfParanthesis(false);
		
		try (Scanner scn = new Scanner(System.in)) {
//			new WeightOfParanthesis(getRandParenthesisStr(scn,
//					false, true), false);
			new Binary2UnaryString(true);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
