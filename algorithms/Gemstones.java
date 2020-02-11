package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class Gemstones {
	// Complete the gemstones function below.
	static int gemstones(String[] arr) {
		boolean[][] mat = new boolean[arr.length]['z' - 'a' + 1];
		for (int arrayIndex = 0; arrayIndex < arr.length; arrayIndex++) {
			String str = arr[arrayIndex];
			for (int strIndex = 0; strIndex < str.length(); strIndex++) {
				mat[arrayIndex]['z' - str.charAt(strIndex)] = true;
			}
		}
		int count = 0;
		for (int col = 0; col < mat[0].length; col++) {
			int row = 0;
			for (; row < mat.length; row++) {
				if (mat[row][col] == false) {
					break;
				}
			}
			if (row == mat.length) {
				count++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			String arrItem = scanner.nextLine();
			arr[i] = arrItem;
		}

		int result = gemstones(arr);
		System.out.println(result);
		scanner.close();
	}
}
