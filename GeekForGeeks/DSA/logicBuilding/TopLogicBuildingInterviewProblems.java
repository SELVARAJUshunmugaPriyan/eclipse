package logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class TopLogicBuildingInterviewProblems {
	
	private static final boolean DEBUG = true;
	// Arithmetic & Number theory
	private static int countDigits(float n)
	{
		if (n == 0)
			return 1;			
		int dgts = 0;
		while (n >= 1) {
			dgts++;
			n /= 10;
		}
		return dgts;
	}
	
	private static int countDigits(double n)
	{
		if (DEBUG) System.out.printf("In countDigits(dbl=%.0f)\n", n);
		if (n < 10) // Or (n / 10 == 0)
			return 1;
		return countDigits(n / 10) + 1;
	}
	
	private static int countDigits(long n)
	{
		if (DEBUG) System.out.printf("In countDigits(lng=%d)\n", n);
		return (int) Math.floor(Math.log10(n) + 1);
	}
	
	private static int countDigits(String n)
	{
		return /*Long.toString(*/n/*)*/.length();
	}
	
	private static int maxKPower(float n, float k)
	{
		if (DEBUG) System.out.printf("In maxKPower(flt=%.0f, flt=%.0f)\n", n, k);
		int factorial = 1, i = 0;
		
		while (n > 1)
			factorial *= n--;
		
		while (factorial % Math.pow(k, ++i) == 0)
			continue;
		
		return --i;
	}
	
	private static int maxKPower(Float n, Float k)
	{
		if (DEBUG) System.out.printf("In maxKPower(flt=%.0f, flt=%.0f)\n", n, k);
		Function<Integer, Integer> 
			computeFac = x -> {
				int res = 1;
				while(x > 1)
					res *= x--;
				return res;
			};
			
		int fact = computeFac.apply(Math.round(n)), power = 0;
		
		while (fact % k == 0) {
			power++;
			fact /= k;
		}
		
		return power;
	}
	
	private static int maxKPower(Double n, Double k)
	{
		if (DEBUG) System.out.printf("In maxKPower(Dbl=%.0f, Dbl=%.0f)\n", n, k);
		Function<Double, List<Integer>> 
			getPrimeFactors = x -> {
				List<Integer> pFactors = new ArrayList<>();
				outerloop:
				for (int i = 2; i <= x; i++) {
					for (int j = 2; j < i; j++)
						if (i % j == 0)
							continue outerloop;
					if (x % i == 0)
						pFactors.add(i);
				}
				return pFactors;
			};
		
		List<Integer> primeFactors = getPrimeFactors.apply(k);
		
		if (DEBUG) System.out.println(primeFactors);
		
		Map<Integer, Integer> exps = 
				primeFactors.stream()
				            .collect(Collectors.toMap(
			            		 x -> x,
			            		 x -> {
			            			 int exp = 0;
			            			 double tmp = k;
			            			 while (tmp % x == 0) {
			            				 tmp /= x;
			            				 exp++;
			            			 }
			            			 return exp;
			            		 }));
		
		if (DEBUG) System.out.println(exps);
		
		int res = Integer.MAX_VALUE;
		for (Integer p : primeFactors) {
			int tot = 0;
			
			for (int i = 1; i <= n; i++) {
				int cnt = 0, num = i;
				
				while (num % p == 0) {
					cnt++;
					num /= p;
				}
				tot += cnt;
			}
			
			tot /= exps.get(p);
			if (tot < res)
				res = tot;
		}
			
		return res;
	}
	
	private static List<List<Integer>> primeFactors(double k)
	{
		List<List<Integer>> factors = new ArrayList<>();

		int count = 0;
		while (k % 2 == 0) {
			k /= 2;
			count++;
		}
		
		if (count > 0) {
			List<Integer> pair = new ArrayList<>();
			pair.add(2);
			pair.add(count);
			factors.add(pair);
		}
		
		for (int i = 3; i * i <= k; i += 2) {
			count = 0;
			while (k % i == 0) {
				count++;
				k /= i;
			}
			
			if (count > 0) {
				List<Integer> pair = new ArrayList<>();
				pair.add(i);
				pair.add(count);
				factors.add(pair);
			}
		}
		
		if (k > 2) {
			List<Integer> pair = new ArrayList<>();
			pair.add((int) k);
			pair.add(1);
			factors.add(pair);
		}
		
		return factors;
	}
	
	private static int maxKPower(double n, double k)
	{
		List<List<Integer>> factors = primeFactors(k);
		int result = Integer.MAX_VALUE;
		
		if (DEBUG) System.out.println(factors);
		
		for (List<Integer> factor : factors) {
			int prime = factor.get(0);
			int freqInK = factor.get(1);
			int count = 0;
			
			for (int i = 1; i <= n; i++) {
				int x = i;
				while (x % prime == 0) {
					x /= prime;
					count++;
				}
			}
			
			result = Math.min(count / freqInK, result);
		}
		
		return result;
	}
	
	private static int maxKPower(Integer n, Integer k)
	{
		if (DEBUG) System.out.printf("In maxKPower(Int=%d, Int=%d)\n", n, k);
		int result = Integer.MAX_VALUE;
		
		List<List<Integer>> factors = primeFactors(k);
		
		for (List<Integer> factor : factors) {
			int prime = factor.get(0);
			int freqInK = factor.get(1);
			int count = 0;
			int p = prime;
			
			while (n / p > 0) {
				count += Math.floor(n / p);
				p *= prime;
			}
			
			if (DEBUG) System.out.println("count=" + count);
			result = Math.min(result, count / freqInK);
		}
		
		return result;
	}
	
	private static int maxKPower(int n, int k)
	{
		if (DEBUG) System.out.printf("In maxKPower(int=%d, int=%d)\n", n, k);
		int result = Integer.MAX_VALUE;
		
		List<List<Integer>> factors = primeFactors(k);
		
		BiFunction<Integer, Integer, Integer>
			legendre = (o, p) -> {
				int count = 0;
				for (long power = p; power <= o; power *= p)
					count += o / power;
				return count;
			};
		
		for (List<Integer> factor : factors) {
			int prime = factor.get(0);
			int expInK = factor.get(1);
			
			int count = legendre.apply(n, prime);
			if (DEBUG) System.out.println("count=" + count);
			result = Math.min(result, count / expInK);
		}
		
		return result;
	}
	
	private static boolean isPerfectSquare(Float n)
	{
		if (DEBUG) System.out.printf("In perfectSquare(Flt=%.0f)\n", n);
		return Math.sqrt(n) == Math.floor(Math.sqrt(n));
	}
	
	private static boolean isPerfectSquare(float n)
	{
		if (DEBUG) System.out.printf("In perfectSquare(flt=%.0f)\n", n);
		
		if (n > 0) {
			long x = (long) Math.sqrt(n);
			return x * x == n;
		}
		return false;
	}
	
	private static boolean isPerfectSquare(Double n)
	{
		if (DEBUG) System.out.printf("In perfectSquare(Dbl=%.0f)\n", n);
		
		return n > 0 ? Math.floor(Math.sqrt(n)) == 
					   Math.ceil(Math.sqrt(n))
				: false ;
	}
	
	private static boolean isPerfectSquare(long n)
	{
		if (DEBUG) System.out.printf("In perfectSquare(lng=%d)\n", n);
		if (n <= 1)
			return true;
		
		long left = 2, right = n;
		
		while (left <= right) {
			long mid = left + (right - left) / 2;
			long square = mid * mid;
			if (DEBUG) System.out.printf("left=%d right=%d mid=%d square=%d\n",
					left, right, mid, square);
			if (square == n)
				return true;
			
			if (square > n)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return false;
	}
	
	private static boolean isPerfectSquare(Integer n)
	{
		if (DEBUG) System.out.printf("In perfectSquare(Int=%d)\n", n);
		if (n <= 1)
			return true;
		
		int sum = 0, odd = -1;
		while (sum < n) {
			odd += 2;
			sum += odd;
			if (DEBUG) System.out.printf("odd=%d sum=%d\n", odd, sum);
			if (sum == n)
				return true;
		}
		
		return false;
	}
	
	private static boolean isPerfectSquare(int n)
	{
		if (DEBUG) System.out.printf("In perfectSquare(int=%d)\n", n);
		if (n <= 1)
			return true;
		
		int odd = 1;
		while (n > 0) {
			n -= odd;
			odd += 2;
		}
		
		return n == 0;
	}
	
	private static boolean isPerfectCube(Float n)
	{
		if (DEBUG) System.out.printf("In perfectCube(Flt=%.0f)\n", n);
		for (int i = 0; i * i * i <= n; i++)
			if (i * i * i == n)
				return true;
		
		return false;
	}
	
	private static boolean isPerfectCube(Double n)
	{
		if (DEBUG) System.out.printf("In perfectCube(Dbl=%.0f)\n", n);
		return Math.cbrt(n) == Math.floor(Math.cbrt(n));
	}
	
	private static boolean isPerfectCube(Long n)
	{
		if (DEBUG) System.out.printf("In perfectCube(Lng=%d)\n", n);
		List<List<Integer>> factors = primeFactors(n);
		
		for (List<Integer> factor : factors)
			if (factor.get(1) != 3)
				return false;
		
		return true;
	}
	
	private static boolean isPerfectCube(long n)
	{
		if (DEBUG) System.out.printf("In perfectCube(lng=%d)\n", n);
		Map<Integer, Integer> factors = new HashMap<>();
		
		while (n % 2 == 0) {
			factors.put(2, factors.getOrDefault(2, 0) + 1);			
			n /= 2;
		}
		
		if (factors.get(2) != 3)
			return false;
		
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				factors.put(i, factors.getOrDefault(i, 0) + 1);
				n /= i;
			}

			if (factors.get(i) != 3)
				return false;
		}
		
		if (n > 2)
//			factors.put((int) n, factors.getOrDefault(n, 1));
			return false;
		
//		for (Map.Entry<Integer, Integer> entry : factors.entrySet())
//			if (entry.getValue() != 3)
//				return false;
		
		return true;
	}
	
	private static boolean isPerfectCube(Integer n)
	{
		if (DEBUG) System.out.printf("In perfectCube(Int=%d)\n", n);

		int left = 1, right = n;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			long cube = (long) mid * mid * mid;
			if (DEBUG) System.out.printf("left=%d right=%d mid=%d cube=%d\n",
					left, right, mid, cube);
			if (cube == n)
				return true;
			
			if (cube > n)
				right = --mid;
			else
				left = ++mid;
		}
		
		return false;
	}
	
	private static boolean isPerfectCube(short n)
	{
		if (DEBUG) System.out.printf("In perfectCube(sht=%d)\n", n);
		
		int sum = 0, odd = 1;
		for (int count = 0; sum < n; count++) {
			sum = 0;
			for (int i = 0; i < count; i++) {
				sum += odd;
				odd += 2;
			}
			
			if (sum == n)
				return true;
		}
		
		return false;
	}
	// Geometry Based Problems
	private static int squaresInTriangle(Integer len)
	{
	/*	int base = len - 2;
		base = Math.floorDiv(base, 2);
		return base * (base + 1) / 2;	*/
		int count = 0;
		while (len > 2) {
			count += (len - 2) / 2;
			len -= 2;
		}
		
		return count;
	}
	
	private static int squaresInRectangle(float m, float n)
	{
		if (DEBUG) System.out.printf("In squaresInRectangle(flt=%.0f, flt=%.0f)\n", m, n);
		int count = 0;
		for (int i = 1; i <= Math.min(m, n); i++)
			count += (m - i + 1) * (n - i + 1);
		
		return count;
	}
	
	private static int squaresInRectangle(int m, int n)
	{
		if (DEBUG) System.out.printf("In squaresInRectangle(int=%d, int=%d)\n", m, n);
		if (m == n)
			return (n * (n + 1) * (2 * n + 1)) / 6;
		
		if (m > n) {
			int temp = m;
			m = n;
			n = temp;
		}
		
		return (m * (m + 1) * (2 * m + 1)) / 6 +
			   ((n - m) * m * (m + 1)) / 2;
	}
	
	private static boolean isValidChessBd(Integer[][] chess)
	{
		Integer whiteSquare = chess[0][0];
		Integer blackSquare = chess[0][1];
		
		if (whiteSquare == blackSquare)
			return false;
		
		for (int i = 0; i < chess.length; i++) {
			Integer row[] = chess[i];
			
			if (row.length != chess.length)
				return false;
			
			if (i < chess.length - 1 &&
				   (chess[i][0] == chess[i + 1][0] ||
				   (chess[i][0] != whiteSquare && chess[i][0] != blackSquare) ||
				   (chess[i + 1][0] != whiteSquare && chess[i + 1][0] != blackSquare)))
				return false;
			
			for (int j = 0; j < row.length - 1; j++) {
				if (row[j] == row[j + 1] ||
				   (row[j] != whiteSquare && row[j] != blackSquare) ||
				   (row[j + 1] != whiteSquare && row[j + 1] != blackSquare))
					return false;
			}
		}
		return true;
	}
	
	private static boolean isValidChessBd(int[][] chess, Integer n)
	{
		int X[] = {0, -1, 0, 1};
		int Y[] = {1, 0, -1, 0};
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int k = 0; k < 4; k++) {
					int newX = i + X[k];
					int newY = j + Y[k];
					if (newX >= 0 && newX < n &&
						newY >= 0 && newY < n &&
						chess[i][j] == chess[newX][newY])
						return false;
				}
				
		return true;
	}
	
	private static boolean isValidChessBd(int[][] chess, float n)
	{
		if (DEBUG) System.out.printf("In isValidChessBd(int[][], flt=%.0f)\n", n);
		int evenSum = chess[0][0];
		int oddSum  = chess[0][1];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if ((i + j) % 2 == 0) {
					if (chess[i][j] != evenSum)
						return false;
				} else
					if (chess[i][j] != oddSum)
						return false;
		
		return true;
	}
	
	private static boolean isValidChessBd(int[][] chess, int n)
	{
		if (DEBUG) System.out.printf("In isValidChessBd(int[][], int=%d)\n", n);
		int base = chess[0][0];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if ((i + j) % 2 == 0) {
					if (chess[i][j] != base)
						return false;
				} else
					if (chess[i][j] == base)
						return false;
		
		return true;
	}
	
	private static int squaresInChessBoard(int n)
	{
		return n * (n + 1) * (2 * n + 1) / 6;
	}
	
	private static int distinctRectanglesInChessBoard(int n)
	{
//		return n * (n + 1) / 2;
		if (n == 1)
			return 1;
		return n + distinctRectanglesInChessBoard(--n);
	}
	
	private static boolean placeQueens(int row, int mat[][])
	{
		int n = mat.length;
		
		BiFunction<int[][], int[], Boolean>
			isSafe = (x, y) -> {
				int rw = y[0], cl = y[1];
				for (int i = rw - 1; i >= 0; i--)
					if (x[i][cl] == 1)
						return false;
				for (int i = rw - 1, j = cl - 1; i >= 0 &&
						j >= 0; i--, j--)
					if (x[i][j] == 1)
						return false;
				for (int i = rw - 1, j = cl + 1; i >= 0 &&
						j < n; i--, j++)
					if (x[i][j] == 1)
						return false;
				return true;
			};
		
		if (row == n)
			return true;
		
		for (int i = 0; i < n; i++) {
			int[] indices = {row, i};
			if (isSafe.apply(mat, indices)) {
				mat[row][i] = 1;
				if (placeQueens(row + 1, mat))
					return true;
				mat[row][i] = 0;
			}
		}
		
		return false;
	}
	
	private static boolean placeQueens(int i, int[] col,
			int[] leftDiagonal, int[] rightDiagonal,
			List<Integer> cur)
	{
		int n = col.length;
		
		if (i == n)
			return true;
		
		for (int j = 0; j < n; j++) {
			if (col[j] == 1 || rightDiagonal[i + j] == 1 ||
					leftDiagonal[i - j + n - 1] == 1)
				continue;
			
			col[j] = 1;
			rightDiagonal[i + j] = 1;
			leftDiagonal[i - j + n - 1] = 1;
			cur.add(j + 1);
			
			if (DEBUG) {
				System.out.println(cur);
				System.out.println(Arrays.toString(col));
				System.out.println(Arrays.toString(leftDiagonal));
				System.out.println(Arrays.toString(rightDiagonal));
			}
			
			if (placeQueens(i + 1, col, leftDiagonal,
					rightDiagonal, cur))
				return true;
			
			col[j] = 0;
			rightDiagonal[i + j] = 0;
			leftDiagonal[i - j + n - 1] = 0;
			cur.remove(cur.size() - 1);
		}
		
		return false;
	}
	
	private static List<Integer> nQueen(long n)
	{
		int mat[][] = new int[(int) n][(int) n];
		
		if (placeQueens(0, mat)) {
			List<Integer> res = new ArrayList<>();
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (mat[i][j] == 1)
						res.add(j + 1);
			
			if (DEBUG) {
				int idx = 0;
				for (int i = 0; i < res.size(); i++) {
					int num = res.get(idx++) - 1;
					
					for (int j = 0; j < res.size(); j++)
						if (j == num)
							System.out.print(1 + " ");
						else
							System.out.print(0 + " ");
					
					System.out.println();
				}
			}
			
			return res;
		} else
			return Collections.singletonList(-1);
	}
	
	private static List<Integer> nQueen(int n)
	{
		if (DEBUG) System.out.printf("In nQueen(int=%d)\n", n);
		
		int[] col = new int[n];
		int[] leftDiagonal = new int[2 * n];
		int[] rightDiagonal = new int[2 * n];
		List<Integer> cur = new ArrayList<>();
		
		if (placeQueens(0, col, leftDiagonal, rightDiagonal, cur)) {
			printBoard(cur);
			return cur;
		} else
			return Collections.singletonList(-1);
	}
	
	private static void printBoard(List<Integer> brd)
	{
		Iterator<Integer> itr = brd.iterator();
		
		for (int i = 0; i < brd.size(); i++) {
			int x = itr.next();
			
			for (int j = 0; j < brd.size(); j++)
				if (x == j + 1)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			
			System.out.println();
		}
	}
	
	private static List<List<Integer>> allNQueen(float n)
	{
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> board = new ArrayList<>();
//		boolean visited[] = new boolean[Math.round(n) + 1];
//		boolean rows[] = new boolean[Math.round(n) + 1];
//		boolean lfDg[] = new boolean[2 * Math.round(n) + 1];
//		boolean rtDg[] = new boolean[2 * Math.round(n) + 1];
//		queenUtil(1, n, board, res, visited);
//		queenUtil(1, n, board, rows, lfDg, rtDg, res);
		queenUtil(1, n, board, 0, 0, 0, res);
		System.out.println(res.size());
		for(List<Integer> x : res) {
			System.out.println(x);
			printBoard(x);
		}
		
		return res;
	}
	
	private static void queenUtil(int col, float n,
			List<Integer> board, List<List<Integer>> res,
			boolean visited[])
	{
		if (col > n) {
			res.add(new ArrayList<>(board));
			return;
		}
		
		for (int row = 1; row <= n; row++) {
			if (!visited[row] && isSafe(board, row, col)) {
				visited[row] = true;
				board.add(row);
				queenUtil(col + 1, n, board, res, visited);
				visited[row] = false;
				board.remove(board.size() - 1);
			}
		}
	}
	
	private static boolean isSafe(List<Integer> board,
			int currRow, int currCol)
	{
		for (int i = 0; i < board.size(); i++) {
			int placedRow = board.get(i);
			int placedCol = i + 1;
			if (Math.abs(placedRow - currRow) == 
					Math.abs(placedCol - currCol))
				return false;
		}
		
		return true;
	}
	
	private static void queenUtil(int col, float n, List<Integer> board,
			boolean[] rows, boolean[] lfDg, boolean[] rtDg,
			List<List<Integer>> res)
	{
		if (col > n) {
			res.add(new ArrayList<>(board));
			return;
		}
		
		for (int row = 1; row <= n; row++)
			if (!rows[row] && !lfDg[row + col] && !rtDg[row - col + (int) n]) {
				rows[row] = lfDg[row + col] = rtDg[row - col + (int) n] = true;
				board.add(row);
				queenUtil(col + 1, n, board, rows, lfDg, rtDg, res);
				rows[row] = lfDg[row + col] = rtDg[row - col + (int) n] = false;
				board.remove(board.size() - 1);
			}
	}
	
	private static void queenUtil(int col, float n, List<Integer> board,
			int rows, int ld, int rd, List< List<Integer>> res)
	{
		if (col > n) {
			res.add(new ArrayList<>(board));
			return;
		}
		
		for (int row = 1; row <= n; row++)
			if (isSafe(row, col, rows, ld, rd, n)) {
				board.add(row);
				queenUtil(col + 1, n, board, rows | (1 << row),
						ld | (1 << (row + col)), rd | (1 << (row - col + (int) n)), res);
				board.remove(board.size() - 1);
			}
	}
	
	private static boolean isSafe(int row, int col, int rows, int ld, int rd, float n)
	{
		return !(((rows >> row) & 1) == 1) && !(((ld >> (row + col)) & 1) == 1) && 
			   !(((rd >> (row - col + (int) n)) & 1) == 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(countDigits("123"));
		System.out.println(maxKPower(10, 9));
//		for (int i = 0; i <= 100; i++)
//			if (isPerfectSquare(Double.valueOf(i)))
//				System.out.println(i);
//		System.out.println(isPerfectSquare(1000000));
//		System.out.println(isPerfectCube(Integer.valueOf(1000000)));
//		for (short i = 0; i <= 1000; i++)
//			if (isPerfectCube(i))
//				System.out.println(i);
//		System.out.println(squaresInTriangle(7));
//		System.out.println(squaresInRectangle(5, 4));
//		System.out.println(isValidChessBd(new int[][] {
//															{1, 0, 1, 0},
//															{0, 1, 0, 1},
//															{1, 0, 1, 0},
//															{0, 1, 0, 1}
//														  }, 4));
//		System.out.println(squaresInChessBoard(2));
//		System.out.println(distinctRectanglesInChessBoard(8));
//		System.out.println(nQueen(8));
//		System.out.println(allNQueen(4f));
	}

}
