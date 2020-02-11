package algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MissingNumbers {

	// Complete the missingNumbers function below.
	static int[] missingNumbers(int[] arr, int[] brr) {
		List<Integer> missingList = new ArrayList<>();
		Map<Integer, Integer> brrMap = new HashMap<>();
		for (int i = 0; i < brr.length; i++) {
			if (brrMap.get(brr[i]) == null) {
				brrMap.put(brr[i], 1);
			} else {
				brrMap.put(brr[i], brrMap.get(brr[i]) + 1);
			}
		}
		Map<Integer, Integer> arrMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (arrMap.get(arr[i]) == null) {
				arrMap.put(arr[i], 1);
			} else {
				arrMap.put(arr[i], arrMap.get(arr[i]) + 1);
			}
		}

		Set<Integer> keys = brrMap.keySet();
		for (int key : keys) {
			Integer count = arrMap.get(key);
			if (count == null) {
				missingList.add(key);
			}else if (count < brrMap.get(key)) {
				missingList.add(key);
			}
		}
		int[] missing = new int[missingList.size()];
		for (int i = 0; i < missingList.size(); i++) {
			missing[i] = missingList.get(i);
		}
		return missing;
	}

	public static void main(String[] args) throws IOException {

//		int[] result = missingNumbers(new int[] {203, 204, 205, 206, 207, 208, 203, 204, 205, 206},
//				new int[] {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204});
//		for (int i = 0; i < result.length; i++) {
//			System.out.print(result[i]+" ");
//		}

		int[] result = missingNumbers(new int[] { 11, 4, 11, 7, 13, 4, 12, 11, 10, 14 },
				new int[] { 11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12 });
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}
}
