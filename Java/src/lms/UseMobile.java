package lms;

class Mobile {
	String brand;
	int price;
	int length;
	float discount;
	float netPrice;
}

public class UseMobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mobile m1 = new Mobile();
		Mobile m2 = new Mobile();
		Mobile m3 = new Mobile();
		Mobile m4 = new Mobile();
		
		String[] t = args[0].split(",");
		m1.brand = t[0];
		m1.price = Integer.parseInt(t[1]);
		m1.length = Integer.parseInt(t[2]);
		m1.discount = Float.parseFloat(t[3]);
		m1.netPrice = m1.price - m1.price * (m1.discount / 100);
		
		t = args[1].split(",");
		m2.brand = t[0];
		m2.price = Integer.parseInt(t[1]);
		m2.length = Integer.parseInt(t[2]);
		m2.discount = Float.parseFloat(t[3]);
		m2.netPrice = m2.price - m2.price * (m2.discount / 100);
		
		t = args[2].split(",");
		m3.brand = t[0];
		m3.price = Integer.parseInt(t[1]);
		m3.length = Integer.parseInt(t[2]);
		m3.discount = Float.parseFloat(t[3]);
		m3.netPrice = m3.price - m3.price * (m3.discount / 100);
		
		t = args[3].split(",");
		m4.brand = t[0];
		m4.price = Integer.parseInt(t[1]);
		m4.length = Integer.parseInt(t[2]);
		m4.discount = Float.parseFloat(t[3]);
		m4.netPrice = m4.price - m4.price * (m4.discount / 100);
		
		System.out.println("Brand = " + m1.brand + "\n"
				+ "Length = " + m1.length + "\n"
				+ "Discount = " + m1.discount + "%\n"
				+ "Net price = " + m1.netPrice + "\n");
		System.out.println("Brand = " + m2.brand + "\n"
				+ "Length = " + m2.length + "\n"
				+ "Discount = " + m2.discount + "%\n"
				+ "Net price = " + m2.netPrice + "\n");
		System.out.println("Brand = " + m3.brand + "\n"
				+ "Length = " + m3.length + "\n"
				+ "Discount = " + m3.discount + "%\n"
				+ "Net price = " + m3.netPrice + "\n");
		System.out.println("Brand = " + m4.brand + "\n"
				+ "Length = " + m4.length + "\n"
				+ "Discount = " + m4.discount + "%\n"
				+ "Net price = " + m4.netPrice + "\n");
	}

} 