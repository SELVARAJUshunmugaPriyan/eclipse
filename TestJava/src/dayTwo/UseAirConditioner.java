package dayTwo;

class AirConditioner {
	String brand;
	int price;
	int noOfWings;
	boolean isQuality;
}
public class UseAirConditioner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AirConditioner a1 = new AirConditioner();
		AirConditioner a2 = new AirConditioner();
		
		a1.brand = "Samsung";
		a1.price = 40000;
		a1.noOfWings = 2;
		a1.isQuality = true;
		
		
		a2.brand = "lg";
		a2.price = 50000;
		a2.noOfWings = 3;
		a2.isQuality = false;
		
		
		System.out.println("Brand = " + a1.brand + '\n' + 
				"Price = " + a1.price + '\n' + 
				"No of wings = " + a1.noOfWings + '\n' + 
				"Is quality = " + a1.isQuality );
		
		System.out.println("\n");
		
		System.out.println("Brand = " + a2.brand + '\n' + 
				"Price = " + a2.price + '\n' + 
				"No of wings = " + a2.noOfWings + '\n' + 
				"Is quality = " + a2.isQuality );
	}

}
