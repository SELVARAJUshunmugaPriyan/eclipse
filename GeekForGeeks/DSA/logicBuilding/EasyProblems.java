package logicBuilding;

import java.util.HashMap;
import java.util.ArrayList;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.function.Function;
import java.util.function.BiFunction;

@SuppressWarnings("unused")
public class EasyProblems {
	private static final boolean DEBUG = true;
	
	private int sumOfDigits(float f)
	{
		if (DEBUG) System.out.println("In sumOfDigits(flt)");
		if ((int) f == 0)
			return 0;
		return ((int) f) % 10 + sumOfDigits(f / 10);
	}
	
	private int sumOfDigits(double d)
	{
		if (DEBUG) System.out.println("In sumOfDigits(dbl)");
		int sum = 0, n = (int) d;
		for (; n > 0; n /= 10)
			sum += n % 10;
		return sum;
	}
	
	private int sumOfDigits(int i)
	{
		if (DEBUG) System.out.println("In sumOfDigits(int)");
		String str = Integer.toString(i);
		int sum = 0;
		
		for (char c : str.toCharArray())
			sum += c - '0';
		
		return sum;
	}
	
	private int reverseDigits(int i, int ... var)
	{
		if (DEBUG) System.out.printf("In reverseDigits(int=%d)\n",
				i);
		int rev = i % 10, q = i / 10;
		
		if (var.length > 0)
			rev += var[0] * 10;
		
		if (q == 0)
			return rev;
		
		return reverseDigits(q, rev);
	}
	
	private int reverseDigits(float f, float ... var)
	{
		int rev = 0;
		if (DEBUG) System.out.println("In reverseDigits(flt)");
		
		for (int n = (int) f; n > 0; n /= 10)
			rev = (rev * 10) + n % 10;
		
		return rev;
	}
	
	private int reverseDigits(double d, double ... var)
	{
		if (DEBUG) System.out.println("In reverseDigits(dbl)");
		return Integer.parseInt(String.valueOf(new StringBuffer(
				String.valueOf((int) d)).reverse()));
	}
	
	private boolean isPrime(double d, double ... var)
	{
		int n = (int) d, i = 2;
		
		if (var.length > 0)
			i = (int) var[0];
		
		if (i == n)
			return true;
		
		if (DEBUG) System.out.printf("In isPrime(dbl=%.0f,"
				+ " %d)\n", d, i);
		
		if (n % i == 0 || n < 2)
			return false;
			
		if (!isPrime(d, ++i))
				return false;
			
		return true;
	}
	
	private boolean isPrime(float f, float ... var)
	{
		if (DEBUG) System.out.printf("In isPrime(flt=%.0f)\n", f);
		for (int i = 2; i < f; i++)
			if (f % i == 0)
				return false;
		return true;
	}
	
	private boolean isPrime(long l, long ... var)
	{
		if (DEBUG) System.out.printf("In isPrime(lng=%d)\n", l);
		for (int i = 2; i * i <= l; i++) {
			if (DEBUG) System.out.printf("i=%d i*i=%d\n", i, i * i);
			if (l % i == 0)
				return false;
		}
		return true;
	}
	
	private boolean isPrime(int n, int ... var)
	{
		if (DEBUG) System.out.printf("In isPrime(int=%d)\n", n);
		if (n == 2 || n == 3)
			return true;
		if (n < 2 || n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6) {
			if (DEBUG) System.out.printf("i=%d i+2=%d i*i=%d\n",
					i, i + 2, i * i);
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}
	
	private boolean isPowerOf(double e, double n, double ... var)
	{
		if (DEBUG) System.out.printf("In isPowerOf(dbl=%.0f,%.0f)\n",
				e, n);
		if (n == 1 || e == n)
			return true;
		else if (e > n)
			return false;
		
		double d, f;
		if (var.length > 0)
			f = var[0];
		else
			f = e;
		d = f * e;
//		if (DEBUG) System.out.printf("e=%.0f n=%.0f"
//				+ " e^i=%.0f\n", e, n, d);
		
		return isPowerOf(d, n, f);
	}
	
	private boolean isPowerOf(long e, long n)
	{
		if (DEBUG) System.out.printf("In isPowerOf(lng=%d,lng=%d)\n",
				e, n);
		if (e == 1)
			return (n == 1);
		
		long pow = 1;
		while (pow < n)
			pow *= e;
		
		return (pow == n);
	}
	
	private boolean isPowerOf(int e, long n)
	{
		if (DEBUG) System.out.printf("In isPowerOf(int=%d,lng=%d)\n",
				e, n);
		if (e == 1 || n == 1)
			return (n == 1);
		
		long pow = e;
		while (pow < n)
			pow *= pow;
		
		if (pow == n)
			return true;
		
		long low = e, high = pow;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			long res = (long) Math.pow(e, (int) (Math.log(mid) / 
					Math.log(e)));
			if (res == n)
				return true;
			else if (res > n)
				high = mid - 1;
			else
				low = low + 1;
		}
		
		return true;
	}
	
	private boolean isPowerOf(int e, int n)
	{
		if (DEBUG) System.out.printf("In isPowerOf(int=%d,int=%d)\n",
				e, n);
		double resl = Math.log(n) / Math.log(e);
		return resl == Math.floor(resl);
	}
	
	private double distBetween(double x1, double y1, double x2,
			double y2)
	{
		return Math.sqrt(Math.pow(x2 - x1, 2) + 
				Math.pow(y2 - y1, 2));
	}
	
	private boolean isTriangleValid(int a, int b, int c)
	{
		return (a + b) > c && (c + a) > b && (b + c) > a;
	}
	
	private boolean doesOverlap(Point l1, Point r1, Point l2, Point r2)
	{
//		// If the rectangles are across horizontally
//		if (l1.x > r2.x || l2.x > r1.x)
//			return false;
//		// If the rectangles are across vertically
//		if (r1.y > l2.y || r2.y > l1.y)
//			return false;
//		return true;
		// Using pointInPolygon() method
//		/*
		ArrayList<Point> polygon = new ArrayList<>();
		
		polygon.add(new Point(r2.x, r2.y)); // Bottom-right corner
		polygon.add(new Point(r2.x, l2.y)); // Top-right corner
		polygon.add(new Point(l2.x, l2.y)); // Top-left corner
		polygon.add(new Point(l2.x, r2.y)); // Bottom-left corner
		
		if (pointInPolygon(new Point(r1.x, r1.y), polygon) ||
			pointInPolygon(new Point(r1.x, l1.y), polygon) ||
			pointInPolygon(new Point(l1.x, l1.y), polygon) ||
			pointInPolygon(new Point(l1.x, r1.y), polygon))
			
			return true;
		
		return false;
//		*/
	}
	
	private boolean pointInPolygon(Point point, ArrayList<Point> polygon)
	{
		Path2D path = new Path2D.Double();
		// Move to the first point in the polygon
		path.moveTo(polygon.get(0).x, polygon.get(0).y);
		// Connect the points in the polygon
		for (int i = 0; i < polygon.size(); i++)
			path.lineTo(polygon.get(i).x, polygon.get(i).y);
		// Close the path
		path.closePath();
		// Create a 2D point object for the test point
		Point2D testPoint = new Point2D.Double(point.x, point.y);
		// Check if the test point is inside the polygon
		return path.contains(testPoint);
	}
	
	private long factorial(long l)
	{
		for (long i = l - 1; i > 1; i--)
			l *= i;
		return l == 0 ? 1 : l;
	}
	
	private double factorial(double d)
	{
		if (d < 2)
			return 1;
		return d * factorial(--d);
	}
	
	private int countCubePair(long l)
	{
		int count = 0;
		for (int i = 1; Math.pow(i, 3) < l; i++) {
			int j = (int) Math.pow(i, 3), k = 0;
			while (Math.pow(++k, 3) + j < l)
				continue;
			if (Math.pow(k, 3) + j == l)
				count++;
		}
		return count;
	}
	
	private int countCubePair(double d)
	{
		int count = 0;
		for (int i = 1; i <= Math.cbrt(d); i++) {
			int cb = (int) Math.pow(i, 3);
			int diff = (int) d - cb;
			int cbDiff = (int) Math.cbrt(diff);
			if (diff == Math.pow(cbDiff, 3))
				count++;
		}
		return count;
	}
	
	private void countCubePair(float f)
	{
		int cbroot = (int) Math.cbrt(f);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 1; i < cbroot; i++)
			for(int j = i + 1; j <= cbroot; j++) {
				int sum = i * i * i + j * j * j;
				if (sum != f)
					continue;
				map.put(i, j);
			}
		map.forEach((k, v) -> System.out.printf("(%d, %d) ", k, v));
	}
	
	private float gcd(float x, float y)
	{
//		float lmt = x < y ? x : y, div = 1;
//		for (int i = 1; i < lmt; i++)
//			if (x % i == 0 && y % i == 0)
//				div = i;
//		return div;
		float res = Math.min(x, y);
		while (res-- > 0)
			if (x % res == 0 && y % res == 0)
				return res;
		return 1.0f;
	}
	
	private int gcd(int x, int y)
	{
		if (x == 0)
			return y;
		if (y == 0)
			return x;
		if (x == y)
			return (int) x;
		if (x > y)
			return gcd(x - y, y);
		return gcd(x, y - x);
	}
	
	private double gcd(double x, double y)
	{
//		if (x == 0 || x % y == 0)
//			return y;
//		if (y == 0 || y % x == 0)
//			return x;
//		if (x == y)
//			return x;
//		if (x > y)
//			return gcd(x - y, y);
//		else
//			return gcd(x, y - x);
		if (x == 0)
			return y;
		if (y == 0)
			return x;
		if (x == y)
			return x;
		if (x > y) {
			if (y % x == 0)
				return x;
			return gcd(x - y, y);
		} else {
			if (x % y == 0)
				return y;
			return gcd(x, y - x);
		}
	}
	
	private long gcd(long x, long y)
	{
		return (y == 0) ? x : gcd(y, x % y);
	}
	
	private float lcm(float x, float y)
	{
		for (float f = Math.max(x, y); f < x * y; f += Math.max(x, y))
			if (f % Math.min(x, y) == 0)
				return f;
		return x * y;
	}
	
	private long lcm(long x, long y)
	{
		return (x * y) / gcd(x, y);
	}
	
	private boolean isPerfectNum(float f)
	{
		ArrayList<Integer> div = new ArrayList<>();
		for (int i = 1; i < f; i++)
			if (f % i == 0)
				div.add(i);
		return div.stream().mapToInt(Integer::intValue).sum()
			   == f;
	}
	
	private boolean isPerfectNum(double d)
	{
		int sum = 0;
		for (int i = 1; i < d; i++)
			if (d % i == 0)
				sum += i;
		return sum == d;
	}
	
	private boolean isPerfectNum(long l)
	{
		int sum = 1;
		for (int i = 2; i * i <= l; i++)
			if (l % i == 0)
				if (i * i != l)
					sum += i + l / i;
				else
					sum += i;
		return sum == l;
	}
	
	private int[] sumOfFractions(int a[], int b[])
	{
		int dnm = (int) lcm(a[1], b[1]);
		a[0] = a[0] * dnm / a[1];
		b[0] = b[0] * dnm / b[1] + a[0];
		b[1] = dnm;
		int gcd = gcd(b[0], b[1]);
		b[0] /= gcd;
		b[1] /= gcd;
		return b;
	}
	
	private ArrayList<Integer> sumOfFractions(ArrayList<Integer> a,
			ArrayList<Integer> b)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		int den = gcd(a.get(1), b.get(1));
		den = (a.get(1) * b.get(1)) / den;
		int num = a.get(0) * den / a.get(1) + b.get(0) * den / b.get(1);
		num /= gcd(num, den);
		den /= gcd(num, den);
		res.add(num);
		res.add(den);
		return res;
	}
	
//	private int dayOfWeek(int d, int m, int y)
//	{
//		int[] monthCode = {6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
//		
//		monthCode[1] = (y % 4 == 0) ? 1 : 2;
//		
//		int yearCode = y % 100;
//		yearCode = (int) (yearCode * 1.25) % 7;
//		if (y / 10 >= 100 && y / 10 <= 199)
//			yearCode += 5;
//		else if (y / 10 >= 200 && y / 10 <= 299)
//			yearCode += 3;
//		else if (y / 10 >= 300 && y / 10 <= 399)
//			yearCode += 1;
//		
//		return (d + monthCode[m] + yearCode) % 7 + 1;
//	}
	
//	private int dayOfWeek(int d, int m, int y)
//	{
//		int[] monthCode = {6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
//		if (m < 3)
//			y--;
//		int yC = (y % 100) + (y % 100) / 4;
//		yC = (yC + (y / 100) / 4 + 5 * (y / 100)) % 7;
//		return (d + monthCode[m - 1] + yC) % 7;
//	}
	
	private int dayOfWeek(int d, int m, int y)
	{
		int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
		if (m < 3)
			y--;
		return (y + y / 4 - y / 100 + y / 400 + t[m - 1]
				+ d) % 7;
	}
	
	private float nthFibonacci(float f)
	{
		if (f < 2)
			return f;
		return nthFibonacci(f - 1) + nthFibonacci(f - 2);
	}
	
	private short nthFibonacci(short s)
	{
//		int n1 = 0, n2 = 1, n;
//		for (int i = 1; i < f; n = n1 + n2, n1 = n2, n2 = n, i++)
//			;
//		return n1;
		if (DEBUG) System.out.printf("In nthFibonacci(shrt=%d)\n",
									 s);
		short arr[] = new short[s + 1];
		
		arr[0] = 0;
		arr[1] = 1;
		
		for (int i = 2; i <= s; i++)
			arr[i] = (short) (arr[i - 1] + arr[i - 2]);
		
		return arr[s];
	}
	
	private byte nthFibonacci(byte b)
	{
		if (DEBUG) System.out.printf("In nthFibonacci(byt=%d)\n",
									 b);
		if (b < 2)
			return b;
		
		byte b0 = 0, b1 = 1, b2 = 1;
		
		for (int i = 2; i <= b; i++) {
			b2 = (byte) (b1 + b0);
			b0 = b1;
			b1 = b2;
		}
		
		return b2;
	}
	
	private double nthFibonacci(double d, double mmtb[])
	{
		if (d < 2)
			return d;
		
		if (mmtb[(int) d] != 0)
			return mmtb[(int) d];
		
		mmtb[(int) d] = nthFibonacci(d - 1, mmtb) +
				nthFibonacci(d - 2, mmtb);
		
		return mmtb[(int) d];
	}
	
	private long nthFibonacci(long l)
	{
		if (DEBUG) System.out.printf("In nthFibonacci(lng=%d)", l);
		
		int mat[][] = {{1, 1}, {1, 0}};
		
		matrixPower(mat, (int) l - 1);
		
		return (long) mat[0][0];
	}
	
	private void matrixPower(int mat[][], int n)
	{
		if (n < 2)
			return;
		
		matrixPower(mat, n / 2);
		
		int hlprMat[][] = {{1, 1}, {1, 0}};
		
		matrixMultiply(mat, mat);
		
		if (n % 2 == 1)
			matrixMultiply(mat, hlprMat);
	}
	
	private void matrixMultiply(int mat1[][], int mat2[][])
	{
		int w = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
		int x = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
		int y = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
		int z = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];
		
		mat1[0][0] = w;
		mat1[0][1] = x;
		mat1[1][0] = y;
		mat1[1][1] = z;
	}
	
	private int nthFibonacci(int n)
	{
//		double mmtb[] = new double[n + 1];
//		return (int) nthFibonacci((double) n, mmtb);
//		return nthFibonacci((byte) n);
		return (int) nthFibonacci((long) n);
//		final double PHI = 1.6180339;
//		int arr[] = {0, 1, 1, 2, 3, 5};
//		
//		if (n < 6)
//			return arr[n];
//		
//		int t = 5, fn = 5;
//		
//		while (t++ < n)
//			fn = (int) Math.round(fn * PHI);
//		
//		return fn;
	}
	
	private String binVal(float d)
	{
		if (d == 0) 
			return "0";
		
		StringBuilder bin = new StringBuilder();
		
		while (d >= 1) {
			bin.append((int) (d % 2));
			d /= 2;
		}
			
		return bin.reverse().toString();
	}
	
	private void binVal(int d, StringBuilder bin)
	{
		if (d == 0)
			return;
		binVal(d / 2, bin);
		bin.append(d % 2);
	}
	
	private String binVal(double d)
	{
		int i = (int) d;
		
		StringBuilder bin = new StringBuilder();
		
		while (i > 0) {
			bin.append(i & 1);
			i = i >> 1;
		}
		
		return bin.reverse().toString();
	}
	
	private String binVal(int d)
	{
		if (d < 2)
			return String.valueOf(d);
//		return binVal(d / 2) + (d % 2 == 0 ?
//								"0" : "1");
//		return Integer.toBinaryString(d);
		return binVal((double) d);
//		StringBuilder bin = new StringBuilder();
//		binVal(d, bin);
//		return bin.toString();
	}
	
	private float nthTermOfSeries(float n, float ... var)
	{
		return n * (n + 1) / 2;
	}
	
	private int nthTermOfSeries(int n, int ... var)
	{
		// iteration method
//		for (int i = 0, j = 1; j < n + 2; i += j++)
//			if (j == n + 1)
//				return i;
//		return 0;
		// recursive method
//		int i = 1, sum = i;
//		if (var.length > 0) {
//			i = ++var[0];
//			sum = var[1] + i;
//		}
//		if (i == n)
//			return sum;
//		return nthTermOfSeries(n, i, sum);
		return (int) nthTermOfSeries((float) n);
	}
	
	private int power(int n, int pow)
	{
		if (pow == 0)
			return 1;
		if (pow % 2 == 0)
			return power(n, pow / 2) * power(n, pow / 2);
		return n * power(n, pow / 2) * power(n, pow / 2);
	}
	
	private boolean armstrongNum(float n)
	{
		int dgts = (int) Math.log10(n) + 1, num = (int) n, sum = 0;
		
		while (num > 0) {
			sum += power(num % 10, dgts);
			num /= 10;
		}
		
		return sum == n;
	}
	
	private boolean armstrongNum(double n)
	{
		if (DEBUG) System.out.printf("In armstrongNum(dbl=%f)\n", n);
		String num = Integer.toString((int) n);
		BiFunction<Integer,
				   Integer,
				   Integer> pwr = (x, y) -> {
					   							int res = 1;
												while (y-- > 0)
													res *= x;
												return res;
											};
		int sum = 0;
		
		for (char c : num.toCharArray())
			sum += pwr.apply(c - '0', num.length());
		
		return sum == n;
	}
	
	private boolean armstrongNum(int n)
	{
//		Function<Integer, Integer> dgts = x -> {
//													int digits = 0;
//													while (x != 0) {
//														x /= 10;
//														digits++;
//													}
//													return digits;
//												};
//		int pwr = dgts.apply(n), sum = 0;
//		for (int num = n; num > 0; num /= 10)
//			sum += (int) Math.pow(num % 10, pwr);
//		return sum == n;
		return armstrongNum((double) n);
	}
	
	private boolean isPalindromeNum(int n)
	{
		// Using iteration
//		int rev = 0, num = n;
//		while (num > 0) {
//			rev = rev * 10 + num % 10;
//			num /= 10;
//		}
//		return rev == n;
		// Using number string
		char nums[] = Integer.toString(n).toCharArray();
		int len = nums.length;
		for (int i = 0; i <= len / 2; i++)
			if (nums[i] != nums[len - 1 - i])
				return false;
		return true;
	}
	
	private int singleDigit(float n)
	{
		int sum = 0, num = (int) n;
		while (num > 0 || sum > 9) {
			if (num == 0) {
				num = sum;
				sum = 0;
			}
			
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
	
	private int singleDigit(double n)
	{
		int num = (int) n;
		if (num == 0)
			return 0;
		if (num % 9 == 0)
			return 9;
		return num % 9;
	}
	
	private int singleDigit(int n)
	{
		// Using iteration
//		int sum = n;
//		while (sum > 9) {
//			int res = 0;
//			while (sum > 0) {
//				res += sum % 10;
//				sum /= 10;
//			}
//			sum = res;
//		}
//		return sum;
		// Using recursion
//		int res = 0;
//		while (n > 0) {
//			res += n % 10;
//			n /= 10;
//		}
//		return res > 9 ? singleDigit(res) : res;
		return singleDigit((double) n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EasyProblems easy = new EasyProblems();
//		System.out.println(easy.sumOfDigits(12345));
//		System.out.println(easy.reverseDigits(12345));
//		System.out.println(easy.isPrime(10007f));
		// TODO improve isPowerOf()
//		System.out.println(easy.isPowerOf(10.0, 1000000.0));
//		System.out.println(easy.distBetween(3, 4, 4, 3));
//		System.out.println(easy.isTriangleValid(1, 10, 12));
//		System.out.println(easy.doesOverlap(
//				new Point(0, 10), new Point(10, 0),
//				new Point(5, 5), new Point(15, 0)));
//		System.out.println(easy.factorial(0));
//		easy.countCubePair(1079f);
//		System.out.println(easy.gcd(20l, 28l));
//		System.out.println(easy.lcm(625l, 75l));
//		System.out.println(easy.isPerfectNum(496l));
//		int[] a = {1, 5}, b = {3, 15}, c = easy.sumOfFractions(a, b);
//		System.out.println(c[0] + " " + c[1]);
//		System.out.println(easy.dayOfWeek(20, 9, 1992));
//		System.out.println(easy.nthFibonacci(3));
//		System.out.println(easy.binVal(643));
//		System.out.println(easy.nthTermOfSeries(6));
//		System.out.println(easy.armstrongNum(153));
//		System.out.println(easy.isPalindromeNum(1222));
		System.out.println(easy.singleDigit(0));
	}

}

class Point
{
	double x, y;
	
	Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}