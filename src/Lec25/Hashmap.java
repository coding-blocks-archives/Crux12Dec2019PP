package Lec25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Hashmap {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		HashMap<String, Integer> map = new HashMap<>();

		// Put
		map.put("Mac", 3);
		map.put("Windows", 2);
		map.put("Linux", 16);
		map.put("Linux", 1);

		// Get
		System.out.println(map.get("Linux"));

		// GetOrDefault
		System.out.println("DEFAULT: " + map.getOrDefault("mac", 23));

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

		int[] a = {1,2};
		a.toString();
		System.out.println(maxFreqChar("ababcdassaadssdssa"));

	}

	public static char maxFreqChar(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

//		for(int i = 0;i < str.length();i++) {
//			
//		}

		for (char ch : str.toCharArray()) {

			if (map.containsKey(ch)) {

				int ov = map.get(ch);
				map.put(ch, ov + 1);

			} else {

				map.put(ch, 1);
			}

//			map.put(ch, map.getOrDefault(ch, 0) + 1);

		}

		System.out.println(map);

		int max = 0;
		char res = '$';

		for (char key : map.keySet()) {

			if (map.get(key) > max) {
				max = map.get(key);
				res = key;
			}

		}

		return res;

	}

	public static void maxContIncr(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int val : arr) {

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1))
				map.put(val + 1, false);

		}

		int max = 0;
		int start = 0;

		for (int key : map.keySet()) {

			if (map.get(key)) {

				int count = 1;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > max) {
					max = count;
					start = key;
				}

			}
		}

		for (int i = start; i < start + max; i++) {
			System.out.print(i + " ");
		}

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int val : one) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		ArrayList<Integer> res = new ArrayList<>();

		for (int val : two) {

			if (map.containsKey(val) && map.get(val) > 0) {
				res.add(val);
				map.put(val, map.get(val) - 1);

//				if (map.get(val) == 0) {
//					map.remove(val);
//				}
			}
		}

		return res;

	}

	
	
}
