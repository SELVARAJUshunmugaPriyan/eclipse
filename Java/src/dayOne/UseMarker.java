package dayOne;

//public class Marker {
//	String brand;
//	int price;
//	String color;
//	Boolean isRefillable;
//}

public class UseMarker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marker m1 = new Marker();
		m1.brand = "Camlin";
		m1.price = 70;
		m1.color = "Black";
		m1.isRefillable = true;
		Marker m2 = new Marker();
		m2.brand = "Faber";
		m2.price = 60;
		m2.color = "Red";
		m2.isRefillable = false;
		System.out.println("Brand = " + m1.brand + "\n" +
					"price = " + m1.price);
	}

}
