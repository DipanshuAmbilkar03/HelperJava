import java.util.*;

public class DiameterOfBinaryTree {

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

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        findDia(root);
        return diameter;
    }

    private static int findDia(TreeNode root) {
        if (root == null) return 0;

        int leftNode = findDia(root.left);
        int rightNode = findDia(root.right);

        diameter = Math.max(diameter, leftNode + rightNode);

        return Math.max(leftNode, rightNode) + 1;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3)
        );

        int result = diameterOfBinaryTree(root);
        System.out.println("Diameter of Binary Tree: " + result);
    }
}
