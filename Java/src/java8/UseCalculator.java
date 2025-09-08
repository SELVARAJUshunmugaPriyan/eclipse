package java8;

public class UseCalculator {
	
	public int findMax(int arr[])
	{
		int max = arr[0];
		
		for (int i : arr)
			if (i > max)
				max = i;
		
		return max;
	}

	public static void main(String[] args) {
		
		MyClass mc = new MyClass();
		Calculator calc = mc::findMax;
//		Calculator calc = new UseCalculator()::findMax;
		System.out.println(calc.getMax(
				new int[] {1, -1, 4, 0, 12, 9}));
	}

}

class MyClass {
	
	public int findMax(int arr[])
	{
		int max = arr[0];
		
		for (int i : arr)
			if (i > max)
				max = i;
		
		return max;
	}
	
}

@FunctionalInterface
interface Calculator
{
	public int getMax(int arr[]);
}
