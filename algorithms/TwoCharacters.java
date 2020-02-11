package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
	Character a;
	Character b;
}

public class TwoCharacters {

	// Complete the alternate function below.
	static int alternate(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int index = 0; index < s.length(); index++) {
			Integer count = map.get(s.charAt(index));
			if (count == null) {
				map.put(s.charAt(index), 1);
			} else {
				map.put(s.charAt(index), count + 1);
			}
		}
		List<Character> keysList = new ArrayList<>(map.keySet());
		int n = keysList.size();
		Pair[] pairs = new Pair[n * (n - 1) / 2];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				Pair pair = new Pair();
				pair.a = keysList.get(i);
				pair.b = keysList.get(j);
				pairs[index++] = pair;
			}
		}
		int max = -1;
		for (Pair pair : pairs) {
			Character pre = null;
			int curentMax = 0;
			for (index = 0; index < s.length(); index++) {
				if (s.charAt(index) == pair.a || s.charAt(index) == pair.b) {
					if (pre == null) {
						pre = s.charAt(index);
						curentMax++;
					} else {
						if (s.charAt(index) == pre) {
							break;
						} else {
							pre = s.charAt(index);
							curentMax++;
						}
					}
				}
			}
			if (index == s.length() && max < curentMax) {
				max = curentMax;
			}

		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int l = Integer.parseInt(bufferedReader.readLine().trim());

		String s = bufferedReader.readLine();

		int result = alternate(s);
		System.out.println(result);
	}
}
