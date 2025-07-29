package javaCollectionExercises;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class KeyExistsHashMapCollections 
{
	
	KeyExistsHashMapCollections()
	{
		Map<Integer, Integer> nums = new HashMap<>();
		
		nums.put(0, 0);
		nums.put(1, 1);
		
		Integer key = 1;
		// Using iterator
		Iterator< Entry<Integer, Integer> > iter 
				   = nums.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> entry = iter.next();
			if (key == entry.getKey())
				System.out.println("Key found");
			else
				System.out.println("no match");
		}
		
		// Using containsKey()
//		System.out.println((nums.containsKey(key) ? "" 
//				: "no ") + "match");
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new KeyExistsHashMapCollections();
	}

}
