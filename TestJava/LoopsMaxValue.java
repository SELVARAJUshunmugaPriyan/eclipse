package forTwo;

public class LoopsMaxValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {12, 13, 19, 98, 123, 34, 68};
		int max = a[0];
		
		for(int i = 1; i < a.length; i++)
			if(a[i] > max)
				max = a[i];
		
		System.out.print(max);
	}

}
