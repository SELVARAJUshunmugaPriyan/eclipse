package dayThree;

class Car {
	String brand;
	String model;
	int price;
	boolean isPetrol;
}

public class UseCar {
	// Class Car and string operations
	public static void main(String[] args) {
		
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		car1.brand = "bmw";
		car1.model = "XVI";
		car1.price = 400000;
		car1.isPetrol = false;
		
		car2.brand = "tata";
		car2.model = "IX";
		car2.price = 300000;
		car2.isPetrol = true;
		
		car3.brand = "swift";
		car3.model = "X2V";
		car3.price = 200000;
		car3.isPetrol = true;
		
		System.out.println("First car brand is " + car1.brand.toUpperCase()
				+ " with length of brand name is " + car1.brand.length());
		System.out.println("Second car brand is " + car2.brand.toUpperCase()
				+ " with length of brand name is " + car2.brand.length());
		System.out.println("Third car brand is " + car3.brand.toUpperCase()
				+ " with length of brand name is " + car3.brand.length());
		System.out.println("Total price is " + (car1.price + car2.price + car3.price));
	}

}
