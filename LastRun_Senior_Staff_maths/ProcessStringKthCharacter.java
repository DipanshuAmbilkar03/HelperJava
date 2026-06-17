package LastRun_Senior_Staff_maths;

class Solution {

    private char sol1(String s, long k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (ch == '#') {
                sb.append(sb.toString());
            } else if (ch == '%') {
                sb.reverse();
            } else {
                sb.append(ch);
            }
        }

        if (sb.length() == 0) return '.';

        return (k < 0 || k >= sb.length()) ? '.' : sb.charAt((int) k);
    }

    private char sol2(String s, long k) {
        long len = 0;

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                len++;
            } else if (c == '*') {
                if (len > 0) len--;
            } else if (c == '#') {
                len *= 2;
            }
        }

        if (k >= len) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') {
                len++;
            } else if (c == '#') {
                len /= 2;
                if (k >= len) {
                    k -= len;
                }
            } else if (c == '%') {
                k = len - k - 1;
            } else {
                len--;
                if (k == len) return c;
            }
        }

        return '.';
    }

    public char processStr(String s, long k) {
        // return sol1(s, k);
        return sol2(s, k);
    }
}

public class ProcessStringKthCharacter {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] strs = {
            "abc",
            "ab#",
            "abc%",
            "abc*",
            "a#b%",
            "ab#c*",
            "a#b#c%"
        };

        long[] ks = {
            0, 1, 2, 3, 4, 5
        };

        for (String s : strs) {
            System.out.println("String: " + s);

            for (long k : ks) {
                System.out.println(
                    "k = " + k + " -> " + sol.processStr(s, k)
                );
            }

            System.out.println("------------------------");
        }
    }
}