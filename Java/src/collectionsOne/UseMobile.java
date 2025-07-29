package collectionsOne;

import java.util.ArrayList;
import java.util.Arrays;

class Mobile
{
	private int price;
	private String brand, color;
	private float size;
	private boolean isWarranty;
	
	// Constructors
	Mobile()
	{
		
	}
	
	Mobile(int price, String brand, String color, float size,
		   boolean isWarranty)
	{
		this.brand = brand;
		this.price = price;
		this.size = size;
		this.color = color;
		this.isWarranty = isWarranty;
	}
	
	// Getters and Setters
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public boolean isWarranty() {
		return isWarranty;
	}
	public void setWarranty(boolean isWarranty) {
		this.isWarranty = isWarranty;
	}
	
	// Methods
	ArrayList<Mobile> maxPrice(ArrayList<Mobile> mobiles)
	{
		ArrayList<Mobile> reducedMobiles = new ArrayList<>();
		
//		Mobile mxPrice = mobiles.get(0);
		reducedMobiles.add(mobiles.get(0));
		for (Mobile mobile : mobiles)
//			if (mobile.getPrice() > mxPrice.getPrice())
//				mxPrice = mobile;
			if (mobile.getPrice() > reducedMobiles.get(0).getPrice())
				reducedMobiles.set(0, mobile);
//		System.out.println("Maximum price mobile : \n" + mxPrice + "\n");
		
//		reducedMobiles.add(mxPrice);
		return reducedMobiles;
	}
	
	ArrayList<Mobile> evenLengthBrandString(ArrayList<Mobile> mobiles)
	{
		ArrayList<Mobile> reducedMobiles = new ArrayList<>();
		
//		System.out.println("Mobiles with even-length brand names:");
		mobiles.forEach(mobile -> {
			if (mobile.getBrand().length() % 2 == 0)
//				System.out.println(mobile);
				reducedMobiles.add(mobile);
		});
//		System.out.println();
		
		return reducedMobiles;
	}
	
	ArrayList<Character> lastCharacterOfBrand(ArrayList<Mobile> mobiles)
	{
		ArrayList<Character> lastChar = new ArrayList<>();
		
//		System.out.println("Last character of mobile brands:");
//		mobiles.forEach(mobile -> System.out.print(mobile
//									.getBrand().charAt(mobile
//									.getBrand().length() - 1) + " "));
		mobiles.forEach(mobile -> lastChar.add(mobile
									.getBrand().charAt(mobile
									.getBrand().length() - 1)));
//		System.out.println("\n");
		
		return lastChar;
	}
	
	ArrayList<String> isWarrantyBrand(ArrayList<Mobile> mobiles)
	{
		ArrayList<String> brands = new ArrayList<>();
		
//		System.out.println("Mobile brands with warranty:");
//		mobiles.forEach(mobile -> System.out.print(
//				mobile.isWarranty() ? mobile.getBrand() + " " : ""));
		mobiles.forEach(mobile -> {
			if (mobile.isWarranty())
				brands.add(mobile.getBrand());
		});
//		System.out.println("\n");
		
		return brands;
	}
	
	ArrayList<Integer> printPricesInRange(ArrayList<Mobile> mobiles, int low,
							int high)
	{
		ArrayList<Integer> prices = new ArrayList<>();
		
//		System.out.println("Mobile prices within price range:");
//		mobiles.forEach(mobile -> System.out.print(
//				mobile.getPrice() >= low &&
//				mobile.getPrice() <= high ? mobile.getPrice() 
//											 + " " : ""));
		mobiles.forEach(mobile -> {
			if (mobile.getPrice() >= low &&
				mobile.getPrice() <= high)
					prices.add(mobile.getPrice());
		});
//		System.out.println("\n");
		
		return prices;
	}
	
	@Override
	public String toString()
	{
		return "{Price: " + price + ",\tbrand: " + brand
			 + ",\tcolor: " + color + ",\tsize: " + size
			 + ",\tisWarranty: " + (isWarranty ? "yes}" : "no}");
	}
}


public class UseMobile 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Mobile m1 = new Mobile(10000, "Samsung", "Blue", 6.8f, true);
		Mobile m2 = new Mobile(20000, "LG", "Green", 5.7f, true);
		Mobile m3 = new Mobile(15000, "Moto", "Black", 6.8f, false);
		Mobile m4 = new Mobile(90000, "Apple", "White", 6.1f, true);
		Mobile m5 = new Mobile(6000, "HTC", "Red", 8.2f, false);
		
		ArrayList<Mobile> mobiles = new ArrayList<>();
		
//		mobiles.add(m1);
//		mobiles.add(m2);
//		mobiles.add(m3);
//		mobiles.add(m4);
//		mobiles.add(m5);
		
		mobiles.addAll(Arrays.asList(m1, m2, m3, m4, m5));
		
//		mobiles.forEach(m -> System.out.println(m));
		
		System.out.println(new Mobile().maxPrice(mobiles));
		System.out.println(new Mobile().evenLengthBrandString(mobiles));
		System.out.println(new Mobile().lastCharacterOfBrand(mobiles));
		System.out.println(new Mobile().isWarrantyBrand(mobiles));
		System.out.println(new Mobile().printPricesInRange(mobiles, 20000, 90000));
	}

}
