package oopsOne;

public class UseCar 
{

	public static void main(String[] args) 
	{
		
		Engine e = new Engine();
		
		e.cc = 12000;
		e.years = 25;
		
		Car c = new Car();
		
		c.brand = "bmw";
		c.color = "blue";
		c.price = 1200000;
		c.engine = e;
		
		System.out.println(e.cc + " " + e.years);
		System.out.println(c.brand + " " + c.color + " "
				+ c.price + " " + c.engine.cc + " "
				+ c.engine.years);
	}

}

class Engine
{
	int cc, years;
}

class Car
{
	String brand, color;
	int price;
	Engine engine;
}
