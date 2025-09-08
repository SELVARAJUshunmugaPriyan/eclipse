package oopsOneWithConditionsOne;

public class UseChair 
{

	public static void main(String[] args) 
	{
		
		Chair c1 = new Chair(), c2 = new Chair(), c3 = new Chair();
		Chair C[] = {c1, c2, c3};
		int sum = 0;
		boolean isAll = true;
		
		c1.setBrand("Nilkamal");
		c1.setIsRolling(true);
		c1.setPrice(1200);
		c1.setNoOfLegs(3);
		
		c2.setBrand("IKEA");
		c2.setIsRolling(true);
		c2.setPrice(1500);
		c2.setNoOfLegs(5);
		
		c3.setBrand("mio");
		c3.setIsRolling(true);
		c3.setPrice(2000);
		c3.setNoOfLegs(1);
		
		for (Chair c : C) {
			System.out.println(c.getBrand() + " " + c.getIsRolling()
					+ " " + c.getPrice() + " " + c.getNoOfLegs());
			
			sum += c.getPrice();
			isAll = c.getIsRolling();
		}
		
		System.out.println("Total price is " + sum);
		
		if(isAll)
			System.out.print("ALL ROLL");
		else
			System.out.print("NOPE");
	}

}

class Chair
{
	private String brand;
	private int price, noOfLegs;
	private boolean isRolling;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setIsRolling(boolean isRolling)
	{
		this.isRolling = isRolling;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public void setNoOfLegs(int noOfLegs)
	{
		this.noOfLegs = noOfLegs;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public boolean getIsRolling()
	{
		return isRolling;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public int getNoOfLegs()
	{
		return noOfLegs;
	}
}