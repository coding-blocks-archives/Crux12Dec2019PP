package Lec15_4Jan;

public class DQClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue q = new Queue();
		q.Enqueue(1);
		q.Enqueue(2);
		q.Enqueue(3);
		q.Enqueue(4);
		q.Enqueue(5);

		displayReverse(q, 0);

		System.out.println("Real Queue");
		q.display();
	}

	public static void ActualReverse(Queue q) {

		if (q.isEmpty()) {
			return;
		}

		int val = q.dequeue();
		ActualReverse(q);

		System.out.println(val);
		q.Enqueue(val);

	}

	public static void displayReverse(Queue q, int cnt) {

		if (cnt == q.size()) {
			return;
		}

		int val = q.dequeue();
		q.Enqueue(val);
		displayReverse(q, cnt + 1);
		System.out.println(val);

	}

	
	
	
	
	
	
	
	
	
}
