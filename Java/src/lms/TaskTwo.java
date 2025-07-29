package lms;

public class TaskTwo {
	// String Manipulation
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] t = args[0].split(",");
		
		System.out.println(t[1].toUpperCase());
		System.out.println("The last letter of " 
				+ t[0] + " is "
				+ t[0].charAt(t[0].length() - 1) + ".");
	}

}
