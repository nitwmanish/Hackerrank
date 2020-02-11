package algorithms;

import java.io.IOException;

public class CrossValidation {

	public static int[][] cross_validation(int[] arr, int k) {

		int[] index;
		index = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			index[i] = arr[i];
		}
		int[][] train = new int[k][];
		int[][] test = new int[k][];

		int chunk = arr.length / k;
		for (int i = 0; i < k; i++) {
			int start = chunk * i;
			int end = chunk * (i + 1);
			if (i == k - 1)
				end = arr.length;
			train[i] = new int[arr.length - end + start];
			test[i] = new int[end - start];
			for (int j = 0, p = 0, q = 0; j < arr.length; j++) {
				if (j >= start && j < end) {
					test[i][p++] = index[j];
				} else {
					train[i][q++] = index[j];
				}
			}
		}
		int[][] result = new int[2 * train.length][];
		for (int x = 0, i = 0; i < 2 * train.length && x < train.length; i = i + 2, x++) {
			result[i] = new int[train[x].length];
			for (int j = 0; j < train[x].length; j++) {
				result[i][j] = train[x][j];
			}
			result[i + 1] = new int[test[x].length];
			for (int j = 0; j < test[x].length; j++) {
				result[i + 1][j] = test[x][j];
			}
		}
		return result;
	}

	public static double sensitivity_and_specificity(int[] A, int[] B, boolean q) {
//	    True positive: Sick people correctly identified as sick
//	    False positive: Healthy people incorrectly identified as sick
//	    True negative: Healthy people correctly identified as healthy
//	    False negative: Sick people incorrectly identified as healthy
		int tp = 0;
		int fp = 0;
		int fn = 0;
		int tn = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1 && B[i] == 1) {
				tp++;
			}
			if (A[i] == 0 && B[i] == 1) {
				fp++;
			}
			if (A[i] == 1 && B[i] == 0) {
				fn++;
			}
			if (A[i] == 0 && B[i] == 0) {
				tn++;
			}
		}
		double result = 0;
		double sensitivity = ((double) tp) / (tp + fn);
		double specificity = ((double) tn) / (tn + fp);
		if (q == false) {
			result = sensitivity;

		} else {
			result = specificity;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		int[][] result = cross_validation(arr, 2);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
//		int[] A = new int[] { 1, 0, 1, 1, 0, 1 };
//		int[] B = new int[] { 0, 1, 1, 0, 0, 1 };
//		boolean q = true;
//		System.out.print(sensitivity_and_specificity(A, B, q));
	}

}
