
// Error while using class from same package with
// private access modifier
package p1;

// Class A
class A
{
	@SuppressWarnings("unused")
	private void display() 
	{
		System.out.println("GeeksforGeeks");
	}
}

// Class B
class B {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		A obj = new A();
		
		// Trying to access private method
		// of another class
//		obj.display();
	}

}
