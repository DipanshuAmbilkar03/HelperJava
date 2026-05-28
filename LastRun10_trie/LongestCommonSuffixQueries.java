import java.util.*;

public class LongestCommonSuffixQueries {

    private int[][] dp;

    private int commonSuffix(String a, String b, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (a.charAt(i) != b.charAt(j)) {
            return dp[i][j] = 0;
        }

        return dp[i][j] = 1 + commonSuffix(a, b, i - 1, j - 1);
    }

    private int commonSuffix2(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int cnt = 0;

        while (i >= 0 && j >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                break;
            }

            cnt++;
            i--;
            j--;
        }

        return cnt;
    }

    private int[] sol1(String[] wordsContainer, String[] wordsQuery) {
        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];

            int bestIdx = 0;
            int bestSuffix = -1;

            for (int j = 0; j < wordsContainer.length; j++) {
                String word = wordsContainer[j];

                dp = new int[query.length()][word.length()];

                for (int k = 0; k < query.length(); k++) {
                    Arrays.fill(dp[k], -1);
                }

                int suffixLen = commonSuffix(
                        query,
                        word,
                        query.length() - 1,
                        word.length() - 1
                );

                if (suffixLen > bestSuffix) {
                    bestSuffix = suffixLen;
                    bestIdx = j;

                } else if (suffixLen == bestSuffix) {

                    if (word.length() < wordsContainer[bestIdx].length()) {
                        bestIdx = j;
                    }
                }
            }

            ans[i] = bestIdx;
        }

        return ans;
    }

    private int[] sol2(String[] wordsContainer, String[] wordsQuery) {
        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];

            int bestIdx = 0;
            int bestSuffix = -1;

            for (int j = 0; j < wordsContainer.length; j++) {
                String word = wordsContainer[j];

                int suffixLen = commonSuffix2(query, word);

                if (suffixLen > bestSuffix) {
                    bestSuffix = suffixLen;
                    bestIdx = j;

                } else if (suffixLen == bestSuffix) {

                    if (word.length() < wordsContainer[bestIdx].length()) {
                        bestIdx = j;
                    }
                }
            }

            ans[i] = bestIdx;
        }

        return ans;
    }

    class TrieNode {
        int index;
        int len;
        TrieNode[] children;

        TrieNode() {
            index = -1;
            len = Integer.MAX_VALUE;
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String s, int idx) {
            TrieNode node = root;
            int len = s.length();

            // store shortest word at root
            if (len < root.len) {
                root.len = len;
                root.index = idx;
            }

            for (int i = len - 1; i >= 0; i--) {
                int ch = s.charAt(i) - 'a';

                if (node.children[ch] == null) {
                    node.children[ch] = new TrieNode();
                }

                node = node.children[ch];

                if (len < node.len) {
                    node.len = len;
                    node.index = idx;
                }
            }
        }

        int prefix(String q) {
            TrieNode node = root;

            for (int i = q.length() - 1; i >= 0; i--) {
                int ch = q.charAt(i) - 'a';

                if (node.children[ch] == null) {
                    break;
                }

                node = node.children[ch];
            }

            return node.index;
        }
    }

    private int[] sol3(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();

        for (int i = 0; i < wordsContainer.length; i++) {
            trie.insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = trie.prefix(wordsQuery[i]);
        }

        return ans;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        // return sol1(wordsContainer, wordsQuery);
        // return sol2(wordsContainer, wordsQuery);
        return sol3(wordsContainer, wordsQuery);
    }

    public static void main(String[] args) {

        LongestCommonSuffixQueries obj = new LongestCommonSuffixQueries();

        String[] wordsContainer = {
                "abcd",
                "bcd",
                "xbcd"
        };

        String[] wordsQuery = {
                "cd",
                "bcd",
                "xyz"
        };

        int[] ans = obj.stringIndices(wordsContainer, wordsQuery);

        System.out.println("Answer Indices:");

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}