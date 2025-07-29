package popularProblems;

@SuppressWarnings("unused")
public class BinaryStrings {
	
	private static final boolean DEBUG = true;
	
	private static int trailOfOnes(float n)
	{
		if (DEBUG) System.out.printf("In trailOfOnes(flt=%.0f)\n", n);
		int lmt = (1 << (int) n) - 1, count = 0;
		
		for (int i = 0; i <= lmt; i++)
			if (Integer.toBinaryString(i).contains("11"))
				count++;
		
		return count;
	}
	
	private static int trailOfOnes(double n)
	{
		if (DEBUG) System.out.printf("In trailOfOnes(dbl=%.0f)\n", n);
		int lmt = (1 << (int) n) - 1, count = 0;
		
		for (int i = 0; i <= lmt; i++) {
			int msk = 3;
			while (msk <= i) {
				if ((msk & i) == msk) {
					count++;
					break;
				}
				msk <<= 1;
			}
		}
		
		return count;
	}
	
	private static int trailOfOnes(long n)
	{
		if (DEBUG) System.out.printf("In trailOfOnes(lng=%d)\n", n);
		
		if (n < 2)
			return 0;
		int nn = (int) n;
		return trailOfOnes(nn - 1) + trailOfOnes(nn - 2) +
			   (1 << (nn - 2));
	}
	
	private static int trailOfOnes(int n)
	{
		if (DEBUG) System.out.printf("In trailOfOnes(int=%d)\n", n);
		
		int dp[] = new int[n + 1], power[] = new int[n - 1];
		
		dp[0] = dp[1] = 0;
		power[0] = 1;
		
		for (int i = 1; i < n - 1; i++)
			power[i] = 2 * power[i - 1];
		
		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 2] + dp[i - 1] + power[i - 2];
		
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int count = 0;
//		for (int i = 0; i < 128; i++)
//			if (Integer.toBinaryString(i).contains("11"))
//				System.out.printf("%07d %3d\n", Integer.valueOf(Integer.toBinaryString(i)), ++count);
//			else
//				System.out.printf("%07d\n", Integer.valueOf(Integer.toBinaryString(i)));
		
		System.out.println(trailOfOnes(12));
	}

}
