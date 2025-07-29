package javaCollectionExercises;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

@SuppressWarnings("unused")
public class CloneCollections 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new HashMapClone();
	}

}

class HashMapClone
{
	HashMapClone()
	{
		Map<Integer, Integer> map = new HashMap<>();
//		Map<Integer, Integer> newMap = new HashMap<>();
		
		map.put(0, 1);
		map.put(1, 2);
		map.put(2, 3);
		map.put(3, 4);
		
		// Copy by referring same object
//		newMap = map; // Refers to same object
		
		// Bulk copying
//		map.forEach((k, v) -> newMap.put(k, v));
		
		// Bulk copying using enhanced for
//		for (Entry<Integer, Integer> entry : map.entrySet())
//			newMap.put(entry.getKey(), entry.getValue());
		
		// Using putAll
//		newMap.putAll(map);
		
		// Using constructor
		Map<Integer, Integer> newMap = new HashMap<>(map);
		
		System.out.println("New map: " + newMap);
		
		map.put(4, 5);
		
		System.out.println("After putting to 'map', new map: " + newMap);
		
		newMap.put(5, 6);
		
		System.out.println("After putting to 'new map', map: " + map);
	}
}