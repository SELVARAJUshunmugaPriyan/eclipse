package exception;

public class InvalidProductExceptionCustom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cart[] = {"aeroplane", "umbrella", "knife", "dictionary"};
		
		for (String product : cart) {
			try {
				if (product.length() < 8)
					throw new InvalidProductException(product + " is invalid product");
			} catch (InvalidProductException ip) {
				System.err.println(ip); 
				continue;
			}
			
			System.out.println(product);
		}
	}

}

class InvalidProductException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	InvalidProductException(String msg)
	{
		super(msg);
	}
	
}