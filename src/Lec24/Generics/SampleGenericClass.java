package Lec24.Generics;

import java.util.ArrayList;

public class SampleGenericClass<T> {

	T data;

	public void print() {
		System.out.println("Hello " + data);
	}

}
