package oopsOneWithConditionsOne;

public class UseTelephone
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Telephone t1 = new Telephone(), t2 = new Telephone(), t3 = new Telephone();
		Telephone T[] = {t1, t2, t3};
		int tCount = 0;
		
		t1.setBrand("Samsung");
		t1.setColor("Blue");
		t1.setPrice(15000);
		t1.setIsWireless(true);
		
		t2.setBrand("Apple");
		t2.setColor("White");
		t2.setPrice(20000);
		t2.setIsWireless(true);
		
		t3.setBrand("Blackberry");
		t3.setColor("Black");
		t3.setPrice(35000);
		t3.setIsWireless(true);
		
		for (Telephone t : T) {
			System.out.println(t.getBrand() + " " + t.getColor()
					+ " " + t.getPrice() + " " + t.getIsWireless());
			
			if (t.getIsWireless())
				tCount++;
		}
		
		System.out.print("Count of wireless phones is " + tCount);
	}

}

class Telephone
{
	private String brand, color;
	private int price;
	private boolean isWireless;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void setIsWireless(boolean isWireless)
	{
		this.isWireless = isWireless;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public boolean getIsWireless()
	{
		return isWireless;
	}
}