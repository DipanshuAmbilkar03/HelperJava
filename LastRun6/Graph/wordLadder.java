package LastRun6.Graph;

import java.util.*;

public class wordLadder {

    static class Solution {
        class Pair {
            String word;
            int level;

            Pair(String word, int level) {
                this.word = word;
                this.level = level;
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;

            Set<String> set = new HashSet<>(wordList);
            Queue<Pair> q = new LinkedList<>();

            q.add(new Pair(beginWord, 1));
            set.remove(beginWord);

            while (!q.isEmpty()) {
                Pair curr = q.poll();
                String word = curr.word;
                int steps = curr.level;

                if (word.equals(endWord)) return steps;

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            q.add(new Pair(newWord, steps + 1));
                        }
                    }

                    arr[i] = original;
                }
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        );

        int result = sol.ladderLength(beginWord, endWord, wordList);

        System.out.println("Shortest transformation length: " + result);
    }
}