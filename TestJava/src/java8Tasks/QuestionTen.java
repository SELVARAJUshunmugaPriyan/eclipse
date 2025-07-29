package java8Tasks;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class QuestionTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Press enter key twice to convert Array -> ArrayList\n"
						+ "and [ctrl + z] to exit\n"
						+ "Please enter numbers: ");
				
				double arr[] = new double[10];
				int i = 0;
				
				try {
					while (true) {
						arr[i++] = Double.parseDouble(scn.nextLine());
						if (i > 0.75 * arr.length) {
							double tmp[] = Arrays.copyOf(arr, arr.length + 5);
							arr = tmp;
						}
					}
				} catch (NumberFormatException e) {
					if (i != 0) {
						arr = Arrays.copyOf(arr, --i);
						List<Double> list = Arrays.stream(arr).boxed().toList();
						System.out.println("Array: " + Arrays.toString(arr) + " " 
								+ arr.getClass().getTypeName()
								+ "\nArrayList: " + list																	  
								+ " " + list.getClass().getName());
					}
					
					arr = null;
				}
			}
		} catch (java.util.NoSuchElementException e) {
			;
		} finally {
			System.out.println("Closing System.in resource");
		}
	}

}
