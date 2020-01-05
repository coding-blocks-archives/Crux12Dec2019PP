package Lec15_4Jan;

import java.util.Stack;

public class DSClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//
//		Stack stack = new DynamicStack();
//
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		stack.push(40);
//		stack.push(50);
//
//		stack.display();
//
////		System.out.println("---------Display Reverse---------");
////		displayRev(stack);
//
//		System.out.println("---------Actual Reverse---------");
//		Stack h = new DynamicStack();
//		ActualRev(stack, h);
//		System.out.println("----------Real Stack-------------");
//		stack.display();

		int[] arr = { 4, 9, 2, 3, 1, 0, 8 };
		int[] ans = Nextgreater2(arr);

//		for (int val : ans) {
//			System.out.print(val + " ");
//		}

		int[] temp = { 4, 2, 2, 4, 1, 6, 3 };

		int[] res = stockSpan(temp);
		for (int val : res) {
			System.out.print(val + " ");
		}

	}

	public static void displayRev(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int val = s.pop();
		displayRev(s);
		System.out.println(val);
		s.push(val);

	}

	public static void ActualRev(Stack s, Stack h) throws Exception {

		if (s.isEmpty()) {

			if (h.isEmpty()) {
				return;
			}

			int val = h.pop();
			ActualRev(s, h);
			s.push(val);
			return;
		}

		int val = s.pop();
		h.push(val);

		ActualRev(s, h);

	}

	public static void cloneStack(Stack s, Stack h) throws Exception {

		if (h.isEmpty()) {
			return;
		}

		int val = h.pop();
		cloneStack(s, h);
		s.push(val);

	}

	public static void Nextgreater(int[] arr) {

		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				System.out.println(stack.pop() + " -> " + arr[i]);
			}
			stack.push(arr[i]);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " -> " + -1);
		}

	}

	public static int[] Nextgreater2(int[] arr) {

		int[] res = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
//		stack.push(0);

		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {

				res[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			res[stack.pop()] = -1;
		}

		return res;
	}

	public static int[] stockSpan(int[] arr) {

		int[] res = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {

				res[i] = i + 1;
			} else {
				res[i] = i - stack.peek();

			}

			stack.push(i);

		}

		return res;

	}

}
