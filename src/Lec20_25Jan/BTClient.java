package Lec20_25Jan;

import java.util.LinkedList;

public class BTClient {

	int a = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "10 true 20 true 40 false false true 50 " + "true 80 false false true 90 false false true "
				+ "30 true 70 false false false";

		String inp = "10 true 20 true 40 true 70 true 80 true 90 true 100 true 110 true 111 false false false false false false false false true 50 false true 11 false true 12 false true 13 false true 14 false true 15 false true 16 false true 17 false false true 30 false true 60 false false";

		String inp2 = "10 true 20 true 40 true 70 false false false false true 30 false true 60 false false";
		String inp3 = "10 true 20 true 40 true 70 false false false true 50 false false true 30 false true 60 false false";

		int[] pre = { 10, 20, 40, 50, 30, 70 };
		int[] in = { 40, 20, 50, 10, 30, 70 };

		BinaryTree bt = new BinaryTree(pre, in);

		bt.from_Level_Order_To_Tree();

		bt.display();
		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.find(100));
//		System.out.println(bt.ht());
//		System.out.println(bt.diameter());
//		System.out.println(bt.diameter2());
//		System.out.println(bt.diameter3());
//
//		System.out.println(bt.isBalanced());
//		System.out.println(bt.isBalanced2());

		bt.preorder();
//		bt.postorder();
//		bt.inorder();
//		bt.preorderItr();
//		
//		bt.Level();
//		
//		System.out.println(bt.LCA(40, 20));

	}

}
