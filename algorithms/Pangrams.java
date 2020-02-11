package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class Pangrams {

	// Complete the pangrams function below.
	static String pangrams(String str) {
		boolean[] map = new boolean[26];
		str = str.toLowerCase();
		for (int index = 0; index < str.length(); index++) {
			if (str.charAt(index) >= 'a' && str.charAt(index) <= 'z')
				map[str.charAt(index) - 'a'] = true;
		}
		for (int index = 0; index < map.length; index++) {
			if (map[index] == false) {
				return "not pangram";
			}
		}
		return "pangram";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		String a = "abc";
//		System.out.println((int) a.charAt(0));

		String s = scanner.nextLine();

		String result = pangrams(s);
		System.out.println(result);

		scanner.close();
	}

}
