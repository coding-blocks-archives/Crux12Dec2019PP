package Lec15_4Jan;

public class DynamicQueue extends Queue {

	@Override
	public void Enqueue(int item) {

		if (isFull()) {

			int[] na = new int[2 * data.length];

			for (int i = 0; i < size; i++) {

				na[i] = data[(front + i) % data.length];
			}

			data = na;
			front = 0;
		}

		super.Enqueue(item);

	}
}
