package L2_Dec14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2019
 *
 */

public class Pattern17 {

	public static void main(String[] args) {

		int n = 13;

		int nst = n / 2;
		int nsp = 1;

		int row = 1;

		while (row <= n) {

			// work

			// stars
			int cst1 = 1;
			while (cst1 <= nst) {
				System.out.print("*");
				cst1 = cst1 + 1;
			}

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			// stars
			int cst2 = 1;
			while (cst2 <= nst) {
				System.out.print("*");
				cst2 = cst2 + 1;
			}

			// prep
			System.out.println();

			if (row <= n / 2) {
				nst = nst - 1;
				nsp = nsp + 2;
			} else {
				nst = nst + 1;
				nsp = nsp - 2;
			}

			row = row + 1;
		}

	}
}
