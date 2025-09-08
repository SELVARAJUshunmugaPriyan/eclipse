package javaPracticePrograms;

//import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddTwoComplexNumbersOne {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			while(true) {
				try {
					String s, sign = "";
					int i = 0, subStr = 0;
					int[] I = new int[4];
					
					System.out.println("Enter two numbers:");
					
					while (i <= 2) {
						s = scn.next();
						
						if(s.indexOf("+") == 0 || s.indexOf("-") == 0)
							subStr = 1;
						
						if(s.substring(subStr).indexOf("+") > 0)
							sign = "\\+";
						else if(s.substring(subStr).indexOf("-") > 0)
							sign = "-";
						else
							throw new NumberFormatException();
						
						for(String t : s.substring(subStr).split(sign)) {
//							System.out.println(t);
							if(t.charAt(t.length() - 1) == 'i') {
								I[i++] = Integer.parseInt(t.substring(0,t.length() - 1));
								if(sign.equals("-"))
									I[i - 1] *= -1;
							} else {
								I[i++] = Integer.parseInt(t);
								if(s.charAt(0) == '-')
									I[i - 1] *= -1;
							}
						}
					}
					
					System.out.print("Sum is " + (I[0] + I[2]));
					if(I[1] + I[3] < 0)
						System.out.print((I[1] + I[3]) + "i");
					else
						System.out.print("+" + (I[1] + I[3]) + "i");
										
				} catch(NumberFormatException e) {
					System.out.println("Only complex numbers of format (a + bi) are accepted");
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
