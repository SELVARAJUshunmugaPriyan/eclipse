package forThree;

public class NestedForSortOne {

	public static void main(String[] args) {
		
		int[] I = {9, 13, 74, 8, 4, 64, 79};
		
		for(int i = 0; i < I.length; i++)
			for(int j = i + 1; j < I.length; j++)
				if(I[i] > I[j]) {
					int temp = I[j];
					I[j] = I[i];
					I[i] = temp;
				}
		
		for(int i : I)
			System.out.print(i + " ");
	}

}
