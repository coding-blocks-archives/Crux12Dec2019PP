package Lec19_18Jan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	public class Node {

		int data;
		ArrayList<Node> children;

		public Node() {
			data = 0;
			children = new ArrayList<>();
		}

		@Override
		public String toString() {

			return data + "";
		}
	}

	private Node root;
	Scanner scn;

	public GenericTree(String str) {
		// TODO Auto-generated constructor stub

		scn = new Scanner(str);
		root = construct(null, 0);
	}

	public Node construct(Node parent, int ith) {

		if (parent == null)
			System.out.println("Enter the data for Root Node? ");
		else
			System.out.println("Enter the data for " + ith + " child of " + parent.data + "? ");

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println("Enter Children for " + nn.data + "? ");
		int noc = scn.nextInt();

		for (int i = 0; i < noc; i++) {
			Node child = construct(nn, i);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		System.out.print(node.data + " -> ");

		for (Node child : node.children) {
			System.out.print(child.data + ", ");
		}

		if (node.children.size() == 0) {
			System.out.print(".");
		}

		System.out.println();

		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {

		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {

			ts += size(child);
		}
		return ts + 1;

	}

	public int height() {

		return height(root);
	}

	private int height(Node node) {

		int sh = -1;

		for (Node child : node.children) {

			int th = height(child);

			if (th > sh) {
				sh = th;
			}
		}

		return sh + 1;

	}

	public int max() {

		return max(root);
	}

	private int max(Node node) {

		int max = Integer.MIN_VALUE;

		for (Node child : node.children) {

			int temp = max(child);

			if (temp > max) {
				max = temp;
			}
		}

		return max;
	}

	public boolean find(int item) {

		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean rr = find(child, item);

			if (rr)
				return true;
		}

		return false;

	}

	public void mirror() {

		mirror(root);
	}

	private void mirror(Node node) {

		int i = 0;
		int j = node.children.size() - 1;

		while (i < j) {

			Node temp1 = node.children.get(i);
			Node temp2 = node.children.get(j);

			node.children.set(i, temp2);
			node.children.set(j, temp1);

			i++;
			j--;
		}

		for (Node child : node.children) {
			mirror(child);
		}

	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {

		// self work
		System.out.print(node.data + " ");

		// Smaller Problem
		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {

		// Smaller Problem
		for (Node child : node.children) {
			postorder(child);
		}

		// self work
		System.out.print(node.data + " ");

	}

	public void LO() {

		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {

				queue.addLast(child);
			}

		}

	}

	public void LOLL() {

		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);
		queue.addLast(null);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			if (rn == null) {

				if (queue.isEmpty()) {
					return;
				}

				System.out.println();

				queue.addLast(null);

				continue;
			}

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {

				queue.addLast(child);
			}

		}

	}

	public void LOLL2() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {

				helper.addLast(child);
			}

			if (queue.isEmpty()) {

				System.out.println();
				queue = helper;
				helper = new LinkedList<>();
			}

		}

	}

	public void LOZZ() {

		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		stack.addFirst(root);

		int level = 0;
		while (!stack.isEmpty()) {

			Node rn = stack.removeFirst();

			System.out.print(rn.data + " ");

			if (level % 2 == 0) {
				for (Node child : rn.children) {
					helper.addFirst(child);
				}
			} else {

				for (int i = rn.children.size() - 1; i >= 0; i--) {
					helper.addFirst(rn.children.get(i));
				}

			}

			if (stack.isEmpty()) {

				level++;
				System.out.println();
				stack = helper;
				helper = new LinkedList<>();
			}

		}
	}

}
