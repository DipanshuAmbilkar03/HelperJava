package LastRun.Tree;
import java.util.*;

public class SameTree {

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

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return (p == q);
        }

        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        /*
            Tree 1:
                1
               / \
              2   3

            Tree 2:
                1
               / \
              2   3
        */

        TreeNode p = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );

        TreeNode q = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );

        boolean result = isSameTree(p, q);
        System.out.println("Are trees same? " + result);
    }
}
