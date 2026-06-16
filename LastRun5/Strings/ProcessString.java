class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '#') {
                sb.append(sb.toString());
            } else if (ch == '%') {
                sb.reverse();
            } else if (ch == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

public class ProcessString {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] testCases = {
            "abc",
            "ab#",
            "abc%",
            "abc*",
            "a#b%",
            "ab#c*",
            "a#b#c%",
            "*",
            "abc**",
            "a%b#c*"
        };

        for (String s : testCases) {
            System.out.println("Input  : " + s);
            System.out.println("Output : " + sol.processStr(s));
            System.out.println();
        }
    }
}