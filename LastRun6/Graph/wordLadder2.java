package LastRun6.Graph;
import java.util.*;

public class wordladder2 {

    static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> ans = new ArrayList<>();
            Set<String> dict = new HashSet<>(wordList);

            if (!dict.contains(endWord)) return ans;

            Map<String, List<String>> map = new HashMap<>();
            Set<String> currLevel = new HashSet<>();
            currLevel.add(beginWord);

            boolean found = false;

            while (!currLevel.isEmpty() && !found) {
                Set<String> nextLevel = new HashSet<>();

                for (String word : currLevel) {
                    dict.remove(word);
                }

                for (String word : currLevel) {
                    char[] arr = word.toCharArray();

                    for (int i = 0; i < arr.length; i++) {
                        char original = arr[i];

                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            arr[i] = ch;
                            String newWord = new String(arr);

                            if (dict.contains(newWord)) {
                                nextLevel.add(newWord);

                                map.putIfAbsent(newWord, new ArrayList<>());
                                map.get(newWord).add(word);

                                if (newWord.equals(endWord)) {
                                    found = true;
                                }
                            }
                        }

                        arr[i] = original;
                    }
                }

                currLevel = nextLevel;
            }

            if (found) {
                List<String> path = new ArrayList<>();
                path.add(endWord);
                dfs(endWord, beginWord, map, path, ans);
            }

            return ans;
        }

        private void dfs(String word, String beginWord, Map<String, List<String>> map,
                         List<String> path, List<List<String>> ans) {

            if (word.equals(beginWord)) {
                List<String> temp = new ArrayList<>(path);
                Collections.reverse(temp);
                ans.add(temp);
                return;
            }

            if (!map.containsKey(word)) return;

            for (String parent : map.get(word)) {
                path.add(parent);
                dfs(parent, beginWord, map, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        );

        List<List<String>> result = sol.findLadders(beginWord, endWord, wordList);

        System.out.println("All shortest transformation sequences:");
        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}