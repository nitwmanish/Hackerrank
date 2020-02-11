package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {

	static int makingAnagrams(String s1, String s2) {
		int count = -1;
		int[] first = new int['z' - 'a' + 1];
		int[] second = new int['z' - 'a' + 1];
		for (int index = 0; index < s1.length(); index++) {
			first['z' - s1.charAt(index)]++;

		}
		for (int index = 0; index < s2.length(); index++) {
			second['z' - s2.charAt(index)]++;
		}
		count = 0;
		for (int index = 0; index < first.length; index++) {

			count = count + Math.abs(first[index] - second[index]);
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		int result = makingAnagrams(s1, s2);
		System.out.println(result);

		scanner.close();
	}
}
