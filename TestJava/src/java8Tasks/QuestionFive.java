package java8Tasks;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class QuestionFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Press enter key twice to get\n"
						+ "least three ages of employees\n"
						+ "and [ctrl + z] to exit\n"
						+ "Please enter employee details: ");
				
				try {
					while (true) {
						System.out.print("Enter name: ");
						String name = scn.nextLine();
						if (name.length() == 0)
							throw new NumberFormatException();
						
						System.out.print("Enter division: ");
						String division = scn.nextLine();
						if (division.length() == 0)
							throw new NumberFormatException();
						
						System.out.print("Enter address: ");
						String address = scn.nextLine();
						if (address.length() == 0)
							throw new NumberFormatException();
						
						System.out.print("Enter age: ");
						int age = Integer.parseInt(scn.nextLine());
						
						System.out.print("Enter salary: ");
						int salary = Integer.parseInt(scn.nextLine());
						
						System.out.print("Enter gender (\"male\"/\"female\"): ");
						boolean isMale = scn.nextLine().equals("male");
						
						list.add(new Employee(name, division, address, age, salary, isMale));
						
						System.out.println("Employee added. Press enter twice to get results.");
					}
				} catch (NumberFormatException e) {
					if (!list.isEmpty()) {
						System.err.println("\n\nlist:\n" + 
								list.stream()
									.map(x -> x.getAge())
									.sorted(Comparable::compareTo)
									.limit(3)
									.toList()
							);
						list.clear();
					}
				}
			}
		} catch (java.util.NoSuchElementException e) {
			;
		} finally {
			System.out.println("\n\nClosing System.in resource");
		}
	}

}