package mathematicalAlgorithms;

import java.util.Arrays;

@SuppressWarnings("unused")
public class BasicProblems {
	
	private static final boolean DEBUG = true;
	
	private static int nthTermOfAP(Float a, Float d, Float n)
	{
		if (DEBUG) System.out.printf("int nthTermOfAP(Flt=%.0f,Flt=%.0f,Flt=%.0f)\n", a, d, n);
		
		if (n == 1)
			return Math.round(a);
		return nthTermOfAP(a + d, d, --n);
	}
	
	private static int nthTermOfAP(Integer a, Integer d, Integer n)
	{
		if (DEBUG) System.out.printf("int nthTermOfAP(Int=%d,Int=%d,Int=%d)\n", a, d, n);
		
		return a + (n - 1) * d;
	}
	
	private static int nthTermOfGP(Float a, Float r, Float n)
	{
		if (DEBUG) System.out.printf("int nthTermOfGP(Flt=%.0f,Flt=%.0f,Flt=%.0f)\n", a, r, n);
		
		if (n == 1)
			return Math.round(a);
		return nthTermOfGP(a * r, r, --n);
	}
	
	private static int nthTermOfGP(Integer a, Integer r, Integer n)
	{
		if (DEBUG) System.out.printf("int nthTermOfGP(Int=%d,Int=%d,Int=%d)\n", a, r, n);
		
		return (int) (a * Math.pow(r, n - 1));
	}
	
	private static boolean triangularNumber(Float n, Float ... var)
	{
		if (DEBUG) System.out.printf("int triangularNumber(Flt=%.0f)\n", n);
		
		int i = 1;
		if (var.length != 0)
			i = Math.round(var[0]);
		
		int ap = i * (i + 1) / 2;
		if (ap == Math.round(n))
			return true;
		else if (ap > Math.round(n))
			return false;
		
		return triangularNumber(n, (float) ++i);
	}
	
	private static boolean triangularNumber(float n)
	{
		if (DEBUG) System.out.printf("int triangularNumber(flt=%.0f)\n", n);
		
		int i = 1, ap = 0;
		
		do {
			ap += i++;
		} while (ap < n);
		
		if (ap == n)
			return true;
		
		return false;
	}
	
	private static boolean triangularNumber(int n)
	{
		if (DEBUG) System.out.printf("int triangularNumber(int=%d)\n", n);
		
		// i^2 + i - 2 * n = 0
		int a = 1, b = 1, c = -2 * n;
		
		double x = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		if (DEBUG) System.out.printf("x=%f\n", x);
		if (x > 0 && x == Math.floor(x))
			return true;
		
		x = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		if (DEBUG) System.out.printf("x=%f\n", x);
		if (x > 0 && x == Math.floor(x))
			return true;
		
		return false;
	}
	
	private static int sumOfSumsNNatNum(Float n)
	{
		if (DEBUG) System.out.printf("int sumOfSumsNNatNum(Flt=%.0f)\n", n);
		
		int sums = 0, sum = 0;
		for (int i = 1; i <= n; i++) {
			sums += i;
			sum += sums;
		}
		
		return sum;
	}
	
	private static int sumOfSumsNNatNum(float n)
	{
		if (DEBUG) System.out.printf("int sumOfSumsNNatNum(flt=%.0f)\n", n);
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i * (i + 1) / 2;
		}
		
		return sum;
	}
	
	private static int sumOfSumsNNatNum(int n)
	{
		if (DEBUG) System.out.printf("int sumOfSumsNNatNum(int=%d)\n", n);
		
		return n * (n + 1) * (n + 2) / 6;
	}
	
	private static int gcd(int a, int b)
	{
//		if (a == 0 || b == 0)
//			return 0;
//		
//		if (a == b)
//			return a;
//		
//		if (a > b)
//			return gcd(a - b, b);
//		return gcd(a, b - a);
		
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
	
	private static boolean coPrime(Float a, Float b)
	{
		if (DEBUG) System.out.printf("In coPrime(Flt=%.0f,Flt=%.0f)\n", a, b);
		
		return gcd(Math.round(a), Math.round(b)) == 1;
	}
	
	private static int gcdOfNNumbers(int[] arr)
	{
		if (DEBUG) System.out.printf("In gcdOfNNumbers(int=%s)\n", Arrays.toString(arr));
		
		if (arr.length == 0)
			return -1;
		
		int res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res = gcd(res, arr[i]);
			
			if (res == 1)
				return 1;
		}
		
		return res;
	}
	
	private static int gcdOfNNumbers(long[] arr)
	{
		if (DEBUG) System.out.printf("In gcdOfNNumbers(lng=%s)\n", Arrays.toString(arr));
		
		if (arr.length == 0)
			return -1;
		
		return (int) (Arrays.stream(arr).reduce((x, y) -> gcd((int) x, (int) y)).getAsLong());
	}
	
	private static int lcmOfNNumbers(Float[] arr)
	{
		if (DEBUG) System.out.printf("In lcmOfNNumbers(Flt=%s)\n", Arrays.toString(arr));
		
		if (arr.length == 0)
			return -1;
		
		int res = Math.round(arr[0]);
		for (int i = 1; i < arr.length; i++)
			res = res * Math.round(arr[i]) / gcd(res, Math.round(arr[i]));
		
		return res;
	}
	
	private static int lcmOfNNumbers(float[] arr)
	{
		if (DEBUG) System.out.printf("In lcmOfNNumbers(flt=%s)\n", Arrays.toString(arr));
		
		if (arr.length == 0)
			return -1;
		
		int lcm = 1, divisor = 2;
		while (true) {
			int counter = 0;
			boolean isDivisible = false;
			
			for (int i = 0; i < arr.length; i++) {
				
				if (arr[i] == 0)
					return 0;
				else if (arr[i] < 0)
					arr[i] *= -1;
				
				if (arr[i] == 1)
					counter++;
				
				if (arr[i] % divisor == 0) {
					isDivisible = true;
					arr[i] /= divisor;
					
					if (DEBUG) System.out.println(divisor + " " + Arrays.toString(arr) + " " + lcm);
				}
			}
			
			if (isDivisible)
				lcm *= divisor;
			else
				divisor++;
			
			if (counter == arr.length)
				return lcm;
		}
	}
	
	private static int lcmOfNNumbers(Double[] arr, int ... var)
	{
		if (DEBUG) System.out.printf("In lcmOfNNumbers(Dbl=%s)\n", Arrays.toString(arr));
		
		int i = 0;
		if (var.length != 0)
			i = var[0];
		
		if (i == arr.length - 1)
			return (int) Math.round(arr[i]);
		
		arr[i + 1] = arr[i] * arr[i + 1] / gcd((int) Math.round(arr[i]),
											(int) Math.round(arr[i + 1]));
		
		return lcmOfNNumbers(arr, ++i);
	}
	
	private static int lcmOfNNumbers(double[] arr, int ... var)
	{
		if (DEBUG) System.out.printf("In lcmOfNNumbers(dbl=%s)\n", Arrays.toString(arr));
		
		int i = 0;
		if (var.length != 0)
			i = var[0];
		
		if (i == arr.length - 1)
			return (int) Math.round(arr[i]);
		
		int a = (int) Math.round(arr[i]);
		int b = lcmOfNNumbers(arr, ++i);
		
		return a * b / gcd(a, b);
	}
	
	private static int lcmOfNNumbers(int[] arr)
	{
		if (DEBUG) System.out.printf("In lcmOfNNumbers(int=%s)\n", Arrays.toString(arr));
		
		return Arrays.stream(arr).reduce((x, y) -> x * y / gcd(x, y)).getAsInt();
	}
	
	private static int padovanSequence(Float n, int ... var)
	{
		if (DEBUG) System.out.printf("In padovanSequence(Flt=%.0f)\n", n);
		
		if (n < 3)
			return 1;
		
		int arr[] = new int[Math.round(n + 1)];
		if (var.length != 0)
			arr = var;
		
		if (arr[Math.round(n)] == 0)		
			arr[Math.round(n)] = padovanSequence(n - 2, arr) + padovanSequence(n - 3, arr);
		
		return arr[Math.round(n)];
	}
	
	private static int padovanSequence(float n)
	{
		if (DEBUG) System.out.printf("In padovanSequence(flt=%.0f)\n", n);
		
		if (n < 3)
			return 1;
		
		int arr[] = new int[Math.round(n + 1)];
		arr[0] = arr[1] = arr[2] = 1;
		
		for (int i = 3; i <= n; i++)
			arr[i] = arr[i - 3] + arr[i - 2];
		
		return arr[Math.round(n)];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(nthTermOfAP(5, 2, 10));
//		System.out.println(nthTermOfGP(2, 2, 4));
//		System.out.println(triangularNumber(11));
//		System.out.println(sumOfSumsNNatNum(24));
//		System.out.println(coPrime(29f, 4f));
//		System.out.println(gcdOfNNumbers(new long[] {2, 4, 6, 8, 16}));
//		System.out.println(lcmOfNNumbers(new int[] {1, 2, 8, 3}));
		System.out.println(padovanSequence(27f));
	}

}
