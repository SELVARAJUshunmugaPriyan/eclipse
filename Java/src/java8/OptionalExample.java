package java8;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		
		Optional<String> a = Optional.of("hi");
		System.out.println(a);
		Optional<String> b = Optional.of("hi");
		System.out.println(b);
		Optional<String> c = Optional.of("hi");
		System.out.println(c);
		
		if (c.isPresent())
			System.out.println(c);
		else
			System.out.println("Value is not present");
		
		String d = null;
		Optional<String> d1 = Optional.ofNullable(d);
		System.out.println(d1);
	}

}
