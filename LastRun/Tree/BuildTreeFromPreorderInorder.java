package LastRun.Tree;

import java.util.*;

public class BuildTreeFromPreorderInorder {

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

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int preIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        map.clear();
        preIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int inStart, int inEnd) {

        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        // Important: build LEFT first (preorder = Root → Left → Right)
        root.left = helper(preorder, inStart, mid - 1);
        root.right = helper(preorder, mid + 1, inEnd);

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

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("Inorder of Constructed Tree:");
        printInorder(root);
    }
}
