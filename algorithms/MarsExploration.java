package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class MarsExploration {
	// Complete the marsExploration function below.
	static int marsExploration(String s) {
        String sos = "SOS";
        int count  = 0;
        for(int index = 0; index < s.length(); index+= 3){
            String sub = s.substring(index, index+3);
            for(int i = 0; i < sos.length(); i++) {
            	if(sos.charAt(i) != sub.charAt(i)) {
            		count++;
            	}
            }
        }
        return count;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();
		int result = marsExploration(s);
		System.out.println(result);
		scanner.close();
	}

}
