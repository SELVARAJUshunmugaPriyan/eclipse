package javaPracticePatterns;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CirclePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					System.out.println("Enter an unsigned integer:");
					
					int radius = Integer.parseInt(scn.next());
					
					if(radius <= 0)
						throw new NumberFormatException();					
					
					System.out.println("Circle pattern:");
					
					for (int i = 0; i <= 2 * radius; i++) {
						for (int j = 0; j <= 2 * radius; j++) {
//							if (((i == 1 || i == 2 * radius) && j >= radius - 1 && j <= radius + 1) || ((j == 1 || j == 2 * radius) && i >= radius - 1 && i <= radius + 1) ||
//								  j == Math.abs(radius - i) || j == (i > radius ? 3 * radius - i : radius + i))
//								System.out.print("*");
//							else
//								System.out.print(" ");
							double dist = Math.sqrt((i - radius) * (i - radius) +
													(j - radius) * (j - radius));
							if (dist > radius - 0.5 && dist < radius + 0.5)
								System.out.print("*");
							else
								System.out.print(" ");
						}
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
