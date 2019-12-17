package L4_Dec17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Dec-2019
 *
 */

public class ArrayDemo {

	public static void main(String[] args) {

		// int[] arr ;
		// arr = new int[5] ;

		int[] arr = new int[5];
		System.out.println(arr);

		// length
		System.out.println(arr.length);

		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		// set
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		// arr[5] = 60 ;

		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		int i = 0;
		while (i <= arr.length - 1) {
			System.out.println(arr[i]);
			i++;
		}

		for (i = 0; i <= arr.length - 1; i++) {
			System.out.println(arr[i]);
		}

		// reverse
		for (i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
			// arr[i] = 100 ;
		}

		// enhanced for loop
		// forward only
		// read only
		System.out.println("-- EFL --");
		for (int val : arr) {
			val = 100;
			System.out.println(val);
			System.out.println(val);
		}

		for (int val : arr) {
			System.out.println(val);
		}

		i = 0;
		int j = 2;

		System.out.println(arr[i] + ", " + arr[j]);
		Swap(arr[i], arr[j]);
		System.out.println(arr[i] + ", " + arr[j]);

		System.out.println(arr[i] + ", " + arr[j]);
		// Swap(arr, i, j);
		System.out.println(arr[i] + ", " + arr[j]);

		int[] other = { 100, 200, 300 };
		System.out.println(arr[0] + ", " + other[0]);
		Swap(arr, other);
		System.out.println(arr[0] + ", " + other[0]);
	}

	public static void Swap(int[] one, int[] two) {
		// int temp = one[0];
		// one[0] = two[0];
		// two[0] = temp;

		int[] temp = one;
		one = two;
		two = temp;

	}

	public static void Swap(int[] a, int i, int j) {
		System.out.println(a[i] + ", " + a[j]);

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

		System.out.println(a[i] + ", " + a[j]);
	}

	public static void Swap(int one, int two) {
		int temp = one;
		one = two;
		two = temp;
	}
}
