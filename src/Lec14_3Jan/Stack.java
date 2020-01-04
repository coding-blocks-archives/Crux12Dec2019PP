package Lec14_3Jan;

public class Stack {

	protected int[] data;
	protected int tos;

	public Stack() {

		this(5);
	}

	public Stack(int cap) {

		data = new int[cap];
		tos = -1;
	}

	public void push(int item) throws Exception {

		if (tos == data.length - 1) {
			throw new Exception("Stack is Full");
		}

		this.tos++;
		data[tos] = item;

	}

	public int pop() throws Exception {

		if (tos == -1) {
			throw new Exception("Stack is Empty");
		}

		int rv = data[tos];
		data[tos] = 0;
		tos--;

		return rv;
	}

	public int peek() throws Exception {

		if (tos == -1) {
			throw new Exception("Stack is Empty");
		}

		return data[tos];
	}

	public int size() {

		return this.tos + 1;
	}

	public void display() {

		for (int i = tos; i >= 0; i--) {

			System.out.println(data[i]);
		}

		System.out.println("--------------");

	}

	public boolean isFull() {
		
		return size() == data.length;
	}
	
	
	
	
	
	
	
	
}
