package L1_Dec12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2019
 *
 */

public class ConditionalStatmentDemo {

	public static void main(String[] args) {

		System.out.println("Hii");

		int marks = 80;

		if (marks == 80) {
			System.out.println("Good");
		} else if (marks >= 50 && marks < 80) {
			System.out.println("Avg");
		} else if (marks > 20 || marks < 50) {
			System.out.println("Bad");
		} else {
			System.out.println("In else");
		}

		if (marks > 30) {
			System.out.println("in if");
		}

		System.out.println("Bye");

	}
}
