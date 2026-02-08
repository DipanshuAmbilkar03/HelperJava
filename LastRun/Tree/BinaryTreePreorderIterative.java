package LastRun.Tree;
import java.util.*;

public class BinaryTreePreorderIterative {

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

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {

            TreeNode node = st.pop();
            res.add(node.val);

            // Push right first so left is processed first
            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }

        return res;
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

        List<Integer> result = preorderTraversal(root);

        System.out.println("Preorder Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
