package oopsOneWithConditionsOne;

public class Solution {

	public static void main(String[] args) {
		
		String s = "SUN,MON,TUE,WED,THURS,FRI,SAT", S[] = s.split(",");
		int countWeekends = 0, countWeekdays = 0, i = 0; 
		while (i < S.length)
			if (S[i++].startsWith("S")) {
				System.out.println("WEEKEND");
				countWeekends++;
			} else {
				System.out.println("WEEKDAY");
				countWeekdays++;
			}
		System.out.println("Number of weekends: " + countWeekends 
				+ "\nNumber of weekends: " + countWeekdays);
	}

}
