package java8Tasks;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class QuestionTwo {

	public static void main(String[] args) {
		
		List<Double> list = new ArrayList<>();
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Press enter key twice to sum\n"
						+ "and [ctrl + z] to exit\n"
						+ "Please enter numbers: ");
				
				try {
					while (true) {
						list.add(Double.parseDouble(scn.nextLine()));
					}
				} catch (NumberFormatException e) {
					if (!list.isEmpty())
						System.out.println("Sum = " + list.stream()
													  	  .reduce((x, y) -> x + y)
													      .get());
				}
			}
		} catch (java.util.NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
		}
	}

}
