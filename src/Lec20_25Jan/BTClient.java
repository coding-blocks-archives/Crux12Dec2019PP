package Lec20_25Jan;

public class BTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "10 true 20 true 40 false false true 50 " + "true 80 false false true 90 false false true "
				+ "30 true 70 false false false";

		String inp = "10 true 20 true 40 true 70 true 80 true 90 true 100 true 110 true 111 false false false false false false false false true 50 false true 11 false true 12 false true 13 false true 14 false true 15 false true 16 false true 17 false false true 30 false true 60 false false";
		BinaryTree bt = new BinaryTree(inp);
		bt.display();
		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(100));
		System.out.println(bt.ht());
		System.out.println(bt.diameter());
		System.out.println(bt.diameter2());
		System.out.println(bt.diameter3());
	}

}
