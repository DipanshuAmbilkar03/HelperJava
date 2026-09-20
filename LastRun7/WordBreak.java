import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);

        int maxLen = 0;

        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();
        int[] record = new int[n + 1];

        record[0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = Math.max(0, i - maxLen); j < i; j++) {

                if (record[j] == 1 && set.contains(s.substring(j, i))) {
                    record[i] = 1;
                    break;
                }
            }
        }

        return record[n] == 1;
    }

    public static void main(String[] args) {

        String[] strings = {
                "leetcode",
                "applepenapple",
                "catsandog",
                "cars",
                "aaaaaaa"
        };

        List<List<String>> dictionaries = Arrays.asList(
                Arrays.asList("leet", "code"),
                Arrays.asList("apple", "pen"),
                Arrays.asList("cats", "dog", "sand", "and", "cat"),
                Arrays.asList("car", "ca", "rs"),
                Arrays.asList("aaaa", "aaa")
        );

        for (int i = 0; i < strings.length; i++) {

            System.out.println("Input : " + strings[i]);
            System.out.println("Dict  : " + dictionaries.get(i));
            System.out.println("Output: " +
                    wordBreak(strings[i], dictionaries.get(i)));

            System.out.println();
        }
    }
}