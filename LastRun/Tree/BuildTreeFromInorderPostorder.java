package LastRun.Tree;
import java.util.*;

public class BuildTreeFromInorderPostorder {

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
    static int postidx;

    private static TreeNode helper(int[] postorder, int start, int end) {

        if (start > end) return null;

        int rootvalue = postorder[postidx--];
        TreeNode root = new TreeNode(rootvalue);

        int mid = map.get(rootvalue);

        // Important: build right first
        root.right = helper(postorder, mid + 1, end);
        root.left = helper(postorder, start, mid - 1);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        postidx = postorder.length - 1;
        map.clear();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    // Inorder traversal for verification
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        System.out.println("Inorder of Constructed Tree:");
        printInorder(root);
    }
}

