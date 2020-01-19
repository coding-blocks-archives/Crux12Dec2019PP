package Lec19_18Jan;


public class GClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "10 3 20 2 50 0 60 0 30 1 70 0 40 3 80 0 90 0 100 0";
		GenericTree gt = new GenericTree(str);

		gt.display();

		System.out.println(gt.size());

		System.out.println(gt.height());
//		System.out.println(gt); Home-work 
		System.out.println(gt.max());

//		gt.mirror();
		gt.display();

		gt.preorder();
		System.out.println();
		gt.postorder();
		System.out.println();
		gt.LO();
		
		System.out.println();
		
		gt.LOLL();
		System.out.println();
		gt.LOLL2();
		
		System.out.println();
		gt.LOZZ();

	}

}
