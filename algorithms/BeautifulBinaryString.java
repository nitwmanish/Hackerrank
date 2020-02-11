package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class BeautifulBinaryString {

	static int beautifulBinaryString(String str) {
		int count = 0;
		int index = 0;
		while (index < str.length() - 2) {
			if (str.charAt(index) == '0' && str.charAt(index + 1) == '1' && str.charAt(index + 2) == '0') {
				count++;
				index = index + 3;
			} else {
				index++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String b = scanner.nextLine();

		int result = beautifulBinaryString(b);
		System.out.println(result);
		scanner.close();
	}
}
