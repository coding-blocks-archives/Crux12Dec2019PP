package Lec7;

import java.util.Scanner;

public class StringBuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hello";
		Scanner scn = new Scanner(System.in);
		String temp = scn.next();
		StringBuilder sb = new StringBuilder(temp);

		char[] charray = new char[2];
		String str2 = sb.toString();

		// Length
		System.out.println(sb.length());

		// CharAt
		System.out.println(sb.charAt(2));

		// Append
		System.out.println(sb.append("Bye"));
//		sb += "bye";

		// Substring
		System.out.println(sb.substring(0, 3));
		System.out.println(sb.substring(2));

		// Delete character
		System.out.println(sb.deleteCharAt(2));

		sb.setCharAt(0, 'T');
		System.out.println(sb);

		sb.insert(2, "hii");
		System.out.println(sb);

		
	}
	
	public static void test() {

		String str = "Hello";
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < 1_000_000_0; i++) {
			sb.append("!");
		}

		System.out.println(sb);
	}
	
	
	public static String AsciiChange(String str) {
		
		StringBuilder sb = new StringBuilder(str);
		
		for(int i = 0;i < sb.length();i++) {
			
			char ch = sb.charAt(i);
			
			if(i % 2 == 0) {
				
				ch = (char) (ch + 1);
//				ch++;
			}else {
				ch = (char) (ch - 1);
//				ch--;
			}
			
			sb.setCharAt(i, ch);
			
		}
		
		return sb.toString();
		
	}

	

	
	
	
	
	
	
	
	
	
}
