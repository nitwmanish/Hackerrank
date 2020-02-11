package algorithms;

import java.io.IOException;
import java.util.Arrays;

class NumberPair implements Comparable<NumberPair> {
	Integer number;
	int index;

	@Override
	public int compareTo(NumberPair o) {
		return this.number.compareTo(o.number);
	}
}

public class IceCreamParlor {

	// Complete the icecreamParlor function below.

	static int[] icecreamParlor(int m, int[] arr) {
		NumberPair[] pairs = new NumberPair[arr.length];
		for (int i = 0; i < arr.length; i++) {
			NumberPair pair = new NumberPair();
			pair.number = arr[i];
			pair.index = i;
			pairs[i] = pair;
		}
		Arrays.sort(pairs);
		int[] result = new int[2];
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (pairs[start].number + pairs[end].number > m) {
				end--;
			} else if (pairs[start].number + pairs[end].number < m) {
				start++;
			} else {
				if (pairs[start].index > pairs[end].index) {
					result[0] = pairs[end].index + 1;
					result[1] = pairs[start].index + 1;
				} else if (pairs[start].number < pairs[end].number) {
					result[0] = pairs[start].index + 1;
					result[1] = pairs[end].index + 1;
				}else {
					result[0] = pairs[start].index + 1;
					result[1] = pairs[end].index + 1;
				}
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

//		int[] result = icecreamParlor(4, new int[] { 1, 4, 5, 3, 2 });
//		for (int i = 0; i < result.length; i++) {
//			System.out.print(result[i] +" ");
//		}
//		System.out.println();
		int[] result = icecreamParlor(4, new int[] { 2, 2, 4, 3 });
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] +" ");
		}

	}
}
