import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {

    public static String smallestSubsequence(String s) {

        int[] lastOccurrence = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && ch < stack.peek()
                    && lastOccurrence[stack.peek() - 'a'] > i) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String[] testCases = {
                "bcabc",
                "cbacdcbc",
                "cdadabcc",
                "ecbacba",
                "leetcode"
        };

        for (String s : testCases) {
            System.out.println("Input : " + s);
            System.out.println("Output: " + smallestSubsequence(s));
            System.out.println();
        }
    }
}