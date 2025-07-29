package forThree;

public class NestedForStringRepeatStringOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I am Prabhu and I am from Canada", u = "";
		String[] T = s.split(" ");
		
		for(int i = 0; i < T.length; i++) {
			int count = 1;
			for(int j = i + 1; j < T.length; j++) {
				if(T[i].equals(T[j])) {
					T[j] = "#";
					count++;
				}
			}
			if(count >= 1 && !T[i].equals("#"))
				u += T[i] + " ";
		}
		System.out.print(u);
	}

}
