package Lec22_Feb1;

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

}
