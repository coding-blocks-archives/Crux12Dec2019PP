package L1_Dec12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class GCD {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		int div = Math.min(n1, n2);

		while (div >= 1) {

			if (n1 % div == 0 && n2 % div == 0) {
				System.out.println(div);
				break;
			}

			div = div - 1;
		}

	}
}
