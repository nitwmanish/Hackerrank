package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class Kangaroo {

	// Complete the kangaroo function below.
	static String kangaroo(int x1, int v1, int x2, int v2) {
		String result = "NO";
		if (x1 > x2 && v1 > v2) {
			result = "NO";
		} else if (x2 > x1 && v2 > v1) {
			result = "NO";
		} else if (x1 == x2 && (v1 > v2 || v2 > v1)) {
			result = "NO";
		} else if (x1 % 2 == 1 && v1 % 2 == 0 && x2 % 2 == 1 && v2 % 2 == 1) {
			result = "NO";
		} else if (x1 % 2 == 0 && v1 % 2 == 0 && x2 % 2 == 0 && v2 % 2 == 1) {
			result = "NO";
		} else {
			if (x1 > x2) {
				while (x2 < x1) {
					x1 = x1 + v1;
					x2 = x2 + v2;
					if (x1 == x2) {
						result = "YES";
						break;
					}
				}
			} else {
				while (x1 < x2) {
					x1 = x1 + v1;
					x2 = x2 + v2;
					if (x1 == x2) {
						result = "YES";
						break;
					}
				}
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] x1V1X2V2 = scanner.nextLine().split(" ");

		int x1 = Integer.parseInt(x1V1X2V2[0]);

		int v1 = Integer.parseInt(x1V1X2V2[1]);

		int x2 = Integer.parseInt(x1V1X2V2[2]);

		int v2 = Integer.parseInt(x1V1X2V2[3]);

		String result = kangaroo(x1, v1, x2, v2);

		System.out.println(result);

		scanner.close();
	}
}
