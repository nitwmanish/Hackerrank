package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

	static int alternatingCharacters(String str) {
		int count = 0;
		char prevChar = str.charAt(0);
		for (int strIndex = 1; strIndex < str.length(); strIndex++) {
			if (prevChar == str.charAt(strIndex)) {
				count++;
			} else {
				prevChar = str.charAt(strIndex);
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = alternatingCharacters(s);
			System.out.println(result);
		}
		scanner.close();
	}
}
