package oopsOneWithConditionsOne;

public class UseMask 
{

	public static void main(String[] args) 
	{
		
		Mask m1 = new Mask(), m2 = new Mask(), m3 = new Mask();
		Mask M[] = {m1, m2, m3};
		int max = 0;
		
		m1.setBrand("Apollo");
		m1.setColor("Blue");
		m1.setPrice(150);
		m1.setIsN95(true);
		
		m2.setBrand("Apotek");
		m2.setColor("Green");
		m2.setPrice(100);
		m2.setIsN95(true);
		
		m3.setBrand("Glargine");
		m3.setColor("Grey");
		m3.setPrice(80);
		m3.setIsN95(false);
		
		for (Mask m : M) {
			System.out.println(m.getBrand() + " " + m.getColor()
					+ " " + m.getPrice() + " " + m.getIsN95());
			
			if (max < m.getPrice())
				max = m.getPrice();
		}
		
		System.out.print("Highest price is " + max);
	}

}

class Mask
{
	private String brand, color;
	private int price;
	private boolean isN95;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void setIsN95(boolean isN95)
	{
		this.isN95 = isN95;
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
	
	public boolean getIsN95()
	{
		return isN95;
	}
}