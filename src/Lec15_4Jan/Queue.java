package Lec15_4Jan;

public class Queue {

	int[] data;
	int front;
	int size;

	public Queue() {

		this(5);
	}

	public Queue(int cap) {

		data = new int[cap];
		front = 0;
		size = 0;
	}

	public void Enqueue(int item) {

		if (isFull()) {
			System.out.println("OverFlow");
			return;
		}

		int rear = (front + size) % data.length;
		data[rear] = item;

		size++;

	}

	public int dequeue() {

		if (isEmpty()) {

			System.out.println("UnderFlow");
			return -1;
		}

		int rv = data[front];
		data[front] = 0;
		front = (front + 1) % data.length;
		size--;

		return rv;
	}

	public int getFront() {

		if (isEmpty()) {

			System.out.println("UnderFlow");
			return -1;
		}

		int rv = data[front];
		return rv;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {

		return size == 0;
	}

	public boolean isFull() {

		return size == data.length;
	}

	public void display() {

		for (int i = 0; i < size; i++) {

			int idx = (front + i) % data.length;
			System.out.print(data[idx] + " ");

		}

		System.out.println("--------------------");
	}

}
