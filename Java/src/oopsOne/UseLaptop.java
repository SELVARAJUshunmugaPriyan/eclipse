package oopsOne;

class Battery
{
	private int capacity, id;
	private String mah;
	
	public Battery(int capacity, int id, String mah)
	{
		this.capacity = capacity;
		this.id = id;
		this.mah = mah;
	}
	
	public String toString()
	{
		return capacity + " " + id + " " + mah;
	}
}

class Laptop
{
	private String brand, color;
	private int price;
	private Battery b;
	
	public Laptop(String brand, String color, int price, Battery b)
	{
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.b = b;
	}
	
	public String toString()
	{
		return brand + " " + color + " " + price + " " + b;
	}
}

public class UseLaptop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Battery b = new Battery(2400, 1, "100mah");
		Laptop l = new Laptop("DELL", "Black", 12000, b);
		
		System.out.print(l);
	}

}
