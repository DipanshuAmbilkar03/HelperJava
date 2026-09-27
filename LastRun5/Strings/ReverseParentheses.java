import java.util.Stack;

public class ReverseParentheses {

    public static String reverseParentheses(String s) {
        // if (s != null && s.length() >= 2) {
        //     s = s.substring(1, s.length() - 1);
        // }
        int n = s.length() - 1;
        System.out.print(s);
        Stack<StringBuilder> st = new Stack<>();
        // StringBuilder sb1 = new StringBuilder();
        StringBuilder newStr = new StringBuilder();
        Boolean take = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(newStr);
                newStr = new StringBuilder();
            } else if (ch == ')') {
                newStr.reverse();
                StringBuilder prev = st.pop();
                prev.append(newStr);
                newStr = prev;
                // ans.append(newStr.reverse());
                // newStr.setLength(0);
            } else {
                newStr.append(ch);
            }
        }

        return newStr.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "(abcd)",
            "(u(love)i)",
            "(ed(et(oc))el)",
            "a(bcdefghijkl(mno)p)q",
            "ta()us"
        };

        for (String s : testCases) {
            System.out.println(" -> " + reverseParentheses(s));
        }
    }
}
