package dayTwo;

class Employee {
	int employeeId;
	String employeeName;
	String dateOfBirth;
	long mobileNo;
}
public class UseEmployee {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.employeeId = 234;
		e1.employeeName = "Sri";
		e1.dateOfBirth = "24/03/1984";
		e1.mobileNo = 9443286321l;
		
		
		e2.employeeId = 354;
		e2.employeeName = "Sethu";
		e2.dateOfBirth = "03/09/1982";
		e2.mobileNo = 9698443221l;
		
		
		System.out.println("Employee Id = " + e1.employeeId +
				"\tMobile No = " + "+91 " + e1.mobileNo);
		System.out.println("Employee Id = " + e2.employeeId +
				"\tMobile No = " + "+91 " + e2.mobileNo);
	}

}
