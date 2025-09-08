package oopsOne;

import java.util.Arrays;

class State
{
	private int id, population;
	private String name, language, capital;
	
	// Constructors
	public State()
	{
		return;
	}
	
	public State(int id, int population, String name,
			String language, String capital)
	{
		this.id = id;
		this.population = population;
		this.name = name;
		this.language = language;
		this.capital = capital;
	}
	
	// Setters
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setPopulation(int population)
	{
		this.population = population;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLanguage(String language)
	{
		this.language = language;
	}
	
	public void setCapital(String capital)
	{
		this.capital = capital;
	}
	
	// Getters
	public int getId()
	{
		return id;
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getLanguage()
	{
		return language;
	}
	
	public String getCapital()
	{
		return capital;
	}
	
	public String toString()
	{
		return "\n\n\tid: " + id
			 + "\n\tname: " + name
			 + "\n\tlanguage: " + language
			 + "\n\tcapital: " + capital
			 + "\n\tpopulation: " + population;
	}
}

class Country
{
	private int id, population;
	private String name, continent, capital/*, states[]*/;
	private State states[];
	private char currency;
	
	// Constructors
	public Country()
	{
		return;
	}
	
	public Country(int id, int population, String name,
			String continent, String capital, State states[],
			char currency)
	{
		this.id = id;
		this.population = population;
		this.name = name;
		this.continent = continent;
		this.capital = capital;
		this.states = states;
		this.currency = currency;
	}
	
	// Setters
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setPopulation(int population)
	{
		this.population = population;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setContinent(String continent)
	{
		this.continent = continent;
	}
	
	public void setCapital(String capital)
	{
		this.capital = capital;
	}
	
	public void setCurrency(char currency)
	{
		this.currency = currency;
	}
	
	public void setStates(State states[])
	{
		this.states = states;
	}
	
	// Getters
	public int getId()
	{
		return id;
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getContinent()
	{
		return continent;
	}
	
	public String getCapital()
	{
		return capital;
	}
	
	public char getCurrency()
	{
		return currency;
	}
	
	public State[] getStates()
	{
		return states;
	}
}

public class UseCountry 
{

	public static void main(String[] args) 
	{
		
		Country countryA = new Country();
		Country countryB = new Country();
		Country countryC = new Country();
		Country countryD = new Country(104, 68605616, "France",
				"Europe", "Paris", new State[] {
						new State(104001, 12271794, "Île-de-France", "French", "Paris"),
						new State(104002, 3339074, "Normandy", "Norman French", "Rouen"),
						new State(104003, 6080731, "Occitania", "Occitan", "Toulouse")
				},'€');
		
		
		countryA.setId(101);
		countryA.setName("India");
		countryA.setContinent("Asia");
		countryA.setCurrency('₹');
		countryA.setPopulation( 1463865525);
		countryA.setCapital("New Delhi");
//		countryA.states = new String[] {"Tamil Nadu", "Karnataka",
//		"Maharashtra"};
		countryA.setStates(new State[] {new State(), new State(),
				new State()});
		
		countryA.getStates()[0].setId(101001);
		countryA.getStates()[0].setName("Tamil Nadu");
		countryA.getStates()[0].setLanguage("Tamil");
		countryA.getStates()[0].setCapital("Chennai");
		countryA.getStates()[0].setPopulation(72147030);
		
		countryA.getStates()[1].setId(101002);
		countryA.getStates()[1].setName("Karnataka");
		countryA.getStates()[1].setLanguage("Kanada");
		countryA.getStates()[1].setCapital("Bengaluru");
		countryA.getStates()[1].setPopulation(61100000);
		
		countryA.getStates()[2].setId(101003);
		countryA.getStates()[2].setName("Maharashtra");
		countryA.getStates()[2].setLanguage("Marathi");
		countryA.getStates()[2].setCapital("Mumbai");
		countryA.getStates()[2].setPopulation(128659000);
		
		
		countryB.setId(102);
		countryB.setName("United States of America");
		countryB.setContinent("North America");
		countryB.setCurrency('$');
		countryB.setPopulation( 34717993);
		countryB.setCapital("Washington D.C.");
//		countryB.getStates()(new String[] {"New York State",
//				"California", "Colorado"};
		countryB.setStates(new State[] {new State(), new State(),
				new State()});
		
		countryB.getStates()[0].setId(102001);
		countryB.getStates()[0].setName("New York State");
		countryB.getStates()[0].setLanguage("English");
		countryB.getStates()[0].setCapital("New York City");
		countryB.getStates()[0].setPopulation(19867248);
		
		countryB.getStates()[1].setId(102002);
		countryB.getStates()[1].setName("California");
		countryB.getStates()[1].setLanguage("English");
		countryB.getStates()[1].setCapital("Sacramento");
		countryB.getStates()[1].setPopulation(39529000);
		
		countryB.getStates()[2].setId(102003);
		countryB.getStates()[2].setName("Colorado");
		countryB.getStates()[2].setLanguage("English");
		countryB.getStates()[2].setCapital("Denver");
		countryB.getStates()[2].setPopulation(5957493);
		
		
		countryC.setId(103);
		countryC.setName("China");
		countryC.setContinent("Asia");
		countryC.setCurrency('¥');
		countryC.setPopulation( 1416304742);
		countryC.setCapital("Beijing");
//		countryC.states = new String[] {"Hebei",
//				"Shanxi", "Liaoning"};
		countryC.setStates(new State[] {new State(), new State(),
				new State()});
		
		countryC.getStates()[0].setId(103001);
		countryC.getStates()[0].setName("Hebei");
		countryC.getStates()[0].setLanguage("Jilu Mandarin,"
				+ " Beijing Mandarin, Jin");
		countryC.getStates()[0].setCapital("Shijiazhuang");
		countryC.getStates()[0].setPopulation(74610235);
		
		countryC.getStates()[1].setId(103002);
		countryC.getStates()[1].setName("Shanxi");
		countryC.getStates()[1].setLanguage("Jin, Central Plains"
				+ " Mandarin, Jilu Mandarin");
		countryC.getStates()[1].setCapital("Taiyuan");
		countryC.getStates()[1].setPopulation(34915616);
		
		countryC.getStates()[2].setId(103003);
		countryC.getStates()[2].setName("Liaoning");
		countryC.getStates()[2].setLanguage("Northeastern Mandarin,"
				+ " Jiaoliao Mandarin, Beijing Mandarin, "
				+ "Pyongan Korean, Manchu");
		countryC.getStates()[2].setCapital("Shenyang");
		countryC.getStates()[2].setPopulation(42591407);
		
		
		System.out.println("id\t: " + countryA.getId()
				+ "\nname\t: " + countryA.getName()
				+ "\ncontinent: " + countryA.getContinent()
				+ "\ncurrency: " + countryA.getCurrency()
				+ "\npopulation: " + countryA.getPopulation()
				+ "\ncapital: " + countryA.getCapital()
//				+ "\nstates: " + Arrays.toString(countryA.getStates())
				+ "\nstates: "
				+ "\n\n\tid: " + countryA.getStates()[0].getId()
				+ "\n\tname: " + countryA.getStates()[0].getName()
				+ "\n\tlanguage: " + countryA.getStates()[0].getLanguage()
				+ "\n\tcapital: " + countryA.getStates()[0].getCapital()
				+ "\n\tpopulation: " + countryA.getStates()[0].getPopulation() + ","
				+ "\n\n\tid: " + countryA.getStates()[1].getId()
				+ "\n\tname: " + countryA.getStates()[1].getName()
				+ "\n\tlanguage: " + countryA.getStates()[1].getLanguage()
				+ "\n\tcapital: " + countryA.getStates()[1].getCapital()
				+ "\n\tpopulation: " + countryA.getStates()[1].getPopulation() + ","
				+ "\n\n\tid: " + countryA.getStates()[2].getId()
				+ "\n\tname: " + countryA.getStates()[2].getName()
				+ "\n\tlanguage: " + countryA.getStates()[2].getLanguage()
				+ "\n\tcapital: " + countryA.getStates()[2].getCapital()
				+ "\n\tpopulation: " + countryA.getStates()[2].getPopulation()
				+ "\n");
		
		System.out.println("id\t: " + countryB.getId()
				+ "\nname\t: " + countryB.getName()
				+ "\ncontinent: " + countryB.getContinent()
				+ "\ncurrency: " + countryB.getCurrency()
				+ "\npopulation: " + countryB.getPopulation()
				+ "\ncapital: " + countryB.getCapital()
//				+ "\nstates: " + Arrays.toString(countryB.getStates())
				+ "\nstates: "
				+ "\n\n\tid: " + countryB.getStates()[0].getId()
				+ "\n\tname: " + countryB.getStates()[0].getName()
				+ "\n\tlanguage: " + countryB.getStates()[0].getLanguage()
				+ "\n\tcapital: " + countryB.getStates()[0].getCapital()
				+ "\n\tpopulation: " + countryB.getStates()[0].getPopulation() + ","
				+ "\n\n\tid: " + countryB.getStates()[1].getId()
				+ "\n\tname: " + countryB.getStates()[1].getName()
				+ "\n\tlanguage: " + countryB.getStates()[1].getLanguage()
				+ "\n\tcapital: " + countryB.getStates()[1].getCapital()
				+ "\n\tpopulation: " + countryB.getStates()[1].getPopulation() + ","
				+ "\n\n\tid: " + countryB.getStates()[2].getId()
				+ "\n\tname: " + countryB.getStates()[2].getName()
				+ "\n\tlanguage: " + countryB.getStates()[2].getLanguage()
				+ "\n\tcapital: " + countryB.getStates()[2].getCapital()
				+ "\n\tpopulation: " + countryB.getStates()[2].getPopulation()
				+ "\n");
		
		System.out.println("id\t: " + countryC.getId()
				+ "\nname\t: " + countryC.getName()
				+ "\ncontinent: " + countryC.getContinent()
				+ "\ncurrency: " + countryC.getCurrency()
				+ "\npopulation: " + countryC.getPopulation()
				+ "\ncapital: " + countryC.getCapital()
//				+ "\nstates: " + Arrays.toString(countryC.getStates())
				+ "\nstates: "
				+ "\n\n\tid: " + countryC.getStates()[0].getId()
				+ "\n\tname: " + countryC.getStates()[0].getName()
				+ "\n\tlanguage: " + countryC.getStates()[0].getLanguage()
				+ "\n\tcapital: " + countryC.getStates()[0].getCapital()
				+ "\n\tpopulation: " + countryC.getStates()[0].getPopulation() + ","
				+ "\n\n\tid: " + countryC.getStates()[1].getId()
				+ "\n\tname: " + countryC.getStates()[1].getName()
				+ "\n\tlanguage: " + countryC.getStates()[1].getLanguage()
				+ "\n\tcapital: " + countryC.getStates()[1].getCapital()
				+ "\n\tpopulation: " + countryC.getStates()[1].getPopulation() + ","
				+ "\n\n\tid: " + countryC.getStates()[2].getId()
				+ "\n\tname: " + countryC.getStates()[2].getName()
				+ "\n\tlanguage: " + countryC.getStates()[2].getLanguage()
				+ "\n\tcapital: " + countryC.getStates()[2].getCapital()
				+ "\n\tpopulation: " + countryC.getStates()[2].getPopulation()
				+ "\n");
		
	System.out.println("id\t: " + countryD.getId()
		+ "\nname\t: " + countryD.getName()
		+ "\ncontinent: " + countryD.getContinent()
		+ "\ncurrency: " + countryD.getCurrency()
		+ "\npopulation: " + countryD.getPopulation()
		+ "\ncapital: " + countryD.getCapital()
		+ "\nstates: " + Arrays.toString(countryD.getStates())
		+ "\n");
	}

}