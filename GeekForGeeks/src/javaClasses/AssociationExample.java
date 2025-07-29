// Java program to illustrate the
// Concept of association
package javaClasses;

import java.util.HashSet;
import java.util.Set;

// Class 1
// Bank class
class Bank
{
	
	// Attributes of bank
	private String name;
	private Set<Individual> employees;
	
	// Constructor
	public Bank(String name)
	{
		this.setBankName(name);
	}

	// Setters
	public void setBankName(String name) {
		this.name = name;
	}

	public void setEmployees(Set<Individual> employees) {
		this.employees = employees;
	}
	
	// Getters
	public String getBankName() {
		return name;
	}

	public Set<Individual> getEmployees() {
		return employees;
	}
}

// Class 2
// Individual class
class Individual
{
	
	// Attributes of Individual
	private String name;
	
	public Individual(String name)
	{
		this.setName(name);
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	// Getters
	public String getName() {
		return name;
	}
}

// Class 3
// Association between both the classes
// in Main method
public class AssociationExample 
{
	// Main driver method
	public static void main(String[] args) 
	{
		// Creating Individual objects
		Individual latha = new Individual("Latha");
		Individual geetha = new Individual("Geetha");
		
		// Adding the individuals to a set
		Set<Individual> employees = new HashSet<Individual>();
		employees.add(latha);
		employees.add(geetha);
		
		// Creating a bank object
		Bank icici = new Bank("ICICI");
		
		// Setting employees for bank object
		// Individual objects latha and geetha are associated
		// with bank object
		icici.setEmployees(employees);
		
		// traversing and displaying the bank employees
		for (Individual person : icici.getEmployees())
			System.out.println(person.getName() + " works at " + icici.getBankName());
		
		System.out.println("Performing restructuring..");
		
		// Individual object geetha has de-associated with bank
		// object
		employees.remove(geetha);
		
//		icici.setEmployees(employees);
		
		for (Individual person : icici.getEmployees())
			System.out.println(person.getName() + " works at " + icici.getBankName());
		
	}

}
