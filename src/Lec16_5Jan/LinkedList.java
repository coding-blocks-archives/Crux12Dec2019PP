package Lec16_5Jan;

public class LinkedList {

	public class Node {

		int data;
		Node next;

		public Node() {
			data = 0;
		}

		public Node(int val) {
			data = val;
		}
	}

	private Node head;
	private Node tail;
	private int size = 0;

	// O(1)
	public int getFirst() {

		return head.data;
	}

	// O(1)
	public int getLast() {

		return tail.data;
	}

	// O(n)
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

	// O(1)
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

	// O(n)
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

	// O(n)
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

	// O(1)
	public boolean isEmpty() {

		return size == 0;
	}

	// O(1)
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

	// O(n)
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

	// O(n)
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

	public void fold() {

//		fold(head, head, 0);

		heapmover mover = new heapmover();
		mover.left = head;

		foldHM(mover, head, 0);
	}

	public Node fold(Node left, Node right, int cnt) {

		if (right == null) {

			return left;
		}
		left = fold(left, right.next, cnt + 1);
		if (cnt > size / 2) {

			Node temp = left.next;

			left.next = right;
			right.next = temp;

			left = temp;
		}
		if (cnt == size / 2) {

			tail = left;
			tail.next = null;
		}

		return left;

	}

	public void foldHM(heapmover mover, Node right, int cnt) {

		if (right == null) {

			return;
		}

		foldHM(mover, right.next, cnt + 1);

		if (cnt > size / 2) {

			Node temp = mover.left.next;

			mover.left.next = right;
			right.next = temp;

			mover.left = temp;
		}
		if (cnt == size / 2) {

			tail = right;
			tail.next = null;
		}

	}

	public int mid() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow.data;

	}

	public int KthFromLast(int k) {

		Node slow = head;
		Node fast = head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		while (fast != null) {

			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public void createDummyList() {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		n9.next = n10;
		n10.next = n7;
		Node h1 = n1;
		Node h2 = n9;
		System.out.println(intersection(h1, h2));
	}

	public int intersection(Node h1, Node h2) {

		// Write your code here
		Node A = h1;
		Node B = h2;

		while (A != B) {
			A = (A != null ? A.next : h2);
			B = (B != null ? B.next : h1);
		}

		return (A == null ? -1 : A.data);

	}

	public void Kreverse(int k) throws Exception {

		LinkedList prev = null;

		while (this.size > 0) {

			LinkedList curr = new LinkedList();

			for (int i = 1; i <= k && !isEmpty(); i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {

				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}

		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	public void delete() {

		this.RPI();

		Node max = head;
		Node curr = head.next;

		while (curr != null) {

			if (curr.data > max.data) {

				max = curr;
			} else {
				max.next = curr.next;
			}

			curr = curr.next;

		}

		this.tail = max;
		this.RPI();
	}

}
