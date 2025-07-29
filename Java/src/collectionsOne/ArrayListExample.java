package collectionsOne;

import java.util.ArrayList;

public class ArrayListExample 
{
	static void sumOfSeries(ArrayList<Integer> I)
	{
		for (int i : I) {
			int sum = 0;
			for (int j = 1; j <= i; j++)
				sum += j;
			System.out.println(sum);
		}
	}
	
	static void additionOfSeries(ArrayList<Integer> I)
	{
		for (int i : I) {
			int sum = 0;
			int total = 0;
			for (int j = 1; j <= i; j++) {
				sum += j;
				total += sum;
//				System.out.println(j + " " + (sum - j) + " " + sum
//						+ "\n" + sum + " " + (total - sum) + " " + total + "\n");
			}
			System.out.println(total);
		}
	}
	
	static void evenCountOddCount(ArrayList<Integer> I)
	{
		int even = 0, odd = 0;
		for (int i : I)
			if (i % 2 == 0)
				even++;
			else
				odd++;
		System.out.println("Even count is " + even
				+ "\nOdd count is " + odd);
	}
	
	static void integerArrayList()
	{
		ArrayList<Integer> I = new ArrayList<>();
		I.add(12);
//		I.add(2, 13); // Error: IndexOutOfBoundsException
//		System.out.println(I.get(2)); // Error: IndexOutOfBoundsException
		I.add(14);
		I.add(13);
		I.add(35);
		I.add(3);
		I.add(5);
		I.add(0);
		I.add(-3);
		I.add(-8);
		I.add(0);
//		System.out.println(I);
		I.get(2);
		I.remove(0); // Removes the elements in index 0, not the
					 // element '0'. This happens only for int.
//		System.out.println(I.size());
		I.add(1, 16);
//		System.out.println(I);
		I.set(2, 16);
		I.add(2, 13);
//		System.out.println(I);
//		I.forEach(x -> System.out.println(x));
//		I.forEach(x -> {
//			if (x % 2 == 0)
//				System.out.println(x);
//		});
//		for (int i : I)
//			System.out.println(i);
//		for (int i = 0; i < I.length; i++)
//			System.out.println(i);
//		I.forEach(x -> if (x % 2 == 0) System.out.println(x)); // Syntax Error
//		additionOfSeries(I);
//		sumOfSeries(I);
		evenCountOddCount(I);
	}
	
	static void floatArrayList()
	{
		ArrayList<Double> F = new ArrayList<>();
		F.add(0.08);
		F.forEach(x -> System.out.println(x));
		F.remove(0.08);
		F.forEach(x -> System.out.println(x));
	}
	
	static String longString(ArrayList<String> S)
	{
		String min = S.get(0);
//		for (String s : S)
//			if (s.length() > max.length())
//				max = s;
		for (int i = 0; i < S.size(); i++)
			if (S.get(i).length() < min.length())
				min = S.get(i);
		return min;
	}
	
	static void stringArrayList() 
	{
		ArrayList<String> al = new ArrayList<>();
		al.add("My");
		al.add("name");
		al.add("is");
		al.add("Shunmuga");
		al.add("Priyan");
//		String max = "";
//		al.forEach(x -> {
//			if (x.length() > max.length())
//				max = x; // Error: local variable 'max' defined
//						 // in an enclosing scope must be final
//						 // or effectively final
//		});
//		System.out.println(max);
		System.out.println(longString(al));
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		integerArrayList();
//		floatArrayList();
//		stringArrayList();
	}

}
