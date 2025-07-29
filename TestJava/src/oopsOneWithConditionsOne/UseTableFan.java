package oopsOneWithConditionsOne;

public class UseTableFan 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TableFan t1 = new TableFan(), t2 = new TableFan(), t3 = new TableFan();
		TableFan T[] = {t1, t2, t3};
		
		t1.setBrand("Usha");
		t1.setColor("Violet");
		t1.setPrice(4500);
		t1.setLogo("USHA");
		t1.setPowerSouce("Electric");
		t1.setNetPrice();
		
		t2.setBrand("CromptonGreaves");
		t2.setColor("Purple");
		t2.setPrice(5000);
		t2.setLogo("CG");
		t2.setPowerSouce("Battery");
		t2.setNetPrice();
		
		t3.setBrand("Bajaj");
		t3.setColor("Pink");
		t3.setPrice(6000);
		t3.setLogo("Bj");
		t3.setPowerSouce("Electric");
		t3.setNetPrice();
		
		for (TableFan t : T)
			System.out.println(t.getBrand() + " " 
					+ t.getColor() + " "
					+ t.getPrice() + " "
					+ t.getPowerSource() + " "
					+ t.getLogo() + " "
					+ t.getNetPrice());
	}

}

class TableFan
{
	private String brand, color, logo, powerSource;
	private int price, netPrice;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void setLogo(String logo)
	{
		this.logo = logo;
	}
	
	public void setPowerSouce(String powerSource)
	{
		this.powerSource = powerSource;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public void setNetPrice()
	{
		this.netPrice = (int) (1.1 * price);
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
	
	public int getNetPrice()
	{
		return netPrice;
	}
	
	public String getLogo()
	{
		return logo;
	}
	
	public String getPowerSource()
	{
		return powerSource;
	}
}