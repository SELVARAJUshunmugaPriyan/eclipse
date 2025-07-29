package oopsOneWithConditionsOne;

public class UseSketch 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Sketch s1 = new Sketch(), s2 = new Sketch(), s3 = new Sketch();
		Sketch S[] = {s1, s2, s3};
		int sum = 0;
		
		s1.setBrand("Camlin");
		s1.setColor("Orange");
		s1.setPrice(25);
		s1.setMaterial("Plastic");
		
		s2.setBrand("Natraj");
		s2.setColor("Brown");
		s2.setPrice(50);
		s2.setMaterial("Synthetic");
		
		s3.setBrand("Apsara");
		s3.setColor("Maroon");
		s3.setPrice(75);
		s3.setMaterial("Rubber");
		
		for (Sketch s : S) {
			System.out.println(s.getBrand() + " " + s.getColor()
					+ " " + s.getMaterial() + " " + s.getPrice());
			
			sum += s.getPrice();
		}
		
		System.out.print("Average price: " + (sum / 3));
	}

}

class Sketch
{
	private String brand, color, material;
	private int price;
	
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
}