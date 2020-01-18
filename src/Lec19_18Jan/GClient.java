package Lec19_18Jan;

public class GClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "100 3 20 1 50 0 30 1 60 0 40 3 70 0 80 0 90 0";
		GenericTree gt = new GenericTree(str);

		gt.display();

		System.out.println(gt.size());

		System.out.println(gt.height());
//		System.out.println(gt); Home-work 
		System.out.println(gt.max());

		gt.mirror();
		gt.display();
	}

}
