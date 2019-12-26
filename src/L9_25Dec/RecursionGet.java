package L9_25Dec;

import java.util.ArrayList;

public class RecursionGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> ans = new ArrayList<>();

//		System.out.println(Subseq("abc"));

//		System.out.println(keypad("145").size());

//		System.out.println(prmt("abc"));

//		System.out.println(mazePath(0, 0, 2, 2));
//		System.out.println(mazePathMM(0, 0, 2, 2));
		
		System.out.println(boardPath(0, 10).size());

	}

	public static ArrayList<String> Subseq(String str) {

		if (str.length() == 0) {

			ArrayList<String> br = new ArrayList<>();
			br.add("");

			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = Subseq(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			mr.add(val);
			mr.add(ch + val);
		}

		return mr;

	}

	public static ArrayList<String> SubseqAscii(String str) {

		if (str.length() == 0) {

			ArrayList<String> br = new ArrayList<>();
			br.add("");

			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = SubseqAscii(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			mr.add(val);
			mr.add(ch + val);
			mr.add((int) (ch) + val);
		}

		return mr;

	}

	public static ArrayList<String> keypad(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = keypad(ros);
		ArrayList<String> mr = new ArrayList<String>();
		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			for (String val : rr) {
				mr.add(code.charAt(i) + val);
			}
		}

		return mr;

	}

	public static ArrayList<String> prmt(String str) {

		if (str.length() == 0) {

			ArrayList<String> br = new ArrayList<String>();
			br.add("");

			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = prmt(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			for (int i = 0; i <= val.length(); i++) {

				String ns = val.substring(0, i) + ch + val.substring(i);

				mr.add(ns);
			}
		}

		return mr;

	}

	public static ArrayList<String> cointoss(int n) {

		if (n == 0) {

			ArrayList<String> br = new ArrayList<String>();
			br.add("");

			return br;
		}

		ArrayList<String> rr = cointoss(n - 1);
		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {

			mr.add("H" + val);
			mr.add("T" + val);
		}

		return mr;

	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {

			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {

			ArrayList<String> br = new ArrayList<String>();
			return br;
		}
		ArrayList<String> rr1 = mazePath(cr + 1, cc, er, ec);
		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr1) {

			mr.add("V" + val);
		}
		ArrayList<String> rr2 = mazePath(cr, cc + 1, er, ec);

		for (String val : rr2) {

			mr.add("H" + val);
		}
		return mr;

	}

	public static ArrayList<String> mazePathMM(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {

			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {

			ArrayList<String> br = new ArrayList<String>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		for (int m = 1; m <= er; m++) {
			ArrayList<String> rr1 = mazePathMM(cr + m, cc, er, ec);

			for (String val : rr1) {

				mr.add("V" + m + val);
			}
		}

		for (int m = 1; m <= ec; m++) {
			ArrayList<String> rr2 = mazePathMM(cr, cc + m, er, ec);

			for (String val : rr2) {

				mr.add("H" + m + val);
			}
		}

		for (int m = 1; m <= er && m <= ec; m++) {
			ArrayList<String> rr3 = mazePathMM(cr + m, cc + m, er, ec);

			for (String val : rr3) {

				mr.add("D" + m + val);
			}
		}

		return mr;

	}

	public static ArrayList<String> boardPath(int curr, int end) {

		if (curr == end) {

			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		if (curr > end) {

			ArrayList<String> br = new ArrayList<String>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		for (int dice = 1; dice <= 6 && curr + dice <= end; dice++) {

			ArrayList<String> rr = boardPath(curr + dice, end);

			for (String val : rr) {

				mr.add(dice + val);
			}

		}
		
		return mr;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
