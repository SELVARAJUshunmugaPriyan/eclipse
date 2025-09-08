package exception;

public class ExampleClassNotFoundException 
{

	public static void main(String[] args)
	{
		
		try {
			Class.forName("exception.ExampleClassNotFoundException");
			System.out.println("Class exists");
		} catch (ClassNotFoundException cnf) {
			System.out.println("Class does not exists");
		}
	}

}
