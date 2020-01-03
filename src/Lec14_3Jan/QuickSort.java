package Lec14_3Jan;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 5, 1, 4, 9, 8, 2 };

		quicksort(arr, 0, arr.length - 1);

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void quicksort(int[] arr, int lo, int hi) {

		if (lo >= hi) {

			return;
		}

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo, right = hi;

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}

		}

		quicksort(arr, lo, right);
		quicksort(arr, left, hi);

	}
	
	

}
