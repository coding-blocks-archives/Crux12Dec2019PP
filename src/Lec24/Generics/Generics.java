package Lec24.Generics;

import java.util.Comparator;

public class Generics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car[] cars = new Car[5];

		cars[0] = new Car(1322, "Black", 1000);
		cars[1] = new Car(123233, "Yellow", 50);
		cars[2] = new Car(1123, "Blue", 2000);
		cars[3] = new Car(1000, "Red", 900);
		cars[4] = new Car(23, "Purple", 1);

		display(cars);
//		bubbleSort(cars);
		bubbleSort(cars, new PriceComparator());
		System.out.println();

		display(cars);

//		Comparator<T>;

	}

	public static <T> void display(T[] arr) {

		for (T val : arr) {
			System.out.println(val + " ");
		}

	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (arr[j].compareTo(arr[j + 1]) < 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}
	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comp) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (comp.compare(arr[j], arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}
	}

}
