package L1_Dec12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class GCD2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int divident = scn.nextInt();
		int divisor = scn.nextInt();

		while (divident % divisor != 0) {

			int rem = divident % divisor;

			// update
			divident = divisor;
			divisor = rem;
		}

		System.out.println(divisor);

	}
}
