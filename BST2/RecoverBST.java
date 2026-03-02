package BST2;

import java.util.*;

public class RecoverBST {

    // Tree Node
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

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public static void recoverTree(TreeNode root) {
        inorder(root);

        // swap the two incorrect nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private static void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        // detect violation of BST property
        if (prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    // inorder print to verify
    public static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        /*
                3
               / \
              1   4
                 /
                2
        */

        TreeNode root = new TreeNode(
                3,
                new TreeNode(1),
                new TreeNode(
                        4,
                        new TreeNode(2),
                        null
                )
        );

        System.out.print("Before Fix (Inorder): ");
        printInorder(root);

        recoverTree(root);

        System.out.print("\nAfter Fix (Inorder): ");
        printInorder(root);
    }
}