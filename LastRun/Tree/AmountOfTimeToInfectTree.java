package LastRun.Tree;

import java.util.*;

public class AmountOfTimeToInfectTree {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static HashMap<Integer, List<Integer>> graph;

    // Convert tree into undirected graph
    private static void helper(TreeNode root) {

        if (root == null) return;

        if (root.left != null) {
            graph.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
        }

        if (root.right != null) {
            graph.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
        }

        helper(root.left);
        helper(root.right);
    }

    public static int amountOfTime(TreeNode root, int start) {

        graph = new HashMap<>();
        helper(root);

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(start);
        int ans = -1;

        while (!q.isEmpty()) {

            int size = q.size();
            ans++;

            for (int i = 0; i < size; i++) {

                int node = q.poll();
                visited.add(node);

                if (graph.containsKey(node)) {
                    for (int child : graph.get(node)) {
                        if (!visited.contains(child)) {
                            q.offer(child);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              5   3
                 / \
                10  6
        */

        TreeNode root = new TreeNode(
                1,
                new TreeNode(5),
                new TreeNode(
                        3,
                        new TreeNode(10),
                        new TreeNode(6)
                )
        );

        int start = 3;

        int result = amountOfTime(root, start);
        System.out.println("Time to infect tree: " + result);
    }
}
