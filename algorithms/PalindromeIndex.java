package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class PalindromeIndex {

	static int palindromeIndex(String str) {
		char[] charArr = str.toCharArray();
		int palindromeIndex = -1;
		if (isPalindrome(charArr)) {
			return palindromeIndex;
		}
		for (int index = 0; index < str.length(); index++) {
			if (isPalindromeAfterIngnoringIndex(charArr, index)) {
				palindromeIndex = index;
				break;
			}

		}
		return palindromeIndex;
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

	static boolean isPalindromeAfterIngnoringIndex(char[] charArr, int index) {
		boolean isPalindrome = false;
		int start = 0;
		int end = charArr.length - 1;
		while (start < end) {
			if (index == start) {
				start++;
				continue;
			} else if (end == index) {
				end--;
				continue;
			}
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

			int result = palindromeIndex(s);
			System.out.println(result);
		}

		scanner.close();
	}
}
