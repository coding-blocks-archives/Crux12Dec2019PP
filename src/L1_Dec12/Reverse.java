package L1_Dec12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class Reverse {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int ans = 0 ;
		
		int n = scn.nextInt();

		while (n > 0) {

			int rem = n % 10;
			ans = ans * 10 + rem ;
			n = n / 10;

		}

		System.out.println(ans);
	}
}








