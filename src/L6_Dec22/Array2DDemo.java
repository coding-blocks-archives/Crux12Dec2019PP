package L6_Dec22;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Dec-2019
 *
 */

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = new int[3][4];

		System.out.println(arr);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		// rows
		System.out.println(arr.length);
		// cols
		System.out.println(arr[0].length);

		// set
		arr[0][2] = 100;

		// get
		System.out.println(arr[0][2]);

		// Jagged array
		System.out.println(" -- JA -- ");

		int[][] jarr = new int[3][];

		System.out.println(jarr);

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		jarr[0] = new int[5];
		jarr[1] = new int[3];
		jarr[2] = new int[7];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		// rows
		System.out.println(jarr.length);
		// cols
		System.out.println(jarr[0].length);
		System.out.println(jarr[1].length);
		System.out.println(jarr[2].length);

	}
}
