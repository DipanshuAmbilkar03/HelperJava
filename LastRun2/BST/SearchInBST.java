package LastRun2.BST;

import java.util.*;

public class SearchInBST {

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

    public static TreeNode searchBST(TreeNode root, int val) {

        while (root != null && root.val != val) {
            root = (val < root.val) ? root.left : root.right;
        }

        return root;
    }

    // Inorder print for verification
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
             / \  / \
            2  6 10 14
        */

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int val = 10;

        TreeNode result = searchBST(root, val);

        if (result != null) {
            System.out.println("Node found with value: " + result.val);
        } else {
            System.out.println("Value not found in BST");
        }
    }
}
