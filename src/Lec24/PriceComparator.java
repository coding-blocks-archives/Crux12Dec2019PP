package Lec24;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
	
		return o2.price - o1.price;
	}

	
}
