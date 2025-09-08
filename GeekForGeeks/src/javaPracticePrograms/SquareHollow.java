package javaPracticePrograms;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SquareHollow {
	static void fill(char[] C, char c) {
		int i = 0;
		while(i < C.length)
			C[i++] = c;
	}
	
	static void fill(char[] C, int start, int end, char c) {
		int i = start;
		while(i < end) {
			C[i++] = c;
		}
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int n = Integer.parseInt(scn.next());
					
					if(n <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Hollow square pattern:");
					
					char[] C = new char[n];
					
					for(int i = 0; i < n; i++) {
						if(i == 0 || i == n - 1)
//							Arrays.fill(C, '*');
							fill(C, '*');
						else
//							Arrays.fill(C, 1, n - 1, ' ');
							fill(C, 1, n - 1, ' ');
						System.out.println(C);
					}
					
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
