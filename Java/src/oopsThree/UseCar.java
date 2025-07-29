package oopsThree;

interface Car
{
	public String getBrand(String brand);
	public int getPrice(int price, int tax);
}

class SportsCar implements Car
{
	public String getBrand(String brand)
	{
		return brand;
	}
	public int getPrice(int price, int tax)
	{
		return price + tax;
	}
	public int getCc(int cc)
	{
		return cc;
	}
}

public class UseCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SportsCar sc = new SportsCar();
		System.out.println(sc.getBrand("BMW") + " " 
				+ sc.getPrice(1000000, 100000) + " "
				+ sc.getCc(650));
	}

}
