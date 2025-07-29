package codility;

public class PrefixSumsMinAvgTwoSlice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-3, -5, -8, -4, -10};
		float minAvg =  10001;
        int minAvgStartPosition = -1;
        for(int i =0; i < A.length-1; i++){
            float twoAvg = (A[i] + A[i+1])/2f;
            if(twoAvg < minAvg){
                minAvg = twoAvg;
                minAvgStartPosition = i;
            }
            if(i != A.length - 2){
                float threeAvg = (A[i] + A[i+1] + A[i+2])/3f;
                if(threeAvg < minAvg){
                    minAvg = threeAvg;
                    minAvgStartPosition = i;
                }
            }
        }
        System.out.print(minAvgStartPosition);
    }
}