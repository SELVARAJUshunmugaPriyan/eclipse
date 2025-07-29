package javaClasses;

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
		@SuppressWarnings("all")
		public static Singleton Singleton()
		{
			if (single_instance == null)
				single_instance = new Singleton();
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