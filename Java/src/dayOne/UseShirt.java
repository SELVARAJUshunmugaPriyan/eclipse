package dayOne;

public class UseShirt {

	public static void main(String[] args) {
		
		Shirt s1 = new Shirt();
		s1.brand = "otto";
		s1.price = 400;
		s1.size = 'm';
		s1.discountAmount = 50;
		Shirt s2 = new Shirt();
		s2.brand = "raymond";
		s2.price = 700;
		s2.size = 'l';
		s2.discountAmount = 20;
		Shirt s3 = new Shirt();
		s3.brand = "peter england";
		s3.price = 500;
		s3.size = 's';
		s3.discountAmount = 10;
		
		int netPrice = s1.price + (s1.price * s1.discountAmount / 100);
		
		System.out.println("Brand = " + s1.brand + "\n" +
				"Price = " + s1.price + "\n" +
				"Size = " + s1.size + "\n" +
				"Discount Amount = " + s1.discountAmount + "\n" +
				"Net Price = " + netPrice + "\n");
		
		netPrice = s2.price + (s2.price * s2.discountAmount / 100);
		
		System.out.println("Brand = " + s2.brand + "\n" +
				"Price = " + s2.price + "\n" +
				"Size = " + s2.size + "\n" +
				"Discount Amount = " + s2.discountAmount + "\n" +
				"Net Price = " + netPrice + "\n");
		
		netPrice = s3.price + (s3.price * s3.discountAmount / 100);
		
		System.out.println("Brand = " + s3.brand + "\n" +
				"Price = " + s3.price + "\n" +
				"Size = " + s3.size + "\n" +
				"Discount Amount = " + s3.discountAmount + "\n" +
				"Net Price = " + netPrice + "\n");
	}

//	static int netPriceCalc(Shirt s) {
//		return s.price + (s.price * s.discountAmount / 100);
//	}
}
