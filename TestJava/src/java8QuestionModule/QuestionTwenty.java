package java8QuestionModule;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class QuestionTwenty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scn  = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter two numbers:");
				
				double a, b;
				
				try {
					a = Double.parseDouble(scn.nextLine());
					b = Double.parseDouble(scn.nextLine());
				} catch (NumberFormatException e) {
					continue;
				}
				
				System.out.println("Enter operation (+, -, *, /, %, ^, &, |, <<, >>, <, >, ==, !=, <=, >=)");
				
				String operation;
				
				try {
					operation = scn.nextLine();
					
					if (!operation.matches("[\\+\\-\\*\\/\\%\\^\\&\\|(\\<\\<)(\\>\\>)\\<\\>(\\=\\=)(\\!\\=)(\\<\\=)(\\>\\=)]+")) // +-*/%^&|<<>><>==!=<=>=
						throw new IllegalArgumentException();
				} catch (IllegalArgumentException e) {
					continue;
				}
				
				String res = "";
				switch (operation) {
				case "+" :
					res += a + b;
					break;
				case "-" :
					res += a - b;
					break;
				case "*" :
					res += a * b;
					break;
				case "/" :
					res += a / b;
					break;
				case "%" :
					res += a % b;
					break;
				case "^" :
					res += Math.pow(a, b);
					break;
				case "&" :
					res += (int) a & (int) b;
					break;
				case "|" :
					res += (int) a | (int) b;
					break;
				case "<<" :
					res += (int) a << (int) b;
					break;
				case ">>" :
					res += (int) a >> (int) b;
					break;
				case "<" :
					res += a < b;
					break;
				case ">" :
					res += a > b;
					break;
				case "==" :
					res += a == b;
					break;
				case "!=" :
					res += a != b;
					break;
				case "<=" :
					res += a <= b;
					break;
				case ">=" :
					res += a >= b;
					break;
				}
				
				System.out.println("Result=" + res);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Closing System.in resource");
		}
	}

}
