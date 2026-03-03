package BST2;
import java.util.*;

class TreeNode {
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

class Solution {

    private int maxSum = 0;

    class NodeValue {
        int minVal;
        int maxVal;
        int sum;

        NodeValue(int minVal, int maxVal, int sum) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxSum;
    }

    private NodeValue solve(TreeNode root) {

        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);

        if (left.maxVal < root.val && root.val < right.minVal) {

            int sum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, sum);

            return new NodeValue(
                    Math.min(left.minVal, root.val),
                    Math.max(root.val, right.maxVal),
                    sum
            );
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}

public class maxSumBST {

    public static void main(String[] args) {

        /*
            Example Tree

                 5
               /   \
              3     8
             / \   / \
            2  4  6   9

            Entire tree is BST
            Sum = 37
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Solution sol = new Solution();
        int result = sol.maxSumBST(root);

        System.out.println("Maximum Sum BST in Binary Tree: " + result);
    }
}