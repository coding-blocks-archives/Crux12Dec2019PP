package Assingments.Jan16;

import java.util.Arrays;
import java.util.Scanner;

public class bookAllocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int nob = scn.nextInt();
		int nos = scn.nextInt();

		int[] books = new int[nob];

		for (int i = 0; i < nob; i++) {
			books[i] = scn.nextInt();
		}

		int lo = books[0];

		int hi = 0;

		for (int pages : books) {
			hi += pages;
		}

		hi = hi - lo;

		int ans = 0;

		while (lo <= hi) {

			int mid = lo + (hi - lo) / 2;

			if (isPossible(books, mid, nos)) {

				ans = mid;
				hi = mid - 1;
			} else {

				lo = mid + 1;

			}

		}

		System.out.println(ans);

	}

	public static boolean isPossible(int[] books, int maxCap, int nos) {

		int students = 1;
		int pagesRead = 0;

		int curr_book = 0;
		while (curr_book < books.length) {

			if (pagesRead + books[curr_book] <= maxCap) {
				pagesRead += books[curr_book];
				curr_book++;
			} else {
				students++;
				pagesRead = 0;
			}

			if (students > nos) {
				return false;
			}

		}

		return true;

	}

}
