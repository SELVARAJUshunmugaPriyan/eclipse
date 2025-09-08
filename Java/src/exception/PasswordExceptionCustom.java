package exception;

public class PasswordExceptionCustom 
{

	public static void main(String[] args) 
	{
		
		String passwords[] = {"abc", "12345678@", "@", "12345678"};
		
		for (String password : passwords)
			try {
				if (password.length() < 8 || !password.contains("@"))
					throw new PasswordException("Password \"" + password +
							"\" is invalid");
				System.out.println("Password \"" + password +
						"\" is valid");
			} catch (PasswordException p) {
				p.printStackTrace();
			}
	}

}

class PasswordException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PasswordException(String msg)
	{
		super(msg);
	}
	
}