package oopsThree;

abstract class SunStar
{
	SunStar()
	{
		System.out.println("Sunstar employee details -");
	}
	
	abstract void printInfo();
	
	static int getSalary()
	{
		return 40000;
	}
}

class Employee extends SunStar
{
	void printInfo()
	{
		String name = "Avinash";
		int age = 21;
		int salary = SunStar.getSalary();

		System.out.println(name + "\n" + age + "\n" + salary);
	}
}

public class UseEmployee
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		SunStar s = new Employee();
		s.printInfo();

//		System.out.println(SunStar.getSalary());
	}

}
