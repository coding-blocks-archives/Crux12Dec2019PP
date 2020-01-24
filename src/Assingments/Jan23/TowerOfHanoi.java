package Assingments.Jan23;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TOH(1, "Source", "Auxillary", "destination");
	}

	public static int TOH(int n, String src, String aux, String dest) {

		if (n == 1) {
			System.out.println("Move 1st disk from " + src + " to " + dest);
			return 1;
		}

		int cnt = 0;

		cnt += TOH(n - 1, src, dest, aux);
		System.out.println("Move " + n + "th disk from " + src + " to " + dest);
		cnt += TOH(n - 1, aux, src, dest);

		return cnt + 1;

	}

}













