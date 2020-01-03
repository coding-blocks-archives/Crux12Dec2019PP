package Lec14_3Jan;

public class Stack {

	int[] data;
	int tos;

	public Stack() {

		this(5);
	}

	public Stack(int cap) {

		data = new int[cap];
		tos = -1;
	}

	public void push(int item) {

		if (tos == data.length - 1) {
			System.out.println("Overflow");

			return;
		}

		this.tos++;
		data[tos] = item;

	}

	public int pop() {

		if (tos == -1) {
			System.out.println("Underflow");
			return -1;
		}

		int rv = data[tos];
		data[tos] = 0;
		tos--;

		return rv;
	}

	public int peek() {

		if (tos == -1) {
			System.out.println("Underflow");
			return -1;
		}

		return data[tos];
	}

	public int size() {

		return this.tos + 1;
	}

	public void display() {

		for (int i = tos; i >= 0; i--) {

			System.out.println(data[i]);
		}

		System.out.println("--------------");

	}

}
