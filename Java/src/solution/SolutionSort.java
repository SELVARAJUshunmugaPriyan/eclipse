package solution;
public class SolutionSort {
	public static void main(String[] args) {
		int len = args.length - 1, i = 0;
		int[] A = new int[len + 1];
		for(String arg : args)
			A[i++] = Integer.parseInt(arg);
		for(i = 0; i <= len; i++)
			for(int j = i + 1; j <= len; j++) {
				int temp;
				if(A[j] < A[i]) {
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		for(int j : A)
			System.out.println(j);
	}

}
