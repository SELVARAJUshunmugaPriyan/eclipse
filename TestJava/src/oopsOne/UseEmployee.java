package oopsOne;

class Address
{
	private int doorNumber, pincode;
	private String streetName, townName, district, state;
	
	// Constructor
	public Address(int doorNumber, int pincode,  String streetName, 
			String townName, String district, String state)
	{
		this.doorNumber = doorNumber;
		this.pincode = pincode;
		this.streetName = streetName;
		this.townName = townName;
		this.district = district;
		this.state = state;
	}
	
	public Address() {
	}

	// Setters
	public void setDoorNumber(int doorNumber)
	{
		this.doorNumber = doorNumber;
	}
	
	public void setPincode(int pincode)
	{
		this.pincode = pincode;
	}
	
	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}
	
	public void setTownName(String townName)
	{
		this.townName = townName;
	}
	
	public void setDistrict(String district)
	{
		this.district = district;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	// Getters
	public int getDoorNumber()
	{
		return doorNumber;
	}
	
	public int getPincode()
	{
		return pincode;
	}
	
	public String getStreetName()
	{
		return streetName;
	}
	
	public String getTownName()
	{
		return townName;
	}
	
	public String getDistrict()
	{
		return district;
	}
	
	public String getState()
	{
		return state;
	}
}

class Employee
{
	private int id, age, salary;
	private String name, dept, role/*, address*/;
	private Address address;
	
	// Constructor
	public Employee(int id, int age, int salary, 
			String name, String dept, String role, 
			Address address)
	{
		this.id = id;
		this.age = age;
		this.salary = salary;
		this.name = name;
		this.dept = dept;
		this.role = role;
		this.address = address;
	}
	
	public Employee() {}

	// Setters
	public void setId(int id)
	{
		this.id = id;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setDept(String dept)
	{
		this.dept = dept;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	// Getters
	public int getId()
	{
		return id;
	}

	public int getAge()
	{
		return age;
	}
	
	public int getSalary()
	{
		return salary;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDept()
	{
		return dept;
	}
	
	public String getRole()
	{
		return role;
	}
	
	public Address getAddress()
	{
		return address;
	}
	
	void showMessage()
	{
		System.out.println("Employee Program");
	}
	
	void showEmployee()
	{
		System.out.println("id\t:\t" + id
				+ "\nname\t:\t" + name
				+ "\ndept\t:\t" + dept
				+ "\nage\t:\t" + age
				+ "\nsalary\t:\t" + salary
				+ "\nrole\t:\t" + role
//				+ "\naddress\t:\t" + address
				+ "\naddress\t:\tdoor no\t\t:\t" + address.getDoorNumber()
				+ "\n\t\tstreet name\t:\t" + address.getStreetName()
				+ "\n\t\ttown name\t:\t" + address.getTownName()
				+ "\n\t\tdistrict\t:\t" + address.getDistrict()
				+ "\n\t\tstate\t\t:\t" + address.getState()
				+ "\n\t\tpincode\t\t:\t" + address.getPincode()
				+ "\n");
	}
}

public class UseEmployee
{

	public static void main(String[] args) 
	{
				
		Employee employeeA = new Employee();
		Employee employeeB = new Employee();
		Employee employeeC = new Employee(1003, 26, 32000, 
				"Hari", "IT", "developer", new Address(64,
				632001, "Temple Street", "Vellore", "Vellore",
				"Tamil Nadu"));
		
		employeeA.setId(1001);
		employeeA.setName("Kavitha");
		employeeA.setDept("HR");
		employeeA.setAge(28);
		employeeA.setSalary(50000);
		employeeA.setRole("professional");
//		employeeA.address = "5, Big Street, Kanchipuram - 2";
		employeeA.setAddress(new Address());
		employeeA.getAddress().setDoorNumber(5);
		employeeA.getAddress().setStreetName("Big Street");
		employeeA.getAddress().setTownName("Kanchipuram");
		employeeA.getAddress().setDistrict("Kanchipuram");
		employeeA.getAddress().setState("Tamil Nadu");
		employeeA.getAddress().setPincode(631502);
		
		employeeB.setId(1002);
		employeeB.setName("Latha");
		employeeB.setDept("Engineering");
		employeeB.setAge(32);
		employeeB.setSalary(45000);
		employeeB.setRole("engineer");
//		employeeB.address = "72, Main Road, Selaiyur - 6";
		employeeB.setAddress(new Address());
		employeeB.getAddress().setDoorNumber(72);
		employeeB.getAddress().setStreetName("Main Street");
		employeeB.getAddress().setTownName("Selaiyur");
		employeeB.getAddress().setDistrict("Chengalpet");
		employeeB.getAddress().setState("Tamil Nadu");
		employeeB.getAddress().setPincode(600046);
		
//		System.out.println("id\t:\t" + employeeA.id
//				+ "\nname\t:\t" + employeeA.name
//				+ "\ndept\t:\t" + employeeA.dept
//				+ "\nage\t:\t" + employeeA.age
//				+ "\nsalary\t:\t" + employeeA.salary
//				+ "\nrole\t:\t" + employeeA.role
//				+ "\naddress\t:\t" + employeeA.address
//				+ "\n");
//		
//		System.out.println("id\t:\t" + employeeB.id
//				+ "\nname\t:\t" + employeeB.name
//				+ "\ndept\t:\t" + employeeB.dept
//				+ "\nage\t:\t" + employeeB.age
//				+ "\nsalary\t:\t" + employeeB.salary
//				+ "\nrole\t:\t" + employeeB.role
//				+ "\naddress\t:\t" + employeeB.address
//				+ "\n");
		
//		employeeA.showMessage();
//		employeeA.showEmployee();
//		
//		employeeB.showMessage();
//		employeeB.showEmployee();
		
		displayEmployee(employeeA);
		displayEmployee(employeeB);
		displayEmployee(employeeC);
	}
	
	static void displayEmployee(Employee employee)
	{
		System.out.println("id\t:\t" + employee.getId()
				+ "\nname\t:\t" + employee.getName()
				+ "\ndept\t:\t" + employee.getDept()
				+ "\nage\t:\t" + employee.getAge()
				+ "\nsalary\t:\t" + employee.getSalary()
				+ "\nrole\t:\t" + employee.getRole()
//				+ "\naddress\t:\t" + employee.address
				+ "\naddress\t:\tdoor no\t\t:\t" + employee.getAddress().getDoorNumber()
				+ "\n\t\tstreet name\t:\t" + employee.getAddress().getStreetName()
				+ "\n\t\ttown name\t:\t" + employee.getAddress().getTownName()
				+ "\n\t\tdistrict\t:\t" + employee.getAddress().getDistrict()
				+ "\n\t\tstate\t\t:\t" + employee.getAddress().getState()
				+ "\n\t\tpincode\t\t:\t" + employee.getAddress().getPincode()
				+ "\n");
	}

}
