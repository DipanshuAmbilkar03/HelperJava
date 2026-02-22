package LastRun2.BST;

import java.util.*;

public class LCAinBST {

    // BST Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // Both nodes are in left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both nodes are in right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // Split point found
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        /*
                6
               / \
              2   8
             / \ / \
            0  4 7  9
              / \
             3   5
        */

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;          // 2
        TreeNode q = root.left.right;   // 4

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
}