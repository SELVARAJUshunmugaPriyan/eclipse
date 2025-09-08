package conditions;

public class ConditionsStringPluralOrSingular {

	public static void main(String[] args) {
		
		String s = "cats";
		
		if (s.endsWith("s")) {
			System.out.println("plural");
		} else {
			System.out.println("Singular");
		}
	}

}
