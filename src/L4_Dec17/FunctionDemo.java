package L4_Dec17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Dec-2019
 *
 */

public class FunctionDemo {

	static int val = 100;

	public static void main(String[] args) {

		System.out.println("hi");

		// fxn call
		// addition();
		//
		// int n1 = 6;
		// int n2 = 90;
		// additionParams(n1, n2);
		// System.out.println("n1 " + n1);

		// int sum = additionReturn(10, 20);
		// System.out.println(sum);

		System.out.println(additionReturn(10, 20));
		// int ans = addition();

		System.out.println("----------- Part-4 -----------");
		int one = 10, two = 20;
		int sum = DemoScopes(one, two);
		System.out.println(sum);

		System.out.println("bye");

		// Part-5
		System.out.println("----------- Part-5 -----------");
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);

		// Part 6
		System.out.println(val); // 100
		int val = 10;

		System.out.println(val); // 10
		System.out.println(FunctionDemo.val); // 100

		val++;
		FunctionDemo.val++;

		System.out.println(val); // 11
		System.out.println(FunctionDemo.val); // 100

		val = 10;
		FunctionDemo.val = 100;

		DemoGlobalScopes(200);

		System.out.println(val);
		System.out.println(FunctionDemo.val);
	}

	public static int DemoGlobalScopes(int one) {

		int val = 600;
		int sum = one + val;

		FunctionDemo.val = sum;

		return sum;
	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static int DemoScopes(int one, int another) {

		int sum = one + another;
		return sum;
	}

	public static int additionReturn(int a, int b) {

		int sum = a + b;
		System.out.println(sum);
		return 10;
	}

	public static void additionParams(int a, int b) {

		int sum = a + b;
		a = a + 1;
		System.out.println("a : " + a);
		System.out.println(sum);
	}

	// fxn definition
	public static void addition() {

		int a = 10;
		int b = 20;

		int sum = a + b;

		subtraction();

		System.out.println(sum);

	}

	public static void subtraction() {

		int a = 100;
		int b = 50;

		int sub = a - b;

		System.out.println(sub);
	}

}
