package Assingments.Jan30;

public class AtmostKswaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "129814999";
		char[] charray = str.toCharArray();

		System.out.println(maxNumber(charray, 0, 4));

	}

	public static int maxNumber(char[] charray, int vidx, int k) {

		int curr_max = Integer.parseInt(new String(charray));
		if (k == 0) {
			return curr_max;
		}

		int NextMaxChar = max(charray, vidx);

		if (NextMaxChar == charray[vidx]) {
			return maxNumber(charray, vidx + 1, k);
		}

		for (int i = vidx + 1; i < charray.length; i++) {

			if (charray[i] == NextMaxChar) {
				swap(charray, vidx, i);
				int rr = maxNumber(charray, vidx + 1, k - 1);
				swap(charray, vidx, i);
				curr_max = Math.max(curr_max, rr);

			}

		}

		return curr_max;

	}

	public static void swap(char[] charray, int i, int j) {

		char temp = charray[i];
		charray[i] = charray[j];
		charray[j] = temp;
	}

	public static char max(char[] charray, int idx) {

		char m = charray[idx];
		for (int i = idx + 1; i < charray.length; i++) {

			if (charray[i] > m) {
				m = charray[i];
			}
		}

		return m;

	}

}
