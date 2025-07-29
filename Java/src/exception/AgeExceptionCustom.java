package exception;

public class AgeExceptionCustom 
{

	public static void main(String[] args)
		throws AgeException
	{
		// TODO Auto-generated method stub
		System.out.println("Start");
		
		int age = 15;
		
		if (age >= 18)
			System.out.println("Eligible");
		else
			try {
				throw new AgeException("Not eligible");
			} catch (AgeException e) {
				e.printStackTrace();
			}
		
		System.out.println("End");
	}

}

class AgeException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AgeException(String msg)
	{
		super(msg);
	}
}
