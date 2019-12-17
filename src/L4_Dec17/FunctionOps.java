package L4_Dec17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Dec-2019
 *
 */

public class FunctionOps {

	public static void main(String[] args) {

		// printPrimes(10, 100);
		printArmstrong(10, 1000);
	}

	public static void printPrimes(int lo, int hi) {

		int i = lo;

		while (i <= hi) {

			boolean res = isPrime(i);

			if (res == true)
				System.out.println(i);

			i++;

		}

	}

	public static boolean isPrime(int num) {

		int fact = 0;

		int div = 1;

		while (div <= num) {

			if (num % div == 0) {
				fact++;
			}

			div++;
		}

		// if (fact == 2) {
		// return true;
		// } else {
		// return false;
		// }

		return fact == 2;
	}

	public static void printArmstrong(int lo, int hi) {

		int i = lo;

		while (i <= hi) {

			boolean res = isArmstrong(i);

			if (res == true)
				System.out.println(i);

			i++;

		}

	}

	public static boolean isArmstrong(int num) {

		int temp = num;

		int nod = noOfDigits(num);
		int ans = 0;

		while (num > 0) {

			int rem = num % 10;
			ans += Math.pow(rem, nod);
			num = num / 10;
		}

		// if (ans == temp) {
		// return true;
		// } else {
		// return false;
		// }

		return ans == temp;
	}

	public static int noOfDigits(int num) {

		int count = 0;

		while (num > 0) {
			count++;
			num = num / 10;
		}

		return count;
	}

}
