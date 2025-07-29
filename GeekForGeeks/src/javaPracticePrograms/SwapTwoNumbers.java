package javaPracticePrograms;

//import java.util.Arrays;
//import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					double[] D = {0, 0, 0, 0};
					
					System.out.println("Enter two numbers:");
					
					for(int i = 0; i < D.length; i += 2) {
						String s = scn.next();
//						System.out.println(s.indexOf("."));
						if(s.indexOf(".") > -1)
							D[i + 1] = s.length() - s.indexOf(".") - 1;
						D[i] = Double.parseDouble(s);
					}
//					System.out.println(Arrays.toString(D));
					System.out.print("Swapped numbers are ");
					if(D[1] == 0 && D[3] != 0)
						System.out.println(D[2] + " and " + (int) D[0]);
					else if(D[1] != 0 && D[3] == 0)
						System.out.println((int) D[2] + " and " + D[0]);
					else if(D[1] == 0 && D[3] == 0)
						System.out.println((int) D[2] + " and " + (int) D[0]);
					else
						System.out.println(D[2] + " and " + D[0]);
				} catch(NumberFormatException e) {
					System.out.println("Only numbers are accepted");
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
