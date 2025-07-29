package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class QuestionSixteen 
{

	public static void main(String[] args)
	{
		List<Employee> list = Arrays.asList(new Employee("Ajay", 28, 20000),
											new Employee("Bharath", 36, 25000),
											new Employee("Chandru", 45, 35000),
											new Employee("Deepak", 32, 60000),
											new Employee("Elango", 26, 20000),
											new Employee("Fernandes", 29, 25000),
											new Employee("Gopi", 37, 25000),
											new Employee("Hari", 45, 35000),
											new Employee("Ilango", 33, 50000),
											new Employee("Jack", 25, 40000));
		
		list.stream().filter(x -> x.getSalary() > 25000)
					 .sorted(Comparator.comparing(Employee::getAge).reversed())
					 .sorted(Comparator.comparing(Employee::getName).reversed())
					 .limit(1)
					 .forEach(x -> System.out.println(x));
	}
}