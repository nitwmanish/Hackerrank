package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class StrongPassword {

	// Complete the minimumNumber function below.
	static boolean isContainDigit(String password) {
		String numbers = "0123456789";
		for (int index = 0; index < password.length(); index++) {
			for (int i = 0; i < numbers.length(); i++)
				if (password.charAt(index) == numbers.charAt(i)) {
					return true;
				}
		}
		return false;
	}

	static boolean isContainLowerCase(String password) {
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		for (int index = 0; index < password.length(); index++) {
			for (int i = 0; i < lowerCase.length(); i++)
				if (password.charAt(index) == lowerCase.charAt(i)) {
					return true;
				}
		}
		return false;
	}

	static boolean isContainUpperCase(String password) {
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int index = 0; index < password.length(); index++) {
			for (int i = 0; i < upperCase.length(); i++)
				if (password.charAt(index) == upperCase.charAt(i)) {
					return true;
				}
		}
		return false;
	}

	static boolean isContainSpecialCharacters(String password) {
		String specialCharacters = "!@#$%^&*()-+";
		for (int index = 0; index < password.length(); index++) {
			for (int i = 0; i < specialCharacters.length(); i++)
				if (password.charAt(index) == specialCharacters.charAt(i)) {
					return true;
				}
		}
		return false;
	}

	static int minimumNumber(int n, String password) {
		int count = 0;
		if (!isContainDigit(password)) {
			count++;
		}
		if (!isContainLowerCase(password)) {
			count++;
		}
		if (!isContainUpperCase(password)) {
			count++;
		}
		if (!isContainSpecialCharacters(password)) {
			count++;
		}
		if (n + count > 6)
			return count;

		return count + 6 - (n + count);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();

		int answer = minimumNumber(n, password);
		System.out.println(answer);

		scanner.close();
	}
}
