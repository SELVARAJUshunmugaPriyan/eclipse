package forTwo;

public class LoopsEForSumArray {

	public static void main(String[] args) {
		
		int[] ia = {12, 16, 22, 35};
		int sum = 0;
		
		for(int i : ia)
			sum += i;
		
		System.out.print(sum);
	}

}
