package L8_Dec24;

import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		PD(7);

		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		System.out.println(fact(n));

		print(3);

		int[] arr = { 1, 2, 9, 4, 5, 2, 2 };

//		printArray(arr, 0);
//		System.out.println(max(arr, 0));
		System.out.println(FirstOccurence(arr, 0, 2));
		System.out.println(LastOccurence(arr, 0, 2));
		int[] ans = AllOccurence(arr, 0, 2, 0);

		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

	public static int fact(int n) {

		if (n == 1) {
			return 1;
		}

		int fn = fact(n - 1);

		return fn * n;

	}

	public static void PD(int n) {

		if (n == 0) {
			return;
		}

		if (n % 2 != 0)
			System.out.println(n);

		// smaller problem
		PD(n - 1);

		// Self Work
		if (n % 2 == 0)
			System.out.println(n);
	}

	public static int fibo(int n) {

		if (n == 1 || n == 0) {
			return n;
		}

		int f1 = fibo(n - 1);
		int f2 = fibo(n - 2);

		return f1 + f2;

	}

	public static void print(int n) {

		for (int i = 1; i <= n; i++) {
			System.out.print("-");
		}

		System.out.println();

	}

	public static int power(int a, int b) {

		if (b == 0) {
			return 1;
		}

		return power(a, b - 1) * a;

	}

	public static void printArray(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);

		printArray(arr, vidx + 1);

	}

	public static int max(int[] arr, int vidx) {

		if (vidx == arr.length) {

			return Integer.MIN_VALUE;
		}

		int m = max(arr, vidx + 1);

		return Math.max(arr[vidx], m);

	}

	public static int FirstOccurence(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		}

		int rr = FirstOccurence(arr, vidx + 1, item);
		return rr;

	}

	public static int LastOccurence(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		int rr = LastOccurence(arr, vidx + 1, item);

		if (arr[vidx] == item) {
			return Math.max(vidx, rr);
		}

		return rr;

	}

	public static int[] AllOccurence(int[] arr, int vidx, int item, int cnt) {

		if (vidx == arr.length) {
			int[] brr = new int[cnt];

			return brr;
		}

		if (arr[vidx] != item) {

			return AllOccurence(arr, vidx + 1, item, cnt);
		} else {

			int[] rr = AllOccurence(arr, vidx + 1, item, cnt + 1);
			rr[cnt] = vidx;

			return rr;
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
