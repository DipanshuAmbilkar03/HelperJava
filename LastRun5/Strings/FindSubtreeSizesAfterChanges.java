import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindSubtreeSizesAfterChanges {

    static HashMap<Integer, ArrayList<Integer>> adj;
    static int[] resultSize;
    static int[] last;

    public static int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        adj = new HashMap<>();
        resultSize = new int[n];
        last = new int[26];

        Arrays.fill(last, -1);
        Arrays.fill(resultSize, 1);
        // parent[0] = 0;
        for (int i = 1; i < n; i++) {
            int u = parent[i];
            int v = i;

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        dfs(0, s, parent);

        return resultSize;
    }

    private static void dfs(int currNode, String s, int[] parent) {
        int c = s.charAt(currNode) - 'a';
        int ancestor = last[c];

        last[c] = currNode;

        if (adj.containsKey(currNode)) {
            for (int child : adj.get(currNode)) {
                dfs(child, s, parent);
            }
        }

        last[c] = ancestor;
        int newPar = parent[currNode];

        if (currNode != 0 && ancestor != -1) {
            newPar = ancestor;
        }

        parent[currNode] = newPar;

        if (newPar != -1) resultSize[newPar] += resultSize[currNode];

    }

    public static void main(String[] args) {
        int[] parent1 = {-1, 0, 0, 1, 1, 2};
        System.out.println("parent = [-1,0,0,1,1,2], s = \"abaabc\" -> "
                + Arrays.toString(findSubtreeSizes(parent1, "abaabc")));

        int[] parent2 = {-1, 0, 1, 2};
        System.out.println("parent = [-1,0,1,2], s = \"abcd\" -> "
                + Arrays.toString(findSubtreeSizes(parent2, "abcd")));

        int[] parent3 = {-1, 0, 1, 2};
        System.out.println("parent = [-1,0,1,2], s = \"aaaa\" -> "
                + Arrays.toString(findSubtreeSizes(parent3, "aaaa")));

        int[] parent4 = {-1, 0, 0, 0};
        System.out.println("parent = [-1,0,0,0], s = \"aaaa\" -> "
                + Arrays.toString(findSubtreeSizes(parent4, "aaaa")));

        int[] parent5 = {-1, 0, 1};
        System.out.println("parent = [-1,0,1], s = \"aba\" -> "
                + Arrays.toString(findSubtreeSizes(parent5, "aba")));

        int[] parent6 = {-1, 0, 1, 2, 3};
        System.out.println("parent = [-1,0,1,2,3], s = \"ababa\" -> "
                + Arrays.toString(findSubtreeSizes(parent6, "ababa")));

        int[] parent7 = {-1};
        System.out.println("parent = [-1], s = \"z\" -> "
                + Arrays.toString(findSubtreeSizes(parent7, "z")));
    }
}
