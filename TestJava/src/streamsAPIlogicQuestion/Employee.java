package streamsAPIlogicQuestion;

class Employee {
	private String role, name;
	private int salary, age;
	
	// Constructors
	Employee(String role, int salary)
	{
		this.role = role;
		this.name = "RemoteEmployee";
		this.age = 0;
		this.salary = salary;
	}
	
	Employee(String name, int age, int salary)
	{
		this.name = name;
		this.role = "default";
		this.age = age;
		this.salary = salary;
	}
	
	// Getters and Setters
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int Salary) {
		this.salary = Salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString()
	{
		return "Name : " + name + ", age : " + age
			 + ", Role : " + role + ", Salary : " + salary;
	}

}