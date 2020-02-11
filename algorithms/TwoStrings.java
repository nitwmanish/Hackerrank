package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class TwoStrings {
	static String twoStrings(String s1, String s2) {
		String result = "NO";
		int[] first = new int['z' - 'a' + 1];
		int[] second = new int['z' - 'a' + 1];
		for (int index = 0; index < s1.length(); index++) {
			first['z' - s1.charAt(index)]++;

		}
		for (int index = 0; index < s2.length(); index++) {
			second['z' - s2.charAt(index)]++;
		}
		for (int index = 0; index < first.length; index++) {
			if (first[index] != 0 && second[index] != 0) {
				result = "YES";
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);
			System.out.println(result);
		}

		scanner.close();
	}
}
