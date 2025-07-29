package oopsTwo;

class TeachingExercise
{
	public int findingMaximum(int a, int b)
	{
		if (a > b)
			return a;
		else
			return b;
	}
	
	public String findingMaximum(String a, String b)
	{
		if (a.length() > b.length())
			return a;
		else
			return b;
	}
	
	public int findingMaximum(int a, int b, int c)
	{
		if (a > b && a > c)
			return a;
		else if (b > a && b > c)
			return b;
		else
			return c;
	}
	
	public int add(int a, int b)
	{
		return a + b;
	}
	
	public long add(int a, long b)
	{
		return a + b;
	}
	
	public long add(long a, long b)
	{
		return a + b;
	}
}

public class UseTeachingExercise 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		TeachingExercise t = new TeachingExercise();
		
		System.out.println(t.findingMaximum(2, 3));
		System.out.println(t.findingMaximum("abc", "ab"));
		System.out.println(t.findingMaximum(2, 3, 1));
		System.out.println(t.add(2, 3));
		System.out.println(t.add(2, 3100000000000l));
		System.out.println(t.add(3100000000000l, 3100000000000l));
	}

}
