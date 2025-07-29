package logicStream;

import java.util.List;
import java.util.Arrays;

public class Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst = Arrays.stream(args[0].split(","))
								  .map(x -> Integer.parseInt(x))
								  .toList();
		lst.stream().filter(x -> x < 5)
					.map(x -> x + " " + lst.stream()
										   .filter(y -> x + y == 5)
										   .findFirst()
//										   .orElse(-1)
										   .get()
										   )
//					.filter(y -> !y.endsWith("-1"))
					.forEach(x -> System.out.println(x));
	}

}
