package LastRun2.DP;

import java.util.*;

public class InsertIntoBST {

    // Binary Search Tree Node
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

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        TreeNode curr = root;

        while (true) {

            if (val < curr.val) {

                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }

                curr = curr.left;

            } else {

                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }

                curr = curr.right;
            }
        }

        return root;
    }

    // Inorder traversal to verify BST
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        /*
                8
               / \
              4   12
        */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        int val = 6;

        root = insertIntoBST(root, val);

        System.out.println("Inorder after insertion:");
        printInorder(root);
    }
}
