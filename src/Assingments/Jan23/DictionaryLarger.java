package Assingments.Jan23;

import java.util.Arrays;

public class DictionaryLarger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "bacd";

		char[] charry = str.toCharArray();
		Arrays.sort(charry);

		String res = new String(charry);

		prmt2(res, "", str);

	}

	public static void prmt2(String ques, String ans, String orig) {

		if (ques.length() == 0) {

			if (ans.compareTo(orig) > 0) {
				System.out.println(ans);
			}

			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);

			prmt2(ros, ans + ch, orig);
		}

	}

}
