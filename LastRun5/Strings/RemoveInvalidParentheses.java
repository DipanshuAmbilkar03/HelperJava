import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    private static int miniRemoved;
    static List<String> ans;

    public static List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        ans = new ArrayList<>();
        takeInput(s, 0, 0);
        return ans;
    }

    private static void takeInput(String s, int i, int j) {
        int balance = 0;
        int n = s.length();
        for (int idx = i; idx < n; idx++) {
            if (s.charAt(idx) == '(') balance++;
            if (s.charAt(idx) == ')') balance--;

            if (balance >= 0) continue;

            for (int row = j; row <= idx; row++) {
                if (s.charAt(row) == ')' && (row == j || s.charAt(row - 1) != ')')) {
                    takeInput(s.substring(0, row) + s.substring(row + 1, n), idx, row);
                }
            }

            return;
        }

        takeback(s, s.length() - 1, s.length() - 1);
    }

    private static void takeback(String s, int i, int j) {
        int balance = 0;
        int n = s.length();
        for (int idx = i; idx >= 0; idx--) {
            if (s.charAt(idx) == ')') balance++;
            if (s.charAt(idx) == '(') balance--;

            if (balance >= 0) continue;

            for (int row = j; row >= idx; row--) {
                if (s.charAt(row) == '(' && (row == j || s.charAt(row + 1) != '(')) {
                    takeback(s.substring(0, row) + s.substring(row + 1, n), idx - 1, row - 1);
                }
            }

            return;
        }
        ans.add(s);
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()")); // [(())(), ()()()]
        System.out.println(removeInvalidParentheses("(a)())()")); // [(a())(), (a)()()]
        System.out.println(removeInvalidParentheses(")(")); // []
        System.out.println(removeInvalidParentheses("()")); // [()]
        System.out.println(removeInvalidParentheses("((")); // []
    }
}
