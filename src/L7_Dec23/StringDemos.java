package L7_Dec23;

import java.util.Scanner;

public class StringDemos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "Hello";
//		str1 = "bye";
		String str2 = "Hello";

		String str3 = new String("hello");

		System.out.println(str1);
		System.out.println(str2);

		// Length
		System.out.println(str1.length());

		// CharAt (0 - (size - 1))
		System.out.println(str1.charAt(0));
//		System.out.println(str1.charAt(5)); Exception

		// Substring ( 0 - (size))
		System.out.println(str1.substring(0, 5));
//		System.out.println(str1.substring(3, 1));	

		// Equals
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));

		// IndexOf
		System.out.println(str1.indexOf("p"));

		// Concat
		System.out.println(str1 + str2);
		System.out.println(str1.concat(str2));

		// StartsWith
		System.out.println(str1.startsWith("elo"));

		// input
		Scanner scn = new Scanner(System.in);
//		String s4 = scn.next();
//		String s5 = scn.nextLine();

//		System.out.println(s5);

		String s6 = "CB";
		s6 = s6 + "A";

		System.out.println(s6);
		
		test();

	}
	
	public static void test() {
		
		String str = "Hello";
		
		for(int i = 0;i < 1_000_000_0;i++) {
			str += "!";
		}
		
		System.out.println(str);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
