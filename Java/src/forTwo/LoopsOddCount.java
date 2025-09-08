package forTwo;

public class LoopsOddCount {

	public static void main(String[] args) {
		
		int[] ia = {7, 89, 56, 24, 73, 39, 58};
		int count = 0;
		
		for(int i = 0; i < ia.length; i++)
			if(ia[i] % 2 != 0)
				count++;
		
		System.out.print(count);
	}

}
