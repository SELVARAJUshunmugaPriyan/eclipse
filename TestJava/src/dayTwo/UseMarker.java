package dayTwo;

class Marker {
	int price;
	String colour;
	float weight;
	boolean isQuality;
}

public class UseMarker {

	public static void main(String[] args) {
		
		Marker m1 = new Marker();
		Marker m2 = new Marker();
		Marker m3 = new Marker();
		
		m1.price = 35;
		m1.colour = "Blue";
		m1.weight = 20.0f;
		m1.isQuality = false;
		
		
		m2.price = 25;
		m2.colour = "Red";
		m2.weight = 20.0f;
		m2.isQuality = false;
		
		
		m3.price = 50;
		m3.colour = "Blue";
		m3.weight = 30.0f;
		m3.isQuality = true;
		
		
		System.out.println("Price = " + m1.price + "\n" +
				"Colour = " + m1.colour + "\n" +
				"Weight = " + m1.weight + "\n" +
				"Is quality = " + m1.isQuality + "\n" );
		
		System.out.println("Price = " + m2.price + "\n" +
				"Colour = " + m2.colour + "\n" +
				"Weight = " + m2.weight + "\n" +
				"Is quality = " + m2.isQuality + "\n" );
		
		System.out.println("Price = " + m3.price + "\n" +
				"Colour = " + m3.colour + "\n" +
				"Weight = " + m3.weight + "\n" +
				"Is quality = " + m3.isQuality);
	}

}
