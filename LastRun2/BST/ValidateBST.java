package LastRun2.BST;
import java.util.*;

public class ValidateBST {

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

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {

        if (node == null) return true;

        // Check BST condition
        if (node.val <= min || node.val >= max) return false;

        // Left subtree must be < node.val
        // Right subtree must be > node.val
        return validate(node.left, min, node.val)
                && validate(node.right, node.val, max);
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