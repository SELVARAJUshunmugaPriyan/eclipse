package dayOne;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionTen {
	// AverageAge
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
//		int a = 31;
//		int b = 42;
//		int c = 39;
//		int d = 23;
//		int e = 46;
//		System.out.println("Average age is " +
//				((a + b + c + d + e) / 5));
		try {
//			while (true) {
				try {
					System.out.println("Enter ages");
					while (scn.hasNextInt()) {
						a.add(scn.nextInt());
					}
					System.out.println("Average age of " 
							+ a + " is " + average(a));
					a.clear();
				} catch (InputMismatchException E) {
					System.out.println("Only Integers accepted");
					scn.next();
				}
//			}
		} catch (NoSuchElementException E) {
			;
		} finally {
			System.out.println("Closed System.in resource");
			scn.close();
		}
	}

	static int average(ArrayList<Integer> a) {
		int sum = 0;
		if (a.isEmpty()) {
			return -1;
		}
		for(int i = 0; i < a.size(); i++) {
			sum += a.get(i);
		}
		return sum/a.size();
	}
}
