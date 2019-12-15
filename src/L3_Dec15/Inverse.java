package L3_Dec15;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2019
 *
 */

public class Inverse {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int num = scn.nextInt();

		int ans = 0;

		int pos = 1;

		while (num > 0) {

			int rem = num % 10;

			ans = ans + pos * (int) Math.pow(10, rem - 1);

			pos++;
			num = num / 10;
		}

		System.out.println(ans);

	}
}
