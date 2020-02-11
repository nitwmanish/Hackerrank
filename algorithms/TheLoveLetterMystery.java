package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class TheLoveLetterMystery {

	static int theLoveLetterMystery(String str) {
		char[] charArr = str.toCharArray();
		int count = 0;
		int start = 0;
		int end = str.length() - 1;
		while (start < end) {
			if (charArr[start] != charArr[end]) {
				if (charArr[start] > charArr[end]) {
					count = count + charArr[start] - charArr[end];
				} else {
					count = count + charArr[end] - charArr[start];
				}
			}
			char tmp = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = tmp;
			if (isPalindrome(charArr)) {
				break;
			}
			start++;
			end--;
		}
		return count;
	}

	static boolean isPalindrome(char[] charArr) {
		boolean isPalindrome = false;
		int start = 0;
		int end = charArr.length - 1;
		while (start < end) {
			if (charArr[start] == charArr[end]) {
				start++;
				end--;
			} else {
				break;
			}
		}
		if (start >= end) {
			isPalindrome = true;
		}
		return isPalindrome;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = theLoveLetterMystery(s);
			System.out.println(theLoveLetterMystery(s));
		}

		scanner.close();
	}
}
