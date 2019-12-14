package L2_Dec14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2019
 *
 */

public class Pattern3 {

	public static void main(String[] args) {

		int n = 5;

		int nst = n;
		int row = 1;

		// row
		while (row <= n) {

			// work
			int col = 1;
			while (col <= nst) {
				System.out.print("*");
				col = col + 1;
			}

			// prep
			System.out.println();
			nst = nst - 1;
			row = row + 1;
		}

	}
}


