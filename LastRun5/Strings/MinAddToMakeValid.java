public class MinAddToMakeValid {
    public static int minAddToMakeValid(String s) {
        // Stack<Integer> st = new Stack<>();
        // st.push(0);
        int open = 0;
        int miniAdd = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
                // st.push(i);
            } else {
                // int pop = st.peek();
                if (open <= 0) {
                    miniAdd++;
                } else {
                    open--;
                }
            }
        }
        return miniAdd + open;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())")); // 1
        System.out.println(minAddToMakeValid("(((")); // 3
        System.out.println(minAddToMakeValid("()")); // 0
        System.out.println(minAddToMakeValid("()))((")); // 4
        System.out.println(minAddToMakeValid("")); // 0
    }
}
