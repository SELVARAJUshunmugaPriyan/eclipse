package lms;

public class TypeConversion {

	public static void main(String[] args) {
		
		int i = Integer.parseInt(args[0]);
		System.out.println(i);
		
		float f = Float.parseFloat(args[1]);
		System.out.println(f);
		
		double d = Double.parseDouble(args[2]);
		System.out.println(d);
		
		long l = Long.parseLong(args[3]);
		System.out.println(l);
		
		boolean b = Boolean.parseBoolean(args[4]);
		System.out.println(b);
		
		String s = args[5];
		System.out.println(s);
		
		char[] ca = args[6].toCharArray();
		System.out.println(ca);
		
		char c = args[6].charAt(0);
		System.out.println(c);
	}

}
