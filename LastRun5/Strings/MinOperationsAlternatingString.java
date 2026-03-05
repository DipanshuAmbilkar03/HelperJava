package LastRun5.Strings;

import java.util.*;

public class MinOperationsAlternatingString {

    public static int minOperations(String s) {

        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            char expected = (i % 2 == 0) ? '0' : '1';

            if (s.charAt(i) == expected) {
                count++;
            }
        }

        // Two patterns possible: 010101... or 101010...
        return Math.min(count, n - count);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int result = minOperations(s);

        System.out.println("Minimum Operations: " + result);

        sc.close();
    }
}