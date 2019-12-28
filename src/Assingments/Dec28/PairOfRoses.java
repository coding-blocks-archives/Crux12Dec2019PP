package Assingments.Dec28;

import java.util.Arrays;
import java.util.Scanner;

public class PairOfRoses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t-- > 0) {
			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			int target = scn.nextInt();

			pairs(arr, target);
			
//			t--;
		}

	}

	public static void pairs(int[] arr, int target) {

		Arrays.sort(arr);

		int i = 0, j = arr.length - 1;

		int a = 0;
		int b = 0;

		while (i < j) {

			int sum = arr[i] + arr[j];

			if (sum < target) {

				i++;
			} else if (sum > target) {
				j--;
			} else {

				a = arr[i];
				b = arr[j];

				i++;
				j--;

			}

		}

		System.out.println("Deepak should buy roses whose prices are " + a + " and " + b + ".");

	}

}
