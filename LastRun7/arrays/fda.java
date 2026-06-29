public class NumberOfStringsThatAppearAsSubstringsInWord {

    public static int numOfStrings(String[] patterns, String word) {

        int count = 0;

        for (String pattern : patterns) {
            if (word.indexOf(pattern) != -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] patterns1 = {"a", "abc", "bc", "d"};
        String word1 = "abc";

        String[] patterns2 = {"a", "b", "c"};
        String word2 = "aaaaabbbbb";

        String[] patterns3 = {"leetcode", "et", "code"};
        String word3 = "leetcode";

        System.out.println(numOfStrings(patterns1, word1));
        System.out.println(numOfStrings(patterns2, word2));
        System.out.println(numOfStrings(patterns3, word3));
    }
}