package Lec25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> map = new HashMap<>();

		// Put
		map.put("Mac", 3);
		map.put("Windows", 2);
		map.put("Linux", 16);
		map.put("Linux", 1);

		// Get
		System.out.println(map.get("Linux"));

		// Remove
		System.out.println(map.remove("Linux"));

		// ContainsKey
		System.out.println(map.containsKey("Linux"));

		// set
		map.put("Windows", 5);

		System.out.println(map);

		// Set
		Set<Integer> s = new HashSet<>();

		// KeySet
		Set<String> keyset = map.keySet();

		// Set -> ArrayList
		ArrayList<String> keyset2 = new ArrayList<>(keyset);

		for (String key : keyset2) {

			System.out.println(key + " : " + map.get(key));

		}

		s.add(1);
		s.add(2);
		s.add(3);
		s.add(1);

		System.out.println(s);

	}

}
