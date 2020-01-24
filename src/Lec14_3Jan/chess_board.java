package Lec14_3Jan;

import java.util.Arrays;
import java.util.Scanner;

public class chess_board {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
//		int cnt = chessboard(0, 0, n - 1, n - 1, "");
//		System.out.println();
//		System.out.println(cnt);

		char[][] mat = filledMatrix(n);
		int cnt = chessboard2(0, 0, n - 1, n - 1, mat, "");
		System.out.println();
		System.out.println(cnt);

//		for (char[] c : mat) {
//			for (char val : c) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//		}
	}

	public static char[][] filledMatrix(int n) {

		boolean[] primes = new boolean[(n * n) + 1];

		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n * n; table++) {

			if (!primes[table])
				continue;
			for (int mult = 2; mult * table <= n * n; mult++) {
				primes[table * mult] = false;
			}
		}

		char[][] matrix = new char[n][n];
		int number = 1;
		boolean isMine = true;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if (primes[number]) {

					if (isMine)
						matrix[i][j] = 'M';
					else
						matrix[i][j] = 'P';

					isMine = !isMine;
				} else {
					matrix[i][j] = 'R';
				}

				number++;
			}
		}

		return matrix;

	}

	public static int chessboard(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.print(ans + "{" + cr + "-" + cc + "} ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}
		String temp = "{" + cr + "-" + cc;
		int cnt = 0;

		// Knight
		cnt += chessboard(cr + 2, cc + 1, er, ec, ans + temp + "}K");
		cnt += chessboard(cr + 1, cc + 2, er, ec, ans + temp + "}K");

		// Rook

		if (cr == 0 || cr == er || cc == 0 || cc == ec) {

			for (int move = 1; cc + move <= ec; move++) {
				cnt += chessboard(cr, cc + move, er, ec, ans + temp + "}R");
			}

			for (int move = 1; cr + move <= er; move++) {
				cnt += chessboard(cr + move, cc, er, ec, ans + temp + "}R");
			}

		}

		if (cr == cc || cc + cr == er) {
			for (int move = 1; cr + move <= er && cc + move <= ec; move++) {
				cnt += chessboard(cr + move, cc + move, er, ec, ans + temp + "}B");
			}
		}

		return cnt;
	}

	public static int chessboard2(int cr, int cc, int er, int ec, char[][] mat, String ans) {

		if (cr == er && cc == ec) {
			System.out.print(ans + "{" + cr + "-" + cc + "} ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (mat[cr][cc] == 'M')
			return 0;

		String temp = "{" + cr + "-" + cc;
		int cnt = 0;

		if (mat[cr][cc] == 'P') {
			cnt += chessboard2(er, ec, er, ec, mat, ans + temp + "}P");
		}

		// Knight
		cnt += chessboard2(cr + 2, cc + 1, er, ec, mat, ans + temp + "}K");
		cnt += chessboard2(cr + 1, cc + 2, er, ec, mat, ans + temp + "}K");

		// Rook

		if (cr == 0 || cr == er || cc == 0 || cc == ec) {

			for (int move = 1; cc + move <= ec; move++) {
				cnt += chessboard2(cr, cc + move, er, ec, mat, ans + temp + "}R");
			}

			for (int move = 1; cr + move <= er; move++) {
				cnt += chessboard2(cr + move, cc, er, ec, mat, ans + temp + "}R");
			}

		}

		if (cr == cc || cc + cr == er) {
			for (int move = 1; cr + move <= er && cc + move <= ec; move++) {
				cnt += chessboard2(cr + move, cc + move, er, ec, mat, ans + temp + "}B");
			}
		}

		return cnt;
	}

}
