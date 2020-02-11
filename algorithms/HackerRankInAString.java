package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class HackerRankInAString {

	static String hackerrankInString(String str) {
		String pattern = "hackerrank";
		boolean[] map = new boolean[255];
		for (int index = 0; index < pattern.length(); index++) {
			map[pattern.charAt(index)] = true;
		}
		for (int index = 0; index < str.length(); index++) {
			map[str.charAt(index)] = false;
		}
		for (int index = 0; index < map.length; index++) {
			if (map[index] == true) {
				return "NO";
			}
		}
		for (int index = 0; index < pattern.length(); index++) {
			map[pattern.charAt(index)] = true;
		}
		int strIndex = 0;
		for (int patternIndex = 0; patternIndex < pattern.length(); patternIndex++) {
			while (strIndex < str.length()) {
				if (str.charAt(strIndex) == pattern.charAt(patternIndex)) {
					map[pattern.charAt(patternIndex)] = false;
					strIndex++;
					break;
				}
				strIndex++;
			}
		}
		
		for (int index = 0; index < map.length; index++) {
			if (map[index] == true) {
				return "NO";
			}
		}

		return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			String result = hackerrankInString(s);
			System.out.println(result);
		}

		scanner.close();
	}
}
