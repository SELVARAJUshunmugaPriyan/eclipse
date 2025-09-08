package oopsOneWithConditionsOne;

public class UsePrinter 
{

	public static void main(String[] args) 
	{
		
		Printer p1 = new Printer(), p2 = new Printer(), p3 = new Printer();
		Printer P[] = {p1, p2, p3};
		int count5k = 0, countBlack = 0;
		
		p1.setBrand("Hp");
		p1.setColor("Blue");
		p1.setPrice(18000);
		p1.setModel("A8");
		
		p2.setBrand("Lenovo");
		p2.setColor("Yellow");
		p2.setPrice(6000);
		p2.setModel("B3");
		
		p3.setBrand("Canon");
		p3.setColor("Red");
		p3.setPrice(7000);
		p3.setModel("X8");
		
		for (Printer p : P) {
			System.out.println(p.getBrand() + " " + p.getColor()
					+ " " + p.getModel() + " " + p.getPrice());
			
			if (p.getPrice() > 5000)
				count5k++;
			
			if (p.getColor().toLowerCase().equals("black"))
				countBlack++;
		}
		
		System.out.print("Number of printers above 5000: " + count5k
				+ "\nNumber of black printers: " + countBlack);
	}

}

class Printer
{
	private String brand, color, model;
	private int price;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setModel(String model)
	{
		this.model = model;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getPrice()
	{
		return price;
	}
}