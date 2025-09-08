package oopsOneWithConditionsOne;

public class UseStickPen 
{

	public static void main(String[] args) 
	{
		
		StickPen s1 = new StickPen(), s2 = new StickPen(), s3 = new StickPen();
		StickPen S[] = {s1, s2, s3};
		int sum = 0;
		
		s1.setBrand("Camlin");
		s1.setColor("Blue");
		s1.setIsPlastic(true);
		s1.setPrice(35);
		s1.setTipWidth("0.5mm");
		
		s2.setBrand("Natraj");
		s2.setColor("Black");
		s2.setIsPlastic(false);
		s2.setPrice(40);
		s2.setTipWidth("0.3mm");
		
		s3.setBrand("Apsara");
		s3.setColor("Yellow");
		s3.setIsPlastic(false);
		s3.setPrice(25);
		s3.setTipWidth("0.7mm");
		
		for (StickPen s : S) {
			System.out.println(s.getBrand() + " " + s.getColor()
			 		+ " " + s.getIsPlastic() + " " + s.getPrice()
			 		+ " " + s.getTipWidth());
			
			sum += s.getPrice();
		}
		
		System.out.print("Total price: " + sum);
	}

}

class StickPen
{
	private String brand, color, tipWidth;
	private int price;
	private boolean isPlastic;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setTipWidth(String tipWidth)
	{
		this.tipWidth = tipWidth;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void setIsPlastic(boolean isPlastic)
	{
		this.isPlastic = isPlastic;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getTipWidth()
	{
		return tipWidth;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public boolean getIsPlastic()
	{
		return isPlastic;
	}
	
	public int getPrice()
	{
		return price;
	}
}