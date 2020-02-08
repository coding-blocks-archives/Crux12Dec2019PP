package Assingments.Feb6;

import java.util.*;

public class Hoodies {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		distribute(scn.nextInt());
	}

	public static void distribute(int q) {

		ArrayList<Queue<Integer>> courses = new ArrayList<>();

		for (int i = 0; i <= 4; i++) {
			courses.add(new LinkedList<>());
		}

		ArrayList<Integer> order = new ArrayList<Integer>();

		for (int i = 0; i < q; i++) {

			char ch = scn.next().charAt(0);

			if (ch == 'E') {

				int cno = scn.nextInt();
				int rno = scn.nextInt();

				courses.get(cno).add(rno);

				if (!order.contains(cno))
					order.add(cno);

			} else {

				int cno = order.get(0);
				int rno = courses.get(cno).remove();

				if (courses.get(cno).isEmpty()) {
					order.remove(0);
				}

				System.out.println(cno + " " + rno);

			}

		}

	}

}
