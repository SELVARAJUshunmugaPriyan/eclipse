package javaClasses;

public class StaticMembers 
{
	
	static int staticVariable;
	
	static {
		System.out.println("Static block executed.");
		staticVariable = 10; // Initializing a static variable
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Demo smA = new Demo("A"); // static block of a class is 
								  // executed only the first time
								  // before the constructor
		Demo smB = new Demo("B");
		
		System.out.println("Main method executed.");
		System.out.println("Static variable: " + staticVariable);
	}

}

class Demo
{
	static String s;
	
	@SuppressWarnings("static-access")
	Demo(String s)
	{
		this.s = s;
		System.out.println(s + ": Demo: Constructor block executed.");
	}
	
	static {
		System.out.println(s + ": Demo: Static block executed.");
	}
}
