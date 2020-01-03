package Lec14_3Jan;

import java.util.Scanner;

public class FunctionOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(sum(2, 3));
//		System.out.println(sum(2, 3, 1));

		
		Scanner scn = new Scanner(System.in);
		sum(1);
//		sum();
		System.out.println(sum(1, 2, 3, 4, 5));

	}

	public int sum(int a) {
		return a;
	}

	public static int sum(int a, int... arr, String str) {

		System.out.println("var args");
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}

		return sum;

	}

	public static int sum(int a, int b) {

		System.out.println("int");
		return a + b;

	}

	public static int sum(int a, int b, int c) {

		System.out.println("three");
		return a + b + c;
	}

}
