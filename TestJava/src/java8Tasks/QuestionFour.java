package java8Tasks;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

class CustomComparator implements Comparator<Employee>
{
	@Override
	public int compare(Employee a, Employee b)
	{
		return b.getName().length() - a.getName().length();
	}
}

public class QuestionFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Press enter key twice to get\n"
						+ "employee list who has longest name\n"
						+ "and [ctrl + z] to exit\n"
						+ "Please enter numbers: ");
				
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
						System.err.println("\n\nlist:\n");
						
						CustomComparator cus = new CustomComparator();
						list.stream()
							.sorted(cus::compare)
							.limit(1)
							.forEach(System.out::println);
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