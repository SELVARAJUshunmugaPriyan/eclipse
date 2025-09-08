package forTwo;

public class LoopsEForOddCount {

	public static void main(String[] args) {
		
		int[] ia = {1, 31, 45, 62, 74, 85};
		int count = 0;
		
		for(int i : ia)
			if(i % 2 == 1)
				count++;
		
		System.out.print(count);
	}

}
