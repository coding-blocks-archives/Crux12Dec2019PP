package Lec11_27Dec;

public class backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
		boolean[][] board = new boolean[n][n];

//		Queen_prmts(board, 0, 2, "");
//		QueenComb(board, 0, 2, -1, "");

//		int[] coins = { 2, 3, 5 };
//		coinChangePrmt(coins, 0, 10, "");
//		coinChangeComb(coins, 0, 10, 0, "");

//		QueenCombBoxrespect(board, 0, 0, 2, "");
		
		QueenComb2D(board, 0, 0, 0, 4, "");

	}

	public static void QueenPrmts(boolean[] board, int qpsf, int tq, String ans) {

		if (qpsf == tq) {

			System.out.println(ans);
			return;
		}

		for (int i = 0; i < board.length; i++) {

			if (board[i] == false) {
				board[i] = true;
				QueenPrmts(board, qpsf + 1, tq, ans + "b" + i + "(q" + (qpsf + 1) + ")");
				board[i] = false;
			}

		}

	}

	public static void QueenComb(boolean[] board, int qpsf, int tq, int LastIndex, String ans) {

		if (qpsf == tq) {

			System.out.println(ans);
			return;
		}

		for (int i = LastIndex + 1; i < board.length; i++) {

			if (board[i] == false) {
				board[i] = true;
				QueenComb(board, qpsf + 1, tq, i, ans + "b" + i + "(q" + (qpsf + 1) + ")");
				board[i] = false;
			}

		}

	}

	public static void coinChangePrmt(int[] coins, int amount, int target, String ans) {

		if (amount == target) {
			System.out.println(ans);

			return;
		}

		if (amount > target) {
			return;
		}

		for (int i = 0; i < coins.length; i++) {

			coinChangePrmt(coins, amount + coins[i], target, ans + coins[i]);
		}

	}

	public static void coinChangeComb(int[] coins, int amount, int target, int LastIndex, String ans) {

		if (amount == target) {
			System.out.println(ans);

			return;
		}

		if (amount > target) {
			return;
		}

		for (int i = LastIndex; i < coins.length; i++) {

			coinChangeComb(coins, amount + coins[i], target, i, ans + coins[i]);
		}

	}

	public static void QueenCombBoxrespect(boolean[] board, int vidx, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		if (vidx == board.length) {
			return;
		}

		// placed
		board[vidx] = true;
		QueenCombBoxrespect(board, vidx + 1, qpsf + 1, tq, ans + "b" + vidx + "(q" + (qpsf + 1) + ")");
		board[vidx] = false;

		// Not placed
		QueenCombBoxrespect(board, vidx + 1, qpsf, tq, ans);

	}

	public static void CoinChange2(int[] coins, int vidx, int amount, int target, String ans) {

		if (amount == target) {
			System.out.println(ans);

			return;
		}

		if (amount > target || vidx == coins.length) {
			return;
		}

		// inc
		CoinChange2(coins, vidx, amount + coins[vidx], target, ans + coins[vidx]);

		// exc
		CoinChange2(coins, vidx + 1, amount, target, ans);

	}

	public static void QueenComb2D(boolean[][] board, int cr, int cc, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);

			return;
		}

		if (cc == board[0].length) {

			cr++;
			cc = 0;
		}
		if (cr == board.length) {
			return;
		}

		// placed
		board[cr][cc] = true;
		QueenComb2D(board, cr, cc + 1, qpsf + 1, tq, ans + "b[" + cr + "-" + cc + "]q" + (qpsf + 1));
		board[cr][cc] = false;

		// Not placed
		QueenComb2D(board, cr, cc + 1, qpsf, tq, ans);

	}

}
