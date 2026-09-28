import java.util.Stack;

public class MaximumNestingDepthOfParentheses {

    private static int approch(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                st.pop();
            }

            ans = Math.max(ans, st.size());
        }

        return ans;
    }

    private static int approch2(String s) {
        int ans = 0;
        int curr = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                curr++;
            } else if (ch == ')') {
                curr--;
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }

    public static int maxDepth(String s) {
        // int ans = approch(s);
        int ans = approch2(s);
        return ans;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "(1+(2*3)+((8)/4))+1",
            "(1)+((2))+(((3)))",
            "()(())((()()))",
            "abc",
            "((()))"
        };

        for (String s : testCases) {
            System.out.println("Input  : " + s);
            System.out.println("Output : " + maxDepth(s));
            System.out.println();
        }
    }
}
