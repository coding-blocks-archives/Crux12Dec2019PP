package Lec22_Feb1;

import org.w3c.dom.Node;

public class BST {

	class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] inorder) {

		root = construct(inorder, 0, inorder.length - 1);
	}

	public Node construct(int[] inorder, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		int mid = lo + (hi - lo) / 2;

		Node nn = new Node();
		nn.data = inorder[mid];

		nn.left = construct(inorder, lo, mid - 1);
		nn.right = construct(inorder, mid + 1, hi);

		return nn;

	}

	public void display() {

		display(root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += "<-" + node.data + "->";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int lsize = size(node.left);
		int rsize = size(node.right);

		return lsize + rsize + 1;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {

			return -1;
		}

		int l_ht = ht(node.left);
		int r_ht = ht(node.right);

		return Math.max(l_ht, r_ht) + 1;
	}

	public int max() {

		return max(root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		if (node.data < item) {
			return find(node.right, item);
		} else {
			return find(node.left, item);
		}

	}

	public void printInRange(int ll, int ul) {

		printInRange(root, ll, ul);
	}

	private void printInRange(Node node, int ll, int ul) {

		if (node == null) {
			return;
		}

		if (node.data < ll) {
			printInRange(node.right, ll, ul);
		} else if (node.data > ul) {
			printInRange(node.left, ll, ul);
		} else {

			printInRange(node.left, ll, ul);
			System.out.println(node.data);
			printInRange(node.right, ll, ul);

		}

	}

	public void replaceWithLarger() {
		replaceWithLarger(root);
	}

	int sum = 0;

	private void replaceWithLarger(Node node) {

		if (node == null) {
			return;
		}

		replaceWithLarger(node.right);
		int temp = node.data;
		node.data = sum;
		sum += temp;
		replaceWithLarger(node.left);

	}

	public void replaceWithLarger2() {
		replaceWithLarger2(root, 0);
	}

	private int replaceWithLarger2(Node node, int ssf) {

		if (node == null) {
			return ssf;
		}

		ssf = replaceWithLarger2(node.right, ssf);

		int temp = node.data;
		node.data = ssf;
		ssf += temp;

		return replaceWithLarger2(node.left, ssf);

	}

	public void add(int item) {
		add(null, root, item);
	}

	private void add(Node parent, Node child, int item) {

		if (child == null) {

			Node nn = new Node();
			nn.data = item;

			if (nn.data < parent.data) {
				parent.left = nn;
			} else {
				parent.right = nn;
			}

			return;
		}

		if (item > child.data) {
			add(child, child.right, item);
		} else {
			add(child, child.left, item);
		}

	}

	public void add2(int item) {

		add2(root, item);
	}

	public Node add2(Node node, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;

			return nn;
		}

		if (node.data < item) {

			node.right = add2(node.right, item);
		} else {
			node.left = add2(node.left, item);
		}

		return node;

	}

	public void remove(int item) {

		root = remove(root, item);
	}

	private Node remove(Node node, int item) {

		if (node.data < item) {
			node.right = remove(node.right, item);
		} else if (node.data > item) {
			node.left = remove(node.left, item);
		} else {

			// Same value which is to be delete

			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {

				int leftMax = max(node.left);
				node.left = remove(node.left, leftMax);
				node.data = leftMax;
			}

		}

		return node;
	}

}
