package oopsTwo;

/*
class Fruit
{
	String color, taste;
	boolean isRipe;
}

class Mango extends Fruit
{
	int price, quantity;
	String type;
}

class Orange extends Fruit
{
	int price, quantity;
	String type;
}

public class UseFruit 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Fruit f = new Fruit();
		
		f.color = "green";
		f.taste = "sour";
		f.isRipe = true;
		
		System.out.println(f.getClass().toString().split("\\.")[1]
				+ " " + f.taste + " "
				+ f.color + " " + (f.isRipe ? "Ready to eat" : 
					"Not ready to eat"));
		
		Mango m = new Mango();
		
		m.color = "yellow";
		m.taste = "sweet";
		m.isRipe = false;
		m.price = 200;
		m.quantity = 5;
		m.type = "Alphonsa";
		
		System.out.println(m.getClass().toString().split("\\.")[1]
				+ " " + m.taste + " "
				+ m.color + " " + (m.isRipe ? "Ready to eat" : 
				"Not ready to eat") + " " + m.price + " " 
				+ m.quantity + "kg " + m.type);
		
		Orange o = new Orange();
		
		o.color = "orange";
		o.taste = "tangy";
		o.isRipe = true;
		o.price = 150;
		o.quantity = 6;
		o.type = "Clementine";
		
		System.out.println(o.getClass().toString().split("\\.")[1]
				+ " " + o.taste + " "
				+ o.color + " " + (o.isRipe ? "Ready to eat" : 
				"Not ready to eat") + " " + o.price + " " 
				+ o.quantity + "kg " + o.type);
	}

}
*/

class Fruit
{
	String color, taste;
	boolean isRipe;
	
	// Constructors
	public Fruit(String color, String taste, boolean isRipe)
	{
		this.color = color;
		this.taste = taste;
		this.isRipe = isRipe;
	}
	
	// Getters
	public String toString()
	{
		return color + " " + taste + " "
			 + (isRipe ? "Ready to eat" : 
				"Not ready to eat");
	}
	
}

class Mango extends Fruit
{
	int price, quantity;
	String type;
	
	// Constructors
	public Mango(String color, String taste, boolean isRipe,
				 int price, int quantity, String type)
	{
		super(color, taste, isRipe);
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}
	
	// Getters
	public String toString()
	{
		return "Mango " + super.toString() + " " + price + " " + 
				quantity + "kg " + type;
	}
	
}

class Orange extends Fruit
{
	int price, quantity;
	String type;

	// Constructors
	public Orange(String color, String taste, boolean isRipe,
				 int price, int quantity, String type)
	{
		super(color, taste, isRipe);
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}
	
	// Getters
	public String toString()
	{
		return "Orange " + super.toString() + " " + price + " " + 
				quantity + "kg " + type;
	}
	
}

public class UseFruit 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Fruit f = new Fruit("green", "sour", true);
		
		System.out.println(f);
		
		Mango m = new Mango("yellow", "sweet", false,
				200, 5, "Alphonsa");
		
		System.out.println(m);
		
		Orange o = new Orange("orange", "tangy", true,
				150, 6, "Clementine");
		
		System.out.println(o);
	}

}