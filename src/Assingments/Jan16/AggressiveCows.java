package Assingments.Jan16;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int nos = scn.nextInt();
		int noc = scn.nextInt();

		int[] stalls = new int[nos];

		for (int i = 0; i < nos; i++) {
			stalls[i] = scn.nextInt();
		}

		Arrays.sort(stalls);

		int lo = 0;
		int hi = stalls[nos - 1] - stalls[0];

		int ans = 0;

		while (lo <= hi) {

			int mid = lo + (hi - lo) / 2;

			if (isPossible(stalls, mid, noc)) {
				ans = mid;
				lo = mid + 1;
			} else {

				hi = mid - 1;
			}

		}

		System.out.println(ans);

	}

	public static boolean isPossible(int[] stalls, int min, int noc) {

		int noOfCowsPlaced = 1;
		int lastCowPlaced = stalls[0];

		for (int i = 1; i < stalls.length; i++) {

			if (stalls[i] - lastCowPlaced >= min) {

				noOfCowsPlaced++;
				lastCowPlaced = stalls[i];
			}

			if (noOfCowsPlaced >= noc) {
				return true;
			}
		}

		return false;

	}

}
