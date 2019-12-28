package Assingments.Dec28;

import java.util.Scanner;

public class ShoppingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t-- > 0) {

			int AayushPhones = 0;
			int HarshitPhones = 0;

			int AayushLimit = scn.nextInt();
			int HarshitLimit = scn.nextInt();

			int cnt = 1;

			while (true) {

				AayushPhones += cnt;
				cnt++;
				HarshitPhones += cnt;
				cnt++;

				if (AayushPhones > AayushLimit) {
					System.out.println("Harshit");
					break;
				}

				if (HarshitPhones > HarshitLimit) {
					System.out.println("Aayush");
					break;
				}

			}

		}
	}

}
