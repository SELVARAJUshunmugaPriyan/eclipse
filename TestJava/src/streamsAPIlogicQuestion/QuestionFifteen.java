package streamsAPIlogicQuestion;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.Function;

public class QuestionFifteen 
{

	public static void main(String[] args)
	{
		List<Employer> list = Arrays.asList(new Employer("IT", 20000),
											new Employer("HR", 25000),
											new Employer("ADMIN", 35000),
											new Employer("IT", 60000),
											new Employer("HR", 20000));
		
		list.stream()
			.map(x -> x.getDept())
			.collect(Collectors.groupingBy(Function.identity(),
			Collectors.counting())).forEach((k, v) -> 
			System.out.println(k + " " + v));
	}
}

class Employer {
	private String dept;
	private int salary;
	
	// Constructor
	Employer(String dept, int salary)
	{
		this.dept = dept;
		this.salary = salary;
	}
	
	// Getters and Setters
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int Salary) {
		this.salary = Salary;
	}
	
	@Override
	public String toString()
	{
		return "Dept : " + dept + ", Salary : " + salary;
	}
	
}