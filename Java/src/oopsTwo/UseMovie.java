package oopsTwo;


class Movie
{
	public String getFightSequence(int fights)
	{
		return "It has " + fights + " fights in that movie.";
	}
}

class ActionMovie
{
	public String getFightSequence(int fights)
	{
		if (fights == 3)
			return "It has " + fights + " fights. It is a normal"
					+ " action movie.";
		else if (fights == 4)
			return "It has " + fights + " fights. It is a good"
			+ " action movie.";
		else if (fights > 4)
			return "It has " + fights + " fights. It is a fully"
			+ " packed action movie.";
		else
			return "It is a normal movie.";
	}
}

public class UseMovie 
{

	public static void main(String[] args) 
	{
		
		ActionMovie a = new ActionMovie();
		System.out.println(a.getFightSequence(3));
		System.out.println(a.getFightSequence(4));
		System.out.println(a.getFightSequence(10));
		System.out.println(a.getFightSequence(1));
		Movie m = new Movie();
		System.out.println(m.getFightSequence(1));
	}

}
