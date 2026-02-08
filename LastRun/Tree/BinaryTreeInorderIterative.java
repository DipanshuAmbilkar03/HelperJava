package LastRun.Tree;
import java.util.*;

public class BinaryTreeInorderIterative {

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

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();

        while (true) {

            if (node != null) {
                st.push(node);
                node = node.left;
            } else {

                if (st.isEmpty()) break;

                node = st.pop();
                res.add(node.val);
                node = node.right;
            }
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

        List<Integer> result = inorderTraversal(root);

        System.out.println("Inorder Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
