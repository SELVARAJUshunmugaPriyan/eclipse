// TODO isDivisibleByX() using String parameter 

package mathematicalAlgorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.BiFunction;

@SuppressWarnings("unused")
public class EasyProblems {
	
	private static final boolean DEBUG = true;
	
	private static int sumOfSeq2_22_222(Float n)
	{
		if (DEBUG) System.out.printf("In sumOfSeq2_22_222(Flt=%.0f)\n", n);
		
		int num = 0, tmp = Math.round(n);
		if (n == 0)
			return num;
		
		while (tmp-- > 0)
			num = num * 10 + 2;
		
		return sumOfSeq2_22_222(--n) + num;
	}
	
	private static int sumOfSeq2_22_222(float n, float ... var)
	{
		if (DEBUG) System.out.printf("In sumOfSeq2_22_222(flt=%.0f,flt=%.0f)\n", n, var[0]);
		
		float num = 2;
		if (var.length != 0)
			num = var[0];
		
		if (n == 0)
			return 0;
		
		return (int) (num + sumOfSeq2_22_222(--n, num * 10 + 2));
	}
	
	private static int sumOfSeq2_22_222(Double n)
	{
		if (DEBUG) System.out.printf("In sumOfSeq2_22_222(Dbl=%.0f)\n", n);
		
		if (n == 0)
			return 0;
		
		int sum = 0, num = 0;
		for (int i = 1; i <= n; i++) {
			num = num * 10 + 2;
			sum += num;
		}
		
		return sum;
	}
	
	private static int sumOfSeq2_22_222(Integer n)
	{
		if (DEBUG) System.out.printf("In sumOfSeq2_22_222(Int=%d)\n", n);
		
		if (n == 0)
			return 0;
		
//		return (int) (2.0 / 9 * ((10 * (Math.pow(10, n) - 1) / 9) - n));
		return (int) (2.0 / 81 * (10 * Math.pow(10, n) - 1 - 9 * n));
	}
	
	private static int sumOfSer1n23n2(Float n)
	{
		if (DEBUG) System.out.printf("In sumOfSer1n23n2(Flt=%.0f)\n", n);
		
		if (n == 1)
			return 1;
		
		return Math.round((2 * n - 1) * (2 * n - 1) + sumOfSer1n23n2(--n));
	}
	
	private static int sumOfSer1n23n2(float n)
	{
		if (DEBUG) System.out.printf("In sumOfSer1n23n2(flt=%.0f)\n", n);
		
		int sum = 0;
		while (n > 0)
			sum += Math.round((2 * n - 1) * (2 * n-- - 1));
			
		return sum;
	}
	
	private static int sumOfSer1n23n2(Integer n)
	{
		if (DEBUG) System.out.printf("In sumOfSer1n23n2(Int=%d)\n", n);
		
		return n * (2 * n - 1) * (2 * n + 1) / 3;
	}
	
	private static double sumOfSer0_60_06(Integer n)
	{
		if (DEBUG) System.out.printf("In sumOfSer0_60_06(Int=%d)\n", n);
		
		if (n == 0)
			return 0;
		
		String res = "0.";
		while (n-- > 0)
			res += "6";
		
		return Double.valueOf(res);
	}
	
	private static double sumOfSer0_60_06(Float n)
	{
		if (DEBUG) System.out.printf("In sumOfSer0_60_06(Flt=%.0f)\n", n);
		
		if (n == 0)
			return 0;
		
		if (n == 1)
			return 0.6;
		
		return Double.valueOf(6 / Math.pow(10, n) + sumOfSer0_60_06(--n));
	}
	
	private static double sumOfSer0_60_06(float n)
	{
		if (DEBUG) System.out.printf("In sumOfSer0_60_06(flt=%.0f)\n", n);
		
		if (n == 0)
			return 0;
		
		double sum = 0;
		while (n > 0)
			sum += 6 / Math.pow(10, n--);
		
		return sum;
	}
	
	private static double sumOfSer0_60_06(Double n)
	{
		if (DEBUG) System.out.printf("In sumOfSer0_60_06(Dbl=%.0f)\n", n);
		
		if (n == 0)
			return 0;
		
		return 6 * (Math.pow(0.1, n) - 1) / (0.1 - 1);
	}
	
	private static double sumOfSer0_60_06(double n)
	{
		if (DEBUG) System.out.printf("In sumOfSer0_60_06(dbl=%.0f)\n", n);
		
		if (n == 0)
			return 0;
		
		return 2 * (1 - 1 / Math.pow(10, n)) / 3;
	}
	
	private static int nthOfSeries2_12_36(int n)
	{
		if (DEBUG) System.out.printf("In nthOfSeries2_12_36(int=%d)\n", n);
		
		if (n == 0)
			return 0;
		
		return n * n * (n + 1);
	}
	
	private static int lucasNumber(float n, float ... var)
	{
		if (DEBUG) System.out.printf("In lucasNumber(int=%.0f)\n", n);
		
		if (n < 2)
			return 2 - (int) n;
		
		float arr[] = new float[(int) n + 1];
		if (var.length != 0)
			arr = var;
		
		if (arr[(int) n] == 0)
			return lucasNumber(n - 2, arr) + lucasNumber(n - 1, arr);
		return (int) arr[(int) n];
	}
	
	private static int lucasNumber(double n)
	{
		if (DEBUG) System.out.printf("In lucasNumber(dbl=%.0f)\n", n);
		
//		double arr[] = new double[(int) n + 1];
//		arr[0] = 2;
//		arr[1] = 1;
//		
//		for (int i = 2; i <= n; i++) {
//			arr[i] = arr[i - 2] + arr[i - 1]; 
//			if (DEBUG) System.out.print((int) arr[i] + (i == n ? "\n" : "," ));
//		}
//		
//		return (int) arr[(int) n];
		int a = 2, b = 1, c;
		
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return b;
	}
	
	private static List<Integer> nthRowOfPascalTriangle(float n)
	{
		if (DEBUG) System.out.printf("In nthRowOfPascalTriangle(flt=%.0f)\n", n);
		
		List<Integer> res = new ArrayList<>();
		
		Recur<BiFunction<Integer, Integer, Integer>> recur = new Recur<>();
		recur.func = (x, y) -> {
			if (x == 1 || x == y)
				return 1;
			return recur.func.apply(x - 1, y - 1) + recur.func.apply(x, y - 1);
		};
		
		for (int i = 1; i <= n; i++)
			res.add(recur.func.apply(i, (int) n));
		
		return res;
	}
	
	private static List<Integer> nthRowOfPascalTriangle(double n)
	{
		if (DEBUG) System.out.printf("In nthRowOfPascalTriangle(dbl=%.0f)\n", n);
		
		List<Integer> res = new ArrayList<>();
		res.add(1);
		
		if (n == 1)
			return res;
		
		List<Integer> prv = nthRowOfPascalTriangle(n - 1);
		
		for (int i = 1; i < prv.size(); i++)
			res.add(prv.get(i - 1) + prv.get(i));
		res.add(1);
		
		return res;
	}
	
	private static List<Integer> nthRowOfPascalTriangle(Integer n)
	{
		if (DEBUG) System.out.printf("In nthRowOfPascalTriangle(Int=%d)\n", n);
		
		Recur<Function<Integer, Integer>> fact = new Recur<>();
		fact.func = x -> {
			if (x < 2)
				return 1;
			return x * fact.func.apply(x - 1);
		};
		
		Recur<BiFunction<Integer, Integer, Integer>> nCr = new Recur<>();
		nCr.func = (x, y) -> fact.func.apply(x) / (fact.func.apply(y) *
												   fact.func.apply(x - y));
		
		List<Integer> res = new ArrayList<>();
		
		for (int i = 0; i < n; i++)
			res.add(nCr.func.apply(n - 1, i));
				
		return res;
	}
	
	private static List<Integer> nthRowOfPascalTriangle(int n)
	{
		if (DEBUG) System.out.printf("In nthRowOfPascalTriangle(int=%d)\n", n);
		
		List<Integer> res = new ArrayList<>();
		
		// To follow 0 based indexing, decrement n
		n--;
		
		// nC0 = 1
		int prev = 1;
		res.add(prev);
		
		for (int i = 1; i <= n; i++) {
			// nCr = nCr-1 * (n - r + 1) / r
			prev = prev * (n - i + 1) / i;
			res.add(prev);
		}
				
		return res;
	}
	
	private static boolean isDivisibleBy3(String n)
	{
		if (DEBUG) System.out.printf("In isDivisibleBy3(Str=%s)\n", n);
		
		return n.chars().map(x -> x - '0').sum() % 3 == 0;
	}
	
	private static boolean isDivisibleBy7(Double n)
	{
		if (DEBUG) System.out.printf("In isDivisibleBy7(Dbl=%.0f)\n", n);
		
		while (n > 0)
			n -= 7;
		
		return n == 0;
	}
	
	private static boolean isDivisibleBy7(Long n)
	{
		if (DEBUG) System.out.printf("In isDivisibleBy7(Lng=%d)\n", n);
		
		while (n > 0) {
			int b = Math.round(n % 10);
			n /= 10;
			n -= 2 * b;
//			n = Math.abs(n);
			if (DEBUG) System.out.printf("n=%d\n", n);
		}
		
//		return n == 0 || n == 7;
		return n % 7 == 0;
	}
	
	private static String differenceStringNumbers(String n, String m)
	{
		if (DEBUG) System.out.printf("In differenceStringNumbers(Str=%s,Str=%s)\n", n, m);
		
		String res = "";
		
		Function<String, String> reverse = x -> {
			String y = "";
			for (char c : x.toCharArray())
				y = c + y;
			return y;
		};
		
		BiFunction<String, String, Boolean> isGrtr = (x, y) -> {
			if (x.length() > y.length())
				return true;
			if (x.length() < y.length())
				return false;
			
			for (int i = 0; i < x.length(); i++)
				if (x.charAt(i) > y.charAt(i))
					return true;
			
			return false;
		};
		
		n = reverse.apply(n);
		m = reverse.apply(m);
		
		if (!isGrtr.apply(n, m)) {
			String tmp = n;
			n = m;
			m = tmp;
		}
		
		int carry = 0;
		for (int i = 0; i < m.length(); i++) {
			int sub = n.charAt(i) - m.charAt(i) - carry;
			carry = 0;
			
			if (sub < 0) {
				sub = 10 + sub;
				carry = 1;
			}
			
			res += (char) (sub + '0');
		}
		
		for (int i = m.length(); i < n.length(); i++) {
			int sub = n.charAt(i) - '0' - carry;
			carry = 0;
			
			if (sub < 0) {
				sub = 10 + sub;
				carry = 1;
			}
			
			res += (char) (sub + '0');
		}
		
		return reverse.apply(res);
	}
	
	private static boolean isDivisibleBy11(Double n)
	{
		if (DEBUG) System.out.printf("In isDivisibleBy11(Dbl=%.0f)\n", n);
		
		return n % 11 == 0;
	}
	
	private static boolean isDivisibleBy11(String n)
	{
		if (DEBUG) System.out.printf("In isDivisibleBy11(Str=%s)\n", n);
		
		int even = 0, odd = 0;
		for (int i = 0; i < n.length(); i++)
			if ((i & 1) == 0)
				even += n.charAt(i) - '0';
			else
				odd += n.charAt(i) - '0';
		
		return (even - odd) % 11 == 0; 
	}
	
	private static boolean isDivisibleBy29(Long n)
	{
		if (DEBUG) System.out.printf("In isDivisibleBy29(Lng=%d)\n", n);
		
		while (n > 99) {
			long b = n % 10;
			n /= 10;
			n += 3 * b;
			if (DEBUG) System.out.printf("n=%d\n", n);
		}
		
		return n % 29 == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(sumOfSeq2_22_222(3));
//		System.out.println(sumOfSer1n23n2(Integer.valueOf(10)));
//		System.out.println(sumOfSer0_60_06(3.0));
//		System.out.println(nthOfSeries2_12_36(4));
//		System.out.println(lucasNumber(10));
//		System.out.println(nthRowOfPascalTriangle(6));
//		System.out.println(isDivisibleBy3("123456758933312"));
//		System.out.println(isDivisibleBy7(40353607l));
//		System.out.println(differenceStringNumbers("123456758933312", "40353607") + " " 
//				+ (123456758933312l - 40353607));
//		System.out.println(isDivisibleBy11("76945"));
		System.out.println(isDivisibleBy29(292929002929l));
	}

}

class Recur<I>
{
	I func;
}