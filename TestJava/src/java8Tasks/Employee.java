package java8Tasks;

public class Employee
{
	private String name, division, address;
	private int age, salary;
	private boolean isMale;
	
	// Constructors
	Employee()
	{
		// Default
	}
	
	Employee(String name, String division, String address,
			int age, int salary, boolean isMale)
	{
		this.setName(name);
		this.setDivision(division);
		this.setAddress(address);
		this.setAge(age);
		this.setSalary(salary);
		this.setMale(isMale);
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	@Override
	public String toString()
	{
		return "\nName : " + name +
			   "\nDivision : " + division +
			   "\nAddress : " + address +
			   "\nAge : " + age +
			   "\nSalary : " + salary +
			   "\nGender : " + ( isMale ? "male" : "female" ) + "\n";
	}
}