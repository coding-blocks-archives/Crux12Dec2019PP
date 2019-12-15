package L3_Dec15;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2019
 *
 */

public class Rotate {

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
		
		rot = rot % nod ;
		
		if(rot < 0) {
			rot = rot + nod ;
		}

		// rotate
		int r = 1;

		while (r <= rot) {
			int rem = n % 10;
			int quotient = n / 10;

			int newNum = rem * (int) Math.pow(10, nod - 1) + quotient;
			n = newNum;
			r++;
		}

		System.out.println(n);

	}
}




