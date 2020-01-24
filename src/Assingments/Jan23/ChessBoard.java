package Assingments.Jan23;

import java.util.Arrays;

public class ChessBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int ans = chessboard(0, 0, 2, 2, "");
//		System.out.println();
//		System.out.println(ans);

		int n = 3;
		char[][] mat = filledArray(n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				System.out.print(mat[i][j] + " ");
			}

			System.out.println();
		}

		int cnt = chessboard2(0, 0, n - 1, n - 1, mat, "");

		System.out.println();
		System.out.println(cnt);

	}

	public static int chessboard(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.print(ans + "{" + cr + "-" + cc + "} ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int cnt = 0;

		// Knight
		cnt += chessboard(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K");
		cnt += chessboard(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K");

		// Rook
		if (cc == 0 || cr == 0 || cr == er || cc == ec) {

			for (int move = 1; cc + move <= ec; move++) {
				cnt += chessboard(cr, cc + move, er, ec, ans + "{" + cr + "-" + cc + "}R");
			}

			for (int move = 1; cr + move <= er; move++) {
				cnt += chessboard(cr + move, cc, er, ec, ans + "{" + cr + "-" + cc + "}R");
			}

		}

		// Bishop
		if (cr == cc || cr + cc == er) {

			for (int move = 1; cr + move <= er && cc + move <= ec; move++) {
				cnt += chessboard(cr + move, cc + move, er, ec, ans + "{" + cr + "-" + cc + "}B");
			}

		}

		return cnt;

	}

	public static char[][] filledArray(int m) {

		int n = m * m;
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table]) {

				for (int mult = 2; mult * table <= n; mult++) {

					primes[table * mult] = false;

				}
			}

		}

		// Filling ch - arry

		char[][] charry = new char[m][m];
		int number = 1;
		boolean isMine = true;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {

				if (primes[number]) {

					if (isMine) {

						charry[i][j] = 'M';
					} else {
						charry[i][j] = 'P';
					}

					isMine = !isMine;
				} else {
					charry[i][j] = 'R';
				}

				number++;
			}
		}
		return charry;

	}

	public static int chessboard2(int cr, int cc, int er, int ec, char[][] mat, String ans) {

		if (cr == er && cc == ec) {
			System.out.print(ans + "{" + cr + "-" + cc + "} ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (mat[cr][cc] == 'M') {
			return 0;
		}

		int cnt = 0;

		if (mat[cr][cc] == 'P') {

			cnt += chessboard2(er, ec, er, ec, mat, ans + "{" + cr + "-" + cc + "}P");
		}

		// Knight
		cnt += chessboard2(cr + 2, cc + 1, er, ec, mat, ans + "{" + cr + "-" + cc + "}K");
		cnt += chessboard2(cr + 1, cc + 2, er, ec, mat, ans + "{" + cr + "-" + cc + "}K");

		// Rook
		if (cc == 0 || cr == 0 || cr == er || cc == ec) {

			for (int move = 1; cc + move <= ec; move++) {
				cnt += chessboard2(cr, cc + move, er, ec, mat, ans + "{" + cr + "-" + cc + "}R");
			}

			for (int move = 1; cr + move <= er; move++) {
				cnt += chessboard2(cr + move, cc, er, ec, mat, ans + "{" + cr + "-" + cc + "}R");
			}

		}

		// Bishop
		if (cr == cc || cr + cc == er) {

			for (int move = 1; cr + move <= er && cc + move <= ec; move++) {
				cnt += chessboard2(cr + move, cc + move, er, ec, mat, ans + "{" + cr + "-" + cc + "}B");
			}

		}

		return cnt;

	}

}
