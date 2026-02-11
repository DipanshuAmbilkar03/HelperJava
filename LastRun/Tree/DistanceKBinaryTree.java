package LastRun.Tree; 
import java.util.*;

public class DistanceKBinaryTree {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static HashMap<Integer, List<Integer>> graph;

    // Convert tree into undirected graph
    private static void buildGraph(TreeNode node) {

        if (node == null) return;

        if (node.left != null) {
            graph.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
            graph.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
        }

        if (node.right != null) {
            graph.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
            graph.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
        }

        buildGraph(node.left);
        buildGraph(node.right);
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        graph = new HashMap<>();
        buildGraph(root);

        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(target.val);
        vis.add(target.val);

        List<Integer> ans = new ArrayList<>();
        int iterator = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (iterator == k) {
                ans.addAll(q);
                return ans;
            }

            for (int i = 0; i < size; i++) {

                int num = q.poll();

                if (graph.containsKey(num)) {
                    for (int child : graph.get(num)) {
                        if (!vis.contains(child)) {
                            vis.add(child);
                            q.offer(child);
                        }
                    }
                }
            }

            iterator++;
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left; // node 5
        int k = 2;

        List<Integer> result = distanceK(root, target, k);

        System.out.println("Nodes at distance K:");
        System.out.println(result);
    }
}
