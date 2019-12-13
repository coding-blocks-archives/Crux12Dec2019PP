package L1_Dec12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class Prime3 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int flag = 0;

		int n = scn.nextInt();

		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				flag = 1;
			}

			div = div + 1;
		}

		if (flag == 1) {
			System.out.println("not prime");
		} else {
			System.out.println("prime");
		}

	}
}
