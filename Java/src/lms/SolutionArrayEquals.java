package lms;

public class SolutionArrayEquals {

	public static void main(String[] args) {
		
		int i = 0;
		boolean isEqual = true;
		int[][] ARR = new int[args.length][];
				
		for(String var : args) {
//			System.out.println(var);
			String[] S = var.split(",");
			int j = 0;
			int[] I = new int[S.length];
			for(String s : S)
				I[j++] = Integer.parseInt(s);
			ARR[i++] = I;
		}
		
		for(i = 0; i < ARR.length; i++)
			for(int j = i + 1; j < ARR.length; j++)
				if(ARR[i].length != ARR[j].length)
					isEqual = false;
		
		for(i = 0; i < ARR.length && isEqual; i++)
			for(int j = i + 1; j < ARR.length && isEqual; j++)
				for(int k = 0; k < ARR[i].length && isEqual; k++)
					if(ARR[i][k] != ARR[j][k])
						isEqual = false;
		
		if(isEqual)
			System.out.print("Equal");
		else
			System.out.print("Not equal");
	}

}
