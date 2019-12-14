package L2_Dec14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2019
 *
 */

public class Pattern21 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;
		int nst = 1;
		int nsp = 2 * n - 3;

		while (row <= n) {

			// work
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

			if (row == n)
				cst2 = 2;

			while (cst2 <= nst) {
				System.out.print("*");
				cst2 = cst2 + 1;
			}

			// prep
			System.out.println();
			row = row + 1;
			nst = nst + 1;
			nsp = nsp - 2;
		}

	}
}
