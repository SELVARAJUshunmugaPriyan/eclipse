package dayOne;

import java.util.Scanner;

public class QuestionFifteen {
	// CelsiusToFahrenheit
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		try {
			while (true) {
				try {
					float celsius = 0.0f;
					
					System.out.println("Enter celsius value");
					celsius = Float.parseFloat(scn.next());
			
					float fahrenheit = (celsius * (9 / 5)) + 32;
					System.out.println("Fahrenheit value is " + fahrenheit);
				} catch (NumberFormatException e) {
					System.out.println("Only float values with 6 decimal places are accepted");
					scn.next();
				}
			}
		} catch (java.util.NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
			scn.close();
		}
	}

}
