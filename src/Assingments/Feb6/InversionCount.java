package Assingments.Feb6;

import java.util.Arrays;

public class InversionCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 20, 6, 4, 5 };
		System.out.println(invCount(arr, 0, arr.length - 1));
	}

	public static int invCount(int[] arr, int lo, int hi) {

		if (lo == hi) {
			return 0;
		}

		int mid = (lo + hi) / 2;

		int count = 0;
		count += invCount(arr, lo, mid);
		count += invCount(arr, mid + 1, hi);

		count += mergeAndCount(arr, lo, mid, hi);

		return count;

	}

	public static int mergeAndCount(int[] arr, int lo, int mid, int hi) {

		int[] left = Arrays.copyOfRange(arr, lo, mid + 1);
		int[] right = Arrays.copyOfRange(arr, mid + 1, hi + 1);

		int i = 0, j = 0, k = lo;

		int cnt = 0;

		while (i < left.length && j < right.length) {

			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
				cnt += (left.length - i);
			}
		}

		while (i < left.length) {
			arr[k++] = left[i++];
		}

		while (j < right.length) {
			arr[k++] = right[j++];
		}

		return cnt;
	}

}
