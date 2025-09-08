package lms;

public class TaskOne {
	// Sum and Average
	public static void main(String[] args) {
		
		int i1 = Integer.parseInt(args[0]);
		int i2 = Integer.parseInt(args[1]);
		int i3 = Integer.parseInt(args[2]);
		int i4 = Integer.parseInt(args[3]);
		int i5 = Integer.parseInt(args[4]);
		
		int sum = i1 + i2 + i3 + i4 + i5;
		int avg = sum / 5;
		
		System.out.println("Sum = " + sum);
		System.out.println("Average = " + avg);
	}

}
