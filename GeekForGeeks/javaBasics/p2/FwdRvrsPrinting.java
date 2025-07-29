package p2;

public class FwdRvrsPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = 1;
		for (int i = 1; i > 0; i = i + j) {
			if (i == 6) {
				j = -1;
				continue;
			}
			System.out.println(i);
		}
	}

}
