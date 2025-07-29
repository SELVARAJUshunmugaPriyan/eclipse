package dayOne;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionThree {
	// OperaterDouble
	public static void main (String[] args) {
//		double a = 5.6253173d;
//		double b = 7.7894321d;
//		System.out.println("a + b = " + (a + b));
//		System.out.println("a - b = " + (a - b));
//		System.out.println("a * b = " + (a * b));
//		System.out.println("a / b = " + (a / b));
		Scanner scn = new Scanner(System.in);
		
		try {
			while (true) {
				try {
					System.out.println("Enter two double values:");
					double varOne = Double.parseDouble(scn.nextLine());
					double varTwo = Double.parseDouble(scn.nextLine());
					
					System.out.println(varOne + " + " + varTwo + " = " + (varOne + varTwo));
					System.out.println(varOne + " - " + varTwo + " = " + (varOne - varTwo));
					System.out.println(varOne + " * " + varTwo + " = " + (varOne * varTwo));
					System.out.println(varOne + " / " + varTwo + " = " + (varOne / varTwo));
				} catch (InputMismatchException e) {
					System.out.println("Only double values are accepted.");
					scn.next();
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