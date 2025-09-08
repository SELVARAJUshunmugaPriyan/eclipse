package functions;

class Calci {
	public void add(int a, int b) {
		int c = a + b;
		System.out.println(c);
	}
	
	public void sub() {
		int a = 8, b = 16, c = a - b;
		System.out.println(c);
	}
	
	public int getMulti(int a, int b) {
		return a * b;
	}
	
	public int getDiv() {
		int a = 8, b = 2;
		return a / b;
	}
}

public class UseCalci {

	public static void main(String[] args) {
		
		Calci c = new Calci();
		
		c.add(12, 113);
		c.sub();
		System.out.println(c.getMulti(2, 3));
		System.out.println(c.getDiv());
	}

}
