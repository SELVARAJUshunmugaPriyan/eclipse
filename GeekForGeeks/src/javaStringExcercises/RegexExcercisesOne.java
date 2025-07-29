// Java program demonstrating working of matches() Method
// from Pattern class

/*
Summary of regular-expression constructs
Construct	Matches
 
Characters
x	The character x
\\	The backslash character
\0n	The character with octal value 0n (0 <= n <= 7)
\0nn	The character with octal value 0nn (0 <= n <= 7)
\0mnn	The character with octal value 0mnn (0 <= m <= 3, 0 <= n <= 7)
\xhh	The character with hexadecimal value 0xhh
\\uhhhh	The character with hexadecimal value 0xhhhh
\x{h...h}	The character with hexadecimal value 0xh...h (Character.MIN_CODE_POINT  <= 0xh...h <=  Character.MAX_CODE_POINT)
\t	The tab character ('\u0009')
\n	The newline (line feed) character ('\u000A')
\r	The carriage-return character ('\u000D')
\f	The form-feed character ('\u000C')
\a	The alert (bell) character ('\u0007')
\e	The escape character ('\u001B')
\cx	The control character corresponding to x
 
Character classes
[abc]	a, b, or c (simple class)
[^abc]	Any character except a, b, or c (negation)
[a-zA-Z]	a through z or A through Z, inclusive (range)
[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
[a-z&&[def]]	d, e, or f (intersection)
[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
 
Predefined character classes
.	Any character (may or may not match line terminators)
\d	A digit: [0-9]
\D	A non-digit: [^0-9]
\h	A horizontal whitespace character: [ \t\xA0\u1680\u180e\u2000-\u200a\u202f\u205f\u3000]
\H	A non-horizontal whitespace character: [^\h]
\s	A whitespace character: [ \t\n\x0B\f\r]
\S	A non-whitespace character: [^\s]
\v	A vertical whitespace character: [\n\x0B\f\r\x85\u2028\u2029]
\V	A non-vertical whitespace character: [^\v]
\w	A word character: [a-zA-Z_0-9]
\W	A non-word character: [^\w]
 
POSIX character classes (US-ASCII only)
\p{Lower}	A lower-case alphabetic character: [a-z]
\p{Upper}	An upper-case alphabetic character:[A-Z]
\p{ASCII}	All ASCII:[\x00-\x7F]
\p{Alpha}	An alphabetic character:[\p{Lower}\p{Upper}]
\p{Digit}	A decimal digit: [0-9]
\p{Alnum}	An alphanumeric character:[\p{Alpha}\p{Digit}]
\p{Punct}	Punctuation: One of !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
\p{Graph}	A visible character: [\p{Alnum}\p{Punct}]
\p{Print}	A printable character: [\p{Graph}\x20]
\p{Blank}	A space or a tab: [ \t]
\p{Cntrl}	A control character: [\x00-\x1F\x7F]
\p{XDigit}	A hexadecimal digit: [0-9a-fA-F]
\p{Space}	A whitespace character: [ \t\n\x0B\f\r]
 
java.lang.Character classes (simple java character type)
\p{javaLowerCase}	Equivalent to java.lang.Character.isLowerCase()
\p{javaUpperCase}	Equivalent to java.lang.Character.isUpperCase()
\p{javaWhitespace}	Equivalent to java.lang.Character.isWhitespace()
\p{javaMirrored}	Equivalent to java.lang.Character.isMirrored()
 
Classes for Unicode scripts, blocks, categories and binary properties
\p{IsLatin}	A Latin script character (script)
\p{InGreek}	A character in the Greek block (block)
\p{Lu}	An uppercase letter (category)
\p{IsAlphabetic}	An alphabetic character (binary property)
\p{Sc}	A currency symbol
\P{InGreek}	Any character except one in the Greek block (negation)
[\p{L}&&[^\p{Lu}]]	Any letter except an uppercase letter (subtraction)
 
Boundary matchers
^	The beginning of a line
$	The end of a line
\b	A word boundary
\B	A non-word boundary
\A	The beginning of the input
\G	The end of the previous match
\Z	The end of the input but for the final terminator, if any
\z	The end of the input
 
Linebreak matcher
\R	Any Unicode linebreak sequence, is equivalent to \u000D\u000A|[\u000A\u000B\u000C\u000D\u0085\u2028\u2029]
 
Greedy quantifiers
X?	X, once or not at all
X*	X, zero or more times
X+	X, one or more times
X{n}	X, exactly n times
X{n,}	X, at least n times
X{n,m}	X, at least n but not more than m times
 
Reluctant quantifiers
X??	X, once or not at all
X*?	X, zero or more times
X+?	X, one or more times
X{n}?	X, exactly n times
X{n,}?	X, at least n times
X{n,m}?	X, at least n but not more than m times
 
Possessive quantifiers
X?+	X, once or not at all
X*+	X, zero or more times
X++	X, one or more times
X{n}+	X, exactly n times
X{n,}+	X, at least n times
X{n,m}+	X, at least n but not more than m times
 
Logical operators
XY	X followed by Y
X|Y	Either X or Y
(X)	X, as a capturing group
 
Back references
\n	Whatever the nth capturing group matched
\k<name>	Whatever the named-capturing group "name" matched
 
Quotation
\	Nothing, but quotes the following character
\Q	Nothing, but quotes all characters until \E
\E	Nothing, but ends quoting started by \Q
 
Special constructs (named-capturing and non-capturing)
(?<name>X)	X, as a named-capturing group
(?:X)	X, as a non-capturing group
(?idmsuxU-idmsuxU) 	Nothing, but turns match flags i d m s u x U on - off
(?idmsux-idmsux:X)  	X, as a non-capturing group with the given flags i d m s u x on - off
(?=X)	X, via zero-width positive lookahead
(?!X)	X, via zero-width negative lookahead
(?<=X)	X, via zero-width positive lookbehind
(?<!X)	X, via zero-width negative lookbehind
(?>X)	X, as an independent, non-capturing group
 
 */

package javaStringExcercises;

//import java.util.regex.Pattern;
//import java.util.regex.Matcher;
import java.util.regex.*;

// Driver class
public class RegexExcercisesOne 
{
	
	void zeroOneOrMoreExcercises()
	{	
		// Following line prints "true" because the whole
		// text "geeksforgeeks" matches pattern
		// "geeksforge*ks"
		
		// CHAR* denotes zero or more CHAR characters
		// CHAR+ denotes one or more CHAR characters
		
		// returns "true"
		
		// for zero e's
		System.out.println(Pattern.matches(
				"geeksforge*ks", "geeksforgks"));
		
		// for more e's
		System.out.println(Pattern.matches(
				"geeksforge*ks", "geeksforgeeks"));
		
		// for more e's
		System.out.println(Pattern.matches(
				"geeksforge+ks", "geeksforgeeks"));
		
		// returns false
		
		// for zero e's
		System.out.println(Pattern.matches(
				"geeksforge+ks", "geeksforgks"));
		
		
		// Following line prints "false" because the whole
		// text "geeksfor" doesn't match pattern "g*geeks*"
		System.out.println(Pattern.matches(
				"g*geeks*", "geeksfor"));
		
		// Following line prints "true" because the whole
		// text "geeksforgeeks" matches pattern
		// "geeks.*"
		System.out.println(Pattern.matches(
				"geeks.*", "geeksforgeeks"));
	}

	// Function to demonstrate
	// Pattern.compile method
	void compileStringInt()
	{
		// Create a REGEX string
		String REGEX = "(.*)(for)(.*)?";
		
		// Create the string
		// in which you want to search
		String actualString
			= "code for Machine";
		
		// compile the regex to create pattern
		// using compile() method
		Pattern pattern = Pattern.compile(REGEX,
							Pattern.CASE_INSENSITIVE);
		
		// check whether Regex string is
		// found in actualString or not
		boolean matches = pattern
								.matcher(actualString)
								.matches();
		
		System.out.println("actualString "
						   + "contains REGEX = "
						   + matches);
	}
	
	// Function to demonstrate
	// Pattern.compile method
	void compileStringIntTwo()
	{
		// Create a REGEX string
		String REGEX = ".*org.*";
		
		// Create the string
		// in which you want to search
		String actualString
			= "geeksforgeeks.org";
		
		// compile the regex to create pattern
		// using compile() method
		Pattern pattern = Pattern.compile(REGEX,
							Pattern.CASE_INSENSITIVE);
		
		// check whether Regex string is
		// found in actualString or not
		boolean matches = pattern
								.matcher(actualString)
								.matches();
		
		System.out.println("actualString "
						   + "contains REGEX = "
						   + matches);
	}

	// Function to demonstrate
	// Pattern.compile method
	void compile()
	{
		// Create a REGEX string
		String REGEX = ".*www.*";
		
		// Create the string
		// in which you want to search
		String actualString
			= "www.geeksforgeeks.org";
		
		// compile the regex to create pattern
		// using compile() method
		Pattern pattern = Pattern.compile(REGEX);
		
		// get a matcher object from pattern
		Matcher matcher = pattern.matcher(actualString);
		
		// check whether Regex string is
		// found in actualString or not
		boolean matches = matcher.matches();
		
		System.out.println("actualString "
						   + "contains REGEX = "
						   + matches);
	}

	// Function to demonstrate
	// Pattern.compile method
	void compileTwo()
	{
		// Create a REGEX string
		String REGEX = "brave";
		
		// Create the string
		// in which you want to search
		String actualString
			= "Cat is cute";
		
		// compile the regex to create pattern
		// using compile() method
		Pattern pattern = Pattern.compile(REGEX);
		
		// get a matcher object from pattern
		Matcher matcher = pattern.matcher(actualString);
		
		// check whether Regex string is
		// found in actualString or not
		boolean matches = matcher.matches();
		
		System.out.println("actualString "
						   + "contains REGEX = "
						   + matches);
	}

	// Function to demonstrate
	// Pattern.flags method
	void flags()
	{
		// Create a REGEX string
		String REGEX = "(.*)(for)(.*)?";
		
		// compile the regex to create pattern
		// using compile() method
		Pattern pattern = Pattern.compile(REGEX,
							Pattern.CASE_INSENSITIVE);
		
		// find the flag of pattern
		int flag = pattern.flags();
		
		System.out.println("Pattern's match flag = "
						   + flag);
	}

	// Function to demonstrate
	// Pattern.flags method
	void flagsTwo()
	{
		// Create a REGEX string
		String REGEX = "(.*)(ee)(.*)?";
		
		// compile the regex to create pattern
		// using compile() method
		Pattern pattern = Pattern.compile(REGEX,
							Pattern.MULTILINE);
		
		// find the flag of pattern
		int flag = pattern.flags();
		
		System.out.println("Pattern's match flag = "
						   + flag);
	}

	// Function to demonstrate
	// Pattern.matcher(CharSequence) method
	void matcher()
	{
		// Create a REGEX string
		String REGEX = "\\S*(ee)\\S*";
		
		// Create the string
		// in which you want to search
		String actualString
			= "geeks for geeks";
		
		// create a pattern
		Pattern pattern = Pattern.compile(REGEX);
		
		// get a matcher object
		Matcher matcher = pattern.matcher(actualString);
		
		// print values if match found
		boolean matchfound = false;
		while (matcher.find()) {
			System.out.println("found the Regex in text:"
					+ matcher.group()
					+ " starting index:" + matcher.start()
					+ " and ending index:"
					+ (matcher.end() - 1));
			
			matchfound = true;
		}
		
		if (!matchfound)
			System.out.print("No match found for Regex.");
	}

	// Function to demonstrate
	// Pattern.matcher(CharSequence) method
	void matcherTwo()
	{
		// Create a REGEX string
		String REGEX = "(.*)(welcome)(.*)?";
		
		// Create the string
		// in which you want to search
		String actualString
			= "geeksforgeeks";
		
		// create a pattern
		Pattern pattern = Pattern.compile(REGEX);
		
		// get a matcher object
		Matcher matcher = pattern.matcher(actualString);
		
		// print values if match found
		boolean matchfound = false;
		while (matcher.find()) {
			System.out.println("match found");
			
			matchfound = true;
		}
		
		if (!matchfound)
			System.out.print("No match found");
	}

	// Function to demonstrate
	// Pattern.matches(String, CharSequence) method
	void matches()
	{
		// Create a REGEX string
		String REGEX = "(.*)(ee)(.*)?";
		
		// Create the string
		// in which you want to search
		String actualString
			= "geeksforgeeks";
		
		// uses matches method to check the match
		boolean matcher = Pattern.matches(REGEX, actualString);
		
		// print values if match found
		if (matcher) {
			System.out.println("match found for Regex.");
		} else {
			System.out.print("No match found for Regex.");
		}
	}

	// Function to demonstrate
	// Pattern.matches(String, CharSequence) method
	void matchesTwo()
	{
		// Create a REGEX string
		String REGEX = "(.*)(welcome)(.*)?";
		
		// Create the string
		// in which you want to search
		String actualString
			= "The indian team wins worldcup";
		
		// uses matches method to check the match
		boolean matcher = Pattern.matches(REGEX, actualString);
		
		// print values if match found
		if (matcher) {
			System.out.println("match found for Regex.");
		} else {
			System.out.print("No match found for Regex.");
		}
	}

	// Function to demonstrate
	// Pattern.split(CharSequence) method
	void split()
	{
		// Create a REGEX string
		String REGEX = "geeksforgeeks";
		
		// Create the string
		// in which you want to search
		String actualString
			= "geeksforgeeks";
		
		// create a Pattern using REGEX
		Pattern pattern = Pattern.compile(REGEX);
		
		// split the text
		String[] array = pattern.split(actualString);
		
		// print array
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i
							   + "]=" + array[i]);
		}
	}

	// Function to demonstrate
	// Pattern.split(CharSequence) method
	void splitTwo()
	{
		// Create a REGEX string
		String REGEX = "ke";
		
		// Create the string
		// in which you want to search
		String actualString
			= "Bharat ke Veer Portal";
		
		// create a Pattern using REGEX
		Pattern pattern = Pattern.compile(REGEX);
		
		// split the text
		String[] array = pattern.split(actualString);
		
		// print array
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i
							   + "]=" + array[i]);
		}
	}

	// Function to demonstrate
	// Pattern.split(CharSequence, int) method
	void splitWithLimit()
	{
		// Create a REGEX string
		String REGEX = " ";
		
		// Create the string
		// in which you want to search
		String actualString
			= "Welcome to geeks for geeks";
		
		// create a Pattern using REGEX
		Pattern pattern = Pattern.compile(REGEX);
		
		// create a limit to 2
		// so it can be applied at most limit - 1 time
		int limit = 3;
		
		// split the text
		String[] array = pattern.split(actualString, limit);
		
		// print array
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i
							   + "]=" + array[i]);
		}
	}

	// Function to demonstrate
	// Pattern.split(CharSequence, int) method
	void splitWithLimitTwo()
	{
		// Create a REGEX string
		String REGEX = "ee";
		
		// Create the string
		// in which you want to search
		String actualString
			= "aaeebbeecceeddee";
		
		// create a Pattern using REGEX
		Pattern pattern = Pattern.compile(REGEX);
		
		// create a limit to 0
		// so it can be applied at most limit - 1 time
		int limit = 0;
		
		// split the text
		String[] array = pattern.split(actualString, limit);
		
		// print array
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i
							   + "]=" + array[i]);
		}
	}

	// Function to demonstrate
	// Pattern.toString() method
	void toStringOne()
	{
		// Create a REGEX string
		String REGEX = "geeks";
		
		// create a Pattern using REGEX
		Pattern pattern = Pattern.compile(REGEX);
		
		// print pattern
		System.out.println("Pattern:" + pattern);
	}

	// Function to demonstrate
	// Pattern.toString() method
	void toStringTwo()
	{
		// Create a REGEX string
		String REGEX = "[* & # $ !]+\\S";
		
		// create a Pattern using REGEX
		Pattern pattern = Pattern.compile(REGEX);
		
		// print pattern
		System.out.println("Pattern:" + pattern);
	}

	// Function Demonstrating Working of matches() Method
	// Pattern class
	void patternMatches()
	{
		// Following line prints "true" because the whole
		// text "geeksforgeeks" matches pattern
		// "geeks.*"
		System.out.println(Pattern.matches(
			"geeks.*", "geeksforgeeks"));
		
		// Following line prints "false" because the whole
		// text "geeks12s" doesn't match pattern "geeks[0-9]+"
		System.out.println(
			Pattern.matches("geeks[0-9]+", "geeks12s"));
	}
	
	// Function to illustrate find() method
	void matcherFind()
	{
		// Get the regex to be checked
        String regex = "Geeks";

        // Create a pattern from regex
        Pattern pattern
            = Pattern.compile(regex);

        // Get the String to be matched
        String stringToBeMatched
            = "GeeksForGeeks";

        // Create a matcher for the input String
        Matcher matcher
            = pattern
                  .matcher(stringToBeMatched);

        // Get the subsequence
        // using find() method
        while (matcher.find())
        	System.out.println(matcher.group());
	}
	
	// Function to illustrate find(int) method
	void matcherFindTwo()
	{
		// Get the regex to be checked
        String regex = "Geeks";

        // Create a pattern from regex
        Pattern pattern
            = Pattern.compile(regex);

        // Get the String to be matched
        String stringToBeMatched
            = "GeeksForGeeks";

        // Create a matcher for the input String
        Matcher matcher
            = pattern
                  .matcher(stringToBeMatched);

        // Get the subsequence
        // using find() method
        System.out.println(matcher.find(1));
	}
	
	// Function to illustrate start() method
	void matcherStart()
	{
		// Get the regex to be checked
        String regex = "(G*G)";

        // Create a pattern from regex
        Pattern pattern
            = Pattern.compile(regex);

        // Get the String to be matched
        String stringToBeMatched = "GFG";

        // Create a matcher for the input String
        Matcher matcher
            = pattern
                  .matcher(stringToBeMatched);

        // Get the current matcher state
        MatchResult result
            = matcher.toMatchResult();
        System.out.println("Current Matcher: "
                           + result);

        while (matcher.find()) {
            // Get the first index of match result
            System.out.println(matcher.start());
        }
	}
	
	

	// Function to illustrate end() method
	void matcherEnd()
	{
		// Get the regex to be checked
	    String regex = "(G*F)";
	
	    // Create a pattern from regex
	    Pattern pattern
	        = Pattern.compile(regex);
	
	    // Get the String to be matched
	    String stringToBeMatched = "GFG";
	
	    // Create a matcher for the input String
	    Matcher matcher
	        = pattern
	              .matcher(stringToBeMatched);
	
	    // Get the current matcher state
	    MatchResult result
	        = matcher.toMatchResult();
	    System.out.println("Current Matcher: "
	                       + result);
	
	    while (matcher.find()) {
	        // Get the last index of match result
	        System.out.println(matcher.end());
	    }
	}

	// Function to illustrate end() method
	void matcherGroup()
	{
		// Get the regex to be checked
	    String regex = "(G*s)";
	
	    // Create a pattern from regex
	    Pattern pattern
	        = Pattern.compile(regex);
	
	    // Get the String to be matched
	    String stringToBeMatched = "GeeksForGeeks";
	
	    // Create a matcher for the input String
	    Matcher matcher
	        = pattern
	              .matcher(stringToBeMatched);
	
	    // Get the current matcher state
	    MatchResult result
	        = matcher.toMatchResult();
	    System.out.println("Current Matcher: "
	                       + result);
	
	    while (matcher.find()) {
	    	// Get the group matched using group() method
	        System.out.println(matcher.group());
	    }
	}

	// Function to illustrate groupCount() method
	void matcherGroupCount()
	{
	    // Get the regex to be checked
        String regex = "Geeks";

        // Create a pattern from regex
        Pattern pattern
            = Pattern.compile(regex);

        // Get the String to be matched
        String stringToBeMatched
            = "GeeksForGeeks";

        // Create a matcher for the input String
        Matcher matcher
            = pattern
                  .matcher(stringToBeMatched);

        // Get the number of capturing groups
        // using groupCount() method
        System.out.println(matcher.groupCount());
	}
	
	// Function to illustrate matches() method
	void matcherMatches()
	{
		// Get the regex to be checked
		String regex = "Geeks";
		
		// Create a pattern from regex
		Pattern pattern 
			= Pattern.compile(regex);
		
		// Get the string to be matched
		String stringToBeMatched
			= "GeeksForGeeks";
		
		// Create a matcher for the input string
		Matcher matcher 
			= pattern
				  .matcher(stringToBeMatched);
		
		// Get the result state
		// using matches() method
		System.out.println("Result: "
						   + matcher.matches());
	}
	
	// Function to demonstrate the working of
	// String matching in Java
	void patternSearching()
	{
		
		
		// Create a pattern to be searched
		// Custom pattern
		Pattern pattern = Pattern.compile("geeks");
		
		// Search above pattern in "geeksforgeeks.org"
		Matcher m = pattern.matcher("geeksforgeeks.org");
		
		// Finding string using find() method
		while (m.find()) {
			
			// Print starting and ending indexes
			// of the pattern in the text
			// using this functionality of this class
			System.out.println("Pattern found from "
							   + m.start() + " to "
							   + (m.end() - 1));
		}
	}
	
	// Function to check on regex
	// Character classes
	void characterClass()
	{
		// Check if the string matches with the regex
		// should be single character a to z
		System.out.println(Pattern.matches("[a-z]",
										   "g"));
		
		// Check if the element is range a to z or A to Z
		System.out.println(Pattern.matches("[a-zA-Z]",
										   "Gfg"));
		
		// Check if the element is [ x OR y OR z ]
		System.out.println( "Pattern.matches(\"[xyz]\", \"x\") :"
				+ Pattern.matches("[xyz]", "x"));
		
		// Check if the String is only [ x OR y OR z ]
		System.out.println( "Pattern.matches(\"[xyz]*\","
				+ " \"xxxxyyyyzyyx\") :"
				+ Pattern.matches("[xyz]*", "xxxxyyyyzyyx"));
		
		// Check if the String is only [ x OR y OR z ]
		System.out.println( "Pattern.matches(\"[xyz]*\","
				+ " \"\") :"
				+ Pattern.matches("[xyz]*", ""));
		
		// Check if the String is only [ x OR y OR z ]
		System.out.println( "Pattern.matches(\"[xyz]*\","
				+ " \"xxxxyyyyzyax\") :"
				+ Pattern.matches("[xyz]*", "xxxxyyyyzyax"));
		
		// Check if the String is other than [ x OR y OR z ]
		System.out.println( "Pattern.matches(\"[^xyz]\","
				+ " \"d\") :"
				+ Pattern.matches("[^xyz]", "d"));
		
		// Check if the String is in union of a to f and m to t
		System.out.println( "Pattern.matches(\"[a-f[m-t]]+\","
				+ " \"am\") :"
				+ Pattern.matches("[a-f[m-t]]+", "am"));
		
		// Check if the String is in union of a to f and m to t
		System.out.println( "Pattern.matches(\"[a-f[m-t]]+\","
				+ " \"amg\") :"
				+ Pattern.matches("[a-f[m-t]]+", "amg"));
		
		// Check if the String is in intersection of a to s
		// and p to y
		System.out.println( "Pattern.matches(\"[a-s && p-y]+\","
				+ " \"qr\") :"
				+ Pattern.matches("[a-s && p-y]+", "qr"));
		
		// Check if the String is in intersection of a to s
		// and p to y
		System.out.println( "Pattern.matches(\"[a-s && p-y]+\","
				+ " \"ay\") :"
				+ Pattern.matches("[a-s && p-y]+", "ay"));
		
		// Check if the String is in union of a to s
		// except b and p
		System.out.println( "Pattern.matches(\"[a-s && [^bp]]+\","
				+ " \"as\") :"
				+ Pattern.matches("[a-s && [^bp]]+", "as"));
		
		// Check if the String is in union of a to s
		// except range b to p
		System.out.println( "Pattern.matches(\"[a-s && [^b-p]]+\","
				+ " \"co\") :"
				+ Pattern.matches("[a-s && [^b-p]]+", "co"));
	}
	
	// Function to illustrate meta-characters
	void metaCharacters()
	{
		// Checking all the strings using regex
        System.out.println(Pattern.matches("[b-z]?",
                                           "a"));

        // Check if all the elements are in range a to z
        // or A to Z
        System.out.println(Pattern.matches("[a-zA-Z]+",
                                           "GfgTestCase"));

        // Check if elements is not in range a to z
        System.out.println(Pattern.matches("[^a-z]?",
                                           "g"));

        // Check if all the elements are either g,e,k or s
        System.out.println(Pattern.matches("[geks]*",
                                           "geeksgeeks"));
	}
	
	// Function to illustrate regex finder
	void regexFinder()
	{
		// Check if all elements are numbers
        System.out.println(Pattern.matches("\\d+", "1234"));

        // Check if all elements are non-numbers
        System.out.println(Pattern.matches("\\D+", "1234"));

        // Check if all the elements are non-numbers
        System.out.println(Pattern.matches("\\D+", "Gfg"));

        // Check if all the elements are non-spaces
        System.out.println(Pattern.matches("\\S+", "gfg"));
	}
	
	// Main function
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RegexExcercisesOne regex = new RegexExcercisesOne();
//		regex.zeroOneOrMoreExcercises();
/*		Pattern methods :-
//		regex.compile();
//		regex.compileTwo();
//		regex.compileStringInt();
//		regex.compileStringIntTwo();
//		regex.flags();
//		regex.flagsTwo();
//		regex.matcher();
//		regex.matcherTwo();
//		regex.matches();
//		regex.matchesTwo();
//		regex.split();
//		regex.splitTwo();
//		regex.splitWithLimit();
//		regex.splitWithLimitTwo();
//		regex.toStringOne();
//		regex.toStringTwo();
*/
//		regex.patternMatches();
/*		Matcher methods :-
//		regex.matcherFind();
//		regex.matcherFindTwo();
//		regex.matcherStart();
//		regex.matcherEnd();
//		regex.matcherGroup();
//		regex.matcherGroupCount();
//		regex.matcherMatches();
*/
//		regex.patternSearching();
//		regex.characterClass();
//		regex.metaCharacters();
		regex.regexFinder();
	}
	
}
