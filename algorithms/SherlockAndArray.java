package algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SherlockAndArray {

	static String balancedSums(List<Integer> arr) {
		int sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
		}
		int curr = 0;
		for (int j = 0; j < arr.size(); j++) {
			if (curr == sum - arr.get(j) - curr) {
				return "YES";
			}
			curr += arr.get(j);
		}
		return "NO";
	}

	public static void main(String[] args) throws IOException {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		String result = balancedSums(list);
		System.out.print(result);

	}
}
