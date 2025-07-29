// Java program to illustrate different types of classes
package javaClasses;

//import java.util.NoSuchElementException;
//import java.util.Scanner;

// Driver code
public class TypesOfClasses 
{
	static TypesOfClasses typesOfClasses = new TypesOfClasses();

	class Student
	{
		int id; // data member (also instance variable)
		String name; // data member (also instance variable)
		
		public static void main(String[] args)
		{
			Student s1 = typesOfClasses.new Student();
			System.out.println(s1.id);
			System.out.println(s1.name);
		}
	}

	/* final class
	final class Base
	{
		
		void display()
		{
			System.out.println("Method for Base class.");
		}
	}
	
	class Extended extends Base
	{
		
		void display()
		{
			System.out.println("Method for Extended class.");
		}
	}
	
	class FinalClass
	{
		
		public static void main(String[] args)
		{
			Extended e = typesOfClasses.new Extended();
			e.display();
		}
	}
	*/
	
	/* static class
	class StaticClass
	{
		static int i;
		static void met(int x, int y)
		{
			System.out.println(
					"static method to calculate sum");
			i = x + y;
			System.out.println(x + " + " + y);
		}
		static class MyNestedClass
		{
			static
			{
				System.out.println(
						"static block inside a static class");
			}
			public void disp()
			{
				int x1, y1;
				Scanner scn = new Scanner(System.in);
				try {
					System.out.println("Enter two numbers");
					x1 = scn.nextInt();
					y1 = scn.nextInt();
					met(x1, y1);
					System.out.println("Sum of the 2 numbers-" + i);
				} catch (NoSuchElementException e) {
					;
				} finally {
					System.out.println("Closing System.in resource");
					scn.close();
				}
			}
		}
	}
	
	class UseStaticClass
	{
		
		public static void main(String[] args)
		{
			StaticClass.MyNestedClass nestedclass
				= new StaticClass.MyNestedClass();
			nestedclass.disp();
		}
	}
	*/
	
	/* abstract class
	interface X
	{
		int product(int x, int y);
	}
	
	abstract class Product implements X
	{
		public int product(int x, int y)
		{
			return x * y;
		}
	}
	
	class UseProduct extends Product
	{
		public static void main(String[] args)
		{
			Product ob = typesOfClasses.new UseProduct();
			int p = ob.product(20, 10);
			System.out.println("Product: " + p);
		}
	}
	*/
	
	/* concrete class
	class UseConcreteClass
	{
		static int sum(int x, int y) { return x + y; }
		
		public static void main(String[] args)
		{
			int p = sum(10, 8);
			System.out.println("Sum: " + p);
		}
	}
	*/
	
	/* POJO class
	class POJO
	{
		private int value = 365;
		public int getValue() { return value; }
		public void setValue(int value) { this.value = value; }
	}
	
	public class UsePOJO
	{
		public static void main(String[] args)
		{
			POJO p = typesOfClasses.new POJO();
			System.out.println(p.getValue());
		}
	}
	*/
	
	/* Singleton class
	class Singleton
	{
		private static Singleton single_instance = null;
		
		String s;
		
		private Singleton()
		{
			s = "This is a string part of Singleton class";
		}
		// here a private constructor is used
		
		// Method
		public static Singleton Singleton()
		{
			if (single_instance == null)
				single_instance = typesOfClasses.new Singleton();
			return single_instance;
		}
	}
	
	public class UseSingleton
	{
		public static void main(String[] args)
		{
			Singleton x = Singleton.Singleton();
			Singleton y = Singleton.Singleton();
			// change var of x
			x.s = (x.s).toUpperCase();
			System.out.println("String from x is -->" + x.s);
			System.out.println("String from y is -->" + y.s);
			System.out.println("\n");
			y.s = (y.s).toLowerCase();
			System.out.println("String from x is -->" + x.s);
			System.out.println("String from y is -->" + y.s);
		}
	}
	*/

	/* Inner class
	class NestedInner
	{
		class Inner
		{
			public void show()
			{
				System.out.println("Inside a nested class");
			}
		}
	}
	
	class UseNestedInner
	{
		public static void main(String[] args)
		{
			NestedInner.Inner in = typesOfClasses.new NestedInner().
					new Inner();
			in.show();
		}
	}
	
	class AnonymousInnerClass
	{
		class Subclass
		{
			void show()
			{
				System.out.println("Show method of super class");
			}
		}
		class UseSubclass
		{
			static Subclass out = typesOfClasses.new AnonymousInnerClass().new Subclass() {
				void show()
				{
					super.show();
					System.out.println("Demo class");
				}
			};
			public static void main(String[] args) { out.show(); }
		}
		class UseInterface
		{
			static Interface i = new Interface() {
				public void show()
				{
					System.out.println(
							"This is an anonymous class");
				}
			};
			public static void main(String[] args)
			{
				i.show();
			}
		}
		interface Interface
		{
			void show();
		}
	}

	class StaticNestedClass
	{
		static int data = 100;
		static class Inner
		{
			void msg() { System.out.println("data is " + data); }
		}
		public static void main(String[] args)
		{
			StaticNestedClass.Inner obj = new StaticNestedClass.Inner();
			obj.msg();
		}
	}

	class MethodLocalInnerClass
	{
		void outerMethod()
		{
			System.out.println("Outer Method");
			class Inner
			{
				void innerMethod() { System.out.println("Inner Method"); }
			}
			Inner y = new Inner();
			y.innerMethod();
		}
	}
	
	class UseMethodLocalInnerClass
	{
		public static void main(String[] args)
		{
			MethodLocalInnerClass x = typesOfClasses.new MethodLocalInnerClass();
			x.outerMethod();
		}
	}
	*/
	
	// Main function
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		Student.main(args);
//		FinalClass.main(args);
//		UseStaticClass.main(args);
//		UseProduct.main(args);
//		UseConcreteClass.main(args);
//		UsePOJO.main(args);
//		UseSingleton.main(args);
//		UseNestedInner.main(args);
//		AnonymousInnerClass.UseSubclass.main(args);
//		AnonymousInnerClass.UseInterface.main(args);
//		StaticNestedClass.main(args);
//		UseMethodLocalInnerClass.main(args);
	}

}
