package Lec19_18Jan;

import java.util.ArrayList;
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

}
