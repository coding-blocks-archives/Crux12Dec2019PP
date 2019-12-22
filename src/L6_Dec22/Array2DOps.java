package L6_Dec22;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Dec-2019
 *
 */

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[][] arr = takeInput();

		// int[][] arr = { { 1, 2, 3, 4, 5 }, { 7, 8, 9, 10, 11 }, { 13, 14, 15, 16, 17
		// } };
		// { 19, 20, 21, 22, 23, 24 }, };

		// display(arr);

		// waveDisplay(arr);
		// spiralDisplay(arr);

		// int[][] one = { { 1, 2, 3 }, { 4, 5, 6 } };
		// int[][] two = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		//
		// display(matrixMultiplication(one, two));

		int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		System.out.println(search2DSorted(arr, 100));
	}

	public static int[][] takeInput() {

		// ask user for no. of rows ?
		System.out.println("Rows ?");
		int rows = scn.nextInt();

		// create a new array with null values at every index
		int[][] arr = new int[rows][];

		// loop on row to update the null value
		for (int r = 0; r < arr.length; r++) {

			// ask for no. of cols in every row ?
			System.out.println("Cols for " + r + " row ?");
			int cols = scn.nextInt();

			// point to some 1d array
			arr[r] = new int[cols];

			// update the 0 values in every 1D array
			for (int c = 0; c < arr[r].length; c++) {

				System.out.println("[" + r + "-" + c + "] ?");
				arr[r][c] = scn.nextInt();
			}

		}

		return arr;

	}

	public static void display(int[][] arr) {

		// for(int r = 0 ; r < arr.length ; r ++) {
		//
		// for(int c =0 ; c < arr[r].length ; c++) {
		// System.out.print(arr[r][c] + " ");
		// }
		//
		// System.out.println();
		// }

		for (int[] val : arr) {
			for (int temp : val) {
				System.out.print(temp + "\t");
			}
			System.out.println();
		}
	}

	public static void waveDisplay(int[][] arr) {

		for (int c = 0; c < arr[0].length; c++) {

			if (c % 2 == 0) {
				for (int r = 0; r < arr.length; r++) {
					System.out.print(arr[r][c] + " ");
				}
			} else {
				for (int r = arr.length - 1; r >= 0; r--) {
					System.out.print(arr[r][c] + " ");
				}
			}
		}
		System.out.println();
	}

	public static void spiralDisplay(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int nel = arr.length * arr[0].length;
		int count = 0;

		while (count < nel) {

			// first col
			for (int r = minRow; r <= maxRow && count < nel; r++) {
				System.out.print(arr[r][minCol] + " ");
				count++;
			}
			minCol++;

			// last row
			for (int c = minCol; c <= maxCol && count < nel; c++) {
				System.out.print(arr[maxRow][c] + " ");
				count++;
			}
			maxRow--;

			// last col
			for (int r = maxRow; r >= minRow && count < nel; r--) {
				System.out.print(arr[r][maxCol] + " ");
				count++;
			}
			maxCol--;

			// first row
			for (int c = maxCol; c >= minCol && count < nel; c--) {
				System.out.print(arr[minRow][c] + " ");
				count++;
			}
			minRow++;

		}

	}

	public static int[][] matrixMultiplication(int[][] one, int[][] two) {

		int r1 = one.length;
		int c1 = one[0].length;

		int r2 = two.length;
		int c2 = two[0].length;

		int[][] ans = new int[r1][c2];

		for (int i = 0; i < ans.length; i++) {

			for (int j = 0; j < ans[0].length; j++) {

				int sum = 0;

				for (int k = 0; k < c1; k++) {
					sum = sum + one[i][k] * two[k][j];
				}

				ans[i][j] = sum;
			}
		}

		return ans;
	}

	public static boolean search2DSorted(int[][] arr, int item) {

		int row = 0;
		int col = arr[0].length - 1;

		while (col >= 0 && row < arr.length) {

			if (arr[row][col] > item) {
				col--;
			} else if (arr[row][col] < item) {
				row++;
			} else {
				System.out.println(row + " - " + col);
				return true;
			}
		}

		return false;
	}

}
