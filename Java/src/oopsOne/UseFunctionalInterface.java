package oopsOne;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface Interface 
{
	abstract int get();
	
	default int getter()
	{
		return 2;
	}
	
	static void set() 
	{
		System.out.println("set");
	}
}

public class UseFunctionalInterface {
	
	int getImplementd()
	{
		return 5;
	}

	public static void main(String[] args) {
		
		UseFunctionalInterface j = new UseFunctionalInterface();
		Interface i = j::getImplementd;
		System.out.println(i.getter());
		System.out.println(i.get());
		Interface.set();
		Consumer<String> consumer = (value) -> System.out.println(value);
		consumer.accept("keerthana");
		Predicate<String> predicate = (value) -> value.startsWith("a");
		System.out.println(predicate.test(""));
		BiFunction<Integer, Integer, Boolean> function = (l, k) -> l == k;
		System.out.println(function.apply(2, 3));
	}

}
