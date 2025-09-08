package forThree;

public class NestedForSumEqualsOne {

	public static void main(String[] args) {
		
		int[] I = {3, 4, 5, 2, 6, 1, 7, 8, 1, 7, 4};
		
		for(int i : I)
			for(int j : I)
				if(i + j == 7)
					System.out.println(i + ", " + j);
	}

}
