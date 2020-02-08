package Lec16_5Jan;

public class LLClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		LinkedList ll = new LinkedList();

		ll.addLast(12);
		ll.addLast(15);
		ll.addLast(10);
		ll.addLast(11);
		ll.addLast(5);
		ll.addLast(6);
		ll.addLast(2);
		ll.addLast(3);

//		System.out.println(ll.getFirst());
//		System.out.println(ll.getLast());
//		System.out.println(ll.getAt(2));

//		ll.display();
//
//		ll.addFirst(8);
//
//		ll.display();
//
////		ll.addAt(2, 9);
//		ll.display();
//
//		ll.RPR();
//
//		ll.display();
//
//		ll.fold();
//
//		ll.display();
//
//		System.out.println(ll.mid());
//
//		ll.createDummyList();
//
//		ll.Kreverse(3);
//
//		ll.display();

		ll.display();
		ll.delete();
		ll.display();

	}

}
