package L2_Dec14;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2019
 *
 */

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int ans = 0;

		int mult = 1; // 10^0
		while (n > 0) {

			int rem = n % 2;

			ans = ans + rem * mult;

			mult = mult * 10;
			n = n / 2;

		}

		System.out.println(ans);

	}
}
