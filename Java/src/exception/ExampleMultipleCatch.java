package exception;

public class ExampleMultipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0, b = 1;
		String str = "2";
		try {
			int c = a / b;
			System.out.println(c);
			System.out.println(Integer.parseInt(str));
			str.charAt(1);
		} catch (ArithmeticException/* | StringIndexOutOfBoundsException*/ ae) {
			System.out.println(ae);
		} catch (NumberFormatException nf) {
			System.out.println(nf);
//		} catch (StringIndexOutOfBoundsException sb) {
//			System.out.println(sb);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
