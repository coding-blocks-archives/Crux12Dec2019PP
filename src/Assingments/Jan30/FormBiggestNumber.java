package Assingments.Jan30;

public class FormBiggestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 9, 911, 123, 99, 1232 };
		bubbleSort(arr);

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void bubbleSort(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (compare(arr[j], arr[j + 1])) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}
	}

	public static boolean compare(int n1, int n2) {

//		String s1 = String.valueOf(n1) + String.valueOf(n2);
		String s1 = n1 + "" + n2;
		String s2 = "" + n2 + n1;

		return s1.compareTo(s2) < 0;

	}

}
