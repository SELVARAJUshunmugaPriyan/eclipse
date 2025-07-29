package javaPracticePrograms;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PascalTriangleThree {
	
	static void printPascal(int n) {
		for(int line = 1; line <= n; line++) {
			int C = 1;
			
			for(int i = 0; i <= n - line; i++)
				System.out.print(" ");
			
			for(int i = 1; i <= line; i++) {
				System.out.print(C + " ");
				C = C * (line - i) / i;
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Pascal triangle:");
					
					printPascal(n);
					
				} catch(NumberFormatException e) {
					System.out.println("Only integers greater than zero are accepted");
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
