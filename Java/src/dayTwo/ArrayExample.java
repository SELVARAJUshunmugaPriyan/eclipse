package dayTwo;

public class ArrayExample {
	
	public static void main (String[] args) {
		// Integer array example
		int[] a = {12, 13, 14, 15, 16};
//		System.out.println("Array = ");
//		System.out.println(a);
		System.out.println("First Element = " + a[0]);
		System.out.println("Length = " + a.length);
		System.out.println("Last Element = " + a[a.length - 1] + "\n");
		
		// String array example
		String[] b = {"Hi", "Hello", "Brave", "New", "World"};
//		System.out.println("Array = ");
//		System.out.println(b);
		System.out.println("First Element = " + b[0]);
		System.out.println("Length = " + b.length);
		System.out.println("Last Element = " + b[b.length - 1] + "\n");
		
		// Character array example
		char[] c = {'f', 'g', 'h', '@', 'B'};
//		System.out.println("Array = ");
//		System.out.print(c);
		System.out.println("First Element = " + c[0]);
		System.out.println("Length = " + c.length);
		System.out.println("Last Element = " + c[c.length - 1] + "\n");
		
		// String.charAt() example
		String d = "shunmuga priyan";
		System.out.println("First Letter = " + d.charAt(0));
		System.out.println("Middle Letter = " + d.charAt(d.length()/2));
		System.out.println("Last Letter = " + d.charAt(d.length() - 1) + "\n");
		
		// String.toCharArray() example
		c = d.toCharArray();
		System.out.println("First Letter = " + c[0]);
		System.out.println("Second Letter = " + c[1]);
		System.out.println("Last Letter = " + c[c.length - 1] + "\n");
		
		// String.split() example
		b = d.split(" ");
		System.out.println("First Element = " + b[0]);
		System.out.println("Second Element = " + b[1]);
	}
	
}
