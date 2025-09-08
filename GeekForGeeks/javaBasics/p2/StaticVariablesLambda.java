package p2;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface PrintCoinPre
{
	void print();
}

class InitializeStaticVarStaticFnc
{
	static int coin;
	
	public static void main(String[] args)
	{
		coin = 100; // init in static method
		PrintCoinPre obj = () -> System.out.println("I bought "
				+ coin + " Doge coins WooHoo!");
		obj.print();
	}
}

class InitializeStaticVarLambdaFnc
{
	class StaticVarManipulationInLambda
	{
		static int coin;
		
		public static void main(String[] args)
		{
			coin = 100;
			
			PrintCoinPre obj = () -> {
				coin += 20; //can manipulate static variables
				System.out.println("I bought " + coin + " Doge coins"
						+ "WooHoo!");
			};
			obj.print();
			
			System.out.println(coin + " coins!! Keep winning sis!");
		}
	}
	
	class StaticInitInLambda
	{
		static int coin;
		
		public static void main(String[] args)
		{
			PrintCoinPre obj = () -> {
				coin += 20; //can manipulate static variables
				System.out.println("I bought " + coin + " Doge coins"
						+ "WooHoo!");
			};
			obj.print();
			
			System.out.println(coin + " coins!! Keep winning sis!");
		}
	}
}

@FunctionalInterface
interface PrintCoin
{
	void print(int value);
}

class LambdaWithParameters
{
	static int coin;
	
	public static void main(String[] args)
	{
		PrintCoin obj = value -> { // value present as parameter
			value += 100;
			coin += 20 + value;
			System.out.println("I bought " + coin + " Doge coins"
					+ "WooHoo!");
		};
		obj.print(500); // passing default value
		
		System.out.println(coin + " coins!! Keep winning sis!");
	}
}

class StaticReferenceVariableLambda 
{
	static int coin;
	
	static List<Integer> coinsBought = Arrays.asList(20, 50, 50);
	
	public static void main(String[] args) 
	{
		
		PrintCoin obj = value -> {
			value = value + 100;
			coin = coinsBought.stream().reduce(0, (coin1, coin2)
					-> coin1 + coin2); // total of coins bought, 
									   // a simple sum of list
			coin = coin + value;
			System.out.println("I bought " + coin + " Doge coins"
					+ "WooHoo!");
		};
		obj.print(500);
		
		System.out.println(coin + " coins!! Keep winning sis!");
	}

}

public class StaticVariablesLambda
{
	static int coin;
	
	public static void main(String[] args)
	{
		
		PrintCoinPre obj = () -> System.out.println("I bought "
				+ coin + " Doge coins WooHoo!");
		obj.print();
		
		
//		InitializeStaticVarStaticFnc.main(args);
//		InitializeStaticVarLambdaFnc
//			.StaticVarManipulationInLambda.main(args);
//		InitializeStaticVarLambdaFnc
//			.StaticInitInLambda.main(args);
//		LambdaWithParameters.main(args);
//		StaticReferenceVariableLambda.main(args);
	}
}
