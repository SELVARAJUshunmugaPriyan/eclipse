package java8Tasks;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class QuestionEight {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		File file = new File("C:\\Users\\monk_\\eclipse-workspace\\TestJava\\src\\java8Tasks\\EmployeeDetails.txt");
		
		try (Scanner scn = new Scanner(file)) {			
			while (scn.hasNext()) {
				String name = scn.nextLine();
				System.out.println("Entered name: " + name);
				
				String division = scn.nextLine();
				System.out.println("Entered division: " + division);
				
				String address = scn.nextLine();
				System.out.println("Entered address: " + address);
				
				int age = Integer.parseInt(scn.nextLine());
				System.out.println("Entered age: " + age);
				
				int salary = Integer.parseInt(scn.nextLine());
				System.out.println("Entered salary: " + salary);
				
				boolean isMale = scn.nextLine().equals("male");
				System.out.println("Entered gender: " +  ( isMale ? "male" : "female" ));
				
				list.add(new Employee(name, division, address, age, salary, isMale));
				
				System.out.println("Employee added.\n\n\n");
			}
			
			if (!list.isEmpty()) {
				System.out.println("Count of employees with duplicate names:");
				System.out.println("Count: " +
						list.stream()
							.map(x -> x.getName())
							.filter(x -> list.stream().filter(y -> y.getName()
																	.equals(x))
											  						.count() > 1)
							.distinct()
							.count());
			}
			
		} catch (java.util.NoSuchElementException | java.io.FileNotFoundException e) {
			;
		} finally {
			System.out.println("\n\nClosing the file");
		}
	}

}