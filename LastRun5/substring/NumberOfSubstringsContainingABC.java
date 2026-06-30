import java.util.Arrays;

public class NumberOfSubstringsContainingABC {

    public static int numberOfSubstrings(String s) {
        return method2(s);
    }

    private static int method1(String s) {

        int[] window = new int[3];
        int n = s.length();

        int left = 0;
        int right = 0;
        int ans = 0;

        while (right < n) {

            window[s.charAt(right) - 'a']++;

            while (isValid(window)) {

                ans += (n - right);

                window[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return ans;
    }

    private static int method2(String s) {

        int[] lastPos = new int[3];
        Arrays.fill(lastPos, -1);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            lastPos[s.charAt(i) - 'a'] = i;

            int minPos = Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));

            ans += (minPos + 1);
        }

        return ans;
    }

    private static boolean isValid(int[] window) {
        return window[0] > 0 && window[1] > 0 && window[2] > 0;
    }

    public static void main(String[] args) {

        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
    }
}