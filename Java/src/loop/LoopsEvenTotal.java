package loop;

public class LoopsEvenTotal {

	public static void main(String[] args) {
		
		int total = 0;
		
		for (int i = 1; i <= 10; i++)
			if (i % 2 == 0)
				total += i;
				
		System.out.println(total);
	}

}
