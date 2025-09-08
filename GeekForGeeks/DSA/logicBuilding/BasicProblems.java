package logicBuilding;

@SuppressWarnings("unused")
public class BasicProblems {
	
	private static final boolean DEBUG = false;
	
	private String checkEvenOrOdd(int i)
	{
		if (DEBUG) System.out.printf("In checkEvenOrOdd(%d)\n", i);
		return (i % 2 == 0) ? "even" : "odd";
	}
	
	private <T> String checkEvenOrOdd(T i)
	{
		if (DEBUG) System.out.printf("In checkEvenOrOdd(%d)"
				+ " with Bitwise AND (&) operator \n", i);
		return ((Integer) i & 1) == 0 ? "even" : "odd";
	}
	
	private void printMulTable(int i)
	{
		if (DEBUG) System.out.printf("In printMulTable(%d)\n", i);
		for (int j = 1; j <= 10; j++)
			System.out.printf("%2d * %2d = %2d\n", i, j, i * j);
	}
	
	private void printMulTable(double n, int ... val)
	{
		int i = 1;
		
		if (val.length != 0)
			i = val[0];
		else
			if (DEBUG) System.out.printf("In printMulTable(%d)"
					+ "using recursive and varargs (...)\n", i);
		
		if (i == 11)
			return;
			
		System.out.printf("%2d * %2d = %2d\n", (int) n,
				i, (int) n * i++);
			
		printMulTable(n, i);
	}
	
	private int sumOfNaturals(int n)
	{
		if (n == 1)
			return 1;
		else
			return n + sumOfNaturals(--n);
	}
	
	private int sumOfNaturals(double n)
	{
		return (int) (n * (n + 1) / 2);
	}
	
	private int sumOfSqrNaturals(int n)
	{
		if (n == 1)
			return 1;
		else
			return n * n + sumOfSqrNaturals(--n);
	}
	
	private int sumOfSqrNaturals(double n)
	{
		return (int) (n * (n + 1) * (2 * n + 1)) / 6;
	}
	
	private <T> void swap(T i, T j)
	{
		if (DEBUG) System.out.println("In swap(T, T)");
		System.out.println("i=" + i + " j=" + j);
		T tmp = i;
		i = j;
		j = tmp;
		System.out.println("i=" + i + " j=" + j);
	}
	
	private void swap(int i, int j)
	{
		if (DEBUG) System.out.println("In swap(int, int)");
		System.out.println("i=" + i + " j=" + j);
		j = i + j;
		if (DEBUG) System.out.println("i=" + i + " j=" + j);
		i = j - i;
		if (DEBUG) System.out.println("i=" + i + " j=" + j);
		j = j - i;
		System.out.println("i=" + i + " j=" + j);
	}
	
	private String binVal(int i)
	{
		if (i == 1)
			return "1";
		return binVal(i / 2) + (i % 2 == 0 ? "0" : "1");
	}
	
	private void swap(double i, double j)
	{
		if (DEBUG) System.out.println("In swap(double, double)");
		System.out.println("i=" + (int) i + " j=" + (int) j);
		if (DEBUG) System.out.println("i=" + binVal((int) i) 
			+ " j=" + binVal((int) j));
		i = (int) i ^ (int) j;
		if (DEBUG) System.out.println("i=i^j=" + binVal((int) i) 
			+ " j=" + binVal((int) j));
		j = (int) i ^ (int) j;
		if (DEBUG) System.out.println("i=" + binVal((int) i) 
			+ " j=i^j=" + binVal((int) j));
		i = (int) i ^ (int) j;
		if (DEBUG) System.out.println("i=i^j=" + binVal((int) i)
			+ " j=" + binVal((int) j));
		System.out.println("i=" + (int) i + " j=" + (int) j);
	}
	
	private int ceilingM(int n, int m)
	{
		return n + m - n % m;
	}
	
	private int closestNumDivByM(int n, int m)
	{
		int q = n / m, n1 = m * q;
		if (DEBUG) System.out.printf("q=%d n1=%d\n", q, n1);
		int n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1));
		// Increasing quotient when n and m have same sign
		// leads to closest number. If they have different signs
		// decreasing quotient leads to closest number
		if (DEBUG) System.out.printf("n2=%d\n", n2);
		if (Math.abs(n - n1) < Math.abs(n - n2))
			return n1;
		return n2;
	}
	
	private int closestNumDivByM(double n, double m)
	{
		int i = (int) n, j = Math.abs((int) m), closest = 0;
		int minDiff = Integer.MAX_VALUE;
		for (int k = i - j; k <= i + j; k++)
			if (k % m == 0) {
				int diff = Math.abs(i - k);
				if (diff < minDiff || (diff == minDiff && 
						// If diff(s) are equal we are taking 
						// absolute largest number (ceiling)
						Math.abs(k) > Math.abs(closest))) {
					closest = k;
					minDiff = diff;
				}
			}
		return closest;
	}
	
	private int diceProblem(float f)
	{
		if (DEBUG) System.out.println("In diceProblem(float)");
		return 7 - ((int) f);
	}
	
	private int diceProblem(int i)
	{
		if (DEBUG) System.out.println("In diceProblem(int)");
		switch (i) {
		case 1 : return 6;
		case 2 : return 5;
		case 3 : return 4;
		case 4 : return 3;
		case 5 : return 2;
		default: return 1;
		}
	}
	
	private int nthTermOfAP(int a1, int a2, int n)
	{
		int i = 1, diff = a2 - a1;
		while (i++ < n)
			a1 += diff;
		return a1;
	}
	
	private int nthTermOfAP(double a1, double a2, int n,
			int ... val)
	{
		int i = 1, diff = (int) (a2 - a1), sum = (int) (a1);
		
		if (DEBUG) System.out.printf("In nthTermOfAp(dbl, dbl)\n");
		
		if (val.length > 0) {
			i = val[0];
			sum = val[1];
		}
		
		if (i++ == n)
			return sum;
		
		return nthTermOfAP(a1, a2, n, i, sum + diff);
	}
	
	private int nthTermOfAP(float a1, float a2, int n)
	{
		return (int) (a1 + (n - 1) * (a2 - a1));
	}

	public static void main(String[] args) {
		
		BasicProblems basic = new BasicProblems();
//		System.out.println(basic.checkEvenOrOdd(Integer.valueOf(3)));
//		basic.printMulTable(5);
//		basic.printMulTable(5.0);
//		System.out.println(basic.sumOfNaturals(10));
//		System.out.println(basic.sumOfNaturals(10.0));
//		System.out.println(basic.sumOfSqrNaturals(2));
//		System.out.println(basic.sumOfSqrNaturals(10.0));
//		basic.swap(1.0, 2.0);
//		System.out.println(basic.binVal(16));
//		System.out.println(basic.closestNumDivByM(-15.0, 6.0));
//		for(int i = 1; i < 7; i++) System.out.println(i + " " +
//				basic.diceProblem(i));
//		System.out.println(basic.nthTermOfAP(1.0, 3, 10));
	}

}
