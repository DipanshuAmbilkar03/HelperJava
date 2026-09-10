import java.util.*;

public class AverageOfSubtree {

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

    private static int ans = 0;

    private static TreeNode inorder(TreeNode root) {

        if (root == null) {
            return new TreeNode(0, new TreeNode(0), null);
        }

        TreeNode left = inorder(root.left);
        TreeNode right = inorder(root.right);

        int count = 1 + left.val + right.val;
        int sum = root.val + left.left.val + right.left.val;

        if (root.val == sum / count) {
            ans++;
        }

        return new TreeNode(count, new TreeNode(sum), null);
    }

    public static int averageOfSubtree(TreeNode root) {

        ans = 0;

        inorder(root);

        return ans;
    }

    public static void main(String[] args) {

        // Tree 1:
        //        4
        //       / \
        //      8   5
        //     / \   \
        //    0   1   6

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(5);

        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(1);

        root1.right.right = new TreeNode(6);

        // Tree 2:
        //       1
        //      / \
        //     0   2

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(2);

        // Tree 3:
        //       5
        //      / \
        //     3   7

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(7);

        System.out.println(averageOfSubtree(root1));
        System.out.println(averageOfSubtree(root2));
        System.out.println(averageOfSubtree(root3));
    }
}