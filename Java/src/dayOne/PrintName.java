package dayOne;

public class PrintName{

	public static void main(String[] args) {
		
		int intVal = 0;
		float floatVal = 0.25f;
		long longVal = 9176453505l;
		double doubleVal = 0.2525252525d;
		char charVal = 'S';
		boolean booleanVal = true;
		String stringVal = "Nisha";
		
		System.out.println(intVal);
		System.out.println(floatVal);
		System.out.println(longVal);
		System.out.println(doubleVal);
		System.out.println(charVal);
		System.out.println(booleanVal);
		System.out.println(stringVal);
		
		System.out.println(intVal 
				+ " " + floatVal
				+ " " + longVal
				+ " " + doubleVal
				+ " " + charVal
				+ " " + booleanVal
				+ " " + stringVal);
		
		System.out.println("my stringVal is " + stringVal);
	}

}
