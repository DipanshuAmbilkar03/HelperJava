package LastRun2.BST;
import java.util.*;

public class KthSmallestInBST {

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

    public static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (true) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;

            if (k == 0) {
                return root.val;
            }

            root = root.right;
        }
    }

    public static void main(String[] args) {

        /*
                5
               / \
              3   6
             / \
            2   4
           /
          1
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        int k = 3;

        int result = kthSmallest(root, k);

        System.out.println("Kth Smallest Element: " + result);
    }
}