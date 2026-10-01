import java.util.Stack;

public class ValidParentheses {

    private static Character check(Character s) {
        if (s == ')') {
            return '(';
        }

        if (s == ']') {
            return '[';
        }

        return '{';
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char ch1 = st.pop();
                if (check(c) != ch1) return false;

            }
            // System.out.print(st);
        }

        return st.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "()",
            "()[]{}",
            "(]",
            "([])",
            "([)]",
            "{[]}",
            "(",
            "]"
        };

        for (String s : testCases) {
            System.out.println("Input  : " + s);
            System.out.println("Output : " + isValid(s));
            System.out.println();
        }
    }
}
