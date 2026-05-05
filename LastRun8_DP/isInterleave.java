package LastRun8_DP;

import java.util.HashMap;
import java.util.Map;

public class isInterleave {

    private static boolean solve(
            int i, String s1,
            int j, String s2,
            String s3,
            Map<String, Boolean> dp
    ) {
        // Base case
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        String key = i + "#" + j;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int k = i + j;
        boolean ans = false;

        // Take from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = solve(i + 1, s1, j, s2, s3, dp);
        }

        // Take from s2
        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = solve(i, s1, j + 1, s2, s3, dp);
        }

        dp.put(key, ans);
        return ans;
    }

    public static boolean isInterleaveStrings(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Map<String, Boolean> dp = new HashMap<>();
        return solve(0, s1, 0, s2, s3, dp);
    }

    // Main method for local testing
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "adbcef";

        System.out.println(isInterleaveStrings(s1, s2, s3)); // true
    }
}