package lms;

public class SolutionSecondLargest {

	public static void main(String[] args) {
		
		String[] a = args[0].split(",");
		
		int[] A = new int[a.length];
		int i = 0;
		for(String s: a)
			A[i++] = Integer.parseInt(s);
		for(i = 0; i < A.length; i++) {
			int b = 0;
			for(int j = i + 1; j < A.length; j++) {
				if(A[j] > A[i]) {
					b = A[i];
					A[i] = A[j];
					A[j] = b;
				}
			}
		}
		
		System.out.print(A[1]);
	}

}
