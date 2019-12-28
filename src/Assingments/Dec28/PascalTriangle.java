package Assingments.Dec28;

import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int nst = 1;
		int rows = 1;

		while (rows <= n) {

			int cst = 1;
			while (cst <= nst) {

				int val = nCr(rows - 1, cst - 1);
				System.out.print(val+" ");
				cst++;
			}

			System.out.println();
			nst++;
			rows++;

		}
	}

	public static int nCr(int n, int r) {
		
		r = Math.min(r, n - r);
		
		int res = 1;
		
		for(int i = 0;i < r;i++) {
			
			res = res * (n - i);
			res = res / (i + 1);
			
		}
		
		return res;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
