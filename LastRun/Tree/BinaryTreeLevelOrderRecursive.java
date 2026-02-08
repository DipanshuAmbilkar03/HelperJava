package LastRun.Tree;
import java.util.*;

public class BinaryTreeLevelOrderRecursive {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(res, 0, root);
        return res;
    }

    private static void levelOrderHelper(List<List<Integer>> res, int level, TreeNode root) {
        if (root == null) return;

        if (level == res.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
        } else {
            res.get(level).add(root.val);
        }

        levelOrderHelper(res, level + 1, root.left);
        levelOrderHelper(res, level + 1, root.right);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(
                        3,
                        null,
                        new TreeNode(6)
                )
        );

        List<List<Integer>> result = levelOrder(root);

        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
