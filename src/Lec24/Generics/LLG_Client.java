package Lec24.Generics;

public class LLG_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LLGeneric<Car> ll = new LLGeneric<Car>();

		ll.addLast(new Car(100, "Yellow", 123));
		ll.addLast(new Car(1, "Yellow", 123));
		ll.addLast(new Car(10, "Yellow", 123));
		ll.addLast(new Car(230, "Yellow", 123));

		ll.display();
	}

}
