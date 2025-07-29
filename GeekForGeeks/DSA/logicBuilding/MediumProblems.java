package logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.BiFunction;

@SuppressWarnings("unused")
public class MediumProblems {
	
	private static final boolean DEBUG = false;
	
	private int squareRoot(int n/*, int ... var*/)
	{
		// With iteration
//		int i = 1;
//		while (i * i++ <= n)
//			if (DEBUG) System.out.printf("In squareRoot(int n=%d) i=%d i*i++=%d\n",
//					n, i, i * i++);
//		return i - 2;
		// With recursion
//		int i = 1;
//		if (var.length > 0)
//			i = var[0];
//		if (i * i > n)
//			return --i;
//		return squareRoot(n, ++i);
		// With binary search
		int lo = 1, hi = n, res = 1;
		
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if (mid * mid <= n) {
				res = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		
		return res;
	}
	
	private double round(double d, int n)
			throws IllegalArgumentException
	{
		if (n < 0) throw new IllegalArgumentException("decimals cannot be less than zero");
		long factor = (long) Math.pow(10, n);
		long tmp = (long) Math.round(d * factor);
		return (double) tmp / factor;
	}
	
	private double squareRoot(double n)
	{
		double d = 1;
		
		while (d * d <= n)
			d++;
		
		double low = d - 1, high = d, mid = 0.0;
		
		while(low < high) {
			mid = (low + high) / 2;
			if (Math.abs(n - (mid * mid)) < 0.00000000001)
				return round(mid, 11);
			else if (mid * mid > n)
				high = mid;
			else
				low = mid;
		}
		
		return round(mid, 11);
	}
	
	private float squareRoot(float n)
	{
//		return (float) Math.sqrt(n);
		return (float) Math.exp(0.5 * Math.log(n));
	}
	
	private int countDivisors(int n)
	{
		int count = 0;
		for (int i = 1; i <= n; i++)
			if (n % i == 0)
				count++;
		return count;
	}
	
	private void numWith3Divisors(int n)
	{
		for (int i = 1; i <= n; i++) {
			if (countDivisors(i) == 3)
				System.out.println(i);
		}
	}
	
	private void numWith3Divisors(long n)
	{
		boolean isPrime[] = new boolean[(int) n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = true;
		
		for (int p = 2; p * p <= n; p++)
			if (isPrime[p])
				for (int i = 2 * p; i <= n; i += p)
					isPrime[i] = false;
		
		for (int i = 0; i * i <= n; i++)
			if (isPrime[i])
				System.out.println(i * i);
	}
	
	private boolean isDivisibleBy4(long n)
	{
//		return n % 4 == 0;
		return (n & 15) % 4 == 0;
	}
	
	private boolean isDivisibleBy4(String nmbr)
	{
		int len = nmbr.length();
		
		if (len == 1)
			return (nmbr.charAt(0) - '0') % 4 == 0;
		
		int scndLstDgt = nmbr.charAt(len - 2) - '0';
		int lstDgt = nmbr.charAt(len - 1) - '0';
		return (scndLstDgt * 10 + lstDgt) % 4 == 0;
	}
	
	private boolean isDivisibleBy11(long n)
	{
		return n % 11 == 0;
	}
	
	private boolean isDivisibleBy11(String nmbr)
	{
		int evenSum = 0, oddSum = 0;
		for (int i = 0; i < nmbr.length(); i++)
			if (i % 2 == 0)
				oddSum += nmbr.charAt(i) - '0';
			else
				evenSum += nmbr.charAt(i) - '0';
		return (evenSum - oddSum) % 11 == 0;
	}
	
	private boolean isDivisibleBy2N(long num, int i)
		throws IllegalArgumentException
	{
		int dgts = 0;
		
		while (i > 1) {
			if (i % 2 == 1)
				throw new IllegalArgumentException("Only powers of two are accepted.");
			dgts++;
			i /= 2;
		}
		
		return (num % Math.pow(10, dgts)) % i == 0;
	}
	
	private boolean isDivisibleBy2N(String nmbr, long i)
		throws IllegalArgumentException
	{
		int dgts = 0;
		long num = i;
		
		while (num > 1) {
			if (num % 2 == 1)
				throw new IllegalArgumentException("Only powers of two are accepted.");
			dgts++;
			num /= 2;
		}
		
		num = 0;
		for (int len = nmbr.length() - dgts ; dgts-- > 0; )
			num += (nmbr.charAt(len++) - '0') * Math.pow(10, dgts);
		
		return num % i == 0;
	}
	
	private boolean isDivisibleBy13(int n)
	{
		return n % 13 == 0;
	}
	
	private boolean isDivisibleBy13(String nmbr)
	{
		int len = nmbr.length(), tot = 0, altSign = 1;
		
		if (len % 3 == 1)
			nmbr = "00" + nmbr;
		else if (len % 3 == 2)
			nmbr = "0" + nmbr;
		
//		len = nmbr.length();
//		for (int i = 0; i < len; i += 3) {
//			int sum = 0;
//			sum += (nmbr.charAt(i) - '0') * 100 +
//				   (nmbr.charAt(i + 1) - '0') * 10 +
//				   (nmbr.charAt(i + 2) - '0');
//			tot += sum * altSign;
//			altSign *= -1;
//		}
		
		for (int i = nmbr.length() - 1; i >= 0; ) {
			int sum = 0;
			sum += (nmbr.charAt(i--) - '0')+
				   (nmbr.charAt(i--) - '0') * 10 +
				   (nmbr.charAt(i--) - '0') * 100;
			tot += sum * altSign;
			altSign *= -1;
		}
			
		return tot % 13 == 0;
	}
	
	private boolean isDivisibleBy13(long n)
	{
		int rem = 0;
		
		while (n > 0) {
			rem = (int) (rem * 10 + (n % 10)) % 13;
			n /= 10;
		}
		
		return rem == 0;
	}
	
	private byte kthDgtInARsd2B(int a, int b, int k)
	{
		long mod = (long) Math.pow(10, k);
		long res = 1;
		long base = a;
		
		while (b > 0) {
			if ((b & 1) == 1)
				res = (res * base) % mod;
				// res is multiplied only at 1s of 
				// bin(b) while being limited to last
				// mod digits
			base = (base * base) % mod;
			b >>= 1; // Divide by 2
		}
		
		for (int i = 1; i < k; i++)
			res /= 10;
		
		return (byte) res;
	}
	
	// Function to get last m digits of a * b without
	// overflowing
	private long abModm(long a, long b, long m)
	{
		long res = 0;
		a %= m;
		b %= m;
		
		while (b > 0) {
			if ((b & 1) == 1)
				res = (res + a) % m;
					 // Adding a for b times
					 // storing only the last m digits
			
			a <<= 1; // Multiply by 2
			b >>= 1; // Divide   by 2
		}
		
		return res;
	}
	
	private byte kthDgtInARsd2B(long a, long b, int k)
	{
		long mod = 1;
		long res = 1;
		
		for (int i = 0; i < k; i++)
			mod *= 10;
		
		for (int i = 0; i < b; i++)
			res = abModm(res, a, mod); // (a * b) % mod
		
		for (int i = 1; i < k; i++)
			res /= 10;
		
		return (byte) res;
	}
	
	// NOTE : the algorithm of kth(l, l, l) is based on limiting the results 
	// to last kth digits only.
	private byte kthDgtInARsd2B(long a, long b, long k)
	{
		long mod = (long) Math.pow(10, k);
		long res = 1;
		a %= mod;
		
		while (b-- > 0) {
			res *= a;
			res %= mod;
		}
		
		return (byte) Math.floor(res * 10 / mod);
	}
	
	private String recurringDecimal(int a, int b)
	{
		String nmbr[] = Double.toString((double) a / b)
//						.replaceFirst(".$", "")
						.split("\\.");
		
		String pattrn = "";
		nmbr[1] = nmbr[1].substring(0, 15);
		for (char c : nmbr[1].toCharArray()) {
			pattrn += c;
			if (nmbr[1].matches("(" + pattrn + ")+"))
				break;
		}
		
		if (pattrn.equals(nmbr[1]))
			return nmbr[0] + "." + nmbr[1];
		
		return nmbr[0] + ".(" + pattrn + ")";
	}
	
	private String recurringDecimal(long a, long b)
	{
		if (a == 0)
			return "0";
		
		String res = (a < 0 || b < 0) ? "-" : "";
		res = Long.toString(a / b);
		
		a = Math.abs(a);
		b = Math.abs(b);
		
		long rem = a % b;
		
		if (rem == 0)
			return res;
		
		res += ".";
		Map<Long, Integer> mp = new HashMap<>();
		
		while (rem > 0) {
			if (mp.containsKey(rem))
				return res.substring(0, mp.get(rem)) +
					   "(" + res.substring(mp.get(rem)) + ")";
			mp.put(rem, res.length());
			rem *= 10;
			res += Long.toString(rem / b);
			rem %= b;
		}
		
		return res;
	}
	
	// Test code
	private void func()
	{
		Map<Integer, Integer> mp = new HashMap<>();
		String num = "32727272727", res = "0.";
		
		for (char c : num.toCharArray()) {
			int i = c - '0';
			if (mp.containsKey(i)) {
				System.out.println(res.substring(0, mp.get(i)) +
					   "(" + res.substring(mp.get(i)) + ")");
				break;
			}
			mp.put(i, res.length());
			res += c;
		}
	}
	
	private String recurringSequence(int numr, int denr)
	{
		String res = "";
		
		Map<Integer, Integer> mp = new HashMap<>();
		int rem = numr % denr;
		
		while (rem != 0 && !mp.containsKey(rem)) {
			mp.put(rem, res.length());
			rem *= 10;
			int resPart = rem / denr;
			res += String.valueOf(resPart);
			rem %= denr;
		}
		
		if (rem == 0)
			return "No recurring sequence";
		else if (mp.containsKey(rem))
			return "Recurring sequence is " + res.substring(mp.get(rem));
		
		return res;
	}
	
	private int factorial(int n, int ... var)
	{
		int i = 0;
		
		if (var.length > 0)
			i = var[0];
		
		if (i > n) {
			i = n + i;
			n = i - n;
			i = i - n;
		}
		
		if (n == i)
			return n == 0 ? 1 : n;
		
		return n * factorial(--n, i);
	}
	
	private int nPr(int n, int r)
	{
		return factorial(n) / factorial(n - r);
	}
	
	private short nCr(short n, short r, Map<String, Short> mmtb)
	{
		String tple = n + "," + r;
		short val = 0;
		
		if (mmtb.containsKey(tple))
			return mmtb.get(tple);
		
		if (r > n)
			val = 0;
		else if (r == 0 || r == n)
			val = 1;
		else
			val = (short) (nCr((short) (n - 1), (short) (r - 1), mmtb) +
						   nCr((short) (n - 1), r, mmtb));
		
		if (DEBUG) System.out.println(mmtb);
		mmtb.put(tple, val);
		return val;
	}
	
	private short nCr(short n, short r)
	{
//		if (r > n)
//			return (short) 0;
//		if (r == 0 || r == n)
//			return (short) 1;
//		return (short) (nCr((short) (n - 1), (short) (r - 1)) +
//				nCr((short) (n - 1), r));
		Map<String, Short> mmtb = new HashMap<>();
		return nCr(n, r, mmtb);
	}
	
	private int nCr(int n, int r)
	{
		return factorial(n) / (factorial(r) * factorial(n - r));
	}
	
	private float nCr(float n, float r)
	{
//		float maxVal = Math.max(r, n - r);
//		float minVal = Math.min(r, n - r);
//		return factorial((int) n, (int) maxVal + 1) /
//			   factorial((int) minVal);
		return factorial((int) n, (int) (r > (n - r) ? r : (n - r)) + 1) /
			   factorial((int) (r < (n - r) ? r : (n - r)));
	}
	
	private double nCr(double n, double r)
	{
		double sum = 1;
		
		for (int i = 1; i <= r; i++)
			sum = sum * (n - r + i) / i;
		
		return (int) sum;
	}
	
	private long nCr(long n, long r)
	{
		Function<Long, Double> log = x -> {
			Double sum = 0.0;
			for (int i = 1; i <= x; i++)
				sum += Math.log(i);
			return sum;
		};
		
		return Math.round
			  (Math.exp(log.apply(n) -
					    log.apply(r) - 
					    log.apply(n - r))); 
	}
	
	private Integer nCr(Integer n, Integer r)
	{
		if (DEBUG) System.out.printf("In nCr(Int=%d,"
				+ "Int=%d)\n", n, r);
		double sum = 0;
		for (int i = 0; i < r; i++)
			sum += Math.log(n - i) - Math.log(i + 1);
		
		if (DEBUG) System.out.printf("sum=%f\n", sum);
		if (DEBUG) System.out.printf("Math.exp(%f)=%f\n", sum, Math.exp(sum));
		return (int) Math.round(Math.exp(sum));
	}
	
	private Float nCr(Float n, Float r)
	{
		if (DEBUG) System.out.printf("In nCr(Flt=%f,Flt=%f)\n", n, r);
		Float res = 1f;
		
		if (r > n - r)
			r = n - r;
		
		for (int i = 0; i < r; i++)
			res *= (n - i) / (i + 1);
		
		return res;
	}
	
	private void pascalTriangle(int n)
	{
		if (DEBUG) System.out.printf("In pascalTriangle(int=%d)\n", n);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++)
				System.out.print(" ");
				
			for (int j = 0; j <= i; j++)
				System.out.print(nCr(i, j) + " ");
			
			System.out.println();
		}
	}
	
	private void pascalTriangle(short n)
	{
		if (DEBUG) System.out.printf("In pascalTriangle(sht=%d)\n", n);
		
		BiFunction<Integer, Integer, Integer>
			bnmlCoeff = (nn, rr) -> {
				int res = 1;
				if (rr > nn - rr)
					rr = nn - rr;
				for (int i = 0; i < rr; i++) {
					res *= nn - i;
					res /= i + 1;
				}
				return res;
			};
			
		Function<Integer, List<List<Integer>>>
			psclGenTr = x -> {
				List<List<Integer>> lst = new ArrayList<>();
				for (int i = 0; i < x; i++) {
					List<Integer> lt = new ArrayList<>();
					for (int j = 0; j <= i; j++)
						lt.add(bnmlCoeff.apply(i, j));
					lst.add(lt);
				}
				return lst;
			};
			
		List<List<Integer>> lst = psclGenTr.apply(Integer.valueOf(n));
		
		for (int i = 0; i < lst.size(); i++) {
			for (int j = 0; j < lst.size() - i; j++)
				System.out.print(" ");
				
			for (int j = 0; j < lst.get(i).size(); j++)
				System.out.printf("%3d", lst.get(i).get(j));
			System.out.println();
		}
	}
	
	private void pascalTriangle(Integer n, Integer ... var)
	{
		if (DEBUG) System.out.printf("In pascalTriangle(Int=%d,Int...=%s)\n",
						   n, Arrays.toString(var));
		
		if (n == 0)
			return;
		
		Integer arr[] = new Integer[var.length + 1];
		
		if (var.length == 0)
			arr[0] = 1;
		else
			for (int i = 0; i < arr.length; i++)
				if (DEBUG) {
					Integer prev = (i - 1) < 0 ? 0 : var[i - 1];
					Integer next = i == var.length ? 0 : var[i];
					
					arr[i] = prev + next;
					System.out.printf("prev=%d next=%d arr[%d]=%d\n", prev, next, i, arr[i]);
				} else
					arr[i] = ((i - 1) < 0 ? 0 : var[i - 1]) + 
						 	 (i == var.length ? 0 : var[i]);
		
		for (int i = 0; i < n - 1; i++)
			System.out.print(" ");
			
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		
		pascalTriangle(--n, arr);
	}
	
	private void pascalTriangle(int n, int ... var)
	{
		if (DEBUG) System.out.printf("In pascalTriangle(int=%d,int...=%s)\n", n, Arrays.toString(var));
		List<List<Integer>> lst = new ArrayList<>();
		
		for (int row = 0; row < n; row++) {
			List<Integer> arr = new ArrayList<>();
			for (int i = 0; i <= row; i++)
				if (i == 0 || row == i)
					arr.add(1);
				else
					arr.add(lst.get(row - 1).get(i - 1) +
							lst.get(row - 1).get(i));
			lst.add(arr);
		}
		
		for (int row = 0; row < lst.size(); row++) {
			for (int i = 0; i < lst.size() - row; i++)
				System.out.print(" ");
			
			for (int i = 0; i < lst.get(row).size(); i++)
				System.out.print(lst.get(row).get(i) + " ");
			
			System.out.println();
		}
	}
	
	private void pascalTriangle(float n)
	{
		for (int row = 1; row <= n; row++) {
			int c = 1;
			
			for (int i = 0; i < n - row; i++)
				System.out.print(" ");
			
			for (int i = 1; i <= row; i++) {
				System.out.print(c + " ");
				c = c * ((int) row - i) / i;
				if (DEBUG) System.out.printf("row=%d i=%d>(%d) ", row, i, c);
			}
			System.out.println();
		}
	}
	
	private List<Integer> factorsOf(int n)
	{
		List<Integer> factors = new ArrayList<>();
		
		for (int i = 1; i <= n / 2; i++)
			if (n % i == 0)
				factors.add(i);
		
		return factors;
	}
	
	private List<Integer> factorsOf(Integer n)
	{
		List<Integer> factors = new ArrayList<>();
		
		for (int i = 1; i * i <= n; i++)
			if (n % i == 0)
				if (i * i == n)
					factors.add(i);
				else {
					factors.add(i);
					factors.add(n / i);
				}
		
		return factors;
	}
	
	private Set<Integer> primeFactorsOf(int n)
	{
		Set<Integer> factors = new HashSet<>();
		int num = n;
		
		for (int i = 2, j = 1; i * i <= n; i += j) {
			while (n % i == 0) {
				n /= i;
				factors.add(i);
			}
			
			if (i == 3)
				j++;
		}
		if (n > 2)
			factors.add(n);
		
		return factors;
	}
	
	private int[] computeSPF(int n)
	{
		int spf[] = new int[n + 1];
		
		for (int i = 0; i <= n; i++)
			spf[i] = i;
		
		for (int i = 2; i * i <= n; i++) {
			if (spf[i] == i)
				for (int j = i * i; j <= n; j += i)
					spf[j] = i;
		}
		
		return spf;
	}
	
	private Set<Integer> primeFactorsOf(Integer n)
	{
		Set<Integer> factors = new HashSet<>();
		int spf[] = computeSPF(n);
		
		while (n > 1) {
			factors.add(spf[n]);
			n /= spf[n];
		}
		
		return factors;
	}
	
	private int largestPrimeFactorOf(int n)
	{
		return Collections.max(primeFactorsOf(n));
	}
	
	private int largestPrimeFactorOf(Integer n)
	{
		int maxPrime = -1;
		
		while (n % 2 == 0) {
			maxPrime = 2;
			n /= 2;
		}
		
		while (n % 3 == 0) {
			maxPrime = 3;
			n /= 3;
		}
		
		for (int i = 5; i * i <= n; i += 6) {
			
			while (n % i == 0) {
				maxPrime = i;
				n /= i;
			}
			
			while (n % (i + 2) == 0) {
				maxPrime = i + 2;
				n /= (i + 2);
			}
		}
		
		if (n > 4)
			maxPrime = n;
		
		return maxPrime;
	}
	
	private int modularExp(int x, int n, int m)
	{
		for (int i = 1, cnst = x; i < n; i++) {
			x *= cnst;
			if (DEBUG) System.out.printf("x=%d ", x);
			x %= m;
			if (DEBUG) System.out.println("x=" + x);
		}
		
		return x;
	}
	
	private Integer modularExp(Integer x, Integer n, Integer m)
	{
		Integer res = 1;
		
		while (n > 0) {
			if (n % 2 == 1) {
				res = (res * x) % m;
				n--;
			} else {
				x = (x * x) % m;
				n /= 2;
			}
		}
		
		return res;
	}
	
	private int nthCatalanNumber(int n, Map<Integer, Integer> mmtb)
	{		
		if (n < 2)
			return 1;
		
		int res = 0;
		
		for (int i = 0; i < n; i++) {
			if (!mmtb.containsKey(i))
				mmtb.put(i, nthCatalanNumber(i, mmtb));
			int ci = mmtb.get(i);
			
			if (!mmtb.containsKey(n - 1 - i))
				mmtb.put(n - 1 - i, nthCatalanNumber(n - 1 - i, mmtb));
			int cn1i = mmtb.get(n - 1 - i);
			
			res += ci * cn1i;
		}
		
		return res;
	}
	
	private Integer nthCatalanNumber(Integer n)
	{
		if (DEBUG) System.out.printf("In nthCatalanNumber(Int=%d)\n", n);
		
		Integer arr[] = new Integer[n + 1];
		arr[0] = arr[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			arr[i] = 0;
			
			for (int j = 0; j < i; j++)
				arr[i] += arr[j] * arr[i - 1 - j];
		}
		
		if (DEBUG) System.out.println(Arrays.toString(arr));
		return arr[n];
	}
	
	private float nthCatalanNumber(float n)
	{
		float ans = nCr(Float.valueOf(2 * n), Float.valueOf(n));
		
		return ans / (n + 1);
	}
	
	private Float nthCatalanNumber(Float n)
	{
		if (n == 1)
			return 1f;
		
		return  ((4 * n - 2) / (n + 1)) * nthCatalanNumber(--n);
	}
	
	private int binomialCoeff(int n, int k)
	{
		if (k > n)
			return 0;
		
		// base condition
		if (k == 0 || k == n)
			return 1;
		
		return binomialCoeff(n - 1, k - 1) +
			   binomialCoeff(n - 1, k);
	}
	
	private int binomialCoeff(int n, int k, int mmtb[][])
	{
		if (k > n)
			return 0;
		
		// base condition
		if (k == 0 || k == n)
			return 1;
		
		if (mmtb[n][k] != 0) return mmtb[n][k];
		
		return mmtb[n][k] = binomialCoeff(n - 1, k - 1, mmtb) +
							binomialCoeff(n - 1, k, mmtb);
	}
	
	private Integer binomialCoeff(Integer n, Integer k)
	{
		int dp[][] = new int[n + 1][k + 1];
		
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= Math.min(i, k); j++)
				if (j == 0 || j == i)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
		
		return dp[n][k];
	}
	
	private float binomialCoeff(float n, float k)
	{
		int dp[] = new int[(int) k + 1];
		dp[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, (int) k); j > 0; j--)
				dp[j] = dp[j] + dp[j - 1];
			if (DEBUG) System.out.println(Arrays.toString(dp));
		}
		
		return dp[(int) k];
	}
	
	private void powerSet(String s)
	{
		/*
		 * 1  -
		 * 2  a
		 * 3  a b
		 * 4  a b c
		 * 5  a b c d
		 * 6  a b d
		 * 7  a c
		 * 8  a c d
		 * 9  a d
		 * 10 b
		 * 11 b c
		 * 12 b c d
		 * 13 b d
		 * 14 c
		 * 15 c d
		 * 16 d
		 */
		Set<String> pos = new TreeSet<>();
		
		for (int i = 0; i < (1 << s.length()); i++) {
			StringBuilder str = new StringBuilder();
			
			for (int j = 0; j < s.length(); j++)
				if ((i & (1 << j)) != 0)
					str.append(s.charAt(j));
			
			pos.add(str.toString());
		}
		
		System.out.println(pos);
	}
	
	private void powerSet(int i, String s, String f)
	{
		if (i == s.length()) {
			System.out.println(f);
			return;
		}
		
		powerSet(i + 1, s, f + s.charAt(i));
		powerSet(i + 1, s, f);
	}
	
	private void generatePermutations(List<List<Integer>> res,
									  int arr[], int idx)
	{
		if (idx == arr.length - 1) {
			List<Integer> tmp = new ArrayList<>();
			
			for (int i : arr)
				tmp.add(i);
			
			res.add(tmp);
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			if (DEBUG) System.out.println(Arrays.toString(arr));
			generatePermutations(res, arr, idx + 1);
			swap(arr, idx, i);
		}
	}
	
	private void swap(int arr[], int i, int j)
	{
		int tm = arr[i];
		arr[i] = arr[j];
		arr[j] = tm;
	}
	
	private <T> void swap(T arr[], int i, int j)
	{
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void nextPermutation(int arr[])
	{
		List<List<Integer>> res = new ArrayList<>();
		
		generatePermutations(res, arr, 0);
		
		Collections.sort(res, (a, b) -> {
											for (int i = 0; i < a.size(); i++)
												if (!a.get(i).equals(b.get(i)))
													return a.get(i) - b.get(i);
											return 0;
										});
		
		if (DEBUG) res.stream()
					  .forEach(x -> System.out.println(x));
		
		for (int i = 0; i < res.size(); i++) {
			boolean match = true;
			
			for (int j = 0; j < arr.length; j++)
				if (res.get(i).get(j) != arr[j]) {
					match = false;
					break;
				}
			
			if (match) {
				i = (i != (res.size() - 1)) ? i + 1 : 0;
				for (int j = 0; j < arr.length; j++)
					arr[j] = res.get(i).get(j);
				break;
			}
		}
	}
	
	private void nextPermutation(Integer arr[])
	{
		Function<Integer[], Integer> 
			getRytSmlrPos = x -> {
									int min = -1;
									for (int i = 0; i < x.length - 1; i++)
										if (x[i] < x[i + 1])
											min = i;
									return Integer.valueOf(min);
								 };
								 
		final Integer rytSmlrPos = getRytSmlrPos.apply(arr);
		
		if (rytSmlrPos != -1) {
			Function<Integer[], Integer>
				getRytGrtrPos = x -> {
										int grtr = rytSmlrPos;
										for (int i = x.length - 1; i >= 0; i--)
											if (x[i] > x[rytSmlrPos])
												return i;
										return rytSmlrPos;
									 };
	
			final Integer rytGrtrPos = getRytGrtrPos.apply(arr);
			
			swap(arr, rytSmlrPos, rytGrtrPos);
		}
		// Reversing the array starting from
		// Right-most smaller element position
		int middle = ((rytSmlrPos + arr.length) / 2) - rytSmlrPos;
		
		for (int i = 0; i < middle; i++)
			swap(arr, rytSmlrPos + 1 + i, arr.length - 1 - i);
	}
	
	private void nextPermutation(float arr[])
	{
		int pivot = -1, n = arr.length;
		
		for (int i = n - 2; i >= 0; i--)
			if (arr[i] < arr[i + 1]) {
				pivot = i;
				break;
			}
		
		if (pivot == -1) {
			reverse(arr, 0, n - 1);
			return;
		}
		
		for (int i = n - 1; i > pivot; i--)
			if (arr[i] > arr[pivot]) {
				swap(arr, i, pivot);
				break;
			}
		
		reverse(arr, pivot + 1, n - 1);
	}
	
	private void reverse(float arr[], int start, int end)
	{
		while (start < end)
			swap(arr, start++, end--);
	}
	
	private void swap(float arr[], int i, int j)
	{
		float tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MediumProblems medium = new MediumProblems();
//		System.out.println(medium.squareRoot(29f));
//		medium.numWith3Divisors(1000l);
//		System.out.println(medium.isDivisibleBy4(76952));
//		System.out.println(medium.isDivisibleBy4("36358839596066704387548752"));
//		System.out.println(medium.isDivisibleBy11(76945));
//		System.out.println(medium.isDivisibleBy11("1234567589333892"));
//		System.out.println(medium.isDivisibleBy2N("1129", 8));
//		System.out.println(medium.isDivisibleBy13(169));
//		System.out.println(medium.isDivisibleBy13(2911285l));
		// CHECKME Understand the algorithm of kthDgtInARsdB()
//		System.out.println(medium.kthDgtInARsd2B(999999, 999999, 9));
//		System.out.println(medium.abModm(625, 25, 10));
		// NOTE xxxx / 9999 returns 0.(xxxx)+
//		System.out.println(medium.recurringDecimal(22227, 99999));
//		medium.func();
//		System.out.println(medium.recurringSequence(50, 22));
//		System.out.println(medium.nPr(3, 3));
//		System.out.println(medium.nCr((short) 4, (short) 4));
//		System.out.println(medium.nCr(Integer.valueOf(5), Integer.valueOf(2)));
//		System.out.println(medium.factorial(5, 3));
//		medium.pascalTriangle(6f);
//		System.out.println(medium.factorsOf(Integer.valueOf(100)));
//		System.out.println(medium.primeFactorsOf(Integer.valueOf(999)));
//		System.out.println(medium.largestPrimeFactorOf(Integer.valueOf(999)));
//		System.out.println(medium.modularExp(Integer.valueOf(123), Integer.valueOf(11), Integer.valueOf(999)));
//		System.out.println(medium.nthCatalanNumber(Float.valueOf(8)));
//		System.out.println(medium.binomialCoeff(6f, 3f));
//		medium.powerSet(0, "abcd", "");
		float arr[] = {2, 4, 1, 7, 5, 0};
		medium.nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}

}