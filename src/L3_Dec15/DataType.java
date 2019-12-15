package L3_Dec15;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2019
 *
 */

public class DataType {

	public static void main(String[] args) {

		// byte x = (byte) 640;
		// System.out.println(x);
		// System.out.println(Integer.toBinaryString(-77)) ;

		// byte b = 1;
		//
		// while (b <= 128) {
		// System.out.println("hi");
		// b++;
		// }

		// Demos

		// case 1
		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;

		// by = sh ;
		// by = in ;
		// by = lo ;

		sh = by;
		// sh = in ;
		// sh = lo ;

		in = by;
		in = sh;
		// in = lo ;

		lo = by;
		lo = sh;
		lo = in;

		// case 2
		by = (byte) 267;

		// case 3
		in = (int) 1_000_000_0000L;
		System.out.println(in);

		// case 4
		float f = 5.6f;
		double d = 6.7;

		// f = d;
		d = f;

		// case 5
		in = (int) f;
		System.out.println(in);

		in = 5000;
		f = in;
		System.out.println(f);

		// case 6
		boolean b = true;
		b = false;

		if (b == true) {

		}

		if (b) {

		}

		// case 7
		System.out.println(Math.pow(2, 16));

		char ch = 97;
		ch = 'a';

		System.out.println(ch);

		in = 'a';
		System.out.println(in);
		System.out.println((int) 'a');
		System.out.println((char) 97);

		ch = (char) (ch + 1);
		System.out.println(ch);

		ch = 'a' + 1;

		char ch1 = 't';

		ch = (char) (ch + ch1);
		System.out.println(ch);

		// case 8

		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");

	}
}















