package oopsOneWithConditionsOne;

public class UseWaterBottle 
{

	public static void main(String[] args) 
	{
		
		WaterBottle w1 = new WaterBottle(), w2 = new WaterBottle(), w3 = new WaterBottle();
		WaterBottle W[] = {w1, w2, w3};
		int wCount = 0;
		
		w1.setBrand("Milton");
		w1.setColor("Red");
		w1.setIsPlastic(true);
		w1.setPrice(450);
		
		w2.setBrand("SaravanaStores");
		w2.setColor("Black");
		w2.setIsPlastic(false);
		w2.setPrice(350);
		
		w3.setBrand("MegaStores");
		w3.setColor("Green");
		w3.setIsPlastic(true);
		w3.setPrice(300);
		
		for (WaterBottle w : W) {
			System.out.println(w.getBrand() + " " + w.getColor()
			 		+ " " + w.getIsPlastic() + " " + w.getPrice());
			
			if (w.getIsPlastic())
				wCount++;
		}
		
		System.out.print("Number of plastic bottles: " + wCount);
	}

}

class WaterBottle
{
	private String brand, color;
	private int price;
	private boolean isPlastic;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
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