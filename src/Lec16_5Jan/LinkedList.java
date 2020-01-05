package Lec16_5Jan;

public class LinkedList {

	public class Node {

		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size = 0;

	public int getFirst() {

		return head.data;
	}

	public int getLast() {

		return tail.data;
	}

	public void addLast(int item) {

		// 1. create Node
		Node nn = new Node();
		nn.data = item;

		if (size == 0) {
			head = nn;
			tail = nn;

		} else {
			// 2.Attach
			tail.next = nn;

			// 3.update
			tail = tail.next;
		}

		size++;

	}

}
