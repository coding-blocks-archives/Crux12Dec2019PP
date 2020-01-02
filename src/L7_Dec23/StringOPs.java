package L7_Dec23;

import java.util.Scanner;

public class StringOPs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
//		String str = scn.next();

//		printChars(str);
		
		printPalSubstrings("nitin");
	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length();i++) {
			System.out.println(str.charAt(i));
		}

	}

	//O (n)
	public static boolean palindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i < j) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}

			i++;
			j--;

		}

		return true;

	}

	public static void printsubstring(String str) {

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {

				System.out.println(str.substring(i, j));
			}
		}

	}

	public static void printPalSubstrings(String str) {

		//O(n2)
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {

				//O(n)
				String res = str.substring(i, j);

				//O(n)
				if (palindrome(res))
					System.out.println(res);
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
