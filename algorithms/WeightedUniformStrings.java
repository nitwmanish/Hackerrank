package algorithms;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformStrings {

	// Complete the weightedUniformStrings function below.
//	static String[] weightedUniformStrings(String str, int[] queries) {
//		int[] map = new int[27];
//		for (int index = 0; index < str.length(); index++) {
//			map[str.charAt(index) - 'a' + 1]++;
//		}
//		Map<Integer, Integer> hasMap = new HashMap<>();
//		for (int index = 0; index < map.length; index++) {
//			int count = map[index];
//			if (count != 0) {
//				int key = index;
//				int value = index;
//				hasMap.put(key, value);
//				for (int i = 1; i < count; i++) {
//					key += index;
//					value += value;
//					hasMap.put(key, value);
//				}
//			}
//		}
//		String[] result = new String[queries.length];
//		for (int index = 0; index < queries.length; index++) {
//			if (hasMap.get(queries[index]) == null) {
//				result[index] = "NO";
//			} else {
//				result[index] = "YES";
//			}
//		}
//		return result;
//	}

	static String[] weightedUniformStrings(String str, int[] queries) {
		Set<Integer> weights = new HashSet<>();
		char prev = 0;
		int length = 0;
		for (int index = 0; index < str.length(); index++) {
			char c = str.charAt(index);
			int weight = (int) c - (int) 'a' + 1;
			weights.add(weight);
			if (prev == c) {
				length += 1;
				weights.add(length * weight);
			} else {
				prev = c;
				length = 1;
			}
		}
		String[] rval = new String[queries.length];
		int index = 0;
		for (int q : queries) {
			if (weights.contains(q)) {
				rval[index] = "Yes";
			} else {
				rval[index] = "No";
			}
			index++;
		}
		return rval;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] queries = new int[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			int queriesItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			queries[i] = queriesItem;
		}

		String[] result = weightedUniformStrings(s, queries);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);

			if (i != result.length - 1) {
				System.out.println();
			}
		}

		scanner.close();
	}
}
