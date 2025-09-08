package mathematicalAlgorithms;

import java.util.Queue;
import java.util.Arrays;
import java.util.Vector;
import java.util.Random;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.BiFunction;

@SuppressWarnings("unused")
public class HardProblems {
	
	private static final boolean DEBUG = true;
	
	private static boolean isFeasible1Jug(int m, int n, int d)
	{
		if (DEBUG) System.out.printf("In isFeasible1Jug(int=%d,int=%d,int=%d)\n", m, n, d);
		
		if (d > m && d > n)
			return false;
		
		Recur<BiFunction<Integer, Integer, Integer>> gcd = new Recur<>();
		gcd.func = (x, y) -> x == 0 ? y : gcd.func.apply(y % x, x) ;
		
		return d % gcd.func.apply(m, n) == 0;
	}
	
	private static boolean isFeasible2Jug(int m, int n, int d)
	{
		if (DEBUG) System.out.printf("In isFeasible2Jug(int=%d,int=%d,int=%d)\n", m, n, d);
		
		if (d > m + n)
			return false;
		
		Recur<BiFunction<Integer, Integer, Integer>> gcd = new Recur<>();
		gcd.func = (x, y) -> x == 0 ? y : gcd.func.apply(y % x, x) ;
		
		return d % gcd.func.apply(m, n) == 0;
	}
	
	private static int minSteps1Jug(int m, int n, int d)
	{
		if (DEBUG) System.out.printf("In minSteps1Jug(int=%d,int=%d,int=%d)\n", m, n, d);
		
		if (d > m && d > n)
			return -1;
		
		Queue<int[]> queue = new LinkedList<>();
		boolean visitd[][] = new boolean[m + 1][n + 1];
		int array[] = {0, 0, 0};
		
		queue.add(array);
		
		while(!queue.isEmpty()) {
			array = queue.poll();
			int jug1 = array[0], jug2 = array[1], steps = array[2];
			
			if (d == jug1 || d == jug2)
				return steps;
			
			if (!visitd[m][jug2]) {
				visitd[m][jug2] = true;
				queue.add(new int[] {m, jug2, steps + 1});
			}
			
			if (!visitd[jug1][n]) {
				visitd[jug1][n] = true;
				queue.add(new int[] {jug1, n, steps + 1});
			}
			
			if (!visitd[0][jug2]) {
				visitd[0][jug2] = true;
				queue.add(new int[] {0, jug2, steps + 1});
			}
			
			if (!visitd[jug1][0]) {
				visitd[jug1][0] = true;
				queue.add(new int[] {jug1, 0, steps + 1});
			}
			
			int pour1to2 = Math.min(jug1, n - jug2);
			if (!visitd[jug1 - pour1to2][jug2 + pour1to2]) {
				visitd[jug1 - pour1to2][jug2 + pour1to2] = true;
				queue.add(new int[] {jug1 - pour1to2, jug2 + pour1to2, steps + 1});
			}
			
			int pour2to1 = Math.min(m - jug1, jug2);
			if (!visitd[jug1 + pour2to1][jug2 - pour2to1]) {
				visitd[jug1 + pour2to1][jug2 - pour2to1] = true;
				queue.add(new int[] {jug1 + pour2to1, jug2 - pour2to1, steps + 1});
			}
			
			if (DEBUG)
				for (int[] arr : queue)
					System.out.println(Arrays.toString(arr));
		}
		
		return -1;
	}
	
	private static Vector<Integer> segmentedSieve(int n)
	{
		int limit = (int) Math.sqrt(n);
		Vector<Integer> prime = new Vector<>();
		simpleSieve(limit, prime);
		
		int low = limit, high = 2 * limit;
		
		while (low < n) {
			
			if (high >= n)
				high = n;
			
			boolean mark[] = new boolean[limit + 1];
			Arrays.fill(mark, true);
			
			for (int i = 0; i < prime.size(); i++) {
				int loLim = (int) (low / prime.get(i)) * prime.get(i);
				if (loLim < low)
					loLim += prime.get(i);
				
				for (int j = loLim; j < high; j += prime.get(i))
					mark[j - low] = false;						
			}
			
			for (int i = low; i < high; i++)
				if (mark[i - low])
					prime.add(i);
			
			low += limit;
			high += limit;
		}
		
		return prime;
	}
	
	private static void simpleSieve(int n, Vector<Integer> prime)
	{
		boolean isPrime[] = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		
		for (int p = 2; p * p <= n; p++)
			if (isPrime[p])
				for (int i = p * p; i <= n; i += p)
					isPrime[i] = false;
		
		for (int i = 2; i <= n; i++)
			if (isPrime[i])
				prime.add(i);
				
		if (DEBUG) System.out.println(prime);
	}
	
	private static int kthPrimeFactor(Float n, Float k)
	{
		if (DEBUG) System.out.printf("In kthPrimeFactor(Flt=%.0f,Flt=%.0f)\n", n, k);
		
		while (n % 2 == 0) {
			n /= 2;
			k--;
			if (DEBUG) System.out.print(2 + " ");
			if (k == 0)
				return 2;
		}
		
		for (int i = 3; i * i <= n; i+= 2)
			while (n % i == 0) {
				n /= i;
				k--;
				if (DEBUG) System.out.print(i + " ");
				if (k == 1)
					return i;
			}
		
		if (n > 2 && k == 1)
			return Math.round(n);
		
		if (DEBUG) System.out.println();
		return -1;
	}
	
	private static int kthPrimeFactor(float n, float k)
	{
		if (DEBUG) System.out.printf("In kthPrimeFactor(flt=%.0f,flt=%.0f)\n", n, k);
		
		int minPf[] = new int[(int) n + 1];
		boolean pFnd[] = new boolean[(int) n + 1];
		
		for (int i = 2; i <= n; i += 2)
			minPf[i] = 2;
		
		for (int i = 3; i <= n; i += 2)
			if (!pFnd[i]) {
				minPf[i] = i;
				for (int j = i; i * j <= n; j += 2)
					if (!pFnd[i * j]) {
						pFnd[i * j] = true;
						minPf[i * j] = i;
					}
			}
		
		while (n > 1) {
			if (k == 1)
				return minPf[(int) n];
			k--;
			n /= minPf[(int) n];
		}
		
		return -1;
	}
	
	// ^
	// | Below function does arrow function (↑)
	private static int inverseArrow(Float n, Float base, Float k)
	{
		if (DEBUG) System.out.printf("In inverseArrow(Flt=%.0f,Flt=%.0f,Flt=%.0f)\n",
				n, base, k);
		
		while (nthRoot(Double.valueOf(n), Double.valueOf(base)) != -1) {
			if (--k == 1)
				return nthRoot(Double.valueOf(n), Double.valueOf(base));
			n = (float) nthRoot(Double.valueOf(n), Double.valueOf(base));
		}
		
		return -1;
	}
	
	private static int nthRoot(Double n, Double k)
	{
		if (DEBUG) System.out.printf("In nthRoot(Dbl=%.0f,Dbl=%.0f)\n", n, k);
		
		double low = 1;
		double hig = n;
		
		while (low <= hig) {
			int mid = (int) (low + hig) / 2;
			
			if (Math.pow(mid, k) == n)
				return mid;
			
			if (Math.pow(mid, k) > n)
				hig = mid - 1;
			else
				low = mid + 1;
		}
		
		return -1;
	}
	
	private static int nthRoot(long n, long k)
	{
		if (DEBUG) System.out.printf("In nthRoot(lng=%d,lng=%d)\n", n, k);
		
		long low = 1, hig = n, ans = -1, mid;
		
		while (low < hig) {
			mid = (int) (low + hig) / 2;
			long x = mid;
			
			// real n-th root stops by kth iterations
			for (int i = 0; i < k; i++) {
				x *= mid;
				if (x > n) // This only deters over-projected cases
					break;
			}
			
			if (x == n) {
				ans = mid;
				break;
			} else if (x > n)
				hig = mid - 1;
			else
				low = mid + 1;
		}
		
		return (int) ans;
	}
	
	private static double nthRoot(int n, int k)
	{
		if (DEBUG) System.out.printf("In nthRoot(int=%d,int=%d)\n", n, k);
		
		if (k == 1)
			return n;
		
		Random random = new Random();
		double xK = random.nextInt(10) + 1, xPre = xK, delX = Double.MAX_VALUE,
			   accuracy = 1e-3;
		
		while (delX > accuracy) {
			xK = ((k - 1.0) * xPre + (double) n / Math.pow(xPre, k - 1)) / (double) k;
			delX = Math.abs(xPre - xK);
			xPre = xK;
		}
		
		return xK;
	}
	
	private static int sumOfDigits(Function<Integer, Vector<Integer>> func, int n)
	{
		if (DEBUG) System.out.printf("In sumOfDigits(F<I,V<I>>=%s,int=%d)\n",
						   func.getClass(), n);
		
		return (int) func.apply(n).stream()
								  .reduce(0, (x, y) -> x + y);
	}
	
	private static int sumOfDigits(BiFunction<Integer, Integer, String> func, int n)
	{
		if (DEBUG) System.out.printf("In sumOfDigits(bF<null,I,V<I>>=%s,int=%d)\n",
						   func.getClass(), n);
		
		return (int) func.apply(null, n).chars()
								  		.map(x -> x - '0')
								  		.reduce(0, (x, y) -> x + y);
	}
	
	// FIXME
	private static int eggDrop(Float n, Float ... var)
	{
		if (DEBUG) System.out.printf("In eggDrop(Flt=%.0f,Flt=%.0f)\n", n,
				(var.length > 0) ? var[0] : 1);
		
		float i = (var.length > 0) ? var[0] : 1 ;
		if (n - i <= 0)
			return Math.round(n);
		return eggDrop(n - i, ++i);
	}
	
	private static int eggDrop(float n, float k)
	{
		if (DEBUG) System.out.printf("In eggDrop(flt=%.0f,flt=%.0f)\n", n, k);
		
		if (k == 1 || k == 0)
			return (int) k;
		
		if (n == 1)
			return (int) k;
		
		int res = Integer.MAX_VALUE;
		
		for (int i = 1; i <= k; i++) {
			int cur = 1 + Math.max(eggDrop(n - 1, i - 1), eggDrop(n, k - i));
			if (cur < res)
				res = cur;
		}
		
		return res;
	}
	
	private static int eggDrop(Double n, Double k, int memo[][])
	{
		if (DEBUG) System.out.printf("In eggDrop(Dbl=%.0f,Dbl=%.0f,%s)\n", n, k,
							Arrays.deepToString(memo));
		
		int intK = (int) Math.round(k);
		int intN = (int) Math.round(n);
		
		if (intK == 1 || intK == 0)
			return memo[intN][intK] = intK;
		
		if (intN == 1)
			return memo[intN][intK] = intK;
		
		if (memo[intN][intK] == 0) {
			int res = Integer.MAX_VALUE;
			for (int i = 1; i <= k; i++) {
				int cur = 1 + Math.max(eggDrop(n - 1, i - 1.0, memo), eggDrop(n, k - i, memo));
				if (cur < res)
					res = cur;
			}
			
			memo[intN][intK] = res;
		}
		
		return memo[intN][intK];
	}
	
	private static int eggDrop(Long n, Long k, int dp[][])
	{
		if (DEBUG) System.out.printf("In eggDrop(Lng=%d,Lng=%d,%s)\n", n, k,
							Arrays.deepToString(dp));
		
		int intK = (int) Math.round(k), intN = (int) Math.round(n), cnt = 0;
		
		while (dp[cnt][intN] < intK) {
			cnt++;
			
			for (int i = 1; i <= intN; i++) {
				dp[cnt][i] = 1 + dp[cnt - 1][i - 1] + dp[cnt - 1][i];
			}
		}
		
		if (DEBUG) System.out.println(Arrays.deepToString(dp));
		return cnt;
	}
	
	private static int eggDrop(Long n, Long k, int dp[])
	{
		if (DEBUG) System.out.printf("In eggDrop(Lng=%d,Lng=%d,%s)\n", n, k,
							Arrays.toString(dp));
		
		int intK = (int) Math.round(k), intN = (int) Math.round(n), cnt = 0;
		
//		outerloop:
		while (dp[intN] < intK) {
			cnt++;
			
			for (int i = intN; i >= 1; i--) {
				dp[i] += 1 + dp[i - 1];
//				if (dp[i] >= intK)
//					break outerloop;
			}
		}
		
		if (DEBUG) System.out.println(Arrays.toString(dp));
		return cnt;
	}

	private static String nextString(StringBuilder str)
	{
		if (DEBUG) System.out.printf("In nextString(SB=%s)\n", str);
		if (str.length() == 0)
			return "a";
		
		int i = str.length() - 1;
		
		while (i > -1 && str.charAt(i) == 'z')
			i--;
		
		if (i > -1)
			str.setCharAt(i, (char) (str.charAt(i) + 1));
		else
			str.insert(i = 0, 'a');
		
		i++;
		
		while (i < str.length())
			str.setCharAt(i++, 'a');
		
		return str.toString();
	}
	
	private static String nextString(String str)
	{
		if (DEBUG) System.out.printf("In nextString(Str=%s)\n", str);
		
		if (str == "")
			return "a";
		
		int i = str.length() - 1;
		while (i >= 0 && str.charAt(i) == 'z')
			i--;
		
		if (i == -1)
			str = str + 'a';
		else
			str = str.substring(0, i) + (char) (str.charAt(i) + 1) + str.substring(i + 1);
		
		return str;
	}
	
	public static void main(String[] args) {
		
//		System.out.println(isFeasible2Jug(5, 3, 4));
//		System.out.println(minSteps1Jug(5, 3, 3));
//		simpleSieve(100, new Vector<Integer>());
//		System.out.println(segmentedSieve(100));
//		System.out.println(kthPrimeFactor(28f, 3f));
//		for (float i = 2; i < 24; i++)
//			System.out.println(nthRoot((float) Math.pow(2, Math.pow(2, i)), i));
//		System.out.println(nthRoot(81, 2));
//		System.out.println(inverseArrow(512f, 3f, 3f));
//		Function<Integer, Vector<Integer>>
//			factorial = i -> {
//				Vector<Integer> res = new Vector<>();
//				res.add(1);
//				while (i > 1) {
//					int carry = 0;
//					for (int j = res.size() - 1; j >= 0; j--) {
//						int pr = res.get(j) * i + carry;
//						res.set(j, pr % 10);
//						carry = pr / 10;
//					}
//					while (carry > 0) {
//						res.addFirst(carry % 10);
//						carry /= 10;
//					}
//					i--;
//				}
//				return res;
//			};
//		BiFunction<Integer, Integer, String>
//			factorialInStr = (x, i) -> {
//				StringBuilder str = new StringBuilder();
//				str.append(1);
//				while (i > 1) {
//					int carry = 0;
//					for (int j = str.length() - 1; j >= 0; j--) {
//						int pr = (str.charAt(j) - '0') * i + carry;
//						str.setCharAt(j, (char) (pr % 10 + '0'));
//						carry = pr / 10;
//					}
//					while (carry > 0) {
//						str.insert(0, (char) (carry % 10 + '0'));
//						carry /= 10;
//					}
//					i--;
//				}
//				return str.toString();
//			};
//		System.out.println(factorialInStr.apply(null, 1000));
//		System.out.println(eggDrop(2l, 10l, new int[3]));
		System.out.println(nextString(""));
	}

}
