package Lec14_3Jan;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 4, 1, 3, 5 };

		int[] ans = mergesort(arr, 0, arr.length - 1);

		for (int val : ans) {
			System.out.print(val + " ");
		}

		System.out.println();
		System.out.println(count);

	}

	public static int[] mergesort(int[] arr, int lo, int hi) {

		if (lo == hi) {

			int[] br = new int[1];
			br[0] = arr[lo];

			return br;

		}

		int mid = (lo + hi) / 2;

		int[] fh = mergesort(arr, lo, mid);
		int[] sh = mergesort(arr, mid + 1, hi);

		int[] ans = mergeTwosortedArrays(fh, sh);

		return ans;

	}

	static int count = 0;

	public static int[] mergeTwosortedArrays(int[] one, int[] two) {

		int i = 0, j = 0, k = 0;

		int[] res = new int[one.length + two.length];

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {

				res[k] = one[i];
				i++;
				k++;
			} else {

				count += one.length - i;
				res[k] = two[j];
				j++;
				k++;
			}

		}

		while (i < one.length) {

			res[k] = one[i];
			i++;
			k++;
		}

		while (j < two.length) {
			res[k] = two[j];
			j++;
			k++;

		}

		return res;
	}

}
