package Lec20_25Jan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	public class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	Scanner scn = new Scanner(System.in);

	public BinaryTree(String str) {

		scn = new Scanner(str);
		root = construct(null, true);
	}

	public BinaryTree(int[] pre, int[] in) {

		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi) {
			return null;
		}

		Node nn = new Node();
		nn.data = pre[plo];

		int idx = -1;
		for (int i = ilo; i <= ihi; i++) {

			if (pre[plo] == in[i]) {
				idx = i;
				break;
			}
		}

		int nel = idx - ilo;

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, idx - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, idx + 1, ihi);

		return nn;

	}

	public Node construct(Node parent, boolean isLeftChild) {

		if (parent == null)
			System.out.println("Enter the Data for Root? ");
		else {

			String child = (isLeftChild ? "Left" : "Right");
			System.out.println("Enter the Data for " + child + " child of " + parent.data + "? ");
		}

		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;

		System.out.println("Is Left child of " + nn.data + "? ");
		boolean ilc = scn.nextBoolean();

		if (ilc) {

			nn.left = construct(nn, true);
		}

		System.out.println("Is Right child of " + nn.data + "? ");
		boolean irc = scn.nextBoolean();

		if (irc) {
			nn.right = construct(nn, false);
		}

		return nn;
	}

	public void from_Level_Order_To_Tree() {

		int val = scn.nextInt();
		root = new Node();
		root.data = val;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			Node rn = queue.remove();

			int lc = scn.nextInt();

			if (lc != -1) {
				Node leftNode = new Node();
				leftNode.data = lc;
				rn.left = leftNode;
				queue.add(leftNode);

			}

			int rc = scn.nextInt();

			if (rc != -1) {
				Node rightNode = new Node();
				rightNode.data = rc;
				rn.right = rightNode;
				queue.add(rightNode);
			}

		}

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

	public int max() {

		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = max(node.left);
		int rmax = max(node.right);

		return Math.max(node.data, Math.max(rmax, lmax));

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

		boolean lans = find(node.left, item);
		boolean rans = find(node.right, item);

		return lans || rans;

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

	public int diameter() {

		return dia(root);
	}

	private int dia(Node node) {

		if (node == null) {

			return 0;
		}

		int ld = dia(node.left);
		int rd = dia(node.right);
		int sd = ht(node.left) + ht(node.right) + 2;

		return Math.max(sd, Math.max(ld, rd));

	}

	int dia = 0;

	public int diameter2() {
		dia2(root);

		return dia;
	}

	private int dia2(Node node) {

		if (node == null) {
			return -1;
		}

		int l_ht = dia2(node.left);
		int r_ht = dia2(node.right);

		int sd = l_ht + r_ht + 2;
		dia = Math.max(dia, sd);
		return Math.max(l_ht, r_ht) + 1;
	}

	class diapair {

		int dia = 0;
		int ht = -1;
	}

	public int diameter3() {

		return dia3(root).dia;
	}

	private diapair dia3(Node node) {

		if (node == null) {
			return new diapair();
		}

		// Left dia pair
		diapair ldp = dia3(node.left);

		// Right dia pair
		diapair rdp = dia3(node.right);

		// Self dia pair
		diapair sdp = new diapair();

		int ld = ldp.dia;
		int rd = rdp.dia;
		int sd = ldp.ht + rdp.ht + 2;

		// Self diameter
		sdp.dia = Math.max(sd, Math.max(ld, rd));

		// Self height
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;

	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	public boolean isBalanced(Node node) {

		if (node == null) {
			return true;
		}

		boolean left = isBalanced(node.left);
		boolean right = isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);
		return left && right && Math.abs(bf) <= 1;

	}

	class balpair {

		int ht = -1;
		boolean isbal = true;
	}

	public boolean isBalanced2() {
		return isBalanced2(root).isbal;
	}

	public balpair isBalanced2(Node node) {

		if (node == null) {
			return new balpair();
		}

		balpair lp = isBalanced2(node.left);
		balpair rp = isBalanced2(node.right);

		balpair sp = new balpair();

		int lh = lp.ht;
		int rh = rp.ht;

		sp.ht = Math.max(lh, rh) + 1;
		int bf = Math.abs(lh - rh);

		sp.isbal = bf <= 1 && lp.isbal && rp.isbal;

		return sp;

	}

	public void preorder() {

		preorder(root);
		System.out.println();
	}

	public void postorder() {

		postorder(root);
		System.out.println();
	}

	public void inorder() {

		inorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null)
			return;

		System.out.print(node.data + " ");

		preorder(node.left);
		preorder(node.right);

	}

	private void postorder(Node node) {

		if (node == null)
			return;

		postorder(node.left);
		postorder(node.right);

		System.out.print(node.data + " ");

	}

	private void inorder(Node node) {

		if (node == null)
			return;

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	class pair {

		Node node;
		boolean isSelf;
		boolean isLeft;
		boolean isRight;

		public pair(Node node) {
			this.node = node;
		}
	}

	public void preorderItr() {

		Stack<pair> stack = new Stack<>();

		stack.push(new pair(root));

		while (!stack.isEmpty()) {

			pair peekpair = stack.peek();

			if (!peekpair.isSelf) {

				System.out.print(peekpair.node.data + " ");
				peekpair.isSelf = true;
			} else if (!peekpair.isLeft) {

				if (peekpair.node.left != null) {
					pair lp = new pair(peekpair.node.left);
					stack.push(lp);
				}
				peekpair.isLeft = true;

			} else if (!peekpair.isRight) {

				if (peekpair.node.right != null) {
					pair rp = new pair(peekpair.node.right);
					stack.push(rp);
				}
				peekpair.isRight = true;
			} else {
				stack.pop();
			}

		}

		System.out.println();
	}

	public void Level() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		ArrayList<Integer> each_level = new ArrayList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			if (rn == null) {
				continue;
			}
			each_level.add(rn.data);

			helper.addLast(rn.left);
			helper.addLast(rn.right);

			if (queue.isEmpty()) {

				res.add(each_level);
				each_level = new ArrayList<>();
				queue = helper;
				helper = new LinkedList<>();
			}

		}

		System.out.println(res);

	}

	public int LCA(int n1, int n2) {

		return LCA(root, n1, n2).data;
	}

	public Node LCA(Node root, int n1, int n2) {

		if (root == null) {
			return null;
		}

		if (root.data == n1 || root.data == n2) {
			return root;
		}

		Node left_LCA = LCA(root.left, n1, n2);
		Node right_LCA = LCA(root.right, n1, n2);

		if (left_LCA != null && right_LCA != null) {
			return root;
		}

		return left_LCA == null ? right_LCA : left_LCA;

	}

}
