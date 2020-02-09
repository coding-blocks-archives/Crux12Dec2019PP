package Lec24;

public class Car {

	int speed;
	String color;
	int price;

	public Car(int s, String c, int p) {

		speed = s;
		color = c;
		price = p;
	}

	@Override
	public String toString() {

		return "{S:" + speed + " P:" + price + " C:" + color + "}";
	}

//	@Override
//	public int compareTo(Car o) {

//		return this.speed - o.speed;
//		return o.price - this.price;
//	}

}
