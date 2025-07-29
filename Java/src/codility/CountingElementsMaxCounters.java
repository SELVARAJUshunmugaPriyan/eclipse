package codility;

//import java.util.Arrays;

public class CountingElementsMaxCounters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");


	class Solution {
	    public int[] solution(int N, int[] A) {

	        final int condition = N + 1;
	        int currentMax = 0;
	        int lastUpdate = 0;
	        int countersArray[] = new int[N];

	        for (int iii = 0; iii < A.length; iii++) {
	            int currentValue = A[iii];
	            if (currentValue == condition) {
	                lastUpdate = currentMax;
	            } else {
	                int position = currentValue - 1;
	                if (countersArray[position] < lastUpdate)
	                    countersArray[position] = lastUpdate + 1;
	                else
	                    countersArray[position]++;

	                if (countersArray[position] > currentMax) {
	                    currentMax = countersArray[position];
	                }
	            }

	        }

	        for (int iii = 0; iii < N; iii++) {
	           if (countersArray[iii] < lastUpdate)
	               countersArray[iii] = lastUpdate;
	        }

	        return countersArray;
	    }
	}
}
