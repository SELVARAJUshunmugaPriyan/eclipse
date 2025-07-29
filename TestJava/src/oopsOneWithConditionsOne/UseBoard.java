package oopsOneWithConditionsOne;

public class UseBoard 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Board b1 = new Board(), b2 = new Board(), b3 = new Board();
		Board B[] = {b1, b2, b3};
		int countSquare = 0, countHeavy = 0, countPlastic = 0;
		
		b1.setBrand("Camlin");
		b1.setHeight(150);
		b1.setWidth(250);
		b1.setMaterial("Glass");
		
		b2.setBrand("Natraj");
		b2.setHeight(200);
		b2.setWidth(200);
		b2.setMaterial("Plastic");
		
		b3.setBrand("Apsara");
		b3.setHeight(300);
		b3.setWidth(300);
		b3.setMaterial("Glass");
		
		for (Board b : B) {
			System.out.print(b.getBrand() + " " + b.getMaterial()
					+ " " + b.getHeight() + " " + b.getWidth());
			
			if (b.getWidth() == b.getHeight()) {
				countSquare++;
				System.out.print(" Square Board");
			}
			if (b.getMaterial().toLowerCase().equals("glass")) {
				countHeavy++;
				System.out.println(" Heavy Board");
			}
			if (b.getMaterial().toLowerCase().equals("plastic")) {
				countPlastic++;
				System.out.println(" Plastic Board");
			}
		}
		
		System.out.print("Number of Square boards is " + countSquare
				+ "\nNumber of Heavy boards is " + countHeavy
				+ "\nNumber of Plastic boards is " + countPlastic);
	}

}

class Board
{
	private String brand, material;
	private int height, width;
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setMaterial(String material)
	{
		this.material = material;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getMaterial()
	{
		return material;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
}