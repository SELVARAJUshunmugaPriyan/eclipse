package java8QuestionModule;

interface Machines
{
	static String onOff(boolean isOn)
	{
		return isOn ? "on" : "off";
	}
	
	default String showMachineType(String machine)
	{
		return machine;
	}
	
	int showProductionYear(int year);
}

class Vehicles implements Machines
{
	public int showProductionYear(int year)
	{
		return year < 26 ? 2000 + year : 1900 + year;
	}
	
	@Override
	public String showMachineType(String machine)
	{
		return machine;
	}
}

public class QuestionTwentyOne 
{

	public static void main(String[] args) 
	{
		
		Machines vehicle = new Vehicles();
		System.out.println(vehicle.showMachineType("car"));
		System.out.println(vehicle.showProductionYear(56));
		System.out.println(Machines.onOff(false));
	}

}
