package L10_26Dec;

import L9_25Dec.RecursionGet;

public class RecursionPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Subseq("abc", "");
//		KeypadComb("145", "");

//		prmt("abc", "");

		System.out.println("---------");
//		prmt2("abc", "");

//		System.out.println(coinToss(3, ""));

//		System.out.println(BoardPath(0, 10, ""));
		
		LexiCounting(0, 1000);
	}

	public static void Subseq(String ques, String ans) {

		if (ques.length() == 0) {

			System.out.println(ans);
			return;

		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		Subseq(ros, ans + ch);
		Subseq(ros, ans);

	}

	public static void SubseqAscii(String ques, String ans) {

	}

	public static void KeypadComb(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);

			return;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {

			KeypadComb(ros, ans + code.charAt(i));
		}

	}

	public static void prmt(String ques, String ans) {

		if (ques.length() == 0) {

			System.out.println(ans);
			return;

		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {
			String temp = ans.substring(0, i) + ch + ans.substring(i);
			prmt(ros, temp);
		}

	}

	public static void prmt2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);

			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);

			prmt2(ros, ans + ch);
		}

	}

	public static int MazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int cnt = 0;

		cnt += MazePath(cr, cc + 1, er, ec, ans + "H");
		cnt += MazePath(cr + 1, cc, er, ec, ans + "V");
		cnt += MazePath(cr + 1, cc + 1, er, ec, ans + "D");

		return cnt;
	}

	public static void MazePathMM(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}

		for (int m = 1; m <= er; m++) {
			MazePathMM(cr, cc + m, er, ec, ans + "H" + m);
		}
		for (int m = 1; m <= er; m++) {
			MazePathMM(cr + m, cc, er, ec, ans + "V");
		}

		for (int m = 1; m <= er && m <= ec; m++) {
			MazePathMM(cr + m, cc + m, er, ec, ans + "D");
		}

	}

	public static int BoardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);

			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int cnt = 0;

		for (int dice = 1; dice <= 6; dice++) {

			cnt += BoardPath(curr + dice, end, ans + dice);
		}

		return cnt;

	}

	public static int coinToss(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return 1;
		}

		int cnt = 0;

		cnt += coinToss(n - 1, ans + "H");
		cnt += coinToss(n - 1, ans + "T");

		return cnt;

	}

	public static void LexiCounting(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		int i = 0;

		if (curr == 0) {
			i = 1;
		}

		while (i <= 9) {

			LexiCounting(curr * 10 + i, end);
			
			i++;
		}

	}

}
