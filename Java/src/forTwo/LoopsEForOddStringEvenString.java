package forTwo;

public class LoopsEForOddStringEvenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sa = {"Hello", "Worlds"};
		String even = "", odd = "";
		
		for(String s : sa)
			if(s.length() % 2 == 0)
				even += s + " ";
			else
				odd += s + " ";
		
		System.out.print("Even: " + even + "\nOdd: " + odd);
	}

}
