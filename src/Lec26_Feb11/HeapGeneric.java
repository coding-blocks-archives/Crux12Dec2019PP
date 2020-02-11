package Lec26_Feb11;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {

	private ArrayList<T> data = new ArrayList<>();

	public void add(T item) {

		data.add(item);
		upheapify(data.size() - 1);
	}

	public void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (data.get(ci).compareTo(data.get(pi)) > 0) {
			swap(ci, pi);
			upheapify(pi);
		}

	}

	public void swap(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);
	}

	public T remove() {

		swap(0, data.size() - 1);
		T rv = data.remove(data.size() - 1);
		downheapify(0);
		return rv;
	}

	public boolean isEmpty() {

		return data.size() == 0;
	}

	public void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < data.size() && data.get(lci).compareTo(data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < data.size() && data.get(rci).compareTo(data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	public T getMin() {
		return data.get(0);
	}

	public void display() {
		System.out.println(data);
	}

}
