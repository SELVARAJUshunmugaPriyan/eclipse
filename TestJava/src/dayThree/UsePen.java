package dayThree;

class Pen {
	String brand;
	int price;
	String color;
}

public class UsePen {
	// Class Pen and string operations
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pen p1 = new Pen();
		Pen p2 = new Pen();
		
		p1.brand = "reynolds";
		p1.price = 5;
		p1.color = "blue";
		
		p2.brand = "parker";
		p2.price = 25;
		p2.color = "black";
		
		System.out.println("Pen brands:\n"
				+ p1.brand + "\n"
				+ p2.brand + "\n"
				+ "\nBrand name contains \"a\"?\n"
				+ p1.brand + " " + p1.brand.contains("a") + "\n"
				+ p2.brand + " " + p2.brand.contains("a") + "\n"
				+ "\nBrand color equals \"BLUE\"?\n"
				+ p1.brand + " " + p1.color.equalsIgnoreCase("BLUE") + "\n"
				+ p2.brand + " " + p2.color.equalsIgnoreCase("BLUE") + "\n"
				+ "\nBrand color equals \"black\"?\n"
				+ p1.brand + " " + p1.color.equalsIgnoreCase("black") + "\n"
				+ p2.brand + " " + p2.color.equalsIgnoreCase("black") + "\n"
				+ "\nCharacter at 2 in brand color of " + p1.brand + " is " + p1.color.charAt(2) + "\n"
				+ "\nCharacter at 4 in brand color of " + p2.brand + " is " + p2.color.charAt(4) + "\n"
				+ "\nSplit strings at \"y\" in brand name of " + p1.brand + " are " + p1.brand.split("y")[0] + " and " + p1.brand.split("y")[1] + "\n"
				+ "\nLength of pen color of brand " + p1.brand + " is " + p1.color.length() + "\n"
				+ "\nLength of pen color of brand " + p2.brand + " is " + p2.color.length() + "\n");
	}

}
