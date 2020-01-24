package Assingments.Jan23;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[][] board = new int[n][n];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = scn.nextInt();
			}
		}

		sudokuSolver(board, 0, 0);

		// Print Board

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}

			System.out.println();
		}
		System.out.println("----------------------------");
	}

	public static boolean sudokuSolver(int[][] board, int cr, int cc) {

		if (cc == board[0].length) {
			cr++;
			cc = 0;
		}

		if (cr == board.length) {
			return true;
		}

		if (board[cr][cc] != 0) {
			return sudokuSolver(board, cr, cc + 1);

		}

		// placed
		for (int i = 1; i <= 9; i++) {
			if (isItSafe(board, cr, cc, i)) {
				board[cr][cc] = i;
				boolean ans = sudokuSolver(board, cr, cc + 1);

				if (ans) {
					return true;
				}
				board[cr][cc] = 0;
			}
		}

		return false;

	}

	public static boolean isItSafe(int[][] board, int cr, int cc, int value) {

		// Entire row
		for (int col = 0; col < board[0].length; col++) {

			if (board[cr][col] == value) {
				return false;
			}
		}

		// Entire Col
		for (int row = 0; row < board.length; row++) {
			if (board[row][cc] == value) {
				return false;
			}
		}

		// Entire grid
		int row = cr - cr % 3;
		int col = cc - cc % 3;

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (board[i][j] == value) {
					return false;
				}
			}
		}

		return true;
	}

}
