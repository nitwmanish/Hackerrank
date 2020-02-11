package algorithms;

import java.util.Scanner;

public class SeparateTheNumbers {

	static String separateNumbers(String str) {
		if (str.charAt(0) != 0) {
			for (int length = 1; length * 2 <= str.length(); length++) {
				long firstNumber = Long.parseLong(str.substring(0, length));
				StringBuilder sequence = new StringBuilder();
				long number = firstNumber;
				while (sequence.length() < str.length()) {
					sequence.append(number);
					number++;
				}
				if (sequence.toString().equals(str)) {
					return "YES" + firstNumber;
				}
			}
		}
		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			System.out.println(separateNumbers(s));
		}

		scanner.close();
	}
}
