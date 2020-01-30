package Assingments.Jan30;

import java.util.ArrayList;
import java.util.Stack;

public class PlayingWithCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] cards = { 3, 4, 7, 6, 5 };
		print(cards, 1);
	}

	public static void print(int[] cards, int Q) {

		ArrayList<Stack<Integer>> A = new ArrayList<>();
		ArrayList<Stack<Integer>> B = new ArrayList<>();

		for (int i = 1; i <= Q + 1; i++) {
			A.add(new Stack<>());
			B.add(new Stack<>());
		}

		for (int card : cards) {
			A.get(0).push(card);
		}

		for (int i = 1; i <= Q; i++) {

			Stack<Integer> primary = A.get(i - 1);

			while (!primary.isEmpty()) {

				int element = primary.pop();

				if (element % ithPrime(i) == 0) {
					B.get(i).push(element);
				} else {
					A.get(i).push(element);
				}
			}

		}

		for (Stack<Integer> temp : B) {

			while (!temp.isEmpty()) {
				System.out.println(temp.pop());
			}
		}

		Stack<Integer> LastStack = A.get(Q);
		while (!LastStack.isEmpty()) {
			System.out.println(LastStack.pop());
		}

	}

	public static int ithPrime(int i) {

		int count = 2;
		int prime_cnt = 0;

		while (true) {
			if (isPrime(count)) {
				prime_cnt++;
			}

			if (prime_cnt == i) {
				return count;
			}

			count++;
		}

	}

	public static boolean isPrime(int n) {

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

}
