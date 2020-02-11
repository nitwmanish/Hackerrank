package algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
A palindrome has the unique property that the frequency of only one character can
be odd, so we can simply count the frequency of characters and check if
there is more than 1 that is odd 
Example: (1)
aaabbbb
a: 3
b: 4
1 odd
Example: (2)
cdefghmnopqrstuvw
c:1
d:1
e:1
f:1
g:1
h:1
m:1
n:1
o:1
p:1
q:1
r:1
s:1
t:1
u:1
v:1
w:1
18 odds
Example: (3)
cdcdcdcdeeeef
c:4
d:4
e:4
f:1
1 odd
Time Complexity: O(n) //In the size of the string
Space Complexity: O(1) //We have a fixed number of different characters
*/
public class GameOfThrones_I {

	static String gameOfThrones(String s) {
		String result = "YES";
		int[] map = new int['z' - 'a' + 1];
		for (int index = 0; index < s.length(); index++) {
			map['z' - s.charAt(index)]++;
		}
		int oddCount = 0;
		for (int index = 0; index < map.length; index++) {
			if (map[index]%2 == 1) {
				oddCount++;
			}
		}
		if (oddCount > 1) {
			result = "NO";
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();
		String result = gameOfThrones(s);
		System.out.println(result);
		scanner.close();
	}
}
