package exception;

public class ExampleException 
{

	@SuppressWarnings("null")
	public static void main(String[] args)
	{
		System.out.println("Start\n\n\n");
		
		// Arithmetic Exception
		try {
			System.err.println("Arithmetic Exception : \n");
			int a = 0, b= 0, c = a / b;
			System.out.println(c);
		} catch (ArithmeticException ae) {
//			System.err.println("Error occur");
			System.out.println(ae);
			System.out.println(ae.getMessage());
			ae.printStackTrace();
		}
		
		// Null pointer Exception
		try {
			System.err.println("\n\nNull pointer Exception : \n");
			String str = null;
			str.toCharArray();
		} catch (NullPointerException np) {
//			System.err.println("Error occur");
			System.out.println(np);
			System.err.println(np.getMessage());
			np.printStackTrace();
		}
		
		// Number format Exception
		try {
			System.err.println("\n\nNumber format Exception : \n");
			Integer.parseInt("abc");
		} catch (NumberFormatException nf) {
//					System.err.println("Error occur");
			System.out.println(nf);
			System.err.println(nf.getMessage());
			nf.printStackTrace();
		}
		
		// Index out-of bound Exception
		//
		// Array index out of bound Exception
		try {
			System.err.println("\n\nArray index out of bound Exception : \n");
			int arr[] = new int[0];
			arr[0] = 1;
		} catch (ArrayIndexOutOfBoundsException ab) {
//			System.err.println("Error occur");
			System.out.println(ab);
			System.err.println(ab.getMessage());
			ab.printStackTrace();
		}
		
		// String index out of bound Exception
		try {
			System.err.println("\n\nString index out of bound Exception : \n");
			String str = "";
			str.charAt(0);
		} catch (StringIndexOutOfBoundsException sb) {
//			System.err.println("Error occur");
			System.out.println(sb);
			System.err.println(sb.getMessage());
			sb.printStackTrace();
		}
		System.out.println("\n\n\nEnd");
	}
	
}
