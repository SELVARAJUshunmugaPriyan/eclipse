package java8QuestionModule;

@FunctionalInterface
interface PriceCalculation
{
	int findNetPrice(int amount, int tax, int discount);
}

public class QuestionTwentyFive {

	public static void main(String[] args) {
		
		PriceCalculation frstCal = (x, y, z) -> (int) (x * ((1 - z / 100.0) + (1 - z / 100.0) * y / 100.0));
		System.out.println(frstCal.findNetPrice(1000, 5, 25));
		PriceCalculation scndCal = (x, y, z) -> x + y - z;
		System.out.println(scndCal.findNetPrice(1000, 37, 250));
	}

}
