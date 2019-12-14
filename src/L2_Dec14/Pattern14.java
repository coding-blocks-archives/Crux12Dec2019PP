package L2_Dec14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2019
 *
 */

public class Pattern14 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = n - 1;
		int nst = 1;
		int row = 1;

		while (row <= 2 * n - 1) {

			// work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			System.out.println();

			if (row <= n - 1) {
				nst = nst + 1;
				nsp = nsp - 1;
			} else {
				nst = nst - 1;
				nsp = nsp + 1;
			}

			row = row + 1;
		}

	}
}
