package forTwo;

public class LoopsIndividualInitMaxVal {

	public static void main(String[] args) {
		
		int[] a = new int[7];
		
		a[0] = 12;
		a[1] = 13;
		a[2] = 19;
		a[3] = 98;
		a[4] = 123;
		a[5] = 34;
		a[6] = 68;
		
		int max = a[0];
		
		for(int i = 1; i < a.length; i++)
			if(a[i] > max)
				max = a[i];
		
		System.out.print(max);
	}

}
