package LastRun.Tree;
import java.util.*;

public class FindBottomLeftValue {

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

    static int ans = 0;
    static int maxheight = -1;

    private static void dfs(TreeNode root, int height) {

        if (root == null) return;

        // First node reached at a new level = leftmost node
        if (height > maxheight) {
            maxheight = height;
            ans = root.val;
        }

        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }

    public static int findBottomLeftValue(TreeNode root) {
        ans = 0;
        maxheight = -1;
        dfs(root, 0);
        return ans;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             /   / \
            4   5   6
               /
              7
        */

        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        null
                ),
                new TreeNode(
                        3,
                        new TreeNode(
                                5,
                                new TreeNode(7),
                                null
                        ),
                        new TreeNode(6)
                )
        );

        int result = findBottomLeftValue(root);
        System.out.println("Bottom Left Value: " + result);
    }
}
