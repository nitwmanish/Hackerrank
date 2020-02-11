package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class SherlockAndTheValidString {

	static String isValid(String str) {
		int[] map = new int['z' - 'a' + 1];
		for (int index = 0; index < str.length(); index++) {
			map[str.charAt(index) - 'a']++;
		}
		int max_occur = -1;
		boolean removed_char = false;
		for (int index = 0; index < map.length; index++) {
			if (map[index] == 0) {
				continue;
			} else if (max_occur == -1) {
				max_occur = map[index];
				continue;
			} else if (map[index] == max_occur) {
				continue;
			} else if (!removed_char && (map[index] == max_occur + 1 || map[index] == 1)) {
				removed_char = !removed_char;
				continue;
			} else {
				return "NO";
			}
		}
		return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();

		String result = isValid(s);

		System.out.println(result);

		scanner.close();
	}
}
