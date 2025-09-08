package collectionsThree;

import java.util.stream.Stream;

public class StreamIterate {

	public static void main(String[] args) {
		
		Stream<Integer> streamA = Stream
				.iterate(1, i -> i <= 20, i -> i * 2);
		streamA.forEach(System.out::println);
		
		Stream<Double> streamB = Stream
				.iterate(2.0, decimal -> decimal > 0.25,
							  decimal -> decimal / 2);
		streamB.forEach(System.out::println);
	}

}
