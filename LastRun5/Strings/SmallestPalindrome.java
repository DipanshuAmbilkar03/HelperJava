import java.util.LinkedList;
import java.util.Queue;

public class SmallestPalindrome {

    public static String smallestPalindrome(String s) {

        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        Queue<Character> queue = new LinkedList<>();
        String middle = "";

        for (int i = 0; i < 26; i++) {

            if (frequency[i] % 2 == 1) {
                middle = String.valueOf((char) (i + 'a'));
            }

            while (frequency[i] >= 2) {
                queue.offer((char) (i + 'a'));
                frequency[i] -= 2;
            }
        }

        StringBuilder firstHalf = new StringBuilder();

        while (!queue.isEmpty()) {
            firstHalf.append(queue.poll());
        }

        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        return firstHalf.toString() + middle + secondHalf;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "z",
                "abba",
                "aabb",
                "aaabbbb",
                "racecar",
                "abcba",
                "zzzxxxzzz"
        };

        for (String s : testCases) {
            System.out.println("Input : " + s);
            System.out.println("Output: " + smallestPalindrome(s));
            System.out.println();
        }
    }
}