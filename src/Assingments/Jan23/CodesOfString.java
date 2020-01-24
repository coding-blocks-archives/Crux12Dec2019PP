package Assingments.Jan23;

import java.util.ArrayList;

public class CodesOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(codes("127"));
		System.out.println(codes2("1125"));
	}

	public static ArrayList<String> codes(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		String ch1 = str.substring(0, 1);
		String ros1 = str.substring(1);

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr1 = codes(ros1);

		int digit1 = Integer.parseInt(ch1);
		char code1 = (char) ('a' + digit1 - 1);

		for (String val : rr1) {
			mr.add(code1 + val);
		}

		if (str.length() >= 2) {

			String ch2 = str.substring(0, 2);
			String ros2 = str.substring(2);

			int digit2 = Integer.parseInt(ch2);

			if (digit2 > 26) {
				return mr;
			}
			char code2 = (char) ('a' + digit2 - 1);

			ArrayList<String> rr2 = codes(ros2);

			for (String val : rr2) {
				mr.add(code2 + val);
			}
		}

		return mr;
	}

	public static ArrayList<String> codes2(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();

		for (int i = 1; i <= 2; i++) {

			if (i > str.length()) {
				return mr;
			}

			String ch1 = str.substring(0, i);
			String ros1 = str.substring(i);
			int digit1 = Integer.parseInt(ch1);

			if (digit1 > 26) {
				return mr;
			}

			ArrayList<String> rr1 = codes(ros1);
			char code1 = (char) ('a' + digit1 - 1);

			for (String val : rr1) {
				mr.add(code1 + val);
			}
		}

		return mr;
	}
}
