package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class Anagram {
	// Complete the anagram function below.
	static int anagram(String str) {
		int count = -1;
		int[] firstHalf = new int['z' - 'a' + 1];
		int[] secondHalf = new int['z' - 'a' + 1];
		if (str.length() % 2 != 0) {
			return count;
		}
		for (int index = 0; index < str.length() / 2; index++) {
			firstHalf['z' - str.charAt(index)]++;
			secondHalf['z' - str.charAt(index + str.length() / 2)]++;
		}
		count = 0;
		for (int index = 0; index < firstHalf.length; index++) {
			if (secondHalf[index] > firstHalf[index])
				count = count + secondHalf[index] - firstHalf[index];
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = anagram(s);
			System.out.println(result);
		}

		scanner.close();
	}
}
