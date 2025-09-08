package logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class HardProblems
{
	
	private static final boolean DEBUG = true;
	
	private void sieveOfEratosthenes(float n)
	{		
		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			
			for (int j = 2; j * j <= i; j++) {
				if (DEBUG) System.out.printf("i=%d j=%d\n", i, j);
				if (i % j == 0 && i != 2) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime)
				System.out.print(i + " ");
		}
	}
	
	private void sieveOfEratosthenes(Float n)
	{
		boolean primtb[] = new boolean[(int) Math.round(n) + 1];
		Arrays.fill(primtb, 2, primtb.length, true);
		
		for (int i = 2; i * i <= n; i++)
			for (int j = 2 * i; primtb[i] && j <= n; j += i)
				primtb[j] = false;
		
		for (int i = 0; i <= n; i++)
			if (primtb[i])
				System.out.print(i + " ");
	}
	
	private int[] sieveOfEratosthenes(int n)
	{
		Boolean primTb[] = new Boolean[n + 1];
		Arrays.fill(primTb, 2, n, true);
		primTb[0] = primTb[1] = false;
		
		for (int i = 2; i * i <= n; i++)
			if (primTb[i])
				for (int j = 2 * i; j <= n; j += i)
					primTb[j] = false;
		
		int count = (int) Arrays.stream(primTb)
						  		.filter(x -> x)
						  		.count();
		
		int res[] = new int[count];
		for (int i = n; i >= 0; i--)
			if (primTb[i])
				res[--count] = i;
		
		return res;
	}
	
	private float clockAngleProblem(float h, float m)
	{
		return (float) Math.abs(30 * h - 5.5 * m);
	}
	
	private double clockAngleProblem(double h, double m)
			throws IllegalArgumentException
	{
		if (h < 0 || h > 23 || m < 0 || m > 60)
			throw new IllegalArgumentException("Wrong input");
				
		if (m == 60) {
			m = 0;
			h += 1;
		}
		
		if (h >= 12)
			h -= 12;
		
		if (h == 12)
			h = 0;
		
		double hourAng = 0.5 * (60 * h + m);
		double minuAng = 6 * m;
		
		double angle = Math.abs(hourAng - minuAng);
		angle = Math.min(360 - angle, angle);
		
		return angle;
	}
	
	private void towerOfHanoi(int n, char from, char to, char aux)
	{
		if (n == 0)
			return;
		
		towerOfHanoi(n - 1, from, aux, to);
		System.out.printf("Move disk %d from rod %c to rod %c\n", n, from, to);
		towerOfHanoi(n - 1, aux, to, from);
	}
	
	private void towerOfHanoi(int n)
	{
		@SuppressWarnings("unchecked")
		Stack<Integer> tower[] = new Stack[4];
		TowerOfHanoi<Consumer<Integer[]>> move = new TowerOfHanoi<>();
		
		Runnable display = () -> {
			System.out.println(" A | B | C ");
			System.out.println("-----------");
			
			for (int i = n -1; i >= 0; i--) {
				String d1 = "", d2 = "", d3 = "";
				
				try {
					d1 += tower[1].get(i);
				} catch (Exception e) {}
				
				try {
					d2 += tower[2].get(i);
				} catch (Exception e) {}
				
				try {
					d3 += tower[3].get(i);
				} catch (Exception e) {}
				
				System.out.printf(" %1s | %1s | %1s \n", d1, d2, d3);
			}
			System.out.println("\n");
		};
		
		move.func = x -> {
			if (x[0] > 0) {
				Integer y[] = new Integer[4];
				
				y[0] = x[0] - 1;
				y[1] = x[1];
				y[2] = x[3];
				y[3] = x[2];
				
				move.func.accept(y);
				int d = tower[x[1]].pop();
				tower[x[3]].push(d);
				display.run();
				
				y[1] = x[2];
				y[2] = x[1];
				y[3] = x[3];
				
				move.func.accept(y);
			}
		};
		
		Consumer<Integer> toh = x -> {
			for (int i = x; i > 0; i--)
				tower[1].push(i);
			
			Integer y[] = {x, 1, 2, 3};
			move.func.accept(y);
		 };
		
		 tower[1] = new Stack<Integer>();
		 tower[2] = new Stack<Integer>();
		 tower[3] = new Stack<Integer>();
		 
		 toh.accept(n);
	}
	
	public static double log2(int n)
	{
		return Math.log(n) / Math.log(2);
	}
	
	private int ratPoisoned(int bottles)
	{
		double rats = log2(bottles);
		return (int) Math.ceil(rats);
	}
	
	private int getDet(int[][] mat)
	{
		int n = mat.length;
		
		if (n == 1)
			return mat[1][1];
		
		if (n == 2)
			return mat[0][0] * mat[1][1] -
				   mat[0][1] * mat[1][0];
		
		int res = 0;
		
		for (int col = 0; col < n; col++) {
			int subMat[][] = new int[n - 1][n - 1];
			
			for (int row = 1; row < n; row++) {
				int k = 0;
				
				for (int j = 0; j < n; j++) {
					if (j == col)
						continue;
					subMat[row - 1][k++] = mat[row][j];
				}
			}
			
			int sign = (col % 2 == 0) ? 1 : -1;
			res += sign * mat[0][col] * getDet(subMat);
		}
			
		return res;
	}
	
	private int getDet(Integer[][] mat)
	{
		int n = mat.length;
		int num1, num2, det = 1, index, total = 1;
		
		int temp[] = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			index = i;
			
			while (index < n && mat[index][i] == 0)
				index++;
			
			if (index == n)
				continue;
			
			if (index != i) {
				for (int j = 0; j < n; j++) {
					Integer tmpSwap = mat[index][j];
					mat[index][j] = mat[i][j];
					mat[i][j] = tmpSwap;
				}
				
				det *= (int) Math.pow(-1, index - i);
			}
			
			for (int j = 0; j < n; j++)
				temp[j] = mat[i][j];
			
			for (int j = i + 1; j < n; j++) {
				num1 = temp[i];
				num2 = mat[j][i];
				
				for (int k = 0; k < n; k++)
					mat[j][k] = (num1 * mat[j][k]) - (num2 * temp[k]);
				
				total *= num1;
			}
		}
		
		for (int i = 0; i < n; i++)
			det *= mat[i][i];
		
		return (det / total);
	}
	
	private int eulerToient(float n)
	{
		int count = 0;
		
		TowerOfHanoi<BiFunction<Integer, Integer, Integer>>
			gcd = new TowerOfHanoi<>();
		gcd.func = (x, y) -> {
			if (x == 0)
				return y;
			return gcd.func.apply(y % x, x);
		};
		
		for (int i = 1; i < n; i++)
			if (gcd.func.apply((int) n, i) == 1)
				count++;
		
		return count;
	}
	
	private int eulerToient(int n)
	{
		int result = n;
		
		for (int p = 2; p * p <= n; p++)
			if (n % p == 0) {
				while(n % p == 0)
					n /= p;
				
				result -= result / p;
			}
		
		if (n > 1)
			result -= result / n;
		
		return result;
	}
	
	private int josephusPrblm(float n, float k)
	{
		List<Integer> position = new ArrayList<>();
		
		while (n > 0)
			position.addFirst((int) n--);
		
		int i = 0;
		k--;
		while (position.size() != 1) {
			if (DEBUG) System.out.println(position);
			i = (int) ((i + k) % position.size());
			position.remove(i);
		}
		
		return position.getFirst();
	}
	
	private int josephusPrblm(Float n, Float k)
	{
		k--;
		int arr[] = new int[Math.round(n)];
		for (int i = 0; i < n; i++)
			arr[i] = 1;
		
		int cnt = 0, cut = 0, num = 1;
		
		while (cnt < n - 1) {
			while (num < k) {
				cut++;
				cut %= n;
				if (arr[cut] == 1)
					num++;
			}
			
			num = 1;
			arr[cut] = 0;
			cut++;
			cnt++;
			
			while (arr[cut] == 0) {
				cut++;
				cut %= n;
			}
		}
		
		return cut;
	}
	
	private int josephusPrblm(int n, int k)
	{
		if (DEBUG) System.out.printf("In josephusPrblm(int=%d,int=%d)\n", n, k);
		
		int i = 1, ans = 0;
		
		while (i <= n)
			ans = (ans + k) % i++;
		
		return ans + 1;
	}
	
	private int josephusPrblm(Integer n, Integer k)
	{
		if (DEBUG) System.out.printf("In josephusPrblm(Int=%d,Int=%d)\n", n, k);
		
		if (n == 1)
			return 1;
		
		return (josephusPrblm(Integer.valueOf(n - 1),
				Integer.valueOf(k)) + k - 1) % n + 1;
	}
	
	public static void main(String[] args) {
		
		HardProblems hard = new HardProblems();
//		hard.sieveOfEratosthenes(10000f);
//		hard.sieveOfEratosthenes(Float.valueOf(10000f));
//		System.out.println(Arrays.toString(
//				hard.sieveOfEratosthenes(1000)));
//		System.out.println(hard.clockAngleProblem(9.0, 15.0));
//		hard.towerOfHanoi(4);
//		System.out.println(hard.ratPoisoned(10));
//		PuzzleSolver.main(new String[] {"false"});
//		EightPuzzleAStar.main(new String[] {"false"});
//		EightPuzzleSolver.main(new String[] {"false"});
//		System.out.println(hard.getDet(new Integer[][] {
//			new Integer[] {1, 0, 2, -1},
//			new Integer[] {3, 0, 0, 5},
//			new Integer[] {2, 1, 4, -3},
//			new Integer[] {1, 0, 5, 0}
//		}));
//		System.out.println(hard.eulerToient(789));
		System.out.println(hard.josephusPrblm(Integer.valueOf(14), Integer.valueOf(2)));
	}

}

class TowerOfHanoi<I>
{
	public I func;
}

class PuzzleSolver
{
	static final int N = 3;
	
	static final int row[] = {0, 0, -1, 1};
	static final int col[] = {-1, 1, 0, 0};
	
	static boolean DEBUG;
	
	static class PuzzleState
	{
		int[][] board;
		int x, y, depth, hash;
		
		PuzzleState(int[][] b, int i, int j, int d)
		{
			board = new int[N][N];
			for (int k = 0; k < N; k++)
				board[k] = Arrays.copyOf(b[k], N);
			
			x = i;
			y = j;
			depth = d;
			hash = Arrays.deepHashCode(board);
		}
		
		@Override
		public boolean equals(Object obj)
		{
			if (this == obj) return true;
			if (obj == null || getClass() != obj.getClass()) return false;
			PuzzleState that = (PuzzleState) obj;
			return hash == that.hash;
		}
		
		@Override
		public int hashCode()
		{
			return hash;
		}
	}
	
	static boolean isGoalState(int[][] board)
	{
		int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
		return Arrays.deepEquals(board, goal);
	}
	
	static boolean isValid(int x, int y)
	{
		return (x >= 0 && x < N && y >= 0 && y < N);
	}
	
	static void printBoard(int[][] board)
	{
		for (int[] row : board) {
			for (int num : row)
				System.out.print(num + " ");
			System.out.println();
		}
		System.out.println("--------");
	}
	
	static void solvePuzzleBFS(int[][] start, int x, int y)
	{
		Queue<PuzzleState> queue = new LinkedList<>();
		Set<PuzzleState> visited = new HashSet<>();
		
		queue.add(new PuzzleState(start, x, y, 0));
		visited.add(new PuzzleState(start, x, y, 0));
		
		while (!queue.isEmpty()) {
			PuzzleState curr = queue.poll();
			
			if (DEBUG) {
				System.out.println("Depth: " + curr.depth);
				printBoard(curr.board);
			}
			
			if (isGoalState(curr.board)) {
				System.out.println("Goal state reached at depth " + curr.depth);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int newX = curr.x + row[i];
				int newY = curr.y + col[i];
				
				if (isValid(newX, newY)) {
					int[][] newBoard = new int[N][N];
					for (int k = 0; k < N; k++)
						newBoard[k] = Arrays.copyOf(curr.board[k], N);
					
					int temp = newBoard[newX][newY];
					newBoard[newX][newY] = newBoard[curr.x][curr.y];
					newBoard[curr.x][curr.y] = temp;
					
					PuzzleState newState = new PuzzleState(newBoard, newX, newY, curr.depth + 1);
					
					if (!visited.contains(newState)) {
						visited.add(newState);
						queue.add(newState);
					}
				}
			}
		}
		
		System.out.println("No solution found (Unsolvable puzzle)");
	}
	
	public static void main(String[] args)
	{
		int[][] start = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};
		
		DEBUG = Boolean.parseBoolean(args[0]);
		
		System.out.println("Initial State:");
		printBoard(start);
		
		solvePuzzleBFS(start, 1, 1);
	}
}

class PuzzleState implements Comparable<PuzzleState>
{
	long board;
	int x, y, depth, f;
	
	PuzzleState(long b, int i, int j, int d, int h)
	{
		board = b;
		x = i;
		y = j;
		depth = d;
		f = d + h;
	}
	
	@Override
	public int compareTo(PuzzleState other)
	{
		return Integer.compare(this.f, other.f);
	}
}

class EightPuzzleAStar {
	static final int N = 3;
	static int row[] = {0, 0, -1, 1};
	static int col[] = {-1, 1, 0, 0};
	static final long GOAL_STATE = 123456780L;
	static boolean DEBUG;
	
	static long boardToLong(int[][] board)
	{
		long result = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				result = (result * 10) + board[i][j];
		
		return result;
	}
	
	static String boardToString(long board)
	{
		String str = String.valueOf(board);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9 - str.length(); i++)
			sb.append("0");
		
		sb.append(str);
		return sb.toString();
	}
	
	static boolean isGoalState(long board)
	{
		return GOAL_STATE == board;
	}
	
	static void printBoard(long board)
	{
		String str = boardToString(board);
		for (int i = 0; i < 9; i++) {
			System.out.print(str.charAt(i) + " ");
			if ((i + 1) % 3 == 0)
				System.out.println();
		}
		
		System.out.println("--------");
	}
	
	static int calculateHeuristic(long board)
	{
		String str = boardToString(board);
		int h = 0;
		for (int i = 0; i < 9; i++) {
			int num = str.charAt(i) - '0';
			if (num != 0) {
				int goalX = (num - 1) % 3;
				int goalY = (num - 1) / 3;
				int currentX = i % 3;
				int currentY = i / 3;
				h += Math.abs(goalX - currentX) + Math.abs(goalY - currentY);				
			}
		}
		
		return h;
	}
	
	static void solvePuzzleAStar(int[][] start, int x, int y)
	{
		Queue<PuzzleState> queue = new LinkedList<>();
		Set<Long> visited = new HashSet<>();
		
		long startBoard = boardToLong(start);
		int h = calculateHeuristic(startBoard);
		
		queue.add(new PuzzleState(startBoard, x, y, 0, h));
		visited.add(startBoard);
		
		while (!queue.isEmpty()) {
			PuzzleState curr = queue.poll();
			
			if (DEBUG) {
				System.out.println("Depth: " + curr.depth);
				printBoard(curr.board);
			}
			
			if (isGoalState(curr.board)) {
				System.out.println("Goal reached at depth " + curr.depth);
				return;
			}
			
			String str = boardToString(curr.board);
			char[] boardArray = str.toCharArray();
			
			for (int i = 0; i < 4; i++) {
				int newX = curr.x + row[i];
				int newY = curr.y + col[i];
				
				if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
					int zeroPos = curr.x * N + curr.y;
					int swapPos = newX * N + newY;
					
					char temp = boardArray[zeroPos];
					boardArray[zeroPos] = boardArray[swapPos];
					boardArray[swapPos] = temp;
					
					long newBoardLong = Long.parseLong(String.valueOf(boardArray));
					
					if (!visited.contains(newBoardLong)) {
						int newH = calculateHeuristic(newBoardLong);
						visited.add(newBoardLong);
						queue.add(new PuzzleState(newBoardLong, newX, newY, curr.depth + 1, newH));
					}
					
					boardArray[swapPos] = boardArray[zeroPos];
					boardArray[zeroPos] = temp;
				}
			}
		}
		
		System.out.println("No Solution found");
	}
	
	public static void main(String[] args)
	{
		int[][] start = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};
		int x = 1, y = 1;
		
		DEBUG = Boolean.parseBoolean(args[0]);
		
		System.out.println("Initial state:");
		printBoard(boardToLong(start));
		
		solvePuzzleAStar(start, x, y);
	}
}

class EightPuzzleSolver
{
	static boolean DEBUG;
	
	static class Node
	{
		Node parent;
		int[][] mat;
		int x, y, cost, level;
		
		Node(int[][] mat, int x, int y, int level, Node parent)
		{
			this.mat = new int[3][3];
			
			for (int i = 0; i < 3; i++)
				System.arraycopy(mat[i], 0, this.mat[i], 0, 3);
			
			this.x = x;
			this.y = y;
			this.level = level;
			this.parent = parent;
			this.cost = Integer.MAX_VALUE;
		}
	}
	
	static void printMatrix(int[][] mat)
	{
		for (int[] row : mat) {
			for (int i : row)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	// Bottom, left, top, right movement
	static int[] row = {1, 0, -1, 0};
	static int[] col = {0, -1, 0, 1};
	
	static int calculateCost(int[][] initial, int[][] goal)
	{
		int count = 0;
		
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (initial[i][j] != 0 && initial[i][j] != goal[i][j])
					count++;
		
		return count;
	}
	
	static boolean isSafe(int x, int y)
	{
		return (x >= 0 && x < 3 && y >= 0 && y < 3);
	}
	
	static void printPath(Node root)
	{
		if (root == null)
			return;
		printPath(root.parent);
		printMatrix(root.mat);
		System.out.println();
	}
	
	static class Comp implements Comparator<Node>
	{
		public int compare(Node lhs, Node rhs)
		{
			return (lhs.cost + lhs.level) - (rhs.cost + rhs.level);
		}
	}
	
	static void solve(int[][] initial, int x, int y, int[][] goal)
	{
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comp());
		Node root = new Node(initial, x, y, 0, null);
		root.cost = calculateCost(initial, goal);
		
		pq.add(root);
		
		int count = 0;
		
		while (!pq.isEmpty()) {
			Node min = pq.poll();
			
			if (DEBUG)
				count++;
			
			if (min.cost == 0) {
				printPath(min);
				if (DEBUG) System.out.println("Max queue size was " + count);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int newX = min.x + row[i];
				int newY = min.y + col[i];
				
				if (isSafe(newX, newY)) {
					int[][] newMat = new int[3][3];
					
					for (int j = 0; j < 3; j++)
						System.arraycopy(min.mat[j], 0, newMat[j], 0, 3);
					
					newMat[min.x][min.y] = newMat[newX][newY];
					newMat[newX][newY] = 0;
					
					Node child = new Node(newMat, newX, newY, min.level + 1, min);
					child.cost = calculateCost(child.mat, goal);
					pq.add(child);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		DEBUG = Boolean.parseBoolean(args[0]);
		
		int[][] initial = {
				{1, 2, 3},
				{4, 0, 5},
				{6, 7, 8}
		};
		
		int[][] goal = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 0}
		};
		
		int x = 1, y = 1;
		solve(initial, x, y, goal);
	}
}