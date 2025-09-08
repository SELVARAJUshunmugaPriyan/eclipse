package collectionsTwo;

import java.util.HashMap;

public class MaximumString {

	public static void main(String[] args) {
		
		HashMap<String, String> hm = new HashMap<>();
		hm.put("tree", "apple");
		hm.put("crop", "rice");
		hm.put("seed", "corn");
		hm.put("food", "butter");
		hm.put("drink", "milk");
		String maxVal = "", maxKey = "";
		for (String s : hm.keySet())
			if (s.length() > maxKey.length())
				maxKey = s;
		for (String s : hm.values())
			if (s.length() > maxVal.length())
				maxVal = s;
		System.out.println("Max key : " + maxKey
				+ "\nMax Val : " + maxVal);
	}

}
