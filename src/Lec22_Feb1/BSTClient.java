package Lec22_Feb1;

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inorder = { 1, 2, 3, 4 };
		BST bst = new BST(inorder);
		bst.display();
		System.out.println(bst.size());
		System.out.println(bst.max());
		System.out.println(bst.find(19));
		bst.printInRange(6, 10);

//		bst.replaceWithLarger();
//		bst.replaceWithLarger2();
		bst.display();
//		bst.add(0);
		bst.add2(4);
		System.out.println();
		bst.display();
		bst.remove(2);
		System.out.println();
		bst.display();
	}

}
