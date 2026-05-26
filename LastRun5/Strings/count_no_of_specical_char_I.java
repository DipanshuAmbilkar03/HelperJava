package LastRun5.Strings;

public class count_no_of_specical_char_I {

    private static int solution1(String word) {
        int[] low = new int[26];
        int[] high = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                low[ch - 'a']++;
            } else if (Character.isUpperCase(ch)) {
                high[ch - 'A']++;
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (low[i] > 0 && high[i] > 0) {
                count++;
            }
        }

        return count;
    }

    private static int optimizedSolution(String word) {
        int high = 0;
        int low = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                low |= (1 << (ch - 'a'));
            } else if (Character.isUpperCase(ch)) {
                high |= (1 << (ch - 'A'));
            }
        }

        return Integer.bitCount(low & high);
    }

    public static int numberOfSpecialChars(String word) {
        // return solution1(word);
        return optimizedSolution(word);
    }

    public static void main(String[] args) {

        String word1 = "aaAbBcC";
        String word2 = "abc";
        String word3 = "aAbBcCdD";

        System.out.println(numberOfSpecialChars(word1));
        System.out.println(numberOfSpecialChars(word2));
        System.out.println(numberOfSpecialChars(word3));
    }
}