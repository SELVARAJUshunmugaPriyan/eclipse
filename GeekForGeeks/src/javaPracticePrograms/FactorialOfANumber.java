package javaPracticePrograms;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class FactorialOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					long pdt = 1; 
					
					System.out.println("\nEnter an unsigned integer:");
					
					int i = Integer.parseInt(scn.next());
					
					if(i > 65)
						throw new NumberFormatException("Integer over 65 are not allowed");
					else if(i < 0)
						throw new NumberFormatException("Unsigned integers are allowed");
					
					for(int j = 1; j <= i; j++)
						pdt *= j;
					
					System.out.print("Factorial of " + i + " is " + pdt);
				} catch(NumberFormatException e) {
					System.out.println("Exception message: " + e.getMessage());
//					scn.next();
				}
			}
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.print("Closing System.in resource");
			scn.close();
		}
	}

}
