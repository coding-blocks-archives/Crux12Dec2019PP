package Assingments.Jan30;

public class GenerateSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 10, 15, 25 };
		int[] B = { 1, 5, 20, 30 };

		int[] C = new int[A.length + B.length];

		generate(A, B, C, 0, 0, 0, true);

	}

	public static void generate(int[] A, int[] B, int[] C, int i, int j, int len, boolean isA) {

		if (isA) {

			if (len != 0)
				printArray(C, len);

			for (int k = i; k < A.length; k++) {

				if (len == 0) {
					C[len] = A[k];
					generate(A, B, C, k + 1, j, len, false);
				} else {
					if (C[len] < A[k]) {
						C[len + 1] = A[k];
						generate(A, B, C, k + 1, j, len + 1, false);
					}
				}

			}

		} else {

			for (int k = j; k < B.length; k++) {

				if (C[len] < B[k]) {
					C[len + 1] = B[k];

					generate(A, B, C, i, k + 1, len + 1, true);
				}
			}
		}

	}

	public static void printArray(int[] C, int len) {

		for (int i = 0; i <= len; i++) {
			System.out.print(C[i] + " ");
		}
		System.out.println();

	}

}
