import java.util.Arrays;

public class MinimumPushesII {

    public static int minimumPushes(String word) {

        int[] frequency = new int[26];

        for (int i = 0; i < word.length(); i++) {
            frequency[word.charAt(i) - 'a']++;
        }

        Arrays.sort(frequency);

        int ans = 0;
        int position = 0;

        for (int i = 25; i >= 0; i--) {

            if (frequency[i] == 0) {
                break;
            }

            ans += frequency[i] * ((position / 8) + 1);
            position++;
        }

        return ans;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "abcde",
                "xyzxyz",
                "abcdefghijklmnop",
                "aabbccddeeffgghhiijj",
                "abcdefghijklmnopqrstuvwxyz"
        };

        for (String word : testCases) {
            System.out.println("Input : " + word);
            System.out.println("Output: " + minimumPushes(word));
            System.out.println();
        }
    }
}