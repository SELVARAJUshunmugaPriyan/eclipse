package forThree;

public class NestedForSumEqualsTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] I = {3, 4, 5, 2, 6, 1, 7, 8, 1, 7, 4};
		
		for(int i = 0; i < I.length; i++)
			for(int j = 0; j < I.length; j++)
				if(I[i] + I[j] == 7)
					System.out.println("I[" + i + "]: " + I[i] + ", I[" + j + "]: " + I[j]);
	}

}
