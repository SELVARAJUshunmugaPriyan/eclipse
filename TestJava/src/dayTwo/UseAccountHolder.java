package dayTwo;

class AccountHolder {
	String name;
	int age;
	String gender;
	long accountNumber;
	int monthlyIncome;
	int savingsPercentage;
}
public class UseAccountHolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountHolder a1 = new AccountHolder();
		AccountHolder a2 = new AccountHolder();
		AccountHolder a3 = new AccountHolder();
		
		a1.name = "mano";
		a1.age = 26;
		a1.gender = "Male";
		a1.accountNumber = 28330485612583l;
		a1.monthlyIncome = 21000;
		a1.savingsPercentage = 18;
		
		
		a2.name = "Savithri";
		a2.age = 25;
		a2.gender = "Female";
		a2.accountNumber = 28330485612584l;
		a2.monthlyIncome = 20000;
		a2.savingsPercentage = 20;
		
		
		a3.name = "Kamban";
		a3.age = 30;
		a3.gender = "Male";
		a3.accountNumber = 28330485612585l;
		a3.monthlyIncome = 30000;
		a3.savingsPercentage = 10;
		
		
		System.out.println("Savings amount of " + a1.name + " is " +
				(a1.monthlyIncome * (a1.savingsPercentage / 100.0)));
		System.out.println("Savings amount of " + a2.name + " is " +
				(a2.monthlyIncome * (a2.savingsPercentage / 100.0)));
		System.out.println("Savings amount of " + a3.name + " is " +
				(a3.monthlyIncome * (a3.savingsPercentage / 100.0)));
	}

}
