package java8;

public class UseCalci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calci add = (x, y) -> x + y;
		System.out.println(add.getAdd(5, 3));
		Calci sub = (x, y) -> x - y;
		System.out.println(sub.getAdd(5, 3));
		Calci max = (x, y) -> {
			if (x > y)
				return x;
			else
				return y;
		};
		System.out.println(max.getAdd(12, 13));
		Calci even = (x, y) -> (x % 2 == 0) ? x : (y % 2 == 0) ? y : -1;
		System.out.println(even.getAdd(13, 12));
		Calci odd = (x, y) -> (x % 2 == 1) ? x : (y % 2 == 1) ? y : -1;
		System.out.println(odd.getAdd(13, 12));
		System.out.println(odd.factorial(0));
		System.out.println(Calci.power(8, 4));
		
		StringManipulation charAtLast = x -> {
			char lastChars[] = new char[x.length];
			for (int i = 0; i < x.length; i++)
				lastChars[i] = x[i].charAt(x[i].length() - 1);
			return lastChars;
		};
		
		String strings[] = {"priyan", "keerthana"};
		for (char c : charAtLast.lastCharacters(strings))
			System.out.println(c);
	}

}

@FunctionalInterface
interface Calci
{
	public int getAdd(int x, int y);
	
	default int factorial(int x) 
	{
		if (x < 2)
			return 1;
		return x * factorial(--x);
	}
	
	static int power(int x, int y)
	{
		if (y == 1)
			return x;
		if (y == 0)
			return 1;
		if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		return x * power(x, y / 2) * power(x, y / 2);
	}
}

@FunctionalInterface
interface StringManipulation
{
	public char[] lastCharacters(String[] arr);
}
