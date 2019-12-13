package L1_Dec12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class EvenOdd {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter n : ");
		int n = scn.nextInt();

		// logic ..
		if (n % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}

	}
}
