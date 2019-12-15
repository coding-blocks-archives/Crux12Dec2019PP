package L3_Dec15;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2019
 *
 */

public class Conversion {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int minF = scn.nextInt();
		int maxF = scn.nextInt();
		int steps = scn.nextInt();

		int f = minF;

		while (f <= maxF) {

			int c = (int) ((5.0 / 9) * (f - 32));
			System.out.println(f + "\t" + c);

			f = f + steps;
		}

	}
}
