package BST2;

import java.util.*;

public class TwoSumBST {

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

    static HashSet<Integer> set;

    public static boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return solve(root, k);
    }

    private static boolean solve(TreeNode root, int k) {

        if (root == null) return false;

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return solve(root.left, k) || solve(root.right, k);
    }

    public static void main(String[] args) {

        /*
                5
               / \
              3   6
             / \   \
            2   4   7
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        int k = 9;

        boolean result = findTarget(root, k);

        System.out.println("Two nodes sum to " + k + "? " + result);
    }
}