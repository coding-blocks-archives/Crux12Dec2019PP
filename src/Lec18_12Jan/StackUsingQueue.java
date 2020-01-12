package Lec18_12Jan;

import Lec15_4Jan.Queue;

public class StackUsingQueue {

	Queue primary = new Queue();

	public void push(int item) throws Exception {

		primary.Enqueue(item);

	}

	public int pop() throws Exception {

		Queue helper = new Queue();

		try {
			while (primary.size() != 1) {
				helper.Enqueue(primary.dequeue());
			}

			int val = primary.dequeue();

			while (!helper.isEmpty()) {

				primary.Enqueue(helper.dequeue());
			}

			return val;
		} catch (Exception e) {

			throw new Exception("Stack is Empty!!");
		}

	}

	public void display() throws Exception {

		display(primary, 0);
	}

	private void display(Queue q, int cnt) throws Exception {

		if (cnt == q.size()) {
			return;
		}

		int val = q.dequeue();
		q.Enqueue(val);
		display(q, cnt + 1);
		System.out.println(val);

	}

}
