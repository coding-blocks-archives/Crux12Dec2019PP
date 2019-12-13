package L1_Dec12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class Prime2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				System.out.println("Not Prime");
				break;
			}

			div = div + 1;
		}

		if (div == n)
			System.out.println("Prime");

	}
}




