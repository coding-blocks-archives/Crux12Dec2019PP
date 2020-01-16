package Assingments.Jan16;

import java.util.Scanner;

public class HelpRamu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int c1 = scn.nextInt();
		int c2 = scn.nextInt();
		int c3 = scn.nextInt();
		int c4 = scn.nextInt();

		int n = scn.nextInt();
		int m = scn.nextInt();

		int[] cabs = new int[n];
		int[] rick = new int[m];

		for (int i = 0; i < n; i++) {
			cabs[i] = scn.nextInt();
		}

		for (int i = 0; i < m; i++) {
			rick[i] = scn.nextInt();
		}

		int fareForCab = minFareUsingc1c2c3(cabs, c1, c2, c3);
		int fareForRick = minFareUsingc1c2c3(rick, c1, c2, c3);

		int min_fare = fareForCab + fareForRick;

		System.out.println(Math.min(min_fare, c4));

	}

	public static int minFareUsingc1c2c3(int[] rides, int c1, int c2, int c3) {

		int total_fare = 0;

		for (int i = 0; i < rides.length; i++) {

			total_fare += Math.min(rides[i] * c1, c2);
		}

		return Math.min(total_fare, c3);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
