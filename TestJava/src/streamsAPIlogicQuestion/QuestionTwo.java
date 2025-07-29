package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;

public class QuestionTwo 
{

	public static void main(String[] args)
	{
		List<Employee> list = Arrays.asList(new Employee("java developer", 20000),
											new Employee("C developer", 25000),
											new Employee("C/C++ developer", 35000),
											new Employee("java developer", 60000),
											new Employee("Devops Engineer", 20000));
		
		list.forEach(x -> System.out.println(x));
		
		System.out.println("\n");
		
		list.stream().peek(x -> {
									if (x.getRole().equals("java developer"))
										x.setSalary(x.getSalary() + 10000);
								})
					 .forEach(x -> System.out.println(x));
	}
}