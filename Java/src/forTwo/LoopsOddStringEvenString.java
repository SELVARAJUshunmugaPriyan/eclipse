package forTwo;

public class LoopsOddStringEvenString {
	public static void main(String[] args) {
		String[] sa = {"Hello", "Worlds", "doggy", "dolly"};
		String odd = "", even = "";
		
//		System.out.print("Even: ");
//		for(int i = 0; i < sa.length; i++)
//			if(sa[i].length() % 2 == 0)
//				System.out.print(sa[i] + " ");
//		System.out.print("\nOdd: ");
//		for(int i = 0; i < sa.length; i++)
//			if(sa[i].length() % 2 == 1)
//				System.out.print(sa[i] + " ");
		
		for(int i = 0; i < sa.length; i++)
			if(sa[i].length() % 2 == 0)
				even += sa[i] + " ";
			else
				odd += sa[i] + " ";
		
		System.out.print("Even: " + even + "\nOdd: " + odd);
	}
}
