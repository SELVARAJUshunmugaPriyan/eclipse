package functions;

import java.util.ArrayList;

class Mobile {
	
	String brand, model;
	char series;
	int price, version;
	boolean isSmartPhone;
	
	static void printMobile(ArrayList<Mobile> mobiles) {
		for(Mobile mobile : mobiles)
			System.out.println(mobile.brand + " "
					+ mobile.model + " "
					+ mobile.series + " "
					+ mobile.price + " "
					+ mobile.version + " "
					+ mobile.isSmartPhone);
		
		return;
	}
	
	static void printMobile(Mobile[] mobiles) {
		for(Mobile mobile : mobiles)
			System.out.println(mobile.brand + " "
					+ mobile.model + " "
					+ mobile.series + " "
					+ mobile.price + " "
					+ mobile.version + " "
					+ mobile.isSmartPhone);
		
		return;
	}
	
	static void printMobile(Mobile mobile) {
		System.out.println(mobile.brand + " "
				+ mobile.model + " "
				+ mobile.series + " "
				+ mobile.price + " "
				+ mobile.version + " "
				+ mobile.isSmartPhone);
		
		return;
	}
	
	static ArrayList<Mobile> maxPriceMobile(Mobile[] mobiles) {
		ArrayList<Mobile> maxMobiles = new ArrayList<Mobile>();
		Mobile maxMobile = new Mobile();
		
		for(Mobile mobile : mobiles)
			if(mobile.price > maxMobile.price) {
				maxMobile = mobile;
				maxMobiles.clear();
				maxMobiles.add(mobile);
			} else if(mobile.price == maxMobile.price)
				maxMobiles.add(mobile);
		
		return maxMobiles;
	}
	
	static ArrayList<Mobile> lonBrandMobile(Mobile[] mobiles) {
		ArrayList<Mobile> longBrandNames = new ArrayList<Mobile>();
		Mobile longBrand = new Mobile();
		longBrand.brand = "";
		
		for(Mobile mobile : mobiles)
			if(mobile.brand.length() > longBrand.brand.length()) {
				longBrand = mobile;
				longBrandNames.clear();
				longBrandNames.add(mobile);
			} else if(mobile.brand.length() == longBrand.brand.length())
				longBrandNames.add(mobile);
		
		return longBrandNames;
	}

}

public class UseMobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mobile m1 = new Mobile(), m2 = new Mobile(),
			   m3 = new Mobile(), m4 = new Mobile(),
			   m5 = new Mobile();
		
		m1.brand = "LG";
		m1.isSmartPhone = false;
		m1.model = "G5";
		m1.series = 'G';
		m1.version = 5;
		m1.price = 20000;
		
		m2.brand = "Samsung";
		m2.isSmartPhone = true;
		m2.model = "S10";
		m2.series = 'S';
		m2.version = 10;
		m2.price = 30000;
		
		m3.brand = "Apple";
		m3.isSmartPhone = false;
		m3.model = "i8";
		m3.series = 'i';
		m3.version = 8;
		m3.price = 45000;
		
		m4.brand = "Motorola";
		m4.isSmartPhone = true;
		m4.model = "G8";
		m4.series = 'G';
		m4.version = 11;
		m4.price = 18000;
		
		m5.brand = "SonyEricson";
		m5.isSmartPhone = true;
		m5.model = "X6";
		m5.series = 'X';
		m5.version = 6;
		m5.price = 25000;
		
		Mobile[] mobiles = {m1, m2, m3, m4, m5};
		
//		Mobile.printMobile(mobiles);
		Mobile.printMobile(Mobile.maxPriceMobile(mobiles));
		Mobile.printMobile(Mobile.lonBrandMobile(mobiles));
	}

}
