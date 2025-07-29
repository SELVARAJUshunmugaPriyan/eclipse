package p1;

abstract class AbstractClass
{
	int sum() { return 2; }
	int sum(int a) { return a; }
}

public class UseAbstractClass extends AbstractClass {
	
	int sum() { return 4; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractClass a = new UseAbstractClass();
		System.out.print(a.sum());
	}

}
