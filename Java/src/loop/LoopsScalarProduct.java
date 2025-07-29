package loop;

import java.util.Arrays;

public class LoopsScalarProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[args.length][], sclPrd = new int[args.length][];
		int j = 0;
		
		for(String arg : args) {
			String[] s = arg.split(",");
			int[] row = new int[s.length];
			
			for(int i = 0; i < s.length; i++)
				row[i] = Integer.parseInt(s[i]);
			
			matrix[j++] = row;
		}
		
		for(int i = 0; i < args.length; i++) {
			sclPrd[i] = new int[matrix[i].length];
			
			for(j = 0; j < matrix[i].length; j++) {
				int sum = 0;
				
				for(int k = 0; k < matrix[i].length; k++)
					sum += matrix[i][k] * matrix[k][j];
				
				sclPrd[i][j] = sum;
			}
		}
		
		System.out.print(Arrays.deepToString(sclPrd));
	}

}
