public class MinimumPushes {

    public static int minimumPushes(String word) {

        int n = word.length();

        if (n <= 8) {
            return n;
        } else if (n <= 16) {
            return 8 + (n - 8) * 2;
        } else if (n <= 24) {
            return 8 + 8 * 2 + (n - 16) * 3;
        } else {
            return 8 + 8 * 2 + 8 * 3 + (n - 24) * 4;
        }
    }

    public static void main(String[] args) {

        String[] testCases = {
                "abc",
                "abcdefgh",
                "abcdefghi",
                "abcdefghijklmnop",
                "abcdefghijklmnopqrstuvwx",
                "abcdefghijklmnopqrstuvwxyz"
        };

        for (String word : testCases) {
            System.out.println("Input : " + word);
            System.out.println("Output: " + minimumPushes(word));
            System.out.println();
        }
    }
}