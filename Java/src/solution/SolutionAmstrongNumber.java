package solution;

public class SolutionAmstrongNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long i = 0;
		for(i = 0; i < Long.MAX_VALUE; i++)
			;
		System.out.print(i);
//			if(amstrongNum(i))
//				System.out.println(i + " is a Amstrong number");
//			else
//				System.out.println(i + " is not a Amstrong number");
	}
	
	public static boolean amstrongNum(int num) {
		int n = (int) Math.log10(num) + 1, sum = 0, temp = num;
		
		for(int i = 1; i <= n; i++) {
			int r = temp % 10;
			sum += power(r, n);
			temp /= 10;
		}
		
		if(sum == num)
			return true;
		
		return false;
	}
	
	static int power(int x, long y)
    {
        if (y == 0)
            return 1;
        if (y % 2 == 0)
            return power(x, y / 2) * power(x, y / 2);
        return x * power(x, y / 2) * power(x, y / 2);
    }
	
}