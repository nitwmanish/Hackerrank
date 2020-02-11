package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class HighestValuePalindrome {

	static String highestValuePalindrome(String str, int n, int allowedChanges) {
		char palindrome[] = str.toCharArray();
		String ans = "";
		int l = 0;
		int r = str.length() - 1;
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				palindrome[l] = palindrome[r] = (char) Math.max(str.charAt(l), str.charAt(r));
				allowedChanges--;
			}
			l++;
			r--;
		}
		if (allowedChanges < 0) {
			return "-1";
		}

		l = 0;
		r = str.length() - 1;

		while (l <= r) {
			if (l == r) {
				if (allowedChanges > 0) {
					palindrome[l] = '9';
				}
			}
			if (palindrome[l] < '9') {
				if (allowedChanges >= 2 && palindrome[l] == str.charAt(l) && palindrome[r] == str.charAt(r)) {
					allowedChanges -= 2;
					palindrome[l] = palindrome[r] = '9';
				} else if (allowedChanges >= 1 && (palindrome[l] != str.charAt(l) || palindrome[r] != str.charAt(r))) {
					allowedChanges--;
					palindrome[l] = palindrome[r] = '9';
				}
			}
			l++;
			r--;
		}
		for (int i = 0; i < palindrome.length; i++)
			ans += palindrome[i];
		return ans;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		String s = scanner.nextLine();

		String result = highestValuePalindrome(s, n, k);
		System.out.println(result);

		scanner.close();
	}
}
