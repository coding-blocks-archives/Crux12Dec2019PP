package Lec16_5Jan;

public class LinkedList {

	public class Node {

		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size = 0;

	public int getFirst() {

		return head.data;
	}

	public int getLast() {

		return tail.data;
	}

	public int getAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty!!!");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index!!!");
		}

		Node temp = head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	public Node getNodeAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty!!!");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index!!!");
		}

		Node temp = head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

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

	public void addFirst(int item) {

		// New Node created
		Node nn = new Node();
		nn.data = item;

		// Pointer change
		nn.next = head;

		// change head
		head = nn;

		// change tail (conditions apply)
		if (isEmpty()) {
			tail = nn;
		}

		size++;

	}

	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx > size) {
			throw new Exception("Invalid Index!!!");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == size) {
			addLast(item);
		} else {
			// Create Node
			Node nn = new Node();
			nn.data = item;

			// get prev Node
			Node temp = getNodeAt(idx - 1);

			// change pointer
			nn.next = temp.next;
			temp.next = nn;

			size++;
		}

	}

	public void display() {

		Node temp = head;

		System.out.println("-----------------");
		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.print("-----------------");

	}

	public boolean isEmpty() {

		return size == 0;
	}

	public int removeFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("UnderFlow!!!");
		}
		int val = head.data;

		if (size == 1) {
			tail = null;
			head = null;
			size = 0;
		} else {
			head = head.next;

			size--;
		}

		return val;

	}

	public int removeLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("UnderFLow!!!");
		}
		int val = tail.data;

		if (size == 1) {
			head = null;
			tail = null;
			size = 0;
		} else {

			Node temp = getNodeAt(size - 2);
			tail = temp;
			tail.next = null;
			size--;
		}

		return val;
	}

	public int removeAt(int idx) throws Exception {

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index!!!");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {

			Node p1 = getNodeAt(idx - 1);
			Node p = getNodeAt(idx);
			Node p2 = getNodeAt(idx + 1);

			p1.next = p2;

			return p.data;
		}

	}

	public void RPI() {

		Node prev = null;
		Node curr = head;

		while (curr != null) {

			Node temp = curr.next;

			curr.next = prev;

			prev = curr;
			curr = temp;

		}

		Node temp = head;
		head = tail;
		tail = temp;

	}

	public void RDI() throws Exception {

		int i = 0;
		int j = size - 1;

		while (i < j) {

			Node left = getNodeAt(i);
			Node right = getNodeAt(j);

			// swap
			int temp = left.data;
			left.data = right.data;
			right.data = temp;

			i++;
			j--;
		}

	}

	public void RPR() {

		RPR(null, head);

		Node temp = head;
		head = tail;
		tail = temp;

	}

	public void RPR(Node prev, Node curr) {

		if (curr == null)
			return;

		RPR(curr, curr.next);

		curr.next = prev;

	}

	Node left;

	class heapmover {
		Node left;
	}

	public void RDRHM(heapmover mover, Node right, int cnt) {

		if (right == null) {

			return;
		}

		RDRHM(mover, right.next, cnt + 1);

		if (cnt >= size / 2) {
			int t = mover.left.data;
			mover.left.data = right.data;
			right.data = t;
		}

		mover.left = mover.left.next;
	}

	public Node RDR(Node left, Node right, int cnt) {

		if (right == null) {

			return left;
		}

		Node temp = RDR(left, right.next, cnt + 1);

		if (cnt >= size / 2) {
			int t = temp.data;
			temp.data = right.data;
			right.data = t;
		}
		return temp.next;

	}

}
