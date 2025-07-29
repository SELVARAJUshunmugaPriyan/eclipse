package forThree;

public class NestedForSortTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] I = {9, 13, 74, 8, 4, 64, 79};
		
		for(int i = 0; i < 2; i++) {
			for(int j = i + 1; j < I.length; j++)
				if(I[j] > I[i]) {
					int temp = I[i];
					I[i] = I[j];
					I[j] = temp;
				}
		
		}
		System.out.print(I[1]);		
	}

}
