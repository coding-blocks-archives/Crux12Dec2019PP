package Lec27_Feb15;

public class DP {

	public static void main(String[] args) {

		int n = 100;
//		System.out.println(fibo(n));

		long start = System.currentTimeMillis();
//		int[] strg = new int[n + 1];
//		System.out.println(fiboBU(n));
//		System.out.println(fibo(n));
//		System.out.println(fiboBUSE(n));
//		System.out.println(fiboTD(n, strg));
		long end = System.currentTimeMillis();

//		System.out.println(end - start);
//		System.out.println(fiboBU(n));

		// Boardpath
//		System.out.println(BoardPath(0, n));
//		System.out.println(BoardPathTD(0, n, strg));
//		System.out.println(boardPathBU(n));
//		System.out.println(boardPathBUSE(n));

		// Mazepath
		int er = 2, ec = 2;
		int[][] strg = new int[er + 1][ec + 1];
		System.out.println(MazePath(0, 0, er, ec));
		System.out.println(MazePathTD(0, 0, er, ec, strg));
//		System.out.println(MazePathBU(er, ec));
	}

	public static int fibo(int n) {

		if (n == 1 || n == 0) {
			return n;
		}

		int f1 = fibo(n - 1);
		int f2 = fibo(n - 2);

		return f1 + f2;

	}

	public static int fiboTD(int n, int[] strg) {

		if (n == 1 || n == 0) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		return strg[n] = fiboTD(n - 1, strg) + fiboTD(n - 2, strg);

	}

	public static int fiboBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];

		}
		return strg[n];

	}

	public static int fiboBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i < n; i++) {
			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	public static int BoardPath(int curr, int end) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int cnt = 0;

		for (int dice = 1; dice <= 6; dice++) {
			cnt += BoardPath(curr + dice, end);
		}

		return cnt;

	}

	public static int BoardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int cnt = 0;

		for (int dice = 1; dice <= 6; dice++) {
			cnt += BoardPathTD(curr + dice, end, strg);
		}

		return strg[curr] = cnt;

	}

	public static int boardPathBU(int end) {

		int[] strg = new int[end + 6];

		strg[end] = 1;

		for (int curr = end - 1; curr >= 0; curr--) {

			int sum = 0;
			for (int dice = 1; dice <= 6; dice++) {

				sum += strg[curr + dice];
			}

			strg[curr] = sum;

		}

		return strg[0];

	}

	public static int boardPathBUSE(int end) {

		int[] strg = new int[6];

		strg[0] = 1;

		for (int i = 1; i <= end; i++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;

		}

		return strg[0];

	}

	public static int MazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int cnt = 0;

		cnt += MazePath(cr, cc + 1, er, ec);
		cnt += MazePath(cr + 1, cc, er, ec);
		cnt += MazePath(cr + 1, cc + 1, er, ec);

		return cnt;
	}

	public static int MazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			strg[cr][cc] = 1;
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int cnt = 0;

		cnt += MazePathTD(cr + 1, cc, er, ec, strg);
		cnt += MazePathTD(cr, cc + 1, er, ec, strg);
		cnt += MazePathTD(cr + 1, cc + 1, er, ec, strg);

		strg[cr][cc] = cnt;

		for (int[] st : strg) {
			for (int s : st) {
				System.out.print(s + " ");
			}

			System.out.println();
		}

		System.out.println("-----------------------");

		return cnt;
	}

	public static int MazePathBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int cr = er; cr >= 0; cr--) {
			for (int cc = ec; cc >= 0; cc--) {

				if (cr == er && cc == ec) {
					strg[cr][cc] = 1;
					continue;
				}

				strg[cr][cc] = strg[cr + 1][cc] + strg[cr][cc + 1] + strg[cr + 1][cc + 1];

			}
		}

		return strg[0][0];

	}

	public static int MazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 2];

		for (int cr = er; cr >= 0; cr--) {
			for (int cc = ec; cc >= 0; cc--) {

				if (cr == er && cc == ec) {
					strg[cc] = 1;
					continue;
				}

				strg[cc] = strg[cc] + strg[cc + 1] + strg[cc + 1];

			}
		}

		return strg[0];

	}

}
