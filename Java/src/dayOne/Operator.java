package dayOne;

public class Operator {

	public static void main(String[] args) {
		
		float a = 5;
		float b = 7;
		
		boolean c = true;
		boolean d = false;
		
		System.out.println("a + b = " + (int)(a + b));
		System.out.println("a - b = " + (int)(a - b));
		System.out.println("a * b = " + (int)(a * b));
		System.out.println("a / b = " + (a / b));
		System.out.println("a % b = " + (int)(a % b) + "\n");
		
		System.out.println("a < b = " + (a < b));
		System.out.println("a > b = " + (a > b));
		System.out.println("a <= b = " + (a <= b));
		System.out.println("a >= b = " + (a >= b));
		System.out.println("a == b = " + (a == b));
		System.out.println("a != b = " + (a != b) + "\n");
		
		System.out.println("c && d = " + (c && d));
		System.out.println("c || d = " + (c || d));
	}

}
