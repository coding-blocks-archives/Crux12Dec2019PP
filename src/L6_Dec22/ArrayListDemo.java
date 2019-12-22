package L6_Dec22;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Dec-2019
 *
 */

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		System.out.println(list);

		// add
		list.add(10);
		System.out.println(list);
		list.add(20);
		System.out.println(list);
		list.add(30);
		System.out.println(list);

		// size
		System.out.println(list.size());

		// add at a index
		// worst performance : n
		// best performance : constant
		// range : 0 -> size
		list.add(0, 100);
		System.out.println(list);
		list.add(list.size(), 40);
		System.out.println(list);

		// get
		// performance : constant
		// range : 0 -> size-1
		System.out.println(list.get(list.size() - 1));

		// set
		// performance : constant
		// range : 0 -> size-1
		System.out.println(list);
		list.set(2, 500);
		System.out.println(list);

		// remove
		// worst performance : n : while removing from 0 index
		// best performance : constant : while removing from last index
		// range : 0 -> size-1
		list.remove(2);
		System.out.println(list);

		// loop
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// enhanced loop
		for (int val : list) {
			System.out.println(val);
		}
	}
}
