package java8;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		
		try (Scanner scn = new Scanner(System.in)) {
			System.out.println(scn.nextLine());
			System.out.println(scn.nextInt());
		}
	}

}
