package lms;

public class TaskFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = args[0].split(",");
		int b = Integer.parseInt(a[0]);
		int c = Integer.parseInt(a[1]);
		int d = Integer.parseInt(a[2]);
		int e = b + c + d;
		int avg = e / 3;
		System.out.print(avg);
	}

}
