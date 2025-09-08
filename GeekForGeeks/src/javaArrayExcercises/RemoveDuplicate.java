package javaArrayExcercises;

//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RemoveDuplicate {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		try {
			
			while(true) {
				int i = 0, j = 0;
				
				System.out.println("Enter array in following format:"
						+ "\n[num1, num2, num3]");
				
				String[] S = scn.nextLine().split(",");
				int[] I = new int[S.length], J = new int[S.length];
				
				try {
					for(String s : S) {
//					
						if(s.indexOf('[') == 0)
							s = s.substring(1);
						else if(s.indexOf(']') == s.length() - 1)
							s = s.substring(0, s.length() - 1);
						
						I[i++] = Integer.parseInt(s.trim());
						
					}
										
					for(i = 0; i < I.length; i++)
						for(int k = 0; k < J.length; k++)
							if(I[i] != J[k] && k == j) {
//								System.out.println(I[i] + " " + Arrays.toString(J));
								J[j++] = I[i];
								break;
							} else if(I[i] == 0 && k == j) {
								J[j++] = 0;
								break;
							} else if(I[i] == J[k])
								break;
								
					System.out.print("Resulting array is [");
					for(i = 0; i < j; i++) {
						System.out.print(J[i]);
						if(i != j - 1)
							System.out.print(", ");
						else
							System.out.println("]");
					}
					
				} catch(NumberFormatException e) {
					System.out.println("Only numbers are accepted");
				} catch(StringIndexOutOfBoundsException e) {
					;
				}
			}
			
		} catch(NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System in resource");
			scn.close();
		}

	}

}
