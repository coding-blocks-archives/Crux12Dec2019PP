package L1_Dec12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class SumNNumbers {

	public static void main(String[] args) {

		int n = 5;

		int sum = 0;
		int count = 1;

		while (count <= n) {
			sum = sum + count;
			count = count + 1;
		}

		System.out.println(sum);

	}
}





