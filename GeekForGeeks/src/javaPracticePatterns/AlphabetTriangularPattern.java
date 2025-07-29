package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AlphabetTriangularPattern {

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
					
					System.out.println("Decreasing rolling pattern:");
					
					for (int i = 0, startLetter = 'A'; i < n; i++, startLetter++) {
						for (int j = i, letter = startLetter; j < n; j++, letter++)
							System.out.print((char) letter + " ");
						System.out.println();
					}
					
					System.out.println("Decreasing descending pattern:");
					
					for (int i = 0, startLetter = 'A' + n - 1; i < n; i++, startLetter--) {
						for (int j = i; j < n; j++)
							System.out.print((char) startLetter + " ");
						System.out.println();
					}
					
					System.out.println("Increasing rolling pattern:");
					
					for (int i = 0; i < n; i++) {
						for (int j = 0, letter = 'A'; j <= i; j++, letter++)
							System.out.print((char) letter + " ");
						System.out.println();
					}
					
					System.out.println("Increasing descending pattern:");
					
					for (int i = 0; i < n; i++) {
						for (int j = 0, letter = '@' + n - i; j <= i; j++, letter++)
							System.out.print((char) letter + " ");
						System.out.println();
					}
					
					System.out.println("Decreasing ascending pattern:");
					
					for (int i = 0, letter = 'A'; i < n; i++, letter++) {
						for (int j = i; j < n; j++)
							System.out.print((char) letter + " ");
						System.out.println();
					}
					
					System.out.println("Decreasing reverse rolling pattern:");
					
					for (int i = 0; i < n; i++) {
						for (int j = 0, letter = 'A' + i; j <= i; j++, letter--)
							System.out.print((char) letter + " ");
						System.out.println();
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
