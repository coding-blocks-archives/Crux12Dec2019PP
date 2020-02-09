package Lec24;

public class LLGeneric<T> {

	public class Node {

		T data;
		Node next;

		public Node() {
			data = null;
		}

		public Node(T val) {
			data = val;
		}
	}

	private Node head;
	private Node tail;
	private int size = 0;

	// O(1)
	public T getFirst() {

		return head.data;
	}

	// O(1)
	public T getLast() {

		return tail.data;
	}

	// O(n)
	public T getAt(int idx) throws Exception {

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

	// O(n)
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

	// O(1)
	public void addLast(T item) {

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

	// O(1)
	public void addFirst(T item) {

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

	// O(n)
	public void addAt(int idx, T item) throws Exception {

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

	// O(n)
	public void display() {

		Node temp = head;

		System.out.println("-----------------");
		while (temp != null) {

			System.out.println(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.print("-----------------");

	}

	// O(1)
	public boolean isEmpty() {

		return size == 0;
	}

	// O(1)
	public T removeFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("UnderFlow!!!");
		}
		T val = head.data;

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

	// O(n)
	public T removeLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("UnderFLow!!!");
		}
		T val = tail.data;

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

	// O(n)
	public T removeAt(int idx) throws Exception {

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

}
