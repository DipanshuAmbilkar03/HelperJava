// package LastRun5.Strings.count no of special character Series;

import java.util.Arrays;

public class count_no_of_specical_char_II {

    static class Solution {

        private int solution1(String word) {

            int[] low = new int[26];
            int[] high = new int[26];

            Arrays.fill(low, -1);
            Arrays.fill(high, -1);

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                if (Character.isLowerCase(ch)) {

                    // store last occurrence of lowercase
                    low[ch - 'a'] = i;

                } else {

                    // store first occurrence of uppercase
                    if (high[ch - 'A'] == -1) {
                        high[ch - 'A'] = i;
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < 26; i++) {

                // lowercase must appear before uppercase
                if (low[i] != -1 && high[i] != -1 && low[i] < high[i]) {
                    count++;
                }
            }

            return count;
        }

        public int numberOfSpecialChars(String word) {
            return solution1(word);
        }
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        String word1 = "aaAbcBC";
        String word2 = "abc";
        String word3 = "AbBCab";

        System.out.println("Output 1: " + obj.numberOfSpecialChars(word1));
        System.out.println("Output 2: " + obj.numberOfSpecialChars(word2));
        System.out.println("Output 3: " + obj.numberOfSpecialChars(word3));
    }
}