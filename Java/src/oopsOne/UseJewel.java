package oopsOne;

class Jewel
{
	String metal, type;
	char size;
	Gold gold;
	Silver silver;
	boolean hasStone;
	
	public String toString()
	{
		return metal + "\t" + type + "\t" + size + "\t" + gold + "\t"
			 + "\t" + silver + "\t" + hasStone;
	}
}

class Gold
{
	float weight;
	int price;
	Stone stone;
	
	public String toString()
	{
		return weight + "\t" + price + "\t" + stone;
	}
}

class Silver
{
	float weight;
	int price;
	Stone stone;
	
	public String toString()
	{
		return weight + "\t" + price + "\t" + stone;
	}
}

class Stone
{
	String type;
	
	public String toString()
	{
		return type;
	}
}

public class UseJewel 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Jewel jewelA = new Jewel(), jewelB = new Jewel();
//		Gold g = new Gold();
		Silver s = new Silver();
		Stone st = new Stone();
//		Stone st2 = new Stone();
		
		jewelA.metal = "gold";
		jewelA.type = "ring";
		jewelA.size = 'S';
		jewelA.gold = new Gold();
		jewelA.gold.price = 75000;
		jewelA.gold.weight = 7.5f;
		jewelA.hasStone = true;
		jewelA.gold.stone = st;
		jewelA.gold.stone.type = "diamond";

		jewelB.metal = "silver";
		jewelB.type = "chain";
		jewelB.size = 'L';
		jewelB.silver = s;
		jewelB.silver.price = 10000;
		jewelB.silver.weight = 52.0f;
		jewelB.hasStone = false;
		
		
		System.out.println(jewelA.metal + "\t" + jewelA.type + "\t"
				+ jewelA.size + "\t" + jewelA.gold.price + "\t"
				+ jewelA.gold.weight + "\t" + jewelA.hasStone + "\t"
				+ jewelA.gold.stone.type);
		
		System.out.println(jewelB.metal + "\t" + jewelB.type + "\t"
				+ jewelB.size + "\t" + jewelB.silver.price + "\t"
				+ jewelB.silver.weight + "\t" + jewelB.hasStone);
		
		System.out.print(jewelA + "\n" + jewelB);
	}

}
