package Assingments.Jan16;

public class FormMinimumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		min("IDI");
	}

	public static void min(String str) {

		int cnt = 1;
		int[] res = new int[str.length() + 1];

		for (int i = 0; i <= str.length(); i++) {

			if (i == str.length() || str.charAt(i) == 'I') {
				res[i] = cnt++;
				for (int j = i - 1; j >= 0 && str.charAt(j) != 'I'; j--) {
					res[j] = cnt++;

				}

			}

		}

		for (int val : res) {
			System.out.print(val);
		}

		System.out.println();

	}

}
