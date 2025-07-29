package oopsTwo;

class Calci
{
	public int getAdd(int a, int b)
	{
		return a + b;
	}
	
	public String getAdd(String a, String b)
	{
		return a + b;
	}
	
	public int getAdd(int a, int b, int c)
	{
		return a * b * c;
	}
}

public class UseCalci 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Calci c = new Calci();
		System.out.println(c.getAdd(10, 20));
		System.out.println(c.getAdd("A", "B"));
		System.out.println(c.getAdd(10, 20, 30));
	}

}
