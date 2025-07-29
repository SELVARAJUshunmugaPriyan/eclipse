package lms;

public class UseMirror {
	public static void main (String[] args) {
		Mirror[] mirrors = new Mirror[3];
		mirrors[0] = new Mirror();
		mirrors[0].price = 0;
		
		int[] abc = new int[1];
		abc[0] = 42;
		
		String[] bcd = new String[1];
		bcd[0] = "abc";
		
		System.out.println(bcd[0]);
	}
}

class Mirror {
	int price;
}