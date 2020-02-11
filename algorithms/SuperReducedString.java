package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperReducedString {

	// Complete the superReducedString function below.
	static String superReducedString(String s) {
		// aaabccddd = abccddd = abddd = abd
		StringBuilder str = new StringBuilder(s);
		int index = 0;
		while (index < str.length()-1) {
			if (str.charAt(index) == str.charAt(index + 1)) {
				str.deleteCharAt(index);
				str.deleteCharAt(index);
				if(index>0) {
					index--;
				}
				else {
					index = 0;
				}
			} else {
				index++;
			}

		}
		String result = new String(str);
		if (result.isEmpty())
			result = "Empty String";
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String s = bufferedReader.readLine();

		String result = superReducedString(s);

		System.out.println(result);
	}
}
