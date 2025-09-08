package java8;

public class UseBank {

	public static void main(String[] args) {
		
		CubBank cb = new CubBank();
		System.out.println(cb.rateOfInterest(1000));
		System.out.println(Bank.accNumber(1000L));
		System.out.println(cb.branch());
	}

}

class CubBank implements Bank
{
	public int rateOfInterest(int amt)
	{
		return amt * 5 / 100;
	}
	
	public String branch()
	{
		return "Kanchipuram";
	}
}

interface Bank
{
	public int rateOfInterest(int amt);
	
	public static long accNumber(long acc)
	{
		return acc;
	}
	
	public default String branch()
	{
		return "Perungudi";
	}
}
