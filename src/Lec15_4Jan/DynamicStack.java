package Lec15_4Jan;

import Lec14_3Jan.Stack;

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {

		if (isFull()) {

			int[] na = new int[data.length * 2];

			for (int i = 0; i < data.length; i++) {

				na[i] = data[i];
			}

			data = na;

		}

		super.push(item);

	}

}
