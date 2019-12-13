package L1_Dec12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class LoopDemo {

	public static void main(String[] args) {

		int x = 100;
		x = 200;

		System.out.println(x);
		//
		// System.out.println("hello");
		// System.out.println("hello");
		// System.out.println("hello");
		// System.out.println("hello");
		// System.out.println("hello");

		int count = 1; // initialisation

		while (count <= 10)

		{ // condition
			System.out.println("hello");
			count = count + 1; // re-initialisation
		}

		System.out.println(count);
		System.out.println("Bye");

	}
}
