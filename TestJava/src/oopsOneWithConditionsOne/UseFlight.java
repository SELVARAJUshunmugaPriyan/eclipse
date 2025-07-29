package oopsOneWithConditionsOne;

public class UseFlight 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Flight f1 = new Flight(), f2 = new Flight(), f3 = new Flight();
		Flight F[] = {f1, f2, f3};
		
		f1.setBrand("SpiceJet");
		f1.setColor("Red");
		f1.setPrice(8000);
		f1.setNoOfSeats(900);
		f1.setMaterial("Cotton");
		
		f2.setBrand("AirIndia");
		f2.setColor("Orange");
		f2.setPrice(5000);
		f2.setNoOfSeats(15);
		f2.setMaterial("Synthetic");
		
		f3.setBrand("Indigo");
		f3.setColor("Blue");
		f3.setPrice(4000);
		f3.setNoOfSeats(400);
		f3.setMaterial("Plastic");
		
		for (Flight f : F) {
			System.out.print(f.getBrand() + " " + f.getColor()
					+ " " + f.getMaterial() + " " + f.getPrice()
					+ " " + f.getNoOfSeats());
			
			if (f.getNoOfSeats() > 800)
				System.out.println(" Super Jumbo");
			else if (f.getNoOfSeats() < 20)
				System.out.println(" minimum Seat");
		}
		
	}

}

class Flight
{
	private String brand, color, material;
	private int price, noOfSeats;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setMaterial(String material)
	{
		this.material = material;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void setNoOfSeats(int noOfSeats)
	{
		this.noOfSeats = noOfSeats;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getMaterial()
	{
		return material;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public int getNoOfSeats()
	{
		return noOfSeats;
	}
}