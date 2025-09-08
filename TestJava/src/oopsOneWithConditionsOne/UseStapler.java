package oopsOneWithConditionsOne;

public class UseStapler 
{

	public static void main(String[] args) 
	{
		
		Stapler s1 = new Stapler(), s2 = new Stapler(), s3 = new Stapler();
		Stapler S[] = {s1, s2, s3};
		
		s1.setBrand("Camlin");
		s1.setColour("Red");
		s1.setMaterial("Steel");
		s1.setPrice(70);
		
		s2.setBrand("Natraj");
		s2.setColour("Blue");
		s2.setMaterial("Iron");
		s2.setPrice(50);
		
		s3.setBrand("Apsara");
		s3.setColour("White");
		s3.setMaterial("Plastic");
		s3.setPrice(100);
		
		for (Stapler st : S)
			System.out.println(st.getBrand() + " " + st.getColour()
			 		+ " " + st.getMaterial() + " " + st.getPrice());
	}

}

class Stapler
{
	private String brand, colour, material;
	private int price;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setColour(String colour)
	{
		this.colour = colour;
	}
	
	public void setMaterial(String material)
	{
		this.material = material;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getColour()
	{
		return colour;
	}
	
	public String getMaterial()
	{
		return material;
	}
	
	public int getPrice()
	{
		return price;
	}
}