package Assingments.Jan23;

public class GenerateBinaryStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		generate("1??01", "");
	}

	public static void generate(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		if (ch == '?') {

			generate(ros, ans + 0);
			generate(ros, ans + 1);
		} else {
			generate(ros, ans + ch);

		}

	}

}
