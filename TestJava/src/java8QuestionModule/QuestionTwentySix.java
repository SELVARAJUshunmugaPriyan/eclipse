package java8QuestionModule;

import java.util.List;
import java.util.Arrays;

@FunctionalInterface
interface Employee
{
	public EmployeeObj find(List<EmployeeObj> a);
}

class Employees
{
	EmployeeObj maxSalaryEmployee(List<EmployeeObj> list)
	{
		EmployeeObj maxE = list.get(0);
		for (EmployeeObj e : list)
			if (e.getSalary() > maxE.getSalary())
				maxE = e;
		return maxE;
	}
	
	EmployeeObj minSalaryEmployee(List<EmployeeObj> list)
	{
		EmployeeObj minE = list.get(0);
		for (EmployeeObj e : list)
			if (e.getSalary() < minE.getSalary())
				minE = e;
		return minE;
	}
	
	EmployeeObj maxExpEmployee(List<EmployeeObj> list)
	{
		EmployeeObj maxE = list.get(0);
		for (EmployeeObj e : list)
			if (e.getExp() > maxE.getExp())
				maxE = e;
		return maxE;
	}
	
	EmployeeObj minExpEmployee(List<EmployeeObj> list)
	{
		EmployeeObj minE = list.get(0);
		for (EmployeeObj e : list)
			if (e.getExp() < minE.getExp())
				minE = e;
		return minE;
	}
}

class EmployeeObj
{
	private int exp, salary;
	
	EmployeeObj(int exp, int salary)
	{
		this.exp = exp;
		this.salary = salary;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString()
	{
		return "Exp: " + exp + ", salary: " + salary;
	}
}

public class QuestionTwentySix {

	public static void main(String[] args) {
		
		Employees emp = new Employees();
		Employee maxSalary = emp::maxSalaryEmployee;
		Employee maxExp = emp::maxExpEmployee;
		Employee minSalary = emp::minSalaryEmployee;
		Employee minExp = emp::minExpEmployee;
		
		List<EmployeeObj> list = Arrays.asList(new EmployeeObj(5, 25000),
											   new EmployeeObj(4, 27000),
											   new EmployeeObj(3, 28000),
											   new EmployeeObj(1, 12000),
											   new EmployeeObj(6, 18000));
		
		System.out.println(maxExp.find(list));
		System.out.println(maxSalary.find(list));
		System.out.println(minExp.find(list));
		System.out.println(minSalary.find(list));
	}

}
