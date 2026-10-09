public class MinInsertionsToBalance {
    public static int minInsertions(String s) {
        // int left = 0;
        // int right = s.length() - 1;
        int count = 0;
        int len = s.length();
        int idx = 0;
        int leftP = 0;
        int addNew = 0;
        while (idx < len) {
            char c = s.charAt(idx);

            if (c == '(') {
                leftP++;
                idx++;
            } else {
                if (leftP > 0) {
                    leftP--;
                } else {
                    addNew++;
                }

                if (idx < len - 1 && s.charAt(idx + 1) == ')') {
                    idx += 2;
                } else {
                    addNew++;
                    idx++;
                }
            }
        }

        addNew += leftP * 2;
        return addNew;
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("(()))")); // 1
        System.out.println(minInsertions("())")); // 0
        System.out.println(minInsertions("))())(")); // 3
        System.out.println(minInsertions("(")); // 2
        System.out.println(minInsertions("))))")); // 2
    }
}
