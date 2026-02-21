package LastRun2.BST;

import java.util.*;

public class ValidateBSTInorder {

    // BST Node
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

    static long prev;

    public static boolean isValidBST(TreeNode root) {
        prev = Long.MIN_VALUE;   // Reset before traversal
        return helper(root);
    }

    private static boolean helper(TreeNode root) {

        if (root == null) return true;

        // Traverse left subtree
        if (!helper(root.left)) return false;

        // Check BST property
        if (root.val <= prev) return false;

        prev = root.val;

        // Traverse right subtree
        return helper(root.right);
    }

    public static void main(String[] args) {

        /*
                5
               / \
              3   7
             / \   \
            2   4   8
        */

        TreeNode root = new TreeNode(
                5,
                new TreeNode(
                        3,
                        new TreeNode(2),
                        new TreeNode(4)
                ),
                new TreeNode(
                        7,
                        null,
                        new TreeNode(8)
                )
        );

        boolean result = isValidBST(root);
        System.out.println("Is Valid BST? " + result);
    }
}