package lms;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionRemoveDuplicate {

	public static void main(String[] args) {
		
		ArrayList<Integer> I = new ArrayList<Integer>();
		
		for(String arg : args) {
			String[] S = arg.split(",");
			for(String s : S)
				I.add(Integer.parseInt(s));
		}
		
		for(int i = 0; i < I.size(); i++)
			for(int j = i + 1; j < I.size(); j++)
				if(I.get(i) == I.get(j)) {
//					I.remove(i--);
					I.remove(j);
				}
		
		Collections.sort(I);
		
		for(int i : I)
			System.out.print(i + " ");
	}

}
