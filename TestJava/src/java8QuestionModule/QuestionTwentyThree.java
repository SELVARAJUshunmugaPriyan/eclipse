package java8QuestionModule;

@FunctionalInterface
interface Laptop
{
	public int getPrice(String price);
	
	static String confg(String ... conf)
	{
		if (conf.length < 3)
			return "Invalid config";
		return "Brand: " + conf[0] + ", Color: " + conf[1] + ", RAM: " + conf[2];
	}
}

class Asus
{
	public int getPrice(String price)
	{
		return Integer.parseInt(price);
	}
}

public class QuestionTwentyThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Laptop lap = new Asus()::getPrice;
		System.out.println(lap.getPrice("25000"));
		System.out.println(Laptop.confg("Asus", "Black", "12Gb"));
		System.out.println(Laptop.confg("Asus", "Black"));
	}

}
