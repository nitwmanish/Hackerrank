package algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HackerlandRadioTransmitters {
	// Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int firstNumber = x[0];
        int lastNumver = x[x.length-1];
        int index = 0;
        int count  = 0;
        while(index < x.length) {
        	index = index+ k;
        	
        }

        System.out.println(firstNumber);
        System.out.println(lastNumver);
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        System.out.print(result);

        scanner.close();
    }
}
