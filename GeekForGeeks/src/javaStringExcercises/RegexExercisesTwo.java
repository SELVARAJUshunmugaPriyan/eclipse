package javaStringExcercises;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Driver code
public class RegexExercisesTwo 
{

	// Function to illustrate capturing groups
	void capturingGroups(String input) 
	{
		// TODO Auto-generated method stub
		// Sample input : sample data with 1234 (digits) in middle
//		String regex = "(.*?)(\\d+)(.*)"; // returns 1234
//		String regex = "(.*?)(\\d)(.*)"; // returns 1
		String regex = "(.*)(\\d+)(.*)"; // returns 4
		// Create a Pattern object
		Pattern pattern = Pattern.compile(regex);
		// Create a Matcher object
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
//			System.out.println("Found value: " + matcher.group(0));
//			System.out.println("Found value: " + matcher.group(1));
//			System.out.println("Found value: " + matcher.group(2));
//			System.out.println("Found value: " + matcher.group(3));
			int i = 0;
			
			while (i <= matcher.groupCount() &&
					matcher.group(i).length() != 0)
				System.out.println("Found value: " + matcher.group(i++));
		} else
			System.out.println("NO MATCH");
		
//		while (matcher.find())
//			System.out.println("Found value: " + matcher.group(1));
	}	

	// Function to illustrate non-capturing groups
	void nonCapturingGroups(String input) 
	{
		String regex = "(.*)(?:\\d+)(.*)";
		// Create a Pattern object
		Pattern pattern = Pattern.compile(regex);
		// Create a Matcher object
		Matcher matcher = pattern.matcher(input);
		
		if (matcher.find()) {
			int i = 0;
			
			while (i <= matcher.groupCount())
				System.out.println("Found value: " + matcher.group(i++));
		} else
			System.out.println("NO MATCH");
	}
	
	// Function to illustrate named capturing groups
	void namedCapturingGroups(String input)
	{
		String regex = "(?<globalCode>[\\d]{2})-"
				+ "(?<nationalCode>[\\d]{5})-"
				+ "(?<number>[\\d]{6})";
		// Create a Pattern object
		Pattern pattern = Pattern.compile(regex);
		// Create a Matcher object
		Matcher matcher = pattern.matcher(input);
		
		while (matcher.find()) {
			System.out.println("Global code : " + matcher.group("globalCode"));
			System.out.println("National code : " + matcher.group("nationalCode"));
			System.out.println("Phone number : " + matcher.group("number"));
		}
	}
	
	// main function
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		RegexExercisesTwo regex = new RegexExercisesTwo();
		
		System.out.println("Enter a string: ");

		try {
			String input = scn.nextLine();
//			regex.capturingGroups(input);
//			regex.nonCapturingGroups(input);
			regex.namedCapturingGroups(input);
		} catch (NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
