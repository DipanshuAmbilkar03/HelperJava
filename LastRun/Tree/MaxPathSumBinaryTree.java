package LastRun.Tree;
public class MaxPathSumBinaryTree {

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

    private static int dfs(TreeNode root, int[] sum) {
        if (root == null) return 0;

        int left = Math.max(0, dfs(root.left, sum));
        int right = Math.max(0, dfs(root.right, sum));

        sum[0] = Math.max(sum[0], left + right + root.val);

        return root.val + Math.max(left, right);
    }

    public static int maxPathSum(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;

        dfs(root, sum);
        return sum[0];
    }

    public static void main(String[] args) {

        /*
                -10
                / \
               9  20
                  / \
                 15  7
        */

        TreeNode root = new TreeNode(
                -10,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        int result = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result);
    }
}
