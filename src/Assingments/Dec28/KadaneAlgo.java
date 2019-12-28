package Assingments.Dec28;

public class KadaneAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 12, -1, -4, 92, -1, -5 };

		System.out.println(maxSum(arr));
	}

	public static int maxSum(int[] arr) {

		int curr_sum = 0;
		int max_sum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			curr_sum += arr[i];
			max_sum = Math.max(max_sum, curr_sum);
			curr_sum = Math.max(curr_sum, 0);

		}

		return max_sum;

	}

}
