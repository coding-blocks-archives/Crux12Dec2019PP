package Lec13_2Jan;

import java.util.Arrays;

public class Time_Space_Complexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SOE(25);
	}

	public static int powerSeries(int x, int n) {

		int pow = (int) Math.pow(x, n);
		int sum = 0;

		for (int i = 1; i <= n; i++) {

			sum += i * pow;

			pow = pow / x;

		}

		return sum;

	}

	public static int powerSeries2(int x, int n) {

		int sum = 0;

		for (int i = n; i >= 1; i--) {

			sum += i * x;
			x = x * x;

		}

		return sum;

	}

	public static int countPalSubstr(String str) {

		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {

			cnt += grow(str, i, i);
			cnt += grow(str, i, i + 1);
		}

		return cnt;

	}

	public static int grow(String str, int si, int ei) {

		int cnt = 0;

		while (si >= 0 && ei < str.length() && str.charAt(si) == str.charAt(ei)) {

			cnt++;
			si--;
			ei++;
		}

		return cnt;

	}

	public static void SOE(int n) {

		boolean[] board = new boolean[n + 1];
		Arrays.fill(board, true);

		board[0] = false;
		board[1] = false;

		for (int table = 2; table * table <= n; table++) {
			
			if (board[table]) {

				for (int mult = 2; mult * table <= n; mult++) {

					board[table * mult] = false;

				}
			}

		}
		
		
		for(int i = 2;i <= n;i++) {
			
			if(board[i]) {
				System.out.println(i);
			}
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
