package dayTwo;

public class StringMethods {

	public static void main(String[] args) {
		
		String a = "hello";
		String b = a.toUpperCase();
		String c = b.toLowerCase();
		String d = b.concat(c);
		
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
//		System.out.println("hello".toUpperCase());
		
		int e = a.length();
		System.out.println(e);
//		System.out.println("Hello".length());
		
		String f = "java";
		
		boolean g = f.equals("java");
//		g = f.equals("JAVA");
//		g = f.equals("JaVA");
		
		boolean h = f.equalsIgnoreCase("JAVa");
		
		boolean i = f.startsWith("j");
//		i = f.startsWith("J");
		
		boolean j = f.endsWith("a");
//		j = f.endsWith("A");
		
		boolean k = f.contains("a");
		k = f.contains("j");
		
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		
		String l = "onesoft";
		int m = l.indexOf("o");
		char n = l.charAt(3);
		String o = l.substring(2,5);
//		o = l.substring(2);
		
		System.out.println(m);
		System.out.println(n);
		System.out.println(o);
	}

}
