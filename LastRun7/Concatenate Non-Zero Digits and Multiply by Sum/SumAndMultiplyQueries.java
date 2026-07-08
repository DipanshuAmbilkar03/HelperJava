import java.util.*;

public class SumAndMultiplyQueries {

    public static int[] sumAndMultiply(String s, int[][] queries) {

        int len = queries.length;
        int mod = 1_000_000_007;

        int n = s.length() + 1;

        int[] prefix = new int[n];
        long[] concatenation = new long[n];
        int[] count = new int[n];
        long[] pow10 = new long[n];

        int[] ans = new int[len];

        for (int i = 1; i <= s.length(); i++) {
            prefix[i] = (prefix[i - 1] + (s.charAt(i - 1) - '0')) % mod;
        }

        concatenation[0] = 0;

        for (int i = 1; i <= s.length(); i++) {

            int num = s.charAt(i - 1) - '0';

            if (num == 0) {
                concatenation[i] = concatenation[i - 1];
                count[i] = count[i - 1];
            } else {
                concatenation[i] = ((concatenation[i - 1] * 10) + num) % mod;
                count[i] = count[i - 1] + 1;
            }
        }

        pow10[0] = 1;

        for (int i = 1; i < n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }

        int idx = 0;

        for (int[] query : queries) {

            int left = query[0];
            int right = query[1];

            long num = (
                    concatenation[right + 1]
                    - (concatenation[left] * pow10[count[right + 1] - count[left]]) % mod
                    + mod
            ) % mod;

            int sum = (prefix[right + 1] - prefix[left] + mod) % mod;

            ans[idx++] = (int) ((num * sum) % mod);
        }

        return ans;
    }

    public static void main(String[] args) {

        String s1 = "10203004";
        int[][] queries1 = {
                {0, 7},
                {1, 3},
                {4, 6}
        };

        System.out.println(Arrays.toString(sumAndMultiply(s1, queries1)));

        String s2 = "1000";
        int[][] queries2 = {
                {0, 3},
                {1, 2}
        };

        System.out.println(Arrays.toString(sumAndMultiply(s2, queries2)));
    }
}