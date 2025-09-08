package oopsTwo;

class Car
{
	String brand;
	int price;
	
	public int showSpeed(int cc)
	{
		return 110;
	}
}

class SportsCar
{
	public int showSpeed(int cc)
	{
		return 365;
	}
}

public class UseCar 
{

	public static void main(String[] args) 
	{
		
		Car c = new Car();
		System.out.println(c.showSpeed(0));
		SportsCar s = new SportsCar();
		System.out.println(s.showSpeed(0));
	}

}
