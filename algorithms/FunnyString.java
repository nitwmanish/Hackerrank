package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class FunnyString {

	// Complete the funnyString function below.
	static String funnyString(String str) {
		StringBuilder sb = new StringBuilder(str);
		String strReverse = sb.reverse().toString();
		int[] diff = new int[str.length() - 1];
		int[] diffReverse = new int[str.length() - 1];
		String result = "Funny";
		for (int index = 0; index < str.length() - 1; index++) {
			diff[index] = str.charAt(index + 1) - str.charAt(index);
		}
		for (int index = 0; index < strReverse.length() - 1; index++) {
			diffReverse[index] = strReverse.charAt(index) - strReverse.charAt(index + 1);
		}
		for (int index = 0; index < str.length() - 1; index++) {
			if (Math.abs(diff[index]) != Math.abs(diffReverse[index])) {
				result = "Not Funny";
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			String result = funnyString(s);
			System.out.println(result);
		}

		scanner.close();
	}
}
