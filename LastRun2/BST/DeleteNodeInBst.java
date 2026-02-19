package LastRun2.BST;
import java.util.*;

public class DeleteNodeInBST {

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

    public static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (root.val == key) return helper(root);

        TreeNode curr = root;

        while (root != null) {

            if (key < root.val) {

                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }

            } else {

                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return curr;
    }

    private static TreeNode helper(TreeNode root) {

        // Case 1: No left child
        if (root.left == null) return root.right;

        // Case 2: No right child
        if (root.right == null) return root.left;

        // Case 3: Two children
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;

        return root.left;
    }

    private static TreeNode findLastRight(TreeNode root) {

        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    // Inorder traversal for verification
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

        int key = 4;

        root = deleteNode(root, key);

        System.out.println("Inorder after deletion:");
        printInorder(root);
    }
}
