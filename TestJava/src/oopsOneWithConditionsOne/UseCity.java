package oopsOneWithConditionsOne;

public class UseCity 
{

	public static void main(String[] args) 
	{
		
		City b1 = new City(), b2 = new City(), b3 = new City();
		City B[] = {b1, b2, b3};
		int countMetro = 0, countCityState = 0, countLucky = 0;
		
		b1.setName("Chennai");
		b1.setId(102);
		b1.setPopulation(20000000);
		b1.setCountryName("India");
		
		b2.setName("Singapore");
		b2.setId(501);
		b2.setPopulation(10000000);
		b2.setCountryName("Singapore");
		
		b3.setName("Dharmshala");
		b3.setId(104);
		b3.setPopulation(100000);
		b3.setCountryName("India");
		
		for (City b : B) {
			System.out.print(b.getName() + " " + b.getCountryName()
					+ " " + b.getId() + " " + b.getPopulation());
			
			if (b.getPopulation() > 1000000) {
				countMetro++;
				System.out.print(" METRO CITY");
			} else
				System.out.print(" SMALL CITY");
			if (b.getCountryName().equals(b.getName())) {
				countCityState++;
				System.out.print(" CITY STATE");
			} else
				System.out.println(" JUST CITY");
			if (b.getId() % 2 == 1) {
				countLucky++;
				System.out.println(" LUCKY CITY");
			}
		}
		
		System.out.print("Number of Metro cities is " + countMetro
				+ "\nNumber of City State cities is " + countCityState
				+ "\nNumber of Lucky cities is " + countLucky);
	}

}

class City
{
	private String name, countryName;
	private int id, population;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
	
	public void setPopulation(int population)
	{
		this.population = population;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCountryName()
	{
		return countryName;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getPopulation()
	{
		return population;
	}
}