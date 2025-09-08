package forTwo;

public class LoopsSumArray {

	public static void main(String[] args) {
		
		int[] ia = new int[3];
		
		int sum = 0;
		
		ia[0] = 12;
		ia[1] = 13;
		ia[2] = 14;
		
		for(int i = 0; i < ia.length; i++)
			sum += ia[i];
		
		System.out.print(sum);
	}

}
