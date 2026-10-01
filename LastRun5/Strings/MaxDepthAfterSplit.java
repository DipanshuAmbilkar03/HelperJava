import java.util.Arrays;

public class MaxDepthAfterSplit {

    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] arr = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                curr++;
                arr[i] = curr % 2;
            } else {
                arr[i] = curr % 2;
                curr--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "(()())",
            "()(())()",
            "((()))",
            "()()",
            "(()(()))"
        };

        for (String seq : testCases) {
            System.out.println("Input  : " + seq);
            System.out.println("Output : " + Arrays.toString(maxDepthAfterSplit(seq)));
            System.out.println();
        }
    }
}
