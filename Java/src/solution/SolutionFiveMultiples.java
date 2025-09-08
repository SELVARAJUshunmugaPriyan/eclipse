package solution;

public class SolutionFiveMultiples {

	public static void main(String[] args) {
		
		String s = "2,12,44,8";
		
		for (String t : s.split(",")) {
			int num = Integer.parseInt(t);
			
			if (num < 5)
				num = 5;
			else if (num % 5 <= 2)
				num -= num % 5;
			else
				num += 5 - num %5;
			
			System.out.print("" + num + ",");
		}
	}

}
