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

public class Create_Binary_Tree_From_Descriptions {

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(child);
        }

        for (int[] d : descriptions) {
            int parent = d[0];
            if (!children.contains(parent)) {
                return map.get(parent);
            }
        }

        return null;
    }

    // Preorder Traversal
    public static void preorder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[][] descriptions = {
            {20, 15, 1},
            {20, 17, 0},
            {15, 10, 1},
            {15, 12, 0}
        };

        TreeNode root = createBinaryTree(descriptions);

        System.out.println("Preorder Traversal:");
        preorder(root);
    }
}