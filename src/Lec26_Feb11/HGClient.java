package Lec26_Feb11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Lec24.Generics.Car;

public class HGClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car[] cars = new Car[5];

		cars[0] = new Car(1322, "Black", 1000);
		cars[1] = new Car(123233, "Yellow", 50);
		cars[2] = new Car(1123, "Blue", 2000);
		cars[3] = new Car(1000, "Red", 900);
		cars[4] = new Car(23, "Purple", 1);

		HeapGeneric<Car> hpg = new HeapGeneric<>();
		for (int i = 0; i < 5; i++) {

			hpg.add(cars[i]);
		}

		while (!hpg.isEmpty()) {
			System.out.println(hpg.remove());
		}

//		System.out.println(KthLargest(new int[] { 4, 1, 5, 2, 3, 6, 9, 1 }, 1));

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.get(0).add(1);
		lists.get(0).add(8);
		lists.get(0).add(9);
		lists.get(0).add(10);
		lists.get(0).add(12);
		lists.get(1).add(5);
		lists.get(1).add(15);
		lists.get(1).add(20);
		lists.get(2).add(7);
		lists.get(2).add(13);
		lists.get(2).add(25);
		lists.get(2).add(30);
		lists.get(3).add(2);
		lists.get(3).add(3);

		System.out.println(mergeKsortedLists(lists));

		// In built

		System.out.println("Priority Queue demo");
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		pq.add(1);
		pq.add(10);
		pq.add(2);
		pq.add(5);
		pq.add(1);
		pq.add(12);

		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}

	}

	public static class MaxComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}

	}

	public static int KthLargest(int[] arr, int k) {

		Heap hp = new Heap();
		for (int i = 0; i < k; i++) {
			hp.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {

			int min = hp.getMin();
			if (arr[i] > min) {
				hp.remove();
				hp.add(arr[i]);
			}

		}

		return hp.remove();

	}

	static class pair implements Comparable<pair> {
		int value;
		int listno;
		int idxno;

		public pair(int v, int lno, int idx) {
			value = v;
			listno = lno;
			idxno = idx;
		}

		@Override
		public int compareTo(pair o) {
			return o.value - this.value;
		}

	}

	public static ArrayList<Integer> mergeKsortedLists(ArrayList<ArrayList<Integer>> arr) {

		HeapGeneric<pair> hpg = new HeapGeneric<>();

		for (int i = 0; i < arr.size(); i++) {

			pair np = new pair(arr.get(i).get(0), i, 0);

			hpg.add(np);
		}

		ArrayList<Integer> res = new ArrayList<>();

		while (!hpg.isEmpty()) {

			pair rp = hpg.remove();
			res.add(rp.value);

			rp.idxno++;

			if (rp.idxno < arr.get(rp.listno).size()) {
				rp.value = arr.get(rp.listno).get(rp.idxno);
				hpg.add(rp);

			}

		}

		return res;

	}

}
