package java8QuestionModule;

interface Bag
{
	public int noOfZips(int no);
	public int warranty(int yr);
	public int price(int price);
	static int discount(int price, int discountPer)
	{
		return (int) (price * (1 - discountPer / 100.0));
	}
}

class SchoolBag implements Bag
{
	public int noOfZips(int no)
	{
		return no;
	}
	public int warranty(int yr)
	{
		return yr;
	}
	public int price(int price)
	{
		return price;
	}
}

public class QuestionTwentyFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchoolBag bag = new SchoolBag();
		
		System.out.println(bag.noOfZips(10));
		System.out.println(bag.warranty(3));
		System.out.println(bag.price(1000));
		System.out.println(Bag.discount(1000, 30));
	}

}
