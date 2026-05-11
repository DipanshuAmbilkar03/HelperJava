package LastRun5.Strings;

public class PalindromicSubstrings {

    private static int solve(String s, int i, int j) {
        // Base condition
        if (i < 0 || j >= s.length() || s.charAt(i) != s.charAt(j)) {
            return 0;
        }

        // Current palindrome + expand further
        return 1 + solve(s, i - 1, j + 1);
    }

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindromes
            count += solve(s, i, i);

            // Even length palindromes
            count += solve(s, i, i + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        String s1 = "abc";
        System.out.println("Input: " + s1);
        System.out.println("Palindromic Substrings: " + countSubstrings(s1));

        String s2 = "aaa";
        System.out.println("\nInput: " + s2);
        System.out.println("Palindromic Substrings: " + countSubstrings(s2));
    }
}