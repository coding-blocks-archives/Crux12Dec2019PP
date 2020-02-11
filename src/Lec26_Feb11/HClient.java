package Lec26_Feb11;

public class HClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Heap hp = new Heap();
		hp.add(2);
		hp.add(5);
		hp.add(4);
		hp.add(3);
		hp.add(1);
		hp.add(6);
		hp.add(9);

		hp.display();

		while (!hp.isEmpty()) {
			System.out.println(hp.remove());
		}

	}

}
