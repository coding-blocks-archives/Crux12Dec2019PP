package L2_Dec14;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2019
 *
 */

public class Pattern7 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		// rows : n
		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {

				if (row == 1 || row == n || col == 1 || col == n)
					System.out.print("*");
				else
					System.out.print(" ");
				
				col = col + 1;
			}

			// prep
			System.out.println();
			row = row + 1;
		}

	}

}





