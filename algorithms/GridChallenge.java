package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	// Complete the gridChallenge function below.

	static String gridChallenge(String[] grid) {
		char[][] mat = new char[grid.length][grid[0].length()];
		for (int row = 0; row < grid.length; row++) {
			String str = grid[row];
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			StringBuilder builder = new StringBuilder();
			for (int index = 0; index < arr.length; index++) {
				mat[row][index] = arr[index];
				builder.append(arr[index]);
			}
			grid[row] = new String(builder);
		}
		// work on mat
		String yes = "YES";
		for (int column = 0; column < mat[0].length; column++) {
			for (int row = 0; row < mat.length - 1; row++) {
				if (mat[row][column] > mat[row + 1][column]) {
					yes = "NO";
				}
			}
		}
		return yes;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String[] grid = new String[n];

			for (int i = 0; i < n; i++) {
				String gridItem = scanner.nextLine();
				grid[i] = gridItem;
			}

			String result = gridChallenge(grid);
			System.out.print(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
		}

//        bufferedWriter.close();

		scanner.close();
	}
}
