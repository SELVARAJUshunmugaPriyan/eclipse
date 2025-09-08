package arrays;

public class CombineArrays {

	public static void main(String[] args) {
		
		int A[] = {1, 2, 3, 4};
		int B[] = {5, 6, 7};
		int C[] = new int[A.length + B.length];
		int i = 0;
		for (int j = 0; j < A.length; j++)
			C[i++] = A[j];
		for (int j = 0; j < B.length; j++)
			C[i++] = B[j];
		for (int j = 0; j < C.length; j++)
			System.out.println(C[j]);
	}

}
