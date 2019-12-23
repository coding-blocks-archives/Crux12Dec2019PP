package L7_Dec23;

import java.util.ArrayList;

public class ArrayListOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] one = { 1, 1, 1, 1 };
		int[] two = { 1, 1 };

		System.out.println(Intersection(one, two));

	}

	public static ArrayList<Integer> Intersection(int[] one, int[] two) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {

				res.add(one[i]);

				i++;
				j++;
			}

		}

		return res;

	}

	public static ArrayList<Integer> sum(int[] one, int[] two) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = one.length - 1;
		int j = two.length - 1;

		int carry = 0;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0) {
				sum += one[i];
			}

			if (j >= 0) {
				sum += two[j];
			}

			int rem = sum % 10;
			carry = sum / 10;

			res.add(0, rem);

			i--;
			j--;

		}

		if (carry > 0) {
			res.add(0, carry);
		}

		return res;

	}

}
