package L2_Dec14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2019
 *
 */

public class Pattern12 {

	public static void main(String[] args) {

		int n = 10;

		int nsp = n - 1;
		int nst = 1;
		int row = 1;

		while (row <= n) {

			// work

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("  ");
				csp = csp + 1;
			}

			// stars
			int cst = 1;
			while (cst <= nst) {
				if (cst % 2 == 0)
					System.out.print("! ");
				else
					System.out.print("* ");
				cst = cst + 1;
			}

			// prep
			System.out.println();
			row = row + 1;
			nsp = nsp - 1;
			nst = nst + 2;
		}

	}
}
