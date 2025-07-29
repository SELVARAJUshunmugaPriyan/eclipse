package dayTwo;

public class StringExampleOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "welcome/to/my/world";
		String[] t = s.split("/");
//		t = {"welcome", "to", "my", "world"};
		System.out.println(t[t.length - 2].concat(t[t.length - 1]));
		System.out.println("Array length is " + t[0].length());
		System.out.println(t[t.length - 1].substring(1,t[t.length - 1].length() - 1));
		System.out.println("The last letter of " + t[0] + " is " + t[0].charAt(t[0].length() - 1));
	}

}
