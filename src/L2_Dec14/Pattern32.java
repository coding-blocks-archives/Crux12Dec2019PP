package L2_Dec14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2019
 *
 */

public class Pattern32 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;

		int row = 1;

		while (row <= 2 * n - 1) {

			int val;

			if (row <= n) {
				val = row;
			} else {
				val = 2 * n - 1 - row + 1;
			}

			// work
			int cst = 1;
			while (cst <= nst) {

				if (cst % 2 == 0)
					System.out.print("*");
				else
					System.out.print(val);

				cst = cst + 1;
			}

			// prep
			System.out.println();

			if (row <= n - 1) {
				nst = nst + 2;
			} else {
				nst = nst - 2;
			}
			row = row + 1;
		}
	}
}
