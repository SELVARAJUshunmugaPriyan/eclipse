// Java program to illustrate
// the concept of aggregation
package javaClasses;

import java.util.ArrayList;
import java.util.List;

// Class 1
// Student class
class Student extends Individual
{
	
	// Attributes of Student
	private int studentId;
	
	// Constructor
	public Student(String name, int studentId)
	{
		super(name);
		this.setStudentId(studentId);
	}

	// Getters
	public int getStudentId() {
		return studentId;
	}

	// Setters
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}

// Class 2
// Department class
// Department class contains list of Students
class Department
{
	
	// Attributes of department class
	private String name;
	private List<Student> students;
	
	// Constructor
	public Department(String name, List<Student> students)
	{
		this.setName(name);
		this.setStudents(students);
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
}

// Class 3
// Institute class
// Institute class contains a list of departments
class Institute
{
	private String name;
	private List<Department> depts;
	
	// Constructor
	public Institute(String name, List<Department> depts)
	{
		this.name = name;
		this.depts = depts;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Department> getDepts() {
		return depts;
	}
	public void setDepts(List<Department> depts) {
		this.depts = depts;
	}
	
	// Method of institute class
	// Counting total students in the institute
	public int getTotalStudentsInInstitute()
	{
		int noOfStudents = 0;
		
		for (Department dept : depts)
			noOfStudents += dept.getStudents().size();
		
		return noOfStudents;
	}
}

// Class 4
// Main class : aggregation of Students with Department
//				Departments with Institute
public class AggregationExample 
{
	// main driver method
	public static void main(String[] args) 
	{
		// Creating independent Student objects
		Student latha = new Student("latha", 101);
		Student geetha = new Student("geetha", 102);
		Student keerthana = new Student("keerthana", 201);
		Student priyan = new Student("priyan", 202);
		
		// Creating an list of IT Students
		List<Student> itStudents = new ArrayList<Student>();
		itStudents.add(keerthana);
		itStudents.add(priyan);
		// Creating an list of EE Students
		List<Student> eeStudents = new ArrayList<Student>();
		eeStudents.add(latha);
		eeStudents.add(geetha);
		
		// Creating a department object with a Students list
		// using Aggregation (Department "has" Students)
		Department it = new Department("IT", itStudents);
		Department ee = new Department("EEE", eeStudents);
		
		List<Department> depts = new ArrayList<Department>();
		
		depts.add(ee);
		depts.add(it);
		
		// Creating an Institute object with Departments list
        // using Aggregation (Institute "has" Departments)
		Institute bits = new Institute("BITS", depts);
		
		System.out.println("Total number of students: " + 
				bits.getTotalStudentsInInstitute());
	}

}
