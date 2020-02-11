package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class InsertionSortAdvancedAnalysis {

	// Complete the insertionSort function below.
	static int getSum(int BITree[], int index) {
		int sum = 0;
		while (index > 0) {
			sum += BITree[index];
			index -= index & (-index);
		}
		return sum;
	}

	static void updateBIT(int BITree[], int n, int index, int val) {
		while (index <= n) {
			BITree[index] += val;
			index += index & (-index);
		}
	}

	
	static int insertionSort(int arr[]) {
		int n = arr.length;
		int invcount = 0;
		int maxElement = 0;
		
		for (int i = 0; i < n; i++)
			if (maxElement < arr[i])
				maxElement = arr[i];
		int[] BIT = new int[maxElement + 1];
		for (int i = 1; i <= maxElement; i++)
			BIT[i] = 0;
		for (int i = n - 1; i >= 0; i--) {
			invcount += getSum(BIT, arr[i] - 1);
			updateBIT(BIT, maxElement, arr[i], 1);
		}
		return invcount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			int result = insertionSort(arr);
			System.out.println(result);
		}


		scanner.close();
	}
}
