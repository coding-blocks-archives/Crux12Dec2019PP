package Lec11_27Dec;

public class backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
//		boolean[][] board = new boolean[n][n];

//		Queen_prmts(board, 0, 2, "");
//		QueenComb(board, 0, 2, -1, "");

//		int[] coins = { 2, 3, 5 };
//		coinChangePrmt(coins, 0, 10, "");
//		coinChangeComb(coins, 0, 10, 0, "");

//		QueenCombBoxrespect(board, 0, 0, 2, "");

//		QueenComb2D(board, 0, 0, 0, 4, "");
//		NQueens2(board, 0, 0, board.length, "");

//		int[][] board = { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 1, 0, 0, 0 } };
//
//		boolean[][] visited = new boolean[board.length][board[0].length];
//		blockMaze(board, 0, 0, "", visited);
//		

		// Word Search

		String word = "GFBCBD";
		char[][] board = { { 'C', 'B', 'C', 'B' }, { 'B', 'F', 'G', 'D' }, { 'I', 'J', 'K', 'L' } };

		boolean rr = false;
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {

				if (word.charAt(0) == board[i][j]) {

					rr = rr || WordSearch(board, i, j, word, new boolean[board.length][board[0].length]);
				}
			}
		}

		System.out.println(rr);

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

	public static void NQueen(boolean[][] board, int cr, int cc, int qpsf, int tq, String ans) {

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

		if (isItSafe(board, cr, cc)) {
			board[cr][cc] = true;
			NQueen(board, cr, cc + 1, qpsf + 1, tq, ans + "b[" + cr + "-" + cc + "]q" + (qpsf + 1));
			board[cr][cc] = false;
		}

		// Not placed
		NQueen(board, cr, cc + 1, qpsf, tq, ans);

	}

	public static void NQueens2(boolean[][] board, int row, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				NQueens2(board, row + 1, qpsf + 1, tq, ans + "[" + row + "-" + col + "]");
				board[row][col] = false;
			}

		}
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {

		// horizontaly left

		int cr = row;
		int cc = col - 1;

		while (cc >= 0) {

			if (board[cr][cc]) {
				return false;
			}

			cc--;
		}

		// Vertically up
		cr = row - 1;
		cc = col;

		while (cr >= 0) {

			if (board[cr][cc]) {
				return false;
			}

			cr--;
		}

		// Diagonally left
		cr = row - 1;
		cc = col - 1;

		while (cr >= 0 && cc >= 0) {

			if (board[cr][cc]) {

				return false;
			}

			cr--;
			cc--;
		}

		// Diagonally right
		cr = row - 1;
		cc = col + 1;

		while (cr >= 0 && cc < board[0].length) {

			if (board[cr][cc]) {
				return false;
			}

			cr--;
			cc++;
		}

		return true;

	}

	public static void blockMaze(int[][] board, int cr, int cc, String ans, boolean[][] visited) {

		if (cr == board.length - 1 && cc == board[0].length - 1) {

			System.out.println(ans);
			return;
		}

		if (cr < 0 || cc < 0 || cr >= board.length || cc >= board[0].length || board[cr][cc] == 1 || visited[cr][cc]) {
			return;
		}

		visited[cr][cc] = true;

		blockMaze(board, cr - 1, cc, ans + "U", visited);
		blockMaze(board, cr + 1, cc, ans + "D", visited);
		blockMaze(board, cr, cc - 1, ans + "L", visited);
		blockMaze(board, cr, cc + 1, ans + "R", visited);

		visited[cr][cc] = false;
	}

	public static boolean WordSearch(char[][] board, int cr, int cc, String word, boolean[][] visited) {

		if (word.length() == 0) {
			return true;
		}

		if (cr < 0 || cc < 0 || cr >= board.length || cc >= board[0].length || visited[cr][cc]) {
			return false;
		}

		if (board[cr][cc] != word.charAt(0)) {
			return false;
		}

		String row = word.substring(1);

		visited[cr][cc] = true;

		boolean down = WordSearch(board, cr + 1, cc, row, visited);
		boolean left = WordSearch(board, cr, cc - 1, row, visited);
		boolean up = WordSearch(board, cr - 1, cc, row, visited);
		boolean right = WordSearch(board, cr, cc + 1, row, visited);

		visited[cr][cc] = false;

		return up || down || left || right;

	}

}
