package L3_Dec15;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2019
 *
 */

public class Rotate2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int rot = scn.nextInt();

		// no. of digits
		int temp = n;
		int nod = 0;
		while (temp > 0) {
			nod++;
			temp = temp / 10;
		}

		rot = rot % nod;

		if (rot < 0) {
			rot = rot + nod;
		}

		int divisor = (int) Math.pow(10, rot);
		int multiplier = (int) Math.pow(10, nod - rot);

		int rem = n % divisor;
		int quotient = n / divisor;

		int ans = rem * multiplier + quotient;

		System.out.println(ans);

	}
}
