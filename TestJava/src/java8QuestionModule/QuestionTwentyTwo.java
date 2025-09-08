package java8QuestionModule;

import java.util.Scanner;
import java.util.Optional;
import java.util.NoSuchElementException;

public class QuestionTwentyTwo {

	public static void main(String[] args) {
		
		Optional<Object[]> objs;
		String[] str = null;
		
		try (Scanner scn = new Scanner(System.in)) {
			int len = -1;
			while (len < 1) {
				System.out.println("Enter a non-zero positive integer");
				
				try {
					len = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					continue;
				}
			}
			
			str = new String[len];
			
			System.out.println("Enter the strings:");
			
			for (int i = 0; i < len; i++)
				str[i] = scn.nextLine();
		} catch (NoSuchElementException e) {
			System.out.println("Closing System.in resource");
		}
		
		objs = Optional.ofNullable(str);
		
		if (objs.isPresent()) {
			Object[] obj = objs.get();
			for(Object o : obj) 
				if (o != null) {
					String s = (String) o;
					System.out.println(s.toUpperCase() + " " + s.length());
				}
		} else
			System.out.println("given Array is null");
	}

}
