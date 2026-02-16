package LastRun.Tree;
import java.util.*;

public class FlattenBinaryTree {

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

    static TreeNode prev = null;

    public static void flatten(TreeNode root) {

        if (root == null) return;

        // Reverse preorder: Right → Left → Root
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    // Helper to print flattened tree
    public static void printList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   5
             / \   \
            3   4   6
        */

        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(
                        5,
                        null,
                        new TreeNode(6)
                )
        );

        flatten(root);

        System.out.println("Flattened Tree:");
        printList(root);
    }
}
