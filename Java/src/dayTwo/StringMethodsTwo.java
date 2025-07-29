package dayTwo;

public class StringMethodsTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = new String("onesoft");
		String b = a.toUpperCase();
		String c = b.toLowerCase();
		String d = b.concat(" ").concat(c);
		int e = a.length();
		boolean f = a.equals("onesoft");
		boolean g = a.equalsIgnoreCase("oneSOft");
		boolean h = a.startsWith("one");
		boolean i = a.endsWith("oft");
		boolean j = a.contains(a.substring(0,a.length()));
		String k = a.substring(2,4);
		char l = a.charAt(3);
		int m = a.indexOf("eso");
		System.out.println("toUpperCase = " + b);
		System.out.println("toLowerCase = " + c);
		System.out.println("concat = " + d);
		System.out.println("length = " + e);
		System.out.println("equals = " + f);
		System.out.println("equalsIgnoreCase = " + g);
		System.out.println("startsWith = " + h);
		System.out.println("endsWith = " + i);
		System.out.println("contains = " + j);
		System.out.println("substring = " + k);
		System.out.println("charAt = " + l);
		System.out.println("indexOf = " + m);
	}

}
