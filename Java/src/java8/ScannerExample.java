package java8;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scn = new Scanner(System.in)) {
			System.out.println(scn.nextLine());
			System.out.println(scn.nextInt());
		}
	}

}
