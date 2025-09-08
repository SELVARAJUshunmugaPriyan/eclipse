package oopsThree;

interface Sum
{
	public int getSum(int i, int j);
}

interface Difference extends Sum
{
	public int getDif(int i, int j);
}

interface Product extends Sum
{
	public int getMul(int i, int j);
}

interface Division extends Difference, Product
{
	public int getDiv(int i, int j);
}

class Calculator implements Division
{
	public int getSum(int i, int j)
	{
		return i + j;
	}
	public int getDif(int i, int j)
	{
		return i - j;
	}
	public int getMul(int i, int j)
	{
		return i * j;
	}
	public int getDiv(int i, int j)
	{
		return i / j;
	}
}

public class UseCal 
{

	public static void main(String[] args) 
	{
		
		Calculator c = new Calculator();
		System.out.println(c.getSum(100, 10));
		System.out.println(c.getDif(100, 10));
		System.out.println(c.getMul(100, 10));
		System.out.println(c.getDiv(100, 10));
	}

}
