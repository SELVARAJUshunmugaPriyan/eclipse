package dayThree;

class Laptop {
	String brand;
	int price;
	String color;
	boolean isWarranty;
}

public class UseLaptop {
	// Class Laptop and string operations
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Laptop laptop1 = new Laptop();
		
		laptop1.brand = "Dell";
		laptop1.price = 45000;
		laptop1.color = "BLUE";
		laptop1.isWarranty = true;
		
		System.out.println("Brand name (UPPER-CASE):\n"
				+ laptop1.brand.toUpperCase()
				+ "\nLength of brand name:\n"
				+ laptop1.brand.length()
				+ "\nBrand name starts with \"D\":\n"
				+ laptop1.brand.startsWith("D")
				+ "\nLast character of brand name:\n"
				+ laptop1.brand.charAt(laptop1.brand.length() - 1)
				+ "\nBrand name color (lower-case):\n"
				+ laptop1.color.toLowerCase());
	}

}
