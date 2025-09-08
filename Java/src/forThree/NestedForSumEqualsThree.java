package forThree;

public class NestedForSumEqualsThree {

	public static void main(String[] args) {
		
		int[] I = {3, 4, 5, 2, 6, 1, 7, 8, 1, 7, 4};
		
		for(int i = 0; i < I.length; i++)
			for(int j = i + 1; j < I.length; j++)
				if(I[i] + I[j] == 7)
					System.out.println(I[i] + ", " + I[j]);
	}

	
}
