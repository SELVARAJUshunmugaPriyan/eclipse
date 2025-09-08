package dayTwo;

class Pen {
	String brand;
	int price;
	boolean isBlueColor;
	float tipWidth;
}

public class UsePen {

	public static void main(String[] args) {
		
		Pen p1 = new Pen();
		
		p1.brand = "Camlin";
		p1.price = 28;
		p1.isBlueColor = false;
		p1.tipWidth = 5.0f;
		
		
		Pen p2 = new Pen();
		
		p2.brand = "nataraj";
		p2.price = 34;
		p2.isBlueColor = false;
		p2.tipWidth = 2.5f;
		
		
		Pen p3 = new Pen();
		
		p3.brand = "apsara";
		p3.price = 35;
		p3.isBlueColor = true;
		p3.tipWidth = 4.5f;
		
		
		System.out.println("Average price is " + 
				((p1.price + p2.price + p3.price) / 3));
	}

}
