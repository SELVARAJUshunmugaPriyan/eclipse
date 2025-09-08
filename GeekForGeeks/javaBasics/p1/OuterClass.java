/*
 *  In Java, a private class refers specifically to an inner
 *  or nested class declared with the private modifier.
 *  
 *  Restricted access : It is accessible only within the enclosing
 *  outer class.
 *  
 *  Encapsulation : Strong. Outer class controls the usage and hi-
 *  des the implementation
 *  
 *  Use-Cases : Helper classes, Data structures
 */


package p1;

public class OuterClass 
{
	// Fields
	int defaultData;
	public int publicData;
	protected int protectedData;
	private int privateData;
	
	// Constructors
	public OuterClass()
	{
		
	}
	
	public OuterClass(int privateData)
	{
		this.privateData = privateData;
	}
	
	// Methods
	void defaultMethod() {}
	public void publicMethod() {}
	protected void protectedMethod() {}
	private void privateMethod() {}
	static protected void staticProtectedMethod() {}
	
	public void createAndUseInner()
	{
		PrivateInnerClass inner = new PrivateInnerClass();
		inner.displayInnerData();
	}
	
	// Inner classes
	private class PrivateInnerClass
	{
		public void displayInnerData()
		{
			System.out.println("Inner class accessing outer "
					+ "data: " + privateData);
		}
	}
	
	class DefaultInnerClass
	{
		public void displayInnerData()
		{
			System.out.println("Inner class accessing outer "
					+ "data: " + privateData);
		}
	}
	
	public class PublicInnerClass
	{
		public void displayInnerData()
		{
			System.out.println("Inner class accessing outer "
					+ "data: " + privateData);
		}
	}
	
	protected class ProtectedInnerClass
	{
		public ProtectedInnerClass() {
		}

		public void displayInnerData()
		{
			System.out.println("Inner class accessing outer "
					+ "data: " + privateData);
		}
	}
	
	static protected class StaticProtectedInnerClass
	{

		public StaticProtectedInnerClass() {
		}
		
	}
	
	// Driver main method
	public static void main(String[] args)
	{	
		// All fields are accessible
		new OuterClass().defaultData = 0;
		new OuterClass().publicData = 0;
		new OuterClass().protectedData = 0;
		new OuterClass().privateData = 0;
		
		// All methods are accessible
		new OuterClass().defaultMethod();
		new OuterClass().publicMethod();
		new OuterClass().protectedMethod();
		new OuterClass().privateMethod();
		
		// All inner classes are accessible
		new OuterClass().new DefaultInnerClass();
		new OuterClass().new PublicInnerClass();
		new OuterClass().new ProtectedInnerClass();
		new OuterClass().new PrivateInnerClass();
	}
}
