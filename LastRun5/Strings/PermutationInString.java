import java.util.*;

public class PermutationInString {

    HashMap<String, Boolean> map;

    // Recursive permutation check
    private boolean check(String curr, String s1, String s2, boolean[] vis) {

        // Base case
        if (s1.length() == curr.length()) {
            return s2.contains(curr);
        }

        String key = curr + Arrays.toString(vis);

        // Memoization check
        if (map.containsKey(key)) {
            return map.get(key);
        }

        for (int i = 0; i < s1.length(); i++) {

            if (!vis[i]) {

                vis[i] = true;

                // Recursive call
                if (check(curr + s1.charAt(i), s1, s2, vis)) {

                    map.put(key, true);
                    vis[i] = false;

                    return true;
                }

                vis[i] = false;
            }
        }

        map.put(key, false);

        return false;
    }

    // Frequency array approach
    public boolean checkInclusion(String s1, String s2) {

        /*
        map = new HashMap<>();
        boolean[] vis = new boolean[s1.length()];

        return check("", s1, s2, vis);
        */

        int[] map1 = new int[26];

        int n = s1.length();
        int m = s2.length();

        // If s1 is larger than s2
        if (n > m) {
            return false;
        }

        // Frequency count of s1
        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
        }

        // Check every window of size n in s2
        for (int i = 0; i <= m - n; i++) {

            int[] map2 = new int[26];

            // Build frequency for current window
            for (int j = 0; j < n; j++) {

                map2[s2.charAt(i + j) - 'a']++;
            }

            // Compare frequency arrays
            if (check2(map1, map2)) {
                return true;
            }
        }

        return false;
    }

    // Compare two frequency arrays
    private boolean check2(int[] m1, int[] m2) {

        for (int i = 0; i < 26; i++) {

            if (m1[i] != m2[i]) {
                return false;
            }
        }

        return true;
    }

    // Main Function
    public static void main(String[] args) {

        PermutationInString obj = new PermutationInString();

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean ans = obj.checkInclusion(s1, s2);

        System.out.println("Result : " + ans);
    }
}