package Assingments.Dec28;

import java.util.Scanner;

public class MaxFreqChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
//
		String str = scn.next();

		int[] freq = new int[256];

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			freq[ch]++;

		}

		int max = 0;
		char ans = '&';

		for (int i = 0; i < freq.length; i++) {

			if (freq[i] > max) {
				max = freq[i];
				ans = (char) (i);
			}
		}

		System.out.println(ans);
	}

}
