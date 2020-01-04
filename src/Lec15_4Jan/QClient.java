package Lec15_4Jan;

public class QClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue q = new Queue();
		
		q.Enqueue(10);
		q.Enqueue(20);
		q.Enqueue(30);
		q.Enqueue(40);
		q.Enqueue(50);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		q.Enqueue(60);
		q.Enqueue(70);
		
		q.display();
		
	}

}






