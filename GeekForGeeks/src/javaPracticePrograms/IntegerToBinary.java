package javaPracticePrograms;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class IntegerToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					int[] I = new int[32];
					
					System.out.println("\nEnter an unsigned integer:");
					
					int i = Integer.parseInt(scn.next()), j = 0;
					
					if(i < 0)
						throw new NumberFormatException();
					
					while(i > 0) {
						I[j++] = i % 2;
						i /= 2;
					}
					
					System.out.print("Binary number is ");
					
					for(j = j - 1; j >= 0; j--)
						System.out.print(I[j]);
					
				} catch(NumberFormatException e) {
					System.out.println("Only unsigned integers are accepted");
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
