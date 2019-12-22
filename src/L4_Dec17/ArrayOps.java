package L4_Dec17;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Dec-2019
 *
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] arr = takeInput();
		// display(arr);
		// System.out.println(maximum(arr));
		//
		// int item = scn.nextInt();
		// System.out.println(linearSearch(arr, item));
		// System.out.println(binarySearch(arr, item));

		// display(takeInput());

		// int[] arr = { 3, 2, 4, 1, 0 };

		// reverse(arr);
		// rotate(arr, -40);
		// display(arr);

		// rotate1(arr, -40);

		// arr = inverse(arr);
		// display(arr);

		int[] arr = { 11, 44, 5, 9, 8 };
		// subarray(arr);

		// subarraySum2Loops(arr);

		// coinToss(3);
		// bubbleSort(arr);
		// selectionSort(arr);
		insertionSort(arr);

		display(arr);
	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] ?");
			arr[i] = scn.nextInt();
		}

		return arr;

	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static int maximum(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1;
	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) {
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}

		}

		return -1;

	}

	public static void reverse(int[] arr) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;

			lo++;
			hi--;

		}
	}

	public static void reverse(int[] arr, int i, int j) {

		int lo = i;
		int hi = j;

		while (lo <= hi) {

			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;

			lo++;
			hi--;

		}
	}

	public static void rotate(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0) {
			rot = rot + arr.length;
		}

		// multiple rotation
		for (int r = 1; r <= rot; r++) {

			// for one rotation
			int temp = arr[arr.length - 1];

			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}

			arr[0] = temp;
		}

	}

	public static void rotate1(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0) {
			rot = rot + arr.length;
		}

		reverse(arr, 0, arr.length - rot - 1);
		reverse(arr, arr.length - rot, arr.length - 1);
		reverse(arr);
	}

	public static int[] inverse(int[] arr) {

		int[] inv = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inv[arr[i]] = i;
		}

		return inv;
	}

	public static void subarray(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= arr.length - 1; ei++) {

				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}

		}

	}

	public static void subarraySum3Loops(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= arr.length - 1; ei++) {

				System.out.print(si + " " + ei + ": ");

				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum = sum + arr[k];
				}
				System.out.println(sum);
			}

		}

	}

	public static void subarraySum2Loops(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			int sum = 0;

			for (int ei = si; ei <= arr.length - 1; ei++) {

				sum += arr[ei];

				System.out.println(sum);
			}
		}
	}

	public static void coinToss(int n) {

		int limit = (int) Math.pow(2, n);

		for (int i = 0; i <= limit - 1; i++) {

			int temp = i;

			for (int j = 1; j <= n; j++) {

				int rem = temp % 2;

				if (rem == 1)
					System.out.print("H");
				else
					System.out.print("T");

				temp /= 2;
			}

			System.out.println();

		}

	}

	public static void bubbleSort(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			System.out.println("Count : " + count);

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (arr[j] > arr[j + 1]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

				display(arr);
			}

		}
	}

	public static void selectionSort(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			// find the index of smallest value
			int min = count;

			for (int j = count + 1; j <= arr.length - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			// you wanted to place the smallest value at count index, and you got the
			// smallest value at min index
			int temp = arr[min];
			arr[min] = arr[count];
			arr[count] = temp;
		}

	}

	public static void insertionSort(int[] arr) {

		for (int count = 1; count <= arr.length - 1; count++) {

			int temp = arr[count];

			int j = count - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;

		}

	}

}
