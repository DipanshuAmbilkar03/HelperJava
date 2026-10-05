import java.util.Stack;

public class ScoreOfParentheses {

    public static int scoreOfParentheses(String s) {
        int len;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(0);
            } else {
                int in = st.pop();
                if (in == 0) {
                    st.push(st.pop() + 1);
                } else {
                    st.push(st.pop() + 2 * in);
                }
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "()",
            "(())",
            "()()",
            "(()(()))",
            "((()))",
            "()((()))"
        };

        for (String s : testCases) {
            System.out.println("Input  : " + s);
            System.out.println("Output : " + scoreOfParentheses(s));
            System.out.println();
        }
    }
}
