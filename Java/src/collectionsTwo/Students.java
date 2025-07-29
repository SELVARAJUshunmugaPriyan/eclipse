package collectionsTwo;

import java.util.HashMap;

public class Students {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> l = new HashMap<>();
		l.put(101, "Ajay");
		l.put(102, "Prabhu");
		l.put(103, "Vijay");
		l.put(104, "Rajesh");
		System.out.println(l);
		System.out.println(l.get(102));
		l.remove(104);
		System.out.println(l);
		l.put(103, "Anbu");
		System.out.println(l);
		System.out.println(l.keySet());
		System.out.println(l.values());
		l.forEach((x, y) -> System.out.println(x + " " + y));
		l.values().forEach(x -> System.out.println(x));
		l.keySet().forEach(y -> System.out.println(y + " " + 
										l.get(y)));
		for (String s : l.values())
			System.out.println(s);
		
		for (int i : l.keySet())
			System.out.println(i + " " + l.get(i));
	}

}
