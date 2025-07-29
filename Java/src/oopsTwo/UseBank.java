package oopsTwo;

class Bank
{

	public int findLoanEligibilityAmount()
	{
		return 30000;
	}
	
	public int findLoanEligibilityAmount(int salary)
	{
		return salary * 10 + 30000;
	}
	
	public int findLoanEligibilityAmount(int salary,
										 int propertyValue)
	{
		return (int) (0.5 * propertyValue) + salary * 10 + 30000;
	}
	
	// Method Overriding
	public int getInterest(int Amount)
	{
		return (int) (Amount * 1.05);
	}
	
	public char getName(String name)
	{
		return name.charAt(0);
	}
}

class AxisBank extends Bank
{
	
	// Method Overriding
	public int getInterest(int Amount)
	{
		return (int) (Amount * 1.1);
	}
	
	public String getBranch(String branch)
	{
		return branch;
	}
}

public class UseBank 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Bank b = new Bank();
		
//		System.out.println(b.findLoanEligibilityAmount());
//		System.out.println(b.findLoanEligibilityAmount(30000));
//		System.out.println(b.findLoanEligibilityAmount(30000, 
//													   300000));
		System.out.println(b.getInterest(30000));
		System.out.println(b.getName("SBI"));
		
		AxisBank a = new AxisBank();
		
		System.out.println(a.getInterest(30000));
	}

}
